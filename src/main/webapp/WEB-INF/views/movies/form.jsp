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
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" media="screen" />
    </jsp:attribute>
    <jsp:attribute name="_page_scripts">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/locales/bootstrap-datepicker.fr.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.full.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/i18n/fr.js"></script>
        <script type="text/javascript">
            $(function() {
                // Initialize vars
                var $directorsSelect = $("#director");
                var firstDirectorValue = $directorsSelect.val();
                var $categoriesSelect = $("#categories");
                var firstCategoriesValue = $categoriesSelect.val();

                // Advanced input elements
                $("#releaseDate").datepicker({
                    language: "fr"
                });

                $directorsSelect.select2();
                $categoriesSelect.select2();

                // Re-establish form behavior
                $("label[for='director']").click(function(e) {
                    // Prevent default behavior
                    e.preventDefault();

                    // Open directors list
                    $directorsSelect.select2("open");
                });

                $("form").on("reset", function(e) {
                    $directorsSelect.val(firstDirectorValue).trigger("change");
                    $categoriesSelect.val(firstCategoriesValue).trigger("change");
                });
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="box box-solid">
            <div class="box-body">
                <c:url value="/movies/submit" var="_url" />
                <form:form method="post" action="${fn:escapeXml(_url)}" modelAttribute="movie" cssClass="form-horizontal">
                    <c:if test="${empty movie.id || movie.id eq 0}">
                        <input type="hidden" name="_is_new" value="1" />
                    </c:if>
                    <form:input path="id" type="hidden" />
                    <spring:bind path="title">
                        <div class="form-group ${status.error ? "has-error" : ""}">
                            <form:label path="title" for="title" cssClass="control-label col-sm-2">
                                Titre*
                            </form:label>
                            <div class="col-sm-10">
                                <form:input
                                    path="title"
                                    type="text"
                                    cssClass="form-control"
                                    id="title"
                                />
                                <form:errors path="title" cssClass="help-block" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="duration">
                        <div class="form-group ${status.error ? "has-error" : ""}">
                            <form:label path="duration" for="duration" cssClass="control-label col-sm-2">
                                Durée*
                            </form:label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <form:input
                                        path="duration"
                                        type="number"
                                        cssClass="form-control"
                                        id="duration"
                                        min="0"
                                        step="1"
                                    />
                                    <span class="input-group-addon">
                                        min
                                    </span>
                                </div>
                                <form:errors path="duration" cssClass="help-block" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="releaseDate">
                        <div class="form-group ${status.error ? "has-error" : ""}">
                            <form:label path="releaseDate" for="releaseDate" cssClass="control-label col-sm-2">
                                Date de sortie*
                            </form:label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <form:input
                                        path="releaseDate"
                                        type="text"
                                        cssClass="form-control"
                                        id="releaseDate"
                                    />
                                    <span class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </span>
                                </div>
                                <form:errors path="releaseDate" cssClass="help-block" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="budget">
                        <div class="form-group ${status.error ? "has-error" : ""}">
                            <form:label path="budget" for="budget" cssClass="control-label col-sm-2">
                                Budget*
                            </form:label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <form:input
                                        path="budget"
                                        type="number"
                                        cssClass="form-control"
                                        id="budget"
                                        min="0"
                                        step="1"
                                    />
                                    <span class="input-group-addon">
                                        <i class="fa fa-dollar"></i>
                                    </span>
                                </div>
                                <form:errors path="budget" cssClass="help-block" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="profit">
                        <div class="form-group ${status.error ? "has-error" : ""}">
                            <form:label path="profit" for="profit" cssClass="control-label col-sm-2">
                                Bénéfices*
                            </form:label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <form:input
                                        path="profit"
                                        type="number"
                                        cssClass="form-control"
                                        id="profit"
                                        min="0"
                                        step="1"
                                    />
                                    <span class="input-group-addon">
                                        <i class="fa fa-dollar"></i>
                                    </span>
                                </div>
                                <form:errors path="profit" cssClass="help-block" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="director">
                        <div class="form-group ${status.error ? "has-error" : ""}">
                            <form:label path="director" for="director" cssClass="control-label col-sm-2">
                                Réalisateur*
                            </form:label>
                            <div class="col-sm-10">
                                <form:select
                                    path="director"
                                    cssClass="form-control"
                                    id="director"
                                >
                                    <form:options items="${directorsList}" itemValue="id" itemLabel="fullName" />
                                </form:select>
                                <form:errors path="director" cssClass="help-block" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="categories">
                        <div class="form-group ${status.error ? "has-error" : ""}">
                            <form:label path="categories" for="categories" cssClass="control-label col-sm-2">
                                Catégories
                            </form:label>
                            <div class="col-sm-10">
                                <form:select
                                    path="categories"
                                    cssClass="form-control"
                                    id="categories"
                                    multiple="multiple"
                                >
                                    <form:options items="${categoriesList}" itemValue="code" itemLabel="name" />
                                </form:select>
                                <form:errors path="categories" cssClass="help-block" />
                            </div>
                        </div>
                    </spring:bind>
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-2">
                            <button type="submit" class="btn btn-success">
                                Enregistrer
                            </button>
                            <button type="reset" class="btn btn-danger">
                                Réinitialiser
                            </button>
                            <c:url value="/movies" var="_url" />
                            <a href="${_url}" class="btn btn-default">
                                Retour à la liste
                            </a>
                            <c:if test="${not empty movie.id && movie.id gt 0}">
                                <c:url value="/movies/${movie.id}/characters" var="_url" />
                                <a href="${_url}" class="btn btn-default">
                                    Aller aux personnages
                                </a>
                            </c:if>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </jsp:body>
</t:layout>