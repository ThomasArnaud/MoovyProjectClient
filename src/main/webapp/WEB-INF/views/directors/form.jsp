<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Réalisateurs &raquo; ${_page_title}</jsp:attribute>
    <jsp:attribute name="body_title">${_body_title}</jsp:attribute>
    <jsp:body>
        <div class="box box-solid">
            <div class="box-body">
                <c:url value="/directors/submit" var="_url" />
                <form:form method="post" action="${fn:escapeXml(_url)}" modelAttribute="director" cssClass="form-horizontal">
                    <c:if test="${empty director.id || director.id eq 0}">
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
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-2 btn-group">
                            <button type="submit" class="btn btn-success">
                                Enregistrer
                            </button>
                            <button type="reset" class="btn btn-danger">
                                Réinitialiser
                            </button>
                            <c:url value="/directors" var="_url" />
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