<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="_page_current" value="movies_characters" scope="request" />
<t:layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Films &raquo; Édition des personnages</jsp:attribute>
    <jsp:attribute name="body_title">
        Édition des personnages
        <small>${fn:escapeXml(movie.title)}</small>
    </jsp:attribute>
    <jsp:attribute name="_page_stylesheets">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" media="screen" />
    </jsp:attribute>
    <jsp:attribute name="_page_scripts">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.full.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/i18n/fr.js"></script>
        <script type="text/javascript">
            $(function() {
                // Initialize vars
                var $tbody = $("form table tbody");

                //
                $tbody.find("select").select2({
                    width: "100%",
                    dropdownAutoWidth: true
                });

                // Remove rows on click
                $tbody.on(
                    "click",
                    "button.btn-danger",
                    function(e) {
                        $(this).closest("tr").remove();
                    }
                );

                // Insert rows on click
                var rowTemplate = "<tr>";
                rowTemplate += "<td><select class='form-control' name='new_actors[]'>";
                <c:forEach items="${actorsList}" var="actor">
                    rowTemplate += "<option value='${actor.id}'>${fn:escapeXml(actor.fullName)}</option>";
                </c:forEach>
                rowTemplate += "</select></td>";
                rowTemplate += "<td><input type='text' class='form-control' name='new_characters[]' /></td>";
                rowTemplate += "<td class='column-icons'><button type='button' class='btn btn-danger'><i class='fa fa-times'></i></button></td>";
                rowTemplate += "</tr>";

                $("form table tfoot button[type='button']").click(function(e) {
                    $(rowTemplate)
                        .find("select")
                        .select2({
                            width: "100%",
                            dropdownAutoWidth: true
                        })
                        .end()
                        .appendTo($tbody)
                    ;
                });
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="box box-solid">
            <div class="box-body">
                <c:url value="/movies/${movie.id}/characters/submit" var="_url" />
                <form:form method="post" action="${fn:escapeXml(_url)}" modelAttribute="movie" cssClass="form-horizontal">
                    <form:input path="id" type="hidden" />
                    <form:input path="title" type="hidden" />
                    <form:input path="duration" type="hidden" />
                    <form:input path="releaseDate" type="hidden" />
                    <form:input path="budget" type="hidden" />
                    <form:input path="benefit" type="hidden" />
                    <form:select path="director" cssClass="hidden">
                        <form:option value="${movie.director.id}" selected="selected" />
                    </form:select>
                    <form:select path="categories" cssClass="hidden">
                        <form:options items="${movie.categories}" itemValue="code" itemLabel="name" />
                    </form:select>
                    <form:errors cssClass="text-red" />
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th style="width: calc((100% - 60px) / 2);">
                                        Acteur
                                    </th>
                                    <th style="width: calc((100% - 60px) / 2)">
                                        Nom du personnage
                                    </th>
                                    <th style="width: 60px;">
                                    </th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <td colspan="2">
                                        <button type="submit" class="btn btn-success">
                                            Enregistrer
                                        </button>
                                        <button type="reset" class="btn btn-danger">
                                            Réinitialiser
                                        </button>
                                        <c:url value="/movies" var="_url" />
                                        <a href="${fn:escapeXml(_url)}" class="btn btn-default">
                                            Retour à la liste
                                        </a>
                                        <c:url value="/movies/edit/${movie.id}" var="_url" />
                                        <a href="${fn:escapeXml(_url)}" class="btn btn-default">
                                            Aller au film
                                        </a>
                                    </td>
                                    <td class="column-icons">
                                        <button type="button" class="btn btn-success">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </td>
                                </tr>
                            </tfoot>
                            <tbody>
                                <c:forEach items="${movie.characters}" var="character" varStatus="loopStatus">
                                    <tr>
                                        <td>
                                            <spring:bind path="characters[${loopStatus.index}].id.actor">
                                                <form:select
                                                    path="characters[${loopStatus.index}].id.actor"
                                                    cssClass="form-control"
                                                >
                                                    <form:options items="${actorsList}" itemValue="id" itemLabel="fullName" />
                                                </form:select>
                                                <form:errors path="characters[${loopStatus.index}].id.actor" cssClass="help-block" />
                                            </spring:bind>
                                        </td>
                                        <td>
                                            <spring:bind path="characters[${loopStatus.index}].name">
                                                <form:input
                                                    path="characters[${loopStatus.index}].name"
                                                    type="text"
                                                    cssClass="form-control"
                                                />
                                                <form:errors path="characters[${loopStatus.index}].name" cssClass="help-block" />
                                            </spring:bind>
                                        </td>
                                        <td class="column-icons">
                                            <button type="button" class="btn btn-danger">
                                                <i class="fa fa-times"></i>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td>
                                        <select class="form-control" name="new_actors[]">
                                            <c:forEach items="${actorsList}" var="actor">
                                                <option value="${actor.id}">${fn:escapeXml(actor.fullName)}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" name="new_characters[]" />
                                    </td>
                                    <td class="column-icons">
                                        <button type="button" class="btn btn-danger">
                                            <i class="fa fa-times"></i>
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </form:form>
            </div>
        </div>
    </jsp:body>
</t:layout>