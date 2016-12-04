<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Films &raquo; ${_page_title}</jsp:attribute>
    <jsp:attribute name="body_title">${_body_title}</jsp:attribute>
    <jsp:attribute name="_page_stylesheets">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" media="screen" />
    </jsp:attribute>
    <jsp:attribute name="_page_scripts">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.full.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/i18n/fr.js"></script>
        <script type="text/javascript">
            $(function() {

            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="box box-solid">
            <div class="box-body">
                <c:url value="/movies/${movie.id}/characters/submit" var="_url" />
                <form:form method="post" action="${fn:escapeXml(_url)}" modelAttribute="movie" cssClass="form-horizontal">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>
                                        Acteur
                                    </th>
                                    <th>
                                        Nom du personnage
                                    </th>
                                    <th>
                                    </th>
                                </tr>
                            </thead>
                            <tfoot>
                            </tfoot>
                            <tbody>
                                <c:forEach items="${movie.characters}" var="character" varStatus="status">
                                    <tr>
                                        <td>
                                            <form:select path="movie.characters[${status.index}].actor">
                                                <form:options items="actorsList" itemValue="id" itemLabel="fullName" />
                                            </form:select>
                                        </td>
                                        <td>
                                            <form:input path="movie.characters[${status.index}].name" type="text" />
                                        </td>
                                        <td>
                                            <button type="button" class="btn btn-link">
                                                <i class="fa fa-times"></i>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </form:form>
            </div>
        </div>
    </jsp:body>
</t:layout>