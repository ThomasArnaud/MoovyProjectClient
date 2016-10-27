<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Recherche</jsp:attribute>
    <jsp:attribute name="body_title">Résultats de la recherche</jsp:attribute>
    <jsp:body>
        <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#tab-movies" data-toggle="tab">Films (?)</a>
                </li>
                <li>
                    <a href="#tab-actors" data-toggle="tab">Acteurs (?)</a>
                </li>
                <li>
                    <a href="#tab-directors" data-toggle="tab">Réalisateurs (?)</a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="tab-movies">
                </div>
                <div class="tab-pane" id="tab-actors">
                </div>
                <div class="tab-pane" id="tab-directors">
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>