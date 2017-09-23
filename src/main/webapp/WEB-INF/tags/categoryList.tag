<%@ attribute name="categories" type="java.util.List" required="true" %>
<%@ attribute name="source" required="true" %>
<%@ attribute name="classParameter" %>
<%@ attribute name="pageName" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="cl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${!empty categories}">
    <ul <c:if test="${!empty classParameter}">class="${classParameter}"</c:if>>
        <c:forEach var="category" items="${categories}">
            <li>
                <c:set var="pageURL"><c:if test="${!empty pageName}">${pageName}/</c:if>${category.pageName}</c:set>
                <a href="<c:url value="${source}/${pageURL}"/>">
                    <div class="category_name">${category.name}</div>
                    <c:if test="${!empty category.subCategoryList}">
                        <div class="pointer">
                            <div class="glyphicon glyphicon-chevron-right"></div>
                        </div>
                    </c:if>
                </a>
                <cl:categoryList categories="${category.subCategoryList}" pageName="${pageURL}" source="${source}"/>
            </li>
        </c:forEach>
    </ul>
</c:if>

