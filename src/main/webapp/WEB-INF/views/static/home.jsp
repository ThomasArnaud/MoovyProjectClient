<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="fr_FR" />
<fmt:requestEncoding value="UTF-8" />

<c:set var="_page_current" value="home" scope="request" />
<t:layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Accueil</jsp:attribute>
    <jsp:attribute name="body_title">Accueil</jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="info-box">
                    <span class="info-box-icon bg-aqua">
                        <i class="ion ion-ios-people-outline"></i>
                    </span>
                    <div class="info-box-content">
                        <span class="info-box-text">Utilisateurs</span>
                        <span class="info-box-number"><fmt:formatNumber value="1598" /></span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="info-box">
                    <span class="info-box-icon bg-red">
                        <c:url value="/movies" var="_url" />
                        <a href="${fn:escapeXml(_url)}">
                            <i class="fa fa-video-camera"></i>
                        </a>
                    </span>
                    <div class="info-box-content">
                        <span class="info-box-text">Films</span>
                        <span class="info-box-number"><fmt:formatNumber value="5575" /></span>
                    </div>
                </div>
            </div>
            <div class="clearfix visible-sm-block"></div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="info-box">
                    <span class="info-box-icon bg-green">
                        <c:url value="/actors" var="_url" />
                        <a href="${fn:escapeXml(_url)}">
                            <i class="fa fa-star"></i>
                        </a>
                    </span>
                    <div class="info-box-content">
                        <span class="info-box-text">Acteurs</span>
                        <span class="info-box-number"><fmt:formatNumber value="4775" /></span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="info-box">
                    <span class="info-box-icon bg-yellow">
                        <c:url value="/directors" var="_url" />
                        <a href="${fn:escapeXml(_url)}">
                            <i class="fa fa-user"></i>
                        </a>
                    </span>
                    <div class="info-box-content">
                        <span class="info-box-text">Réalisateurs</span>
                        <span class="info-box-number"><fmt:formatNumber value="5887" /></span>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>