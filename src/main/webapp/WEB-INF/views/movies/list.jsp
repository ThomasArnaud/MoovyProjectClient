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
                // Initialize vars
                var $moviesTable = $("#table-movies");
                var charactersArray = {};

                <c:if test="${not empty moviesList && fn:length(moviesList) gt 0}">
                    <c:forEach items="${moviesList}" var="movie">
                        charactersArray[${movie.id}] = [];

                        <c:if test="${not empty movie.characters && fn:length(movie.characters) gt 0}">
                            <c:forEach items="${movie.characters}" var="character">
                                charactersArray[${movie.id}].push({
                                    name: "<c:out value="${character.name}" />",
                                    actor: "<c:out value="${character.id.actor.firstName} ${character.id.actor.lastName}" />"
                                });
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </c:if>

                // Set up movies data table
                var moviesDataTable = $moviesTable.dataTable({
                    language: {
                        url: "https://cdn.datatables.net/plug-ins/1.10.12/i18n/French.json"
                    },
                    columnDefs: [{
                        targets: 6,
                        orderable: false
                    }]
                });

                // Set up characters details listener
                var $charactersModal = $("#modal-characters");
                var charactersCache = {};
                <c:url value="/movies/{movieId}/characters" var="_url" />
                var charactersEditionUrl = "${fn:escapeXml(_url)}";

                $charactersModal.on("show.bs.modal", function(e) {
                    // Initialize vars
                    var $row = $(e.relatedTarget).closest("tr");
                    var movieId = $row.data("movie-id");

                    // Build cache if necessary
                    if(typeof charactersCache[movieId] === "undefined") {
                        var charactersList = "<ul class='list-responsive'>";

                        for(var i = 0, j = charactersArray[movieId].length; i < j; i++) {
                            charactersList += "<li>" + charactersArray[movieId][i].name + " joué(e) par " + charactersArray[movieId][i].actor + "</li>";
                        }

                        charactersList += "</ul>";
                        charactersCache[movieId] = charactersList;
                    }

                    // Set up modal
                    $charactersModal.find(".modal-title").html("Personnages de <cite>" + $row.find("td:eq(0)").text() + "</cite>");
                    $charactersModal.find(".modal-body").html(charactersCache[movieId]);
                    $charactersModal.find("a").attr("href", charactersEditionUrl.replace("{movieId}", movieId));
                });

                // Set up tooltips
                $("[data-tooltip]").tooltip({
                    container: "body"
                });

                $moviesTable.find("a[data-tooltip]").click(function(e) {
                    $(this).tooltip("hide");
                });

                $moviesTable.on('hidden.bs.tooltip', function () {
                    console.log($(this));
                })
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
                                                <c:choose>
                                                    <c:when test="${not empty movie.characters && fn:length(movie.characters) gt 0}">
                                                        <a
                                                            href="#"
                                                            data-toggle="modal"
                                                            data-target="#modal-characters"
                                                            data-tooltip
                                                            data-placement="left"
                                                            title="${fn:length(movie.characters)} ${fn:length(movie.characters) gt 1 ? "personnages" : "personnage"}"
                                                        >
                                                            <i class="fa fa-users"></i>
                                                        </a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <i class="fa fa-users"></i>
                                                    </c:otherwise>
                                                </c:choose>
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
        <div class="modal fade" id="modal-characters" tabindex="-1" role="dialog" aria-labelledby="Characters modal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fermer">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title"></h4>
                    </div>
                    <div class="modal-body">
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-default">
                            Éditer
                        </a>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>