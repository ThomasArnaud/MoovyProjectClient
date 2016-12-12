<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <meta name="author" content="Thomas Arnaud, Bruno Buiret, Alexis Rabilloud" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
        <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge" />
        <title>Moovy - Connexion</title>
        <c:url value="/assets/css/bootstrap.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" media="screen" />
        <c:url value="/assets/css/admin-lte.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <c:url value="/assets/css/skin-black-light.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <%--
        <c:url value="/assets/css/icheck-square-grey.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        --%>
        <c:url value="/assets/css/common.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                Moovy
            </div>
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
                        <input type="password" class="form-control" name="password" placeholder="Mot de passe" value="Bruno" />
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
                            <%--
                            <div class="checkbox icheck">
                                <label>
                                    <input type="checkbox"> Se souvenir de moi
                                </label>
                            </div>
                            --%>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
        <c:url value="/assets/js/bootstrap.min.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
        <%--
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
        --%>
    </body>
</html>