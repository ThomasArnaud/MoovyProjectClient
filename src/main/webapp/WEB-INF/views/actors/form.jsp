<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Acteurs &raquo; ${_page_title}</jsp:attribute>
    <jsp:attribute name="body_title">${_body_title}</jsp:attribute>
    <jsp:attribute name="_page_stylesheets">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css" media="screen" />
    </jsp:attribute>
    <jsp:attribute name="_page_scripts">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/locales/bootstrap-datepicker.fr.min.js"></script>
        <script type="text/javascript">
            $(function() {
                $("#birthDate, #deathDate").datepicker({
                    language: "fr"
                });
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="box box-solid">
            <div class="box-body">
                <c:url value="/actors/submit" var="_url" />
                <form:form method="post" action="${fn:escapeXml(_url)}" modelAttribute="actor" cssClass="form-horizontal">
                    <c:if test="${empty actor.id || actor.id eq 0}">
                        <input type="hidden" name="_is_new" value="1" />
                    </c:if>
                    <form:input path="id" type="hidden" />
                    <spring:bind path="firstName">
                        <div class="form-group ${status.error ? "has-error" : ""}">
                            <form:label path="firstName" for="firstName" cssClass="control-label col-sm-2">
                                Prénom*
                            </form:label>
                            <div class="col-sm-10">
                                <form:input
                                    path="firstName"
                                    type="text"
                                    cssClass="form-control"
                                    id="firstName"
                                />
                                <form:errors path="firstName" cssClass="help-block" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="lastName">
                        <div class="form-group ${status.error ? "has-error" : ""}">
                            <form:label path="lastName" for="lastName" cssClass="control-label col-sm-2">
                                Nom*
                            </form:label>
                            <div class="col-sm-10">
                                <form:input
                                    path="lastName"
                                    type="text"
                                    cssClass="form-control"
                                    id="lastName"
                                />
                                <form:errors path="lastName" cssClass="help-block" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="birthDate">
                        <div class="form-group ${status.error ? "has-error" : ""}">
                            <form:label path="birthDate" for="birthDate" cssClass="control-label col-sm-2">
                                Date de naissance
                            </form:label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <form:input
                                            path="birthDate"
                                            type="text"
                                            cssClass="form-control"
                                            id="birthDate"
                                    />
                                    <span class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </span>
                                </div>
                                <form:errors path="birthDate" cssClass="help-block" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="deathDate">
                        <div class="form-group ${status.error ? "has-error" : ""}">
                            <form:label path="deathDate" for="deathDate" cssClass="control-label col-sm-2">
                                Date de décès
                            </form:label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <form:input
                                            path="deathDate"
                                            type="text"
                                            cssClass="form-control"
                                            id="deathDate"
                                    />
                                    <span class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </span>
                                </div>
                                <form:errors path="deathDate" cssClass="help-block" />
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
                            <c:url value="/actors" var="_url" />
                            <a href="${_url}" class="btn btn-default">
                                Retour à la liste
                            </a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </jsp:body>
</t:layout>