<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="_page_current" value="error" scope="request" />
<c:choose>
    <c:when test="${not empty _user}">
        <t:layout>
            <jsp:attribute name="_page_title">Moovy &raquo; Erreur 500</jsp:attribute>
            <jsp:attribute name="body_title"></jsp:attribute>
            <jsp:body>
                <div class="error-page">
                    <h2 class="headline text-red">
                        500
                    </h2>
                    <div class="error-content">
                        <h3>
                            <i class="fa fa-warning text-red"></i>
                            Une erreur interne est survenue.
                        </h3>
                        <p>
                            <c:out value="${exception.message}" />
                        </p>
                    </div>
                    <div class="clearfix"></div>
                    <h3>Pile d'appels</h3>
                    <c:if test="${not empty exception.stackTrace && fn:length(exception.stackTrace) gt 0}">
                        <ol>
                            <c:forEach items="${exception.stackTrace}" var="item">
                                <li>
                                    <strong>${item.fileName}</strong> à la ligne <strong>${item.lineNumber}</strong><br/>
                                    <code>${item.className}.${item.methodName}()</code>
                                </li>
                            </c:forEach>
                        </ol>
                    </c:if>
                </div>
            </jsp:body>
        </t:layout>
    </c:when>
    <c:otherwise>
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
                <c:url value="/assets/css/common.min.css" var="_url" />
                <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
                <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
                <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
                <!--[if lt IE 9]>
                    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
                <![endif]-->
            </head>
            <body class="hold-transition error-page">
                <div class="error-box">
                    <div class="error-logo">
                        <c:url value="/login" var="_url" />
                        <a href="${fn:escapeXml(_url)}">Moovy</a>
                    </div>
                    <c:if test="${not empty _flashMessages && fn:length(_flashMessages) gt 0}">
                        <c:forEach items="${_flashMessages}" var="flashMessage">
                            <div class="alert alert-${flashMessage.type} alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                    ${flashMessage.contents}
                            </div>
                        </c:forEach>
                    </c:if>
                    <div class="error-box-body">
                        <p class="error-box-msg">
                            <c:out value="${exception.message}" />
                        </p>
                        <c:if test="${not empty exception.stackTrace && fn:length(exception.stackTrace) gt 0}">
                            <ol>
                                <c:forEach items="${exception.stackTrace}" var="item">
                                    <li>
                                        <strong>${item.fileName}</strong> à la ligne <strong>${item.lineNumber}</strong><br/>
                                        <code>${item.className}.${item.methodName}()</code>
                                    </li>
                                </c:forEach>
                            </ol>
                        </c:if>
                    </div>
                </div>

                <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
                <c:url value="/assets/js/bootstrap.min.js" var="_url" />
                <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
            </body>
        </html>
    </c:otherwise>
</c:choose>