<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:unlogged-layout>
    <jsp:attribute name="_page_title">Moovy &raquo; Conditions d'utilisation</jsp:attribute>
    <jsp:body>
        <body class="hold-transition terms-page">
            <div class="terms-box">
                <div class="terms-logo">
                    <c:url value="/login" var="_url" />
                    <a href="${fn:escapeXml(_url)}">
                        Moovy
                    </a>
                </div>
                <c:if test="${not empty _flashMessages && fn:length(_flashMessages) gt 0}">
                    <c:forEach items="${_flashMessages}" var="flashMessage">
                        <div class="alert alert-${flashMessage.type} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            ${flashMessage.contents}
                        </div>
                    </c:forEach>
                </c:if>
                <div class="terms-box-body">
                    <p class="terms-box-msg">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla auctor quis nibh vitae accumsan.
                        Praesent pellentesque mollis leo vel egestas. Ut sit amet tortor et sapien posuere porta.
                        Nam vitae scelerisque diam. Etiam sed odio felis. Morbi scelerisque purus vitae quam egestas,
                        a tempor nunc porta. Nullam quis eros aliquam, aliquam est bibendum, sodales augue.<br/>
                        Quisque sodales massa imperdiet felis placerat, ac tristique mauris aliquam. Sed rutrum risus
                        feugiat consectetur euismod. Curabitur mollis nec orci elementum feugiat. Nunc a pretium lectus.
                        Duis ipsum orci, semper at dui sit amet, molestie volutpat leo. Quisque efficitur porttitor
                        odio, at rhoncus lorem accumsan vitae.
                    </p>
                    <p class="terms-box-msg">
                        Sed suscipit, est facilisis scelerisque interdum, augue augue tempus lectus, et vestibulum
                        libero erat id nisl. Fusce sollicitudin nulla vel urna dictum eleifend nec a tortor. Nunc
                        quis laoreet mauris. Aliquam tellus tellus, pharetra laoreet blandit in, semper eget quam.
                        Morbi pulvinar purus fermentum arcu ornare bibendum. Morbi dignissim ligula et felis pharetra
                        fringilla. Maecenas erat purus, sodales maximus felis at, egestas pellentesque enim.<br/>
                        Praesent malesuada tellus a dui euismod imperdiet. Donec mollis convallis elit, sed tincidunt
                        nisi semper vitae. Cras id tellus scelerisque, lacinia turpis id, posuere lorem. Vivamus dictum
                        nec arcu in cursus. Nunc tincidunt, mauris laoreet euismod tincidunt, turpis elit blandit magna,
                        in suscipit dui risus in purus. Etiam et vulputate ipsum. Class aptent taciti sociosqu ad litora
                        torquent per conubia nostra, per inceptos himenaeos. Pellentesque habitant morbi tristique
                        senectus et netus et malesuada fames ac turpis egestas. Nullam eu congue ipsum, in tempus
                        lorem.<br/>
                        Maecenas iaculis odio euismod dui accumsan, non aliquam purus malesuada. Lorem ipsum dolor sit
                        amet, consectetur adipiscing elit. Aliquam erat volutpat. Interdum et malesuada fames ac ante
                        ipsum primis in faucibus. In ullamcorper dictum felis. Sed scelerisque orci at risus tempor
                        feugiat. Suspendisse eget tortor lectus. In pretium tempor pretium.<br/>
                        Vestibulum sit amet quam finibus, dignissim odio quis, pulvinar tortor. Duis elementum purus vel
                        pulvinar ornare. Nam finibus maximus purus luctus malesuada. Mauris eget urna lectus. Ut nec
                        massa tincidunt, fermentum dolor in, interdum est. Nam accumsan mauris ac pellentesque rhoncus.
                        Ut varius varius mauris, in laoreet libero hendrerit vel.
                    </p>
                    <p class="terms-box-msg">
                        Praesent eleifend ipsum sed eleifend iaculis. Nullam imperdiet a odio vel imperdiet. Proin
                        vulputate sit amet mi nec condimentum. Cras laoreet tempus lectus, eget rhoncus nisl dictum ac.
                        Aenean a eros porttitor, gravida lorem vel, pulvinar metus. Curabitur sed placerat est.
                        Phasellus dui nibh, sodales in semper eu, lobortis eget purus. Vivamus ornare dui tortor,
                        viverra sodales lectus placerat ut.<br/>
                        Duis vehicula augue neque, id vestibulum felis feugiat ac. In tempus lectus sollicitudin varius
                        semper. Vivamus tempus eget quam eget tempor. Ut eros magna, consectetur eget odio eget,
                        posuere dictum tortor. Mauris augue nisi, finibus vel dui vel, ultrices tempor ex. Morbi a
                        felis nec erat aliquet feugiat vitae at odio. Phasellus viverra tempor nunc. Suspendisse
                        sit amet ex ut urna blandit sollicitudin. Pellentesque id consequat lorem. Cras ac convallis
                        elit.<br/>
                        Integer dignissim condimentum nunc, id feugiat risus eleifend in. Integer mattis suscipit felis
                        quis viverra. Ut at ligula vel eros egestas porttitor.
                    </p>
                    <div class="row">
                        <div class="col-sm-6">
                            <c:url value="/login" var="_url" />
                            <a href="${fn:escapeXml(_url)}" class="btn btn-default btn-block btn-flat">
                                Connectez-vous
                            </a>
                        </div>
                        <div class="col-sm-6 margin-top-15-sm">
                            <c:url value="/register" var="_url" />
                            <a href="${fn:escapeXml(_url)}" class="btn btn-default btn-block btn-flat">
                                Inscrivez-vous
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
            <c:url value="/assets/js/bootstrap.min.js" var="_url" />
            <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
        </body>
    </jsp:body>
</t:unlogged-layout>