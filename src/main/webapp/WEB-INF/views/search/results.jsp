<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<t:layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Recherche</jsp:attribute>
    <jsp:attribute name="body_title">Résultats de la recherche</jsp:attribute>
    <jsp:body>
        <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#tab-movies" data-toggle="tab">Films (<fmt:formatNumber value="${fn:length(moviesList)}" />)</a>
                </li>
                <li>
                    <a href="#tab-actors" data-toggle="tab">Acteurs (<fmt:formatNumber value="${fn:length(actorsList)}" />)</a>
                </li>
                <li>
                    <a href="#tab-directors" data-toggle="tab">Réalisateurs (<fmt:formatNumber value="${fn:length(directorsList)}" />)</a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="tab-movies">
                    <c:choose>
                        <c:when test="${not empty(moviesList) && fn:length(moviesList) gt 0}">
                            <ul class="list-responsive">
                                <c:forEach items="${moviesList}" var="movie">
                                    <li>
                                        <c:url value="/movies/edit/${movie.id}" var="_url" />
                                        <a href="${fn:escapeXml(_url)}">
                                            <c:out value="${movie.title}" />
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <p>
                                Aucun film n'a été trouvé.
                            </p>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="tab-pane" id="tab-actors">
                    <c:choose>
                        <c:when test="${not empty(actorsList) && fn:length(actorsList) gt 0}">
                            <ul class="list-responsive">
                                <c:forEach items="${actorsList}" var="actor">
                                    <li>
                                        <c:url value="/actors/edit/${actor.id}" var="_url" />
                                        <a href="${fn:escapeXml(_url)}">
                                            <c:out value="${actor.firstName} ${actor.lastName}" />
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <p>
                                Aucun acteur n'a été trouvé.
                            </p>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="tab-pane" id="tab-directors">
                    <c:choose>
                        <c:when test="${not empty(directorsList) && fn:length(directorsList) gt 0}">
                            <ul class="list-responsive">
                                <c:forEach items="${directorsList}" var="director">
                                    <li>
                                        <c:url value="/directors/edit/${director.id}" var="_url" />
                                        <a href="${fn:escapeXml(_url)}">
                                            <c:out value="${director.firstName} ${director.lastName}" />
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <p>
                                Aucun réalisateur n'a été trouvé.
                            </p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>