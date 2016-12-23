<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:unlogged-layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Connexion</jsp:attribute>
    <jsp:body>
        <body class="hold-transition login-page">
            <div class="login-box">
                <div class="login-logo">
                    Moovy
                </div>
                <c:if test="${not empty _flashMessages && fn:length(_flashMessages) gt 0}">
                    <c:forEach items="${_flashMessages}" var="flashMessage">
                        <div class="alert alert-${flashMessage.type} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            ${flashMessage.contents}
                        </div>
                    </c:forEach>
                </c:if>
                <div class="login-box-body">
                    <p class="login-box-msg">
                        Connectez-vous pour accéder aux services de Moovy.
                    </p>
                    <c:url value="/login" var="_url" />
                    <form action="${fn:escapeXml(_url)}" method="post">
                        <div class="form-group has-feedback<c:if test="${not empty emailError}"> has-error</c:if>">
                            <input type="email" class="form-control" name="email" placeholder="Adresse email" value="bruno.buiret@etu.univ-lyon1.fr<%--<c:if test="${not empty lastEmail}"><c:out value="${lastEmail}" /></c:if>--%>" />
                            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                            <c:if test="${not empty emailError}">
                                <span class="text-red"><c:out value="${emailError}" /></span>
                            </c:if>
                        </div>
                        <div class="form-group has-feedback<c:if test="${not empty passwordError}"> has-error</c:if>">
                            <input type="password" class="form-control" name="password" placeholder="Mot de passe" value="admin" />
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            <c:if test="${not empty passwordError}">
                                <span class="text-red"><c:out value="${passwordError}" /></span>
                            </c:if>
                        </div>
                        <c:if test="${not empty loginError}">
                            <p class="text-red">
                                <c:out value="${loginError}" />
                            </p>
                        </c:if>
                        <div class="row">
                            <div class="col-sm-6">
                                <button type="submit" class="btn btn-default btn-block btn-flat">Connexion</button>
                            </div>
                            <div class="col-sm-6 margin-top-15-sm">
                                <c:url value="/register" var="_url" />
                                <a href="${fn:escapeXml(_url)}" class="btn btn-default btn-block btn-flat">
                                    Inscrivez-vous
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
            <c:url value="/assets/js/bootstrap.min.js" var="_url" />
            <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
        </body>
    </jsp:body>
</t:unlogged-layout>