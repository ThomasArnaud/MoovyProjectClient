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
                            <c:choose>
                                <c:when test="${not isServerSide}">
                                    Une erreur interne est survenue.
                                </c:when>
                                <c:otherwise>
                                    Une erreur est survenue côté serveur.
                                </c:otherwise>
                            </c:choose>
                        </h3>
                        <p>
                            <c:out value="${exception.message}" />
                        </p>
                    </div>
                    <c:if test="${not empty exception.stackTrace && fn:length(exception.stackTrace) gt 0}">
                        <div class="clearfix"></div>
                        <h3>Pile d'appels</h3>
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
        <t:unlogged-layout>
            <jsp:attribute name="_page_title">Moovy &raquo; Erreur</jsp:attribute>
            <jsp:body>
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
            </jsp:body>
        </t:unlogged-layout>
    </c:otherwise>
</c:choose>