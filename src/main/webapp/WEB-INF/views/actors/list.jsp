<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="fr_FR" />
<fmt:requestEncoding value="UTF-8" />

<c:set var="_page_current" value="actors_list" scope="request" />
<t:layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Acteurs</jsp:attribute>
    <jsp:attribute name="body_title">Liste des acteurs</jsp:attribute>
    <jsp:attribute name="_page_stylesheets">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" media="screen" />
    </jsp:attribute>
    <jsp:attribute name="_page_scripts">
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">
            $(function() {
                var actorsDataTable = $("#table-actors").dataTable({
                    language: {
                        url: "https://cdn.datatables.net/plug-ins/1.10.12/i18n/French.json"
                    },
                    columnDefs: [{
                        targets: 2,
                        orderable: false
                    }]
                });
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="box box-solid">
            <div class="box-body">
                <div class="table-responsive">
                    <table class="table table-striped table-hover" id="table-actors">
                        <thead>
                        <tr>
                            <th>
                                Prénom
                            </th>
                            <th>
                                Nom
                            </th>
                            <th>
                                Date de naissance
                            </th>
                            <th>
                                Date de décès
                            </th>
                            <th style="width: 50px;">
                            </th>
                        </tr>
                        </thead>
                        <tfoot>
                        </tfoot>
                        <tbody>
                        <c:choose>
                            <c:when test="${not empty actorsList && fn:length(actorsList) gt 0}">
                                <c:forEach items="${actorsList}" var="actor">
                                    <tr>
                                        <td>
                                            <c:out value="${actor.firstName}" />
                                        </td>
                                        <td>
                                            <c:out value="${actor.lastName}" />
                                        </td>
                                        <td>
                                            <c:if test="${not empty actor.birthDate}">
                                                <fmt:formatDate value="${actor.birthDate}" />
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${not empty actor.deathDate}">
                                                <fmt:formatDate value="${actor.deathDate}" />
                                            </c:if>
                                        </td>
                                        <td class="column-icons">
                                            <c:url value="/actors/edit/${actor.id}" var="_url" />
                                            <a href="${fn:escapeXml(_url)}">
                                                <i class="fa fa-pencil"></i>
                                            </a>
                                            <c:url value="/actors/delete/${actor.id}" var="_url" />
                                            <a href="${fn:escapeXml(_url)}">
                                                <i class="fa fa-times"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="5">
                                        Il n'existe aucun acteur dans la base de données.
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