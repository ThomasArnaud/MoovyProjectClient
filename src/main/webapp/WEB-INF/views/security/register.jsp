<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <meta name="author" content="Thomas Arnaud, Bruno Buiret, Alexis Rabilloud" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
        <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge" />
        <title>Moovy - Inscription</title>
        <c:url value="/assets/css/bootstrap.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" media="screen" />
        <c:url value="/assets/css/admin-lte.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <c:url value="/assets/css/skin-black-light.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <c:url value="/assets/css/icheck-square-grey.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <c:url value="/assets/css/common.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition register-page">
        <div class="register-box">
            <div class="register-logo">
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
            <div class="register-box-body">
                <p class="register-box-msg">
                    Inscrivez-vous pour bénéficier des services de Moovy.
                </p>
                <c:url value="/register" var="_url" />
                <form:form method="post" action="${fn:escapeXml(_url)}" modelAttribute="user">
                    <spring:bind path="email">
                        <div class="form-group has-feedback ${status.error ? "has-error" : ""}">
                            <form:input
                                path="email"
                                type="email"
                                cssClass="form-control"
                                id="email"
                                placeholder="Adresse e-mail"
                            />
                            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                            <form:errors path="email" cssClass="help-block" />
                        </div>
                    </spring:bind>
                    <spring:bind path="password">
                        <div class="form-group has-feedback ${status.error ? "has-error" : ""}">
                            <form:input
                                path="password"
                                type="password"
                                cssClass="form-control"
                                id="password"
                                placeholder="Mot de passe"
                            />
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            <form:errors path="password" cssClass="help-block" />
                        </div>
                    </spring:bind>
                    <div class="form-group has-feedback<c:if test="${false}"> has-error</c:if>">
                        <input type="password" class="form-control" name="password_confirmation" placeholder="Confirmation" />
                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                        <c:if test="${false}">
                            <span class="help-block"></span>
                        </c:if>
                    </div>
                    <spring:bind path="firstName">
                        <div class="form-group has-feedback ${status.error ? "has-error" : ""}">
                            <form:input
                                path="firstName"
                                type="text"
                                cssClass="form-control"
                                id="firstName"
                                placeholder="Prénom"
                            />
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            <form:errors path="firstName" cssClass="help-block" />
                        </div>
                    </spring:bind>
                    <spring:bind path="lastName">
                        <div class="form-group has-feedback ${status.error ? "has-error" : ""}">
                            <form:input
                                path="lastName"
                                type="text"
                                cssClass="form-control"
                                id="lastName"
                                placeholder="Nom"
                            />
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            <form:errors path="lastName" cssClass="help-block" />
                        </div>
                    </spring:bind>
                    <div class="row">
                        <div class="col-sm-8">
                            <div class="checkbox icheck">
                                <label for="terms">
                                    <input type="checkbox" name="terms" id="terms" />
                                    <c:url value="/terms" var="_url" />
                                    J'accepte les <a href="${fn:escapeXml(_url)}">conditions d'utilisation</a>
                                </label>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <button type="submit" class="btn btn-default btn-block btn-flat">Inscription</button>
                        </div>
                    </div>
                </form:form>
                <p class="text-center margin-top-10-sm" style="margin-bottom: 0;">
                    <c:url value="/login" var="_url" />
                    <a href="${fn:escapeXml(_url)}">
                        Connectez-vous
                    </a>
                </p>
            </div>
        </div>

    <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <c:url value="/assets/js/bootstrap.min.js" var="_url" />
    <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
    <c:url value="/assets/js/icheck.min.js" var="_url" />
    <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
    <script type="text/javascript">
        $(function() {
            $("input").iCheck({
                checkboxClass: "icheckbox_square-grey",
                radioClass: "iradio_square-grey",
                increaseArea: "20%"
            });
        });
    </script>
    </body>
</html>