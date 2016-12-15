<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="/WEB-INF/tags/duration_functions.tld" prefix="my" %>

<fmt:setLocale value="fr_FR" />
<fmt:requestEncoding value="UTF-8" />

<c:set var="_page_current" value="movies_list" scope="request" />
<t:layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Films</jsp:attribute>
    <jsp:attribute name="body_title">Liste des films</jsp:attribute>
    <jsp:attribute name="_page_stylesheets">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" media="screen" />
    </jsp:attribute>
    <jsp:attribute name="_page_scripts">
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">
            $(function() {
                var moviesDataTable = $("#table-movies").dataTable({
                    language: {
                        url: "https://cdn.datatables.net/plug-ins/1.10.12/i18n/French.json"
                    },
                    columnDefs: [{
                        targets: 6,
                        orderable: false
                    }]
                });

                // Set up tooltips
                $("[data-tooltip]").tooltip({
                    container: "body"
                });
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="box box-solid">
            <div class="box-body">
                <div class="table-responsive">
                    <table class="table table-striped table-hover" id="table-movies">
                        <thead>
                            <tr>
                                <th>
                                    Titre
                                </th>
                                <th>
                                    Date de sortie
                                </th>
                                <th>
                                    Durée
                                </th>
                                <th>
                                    Budget
                                </th>
                                <th>
                                    Bénéfices
                                </th>
                                <th>
                                    Réalisateur
                                </th>
                                <th style="width: 75px;">
                                </th>
                            </tr>
                        </thead>
                        <tfoot>
                        </tfoot>
                        <tbody>
                            <c:choose>
                                <c:when test="${not empty moviesList && fn:length(moviesList) gt 0}">
                                    <c:forEach items="${moviesList}" var="movie">
                                        <tr data-movie-id="${movie.id}">
                                            <td>
                                                <c:out value="${movie.title}" />
                                            </td>
                                            <td data-order="<fmt:formatDate value="${movie.releaseDate}" pattern="yyyyMMdd"/>">
                                                <fmt:formatDate value="${movie.releaseDate}" />
                                            </td>
                                            <td data-order="${movie.duration}">
                                                <my:formatMinutes value="${movie.duration}" />
                                            </td>
                                            <td data-order="${movie.budget}">
                                                <fmt:formatNumber value="${movie.budget}" type="currency" />
                                            </td>
                                            <td data-order="${movie.benefit}">
                                                <fmt:formatNumber value="${movie.benefit}" type="currency" />
                                            </td>
                                            <td>
                                                <c:out value="${movie.director.firstName} ${movie.director.lastName}" />
                                            </td>
                                            <td class="column-icons">
                                                <c:url value="/movies/${movie.id}/characters" var="_url" />
                                                <a href="${fn:escapeXml(_url)}">
                                                    <i class="fa fa-users"></i>
                                                </a>
                                                <c:url value="/movies/edit/${movie.id}" var="_url" />
                                                <a href="${fn:escapeXml(_url)}">
                                                    <i class="fa fa-pencil"></i>
                                                </a>
                                                <c:url value="/movies/delete/${movie.id}" var="_url" />
                                                <a href="${fn:escapeXml(_url)}">
                                                    <i class="fa fa-times"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="8">
                                            Il n'existe aucun film dans la base de données.
                                        </td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>