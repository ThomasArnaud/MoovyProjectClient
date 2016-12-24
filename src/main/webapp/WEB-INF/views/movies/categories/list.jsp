<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="_page_current" value="movies_categories_list" scope="request" />
<t:layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Films &raquo; Catégories</jsp:attribute>
    <jsp:attribute name="body_title">
        Liste des catégories
        <small>Films</small>
    </jsp:attribute>
    <jsp:attribute name="_page_stylesheets">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" media="screen" />
    </jsp:attribute>
    <jsp:attribute name="_page_scripts">
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">
            $(function() {
                var categoriesDataTable = $("#table-categories").dataTable({
                    language: {
                        url: "https://cdn.datatables.net/plug-ins/1.10.12/i18n/French.json"
                    },
                    columnDefs: [{
                        targets: 1,
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
                    <table class="table table-striped table-hover" id="table-categories">
                        <thead>
                            <tr>
                                <th>
                                    Nom
                                </th>
                                <th style="width: 50px;">
                                </th>
                            </tr>
                        </thead>
                        <tfoot>
                        </tfoot>
                        <tbody>
                            <c:choose>
                                <c:when test="${not empty categoriesList && fn:length(categoriesList) gt 0}">
                                    <c:forEach items="${categoriesList}" var="category">
                                        <tr>
                                            <td>
                                                <c:out value="${category.name}" />
                                            </td>
                                            <td class="column-icons">
                                                <c:url value="/movies/categories/edit/${category.id}" var="_url" />
                                                <a href="${fn:escapeXml(_url)}">
                                                    <i class="fa fa-pencil"></i>
                                                </a>
                                                <c:url value="/movies/categories/delete/${category.id}" var="_url" />
                                                <a href="${fn:escapeXml(_url)}">
                                                    <i class="fa fa-times"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="2">
                                            Il n'existe aucune catégorie dans la base de données.
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