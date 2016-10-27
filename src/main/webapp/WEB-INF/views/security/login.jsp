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
        <c:url value="/assets/css/icheck-square-grey.css" var="_url" />
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
                    <div class="form-group has-feedback">
                        <input type="email" class="form-control" name="email" placeholder="Adresse email" />
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" name="password" placeholder="Mot de passe" />
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-sm-8">
                            <div class="checkbox icheck">
                                <label>
                                    <input type="checkbox"> Se souvenir de moi
                                </label>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <button type="submit" class="btn btn-default btn-block btn-flat">Connexion</button>
                        </div>
                    </div>
                </form>
                <c:url value="/register" var="_url" />
                <p class="text-center margin-top-10-sm" style="margin-bottom: 0;">
                    <a href="${fn:escapeXml(_url)}">
                        Inscrivez-vous
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