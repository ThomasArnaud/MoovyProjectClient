<%@tag pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@attribute name="_page_title" fragment="true" required="false" %>
<%@attribute name="_page_stylesheets" fragment="true" required="false" %>
<%@attribute name="_page_scripts" fragment="true" required="false" %>
<%@attribute name="body_title" fragment="true" required="true" %>

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
        <c:url value="/assets/css/skin-black-light.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <c:url value="/assets/css/common.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <jsp:invoke fragment="_page_stylesheets" />
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition skin-black-light sidebar-mini">
        <div class="wrapper">
            <header class="main-header">
                <c:url value="/" var="_url" />
                <a href="${fn:escapeXml(_url)}" class="logo">
                    <span class="logo-mini"><b>M</b></span>
                    <span class="logo-lg"><b>M</b>oovy</span>
                </a>
                <nav class="navbar navbar-static-top">
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Afficher / Cacher la navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Prénom Nom
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="user-header">
                                        <p>
                                            Prénom Nom
                                            <small>Membre depuis Date</small>
                                        </p>
                                    </li>
                                    <li class="user-body">
                                        <div class="row">
                                            <div class="col-xs-4 text-center">
                                                <a href="#">Followers</a>
                                            </div>
                                            <div class="col-xs-4 text-center">
                                                <a href="#">Sales</a>
                                            </div>
                                            <div class="col-xs-4 text-center">
                                                <a href="#">Friends</a>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="user-footer">
                                        <div class="pull-left">
                                            <a href="#" class="btn btn-default btn-flat">
                                                Profil
                                            </a>
                                        </div>
                                        <div class="pull-right">
                                            <c:url value="/logout" var="_url" />
                                            <a href="${fn:escapeXml(_url)}" class="btn btn-default btn-flat">
                                                Déconnexion
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
            <aside class="main-sidebar">
                <section class="sidebar">
                    <c:url value="/search" var="_url" />
                    <form action="${fn:escapeXml(_url)}" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input
                                type="text"
                                name="q"
                                class="form-control"
                                placeholder="Rechercher..."
                                <c:if test="${not empty _search && fn:length(_search) gt 0}">
                                    value="<c:out value="${_search}" />"
                                </c:if>
                            />
                            <span class="input-group-btn">
                                <button type="submit" id="search-btn" class="btn btn-flat">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </form>
                    <ul class="sidebar-menu">
                        <li<c:if test="${not empty _page_current && _page_current == 'home'}"> class="active"</c:if>>
                            <c:url value="/" var="_url" />
                            <a href="${fn:escapeXml(_url)}">
                                <i class="fa fa-home"></i>
                                <span>Accueil</span>
                            </a>
                        </li>
                        <li class="treeview<c:if test="${not empty _page_current && fn:startsWith(_page_current, 'movies_')}"> active</c:if>">
                            <a href="#">
                                <i class="fa fa-video-camera"></i>
                                <span>Films</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li<c:if test="${not empty _page_current && _page_current == 'movies_list'}"> class="active"</c:if>>
                                    <c:url value="/movies" var="_url" />
                                    <a href="${fn:escapeXml(_url)}">
                                        <i class="fa fa-angle-right"></i>
                                        Consulter la liste des films
                                    </a>
                                </li>
                                <li<c:if test="${not empty _page_current && _page_current == 'movies_add'}"> class="active"</c:if>>
                                    <c:url value="/movies/add" var="_url" />
                                    <a href="${fn:escapeXml(_url)}">
                                        <i class="fa fa-angle-right"></i>
                                        Ajouter un nouveau film
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="treeview<c:if test="${not empty _page_current && fn:startsWith(_page_current, 'actors_')}"> active</c:if>">
                            <a href="#">
                                <i class="fa fa-star"></i>
                                <span>Acteurs</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li<c:if test="${not empty _page_current && _page_current == 'actors_list'}"> class="active"</c:if>>
                                    <c:url value="/actors" var="_url" />
                                    <a href="${fn:escapeXml(_url)}">
                                        <i class="fa fa-angle-right"></i>
                                        Consulter la liste des acteurs
                                    </a>
                                </li>
                                <li<c:if test="${not empty _page_current && _page_current == 'actors_add'}"> class="active"</c:if>>
                                    <c:url value="/actors/add" var="_url" />
                                    <a href="${fn:escapeXml(_url)}">
                                        <i class="fa fa-angle-right"></i>
                                        Ajouter un nouvel acteur
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="treeview<c:if test="${not empty _page_current && fn:startsWith(_page_current, 'directors_')}"> active</c:if>">
                            <a href="#">
                                <i class="fa fa-user"></i>
                                <span>Réalisateurs</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li<c:if test="${not empty _page_current && _page_current == 'directors_list'}"> class="active"</c:if>>
                                    <c:url value="/directors" var="_url" />
                                    <a href="${fn:escapeXml(_url)}">
                                        <i class="fa fa-angle-right"></i>
                                        Consulter la liste des réalisateurs
                                    </a>
                                </li>
                                <li<c:if test="${not empty _page_current && _page_current == 'directors_add'}"> class="active"</c:if>>
                                    <c:url value="/directors/add" var="_url" />
                                    <a href="${fn:escapeXml(_url)}">
                                        <i class="fa fa-angle-right"></i>
                                        Ajouter un nouveau réalisateur
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </section>
            </aside>
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        <jsp:invoke fragment="body_title" />
                    </h1>
                </section>
                <section class="content">
                    <c:if test="${not empty _flashMessages && fn:length(_flashMessages) gt 0}">
                        <c:forEach items="${_flashMessages}" var="flashMessage">
                            <div class="alert alert-${flashMessage.type} alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                    ${flashMessage.contents}
                            </div>
                        </c:forEach>
                    </c:if>
                    <jsp:doBody />
                </section>
            </div>
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 1.0
                </div>
                &copy; <a href="https://github.com/ThomasArnaud/MoovyProjectClient">Polytech Lyon</a>, 2016
            </footer>
            <aside class="control-sidebar control-sidebar-dark">
            </aside>
            <div class="control-sidebar-bg"></div>
        </div>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
        <c:url value="/assets/js/bootstrap.min.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
        <c:url value="/assets/js/admin-lte.min.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
        <jsp:invoke fragment="_page_scripts" />
    </body>
</html>