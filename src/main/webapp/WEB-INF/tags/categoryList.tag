<%@ attribute name="categories" type="java.util.List" required="true" %>
<%@ attribute name="classParameter" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="cl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${!empty categories}">
    <ul <c:if test="${!empty classParameter}">class="${classParameter}"</c:if>>
        <c:forEach var="category" items="${categories}">
            <li>
                <a href="#">
                    <div class="category_name">${category.name}</div>
                    <c:if test="${!empty category.subCategoryList}">
                        <div class="pointer">
                            <div class="glyphicon glyphicon-chevron-right"></div>
                        </div>
                    </c:if>
                </a>
                <cl:categoryList categories="${category.subCategoryList}"/>
            </li>
        </c:forEach>
    </ul>
</c:if>

