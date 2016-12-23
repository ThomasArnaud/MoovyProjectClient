<%@tag pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@attribute name="_page_title" fragment="true" required="false" %>
<%@attribute name="_page_stylesheets" fragment="true" required="false" %>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <meta name="author" content="Thomas Arnaud, Bruno Buiret, Alexis Rabilloud" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
        <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge" />
        <title><jsp:invoke fragment="_page_title" /></title>
        <c:url value="/assets/css/bootstrap.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" media="screen" />
        <c:url value="/assets/css/admin-lte.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <jsp:invoke fragment="_page_stylesheets" />
        <c:url value="/assets/css/common.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <jsp:doBody />
</html>