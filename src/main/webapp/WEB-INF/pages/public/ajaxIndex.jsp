<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cl" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<input type="hidden" name="ajax" value="true">
<section class="ajaxBreadcrumbs" style="display: none">
    <ol class="arrows">
        <c:forEach items="${breadcrumbsPath}" var="path" varStatus="status">
            <c:choose>
                <c:when test="${breadcrumbsPath.size() != status.count}">
                    <li><a href="${pageContext.request.contextPath}${path.key}">${path.value}</a></li>
                </c:when>
                <c:otherwise>
                    <li><a>${path.value}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </ol>
</section>

<div class="main_categories" style="background-color: rgb(246, 248, 253)">
    <div style="">
        <div class="categories_menu">
            <cl:categoryList categories="${current_menu}" classParameter="nav categories_list" source="${current_menu_source}"/>
        </div>
        <div class="categories_content" style="max-width: 848px; text-align: left;">
            <div class="media_content">
                <iframe width="280" height="230" src="<c:url value='/images/play-button.png'/>" frameborder="0" allowfullscreen></iframe>
            </div>
            <div class="media_content">
                <iframe width="280" height="230" src="<c:url value='/images/mail1.png'/>" frameborder="0" allowfullscreen></iframe>
            </div>
            <div class="media_content">
                <iframe width="280" height="230" src="<c:url value='/images/mail2.png'/>" frameborder="0" allowfullscreen></iframe>
            </div>
            <div class="media_content">
                <iframe width="280" height="230" src="<c:url value='/images/mail3.png'/>" frameborder="0" allowfullscreen></iframe>
            </div>
            <img style="height: 200px; width: 250px" src="<c:url value="/images/mail3.png"/>">
            <div class="media_content">
                <iframe width="280" height="230" src="https://www.youtube.com/embed/fxnf1lIIepw" frameborder="0" allowfullscreen></iframe>
            </div>
            <%--<div class="media_content">--%>
            <%--<iframe width="280" height="230" src="https://www.youtube.com/embed/fxnf1lIIepw" frameborder="0" allowfullscreen></iframe>--%>
            <%--</div>--%>
            <%--<div class="media_content">--%>
            <%--<iframe width="280" height="230" src="https://www.youtube.com/embed/fxnf1lIIepw" frameborder="0" allowfullscreen></iframe>--%>
            <%--</div>--%>
            <%--<div class="media_content">--%>
            <%--<iframe width="280" height="230" src="https://www.youtube.com/embed/fxnf1lIIepw" frameborder="0" allowfullscreen></iframe>--%>
            <%--</div>--%>
            <%--<div class="media_content">--%>
            <%--<iframe width="280" height="230" src="https://www.youtube.com/embed/fxnf1lIIepw" frameborder="0" allowfullscreen></iframe>--%>
            <%--</div>--%>
            <%--<div class="media_content">--%>
            <%--<iframe width="280" height="230" src="https://www.youtube.com/embed/fxnf1lIIepw" frameborder="0" allowfullscreen></iframe>--%>
            <%--</div>--%>
            <%--<div class="media_content">--%>
            <%--<iframe width="280" height="230" src="https://www.youtube.com/embed/fxnf1lIIepw" frameborder="0" allowfullscreen></iframe>--%>
            <%--</div>--%>
            <%--<div class="media_content">--%>
            <%--<iframe width="280" height="230" src="https://www.youtube.com/embed/fxnf1lIIepw" frameborder="0" allowfullscreen></iframe>--%>
            <%--</div>--%>
        </div>
    </div>
</div>