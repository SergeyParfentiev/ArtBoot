<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cl" %>

<jsp:include page="top.jsp"/>

<div class="content">
    <div class="main_categories">
        <div style="display: table-row">
            <div class="categories_menu">
                <cl:categoryList categories="${list}" classParameter="nav categories_list"/>
            </div>
            <div class="categories_content" style="max-width: 848px; text-align: center">
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
</div>


<script>
    $(document).ready(function () {
    setCategoriesWidth();
    });

    window.onresize = function() {
        setCategoriesWidth();
    };

    function setCategoriesWidth() {
        var windowWidth = $(window).width();
        var menuWidth = $(".categories_menu").width();
        var mediaContentWidth = $(".media_content").width();
        var category = $(".categories_content");
        var elementList = category.find(".media_content");

        var realForContentWidth = windowWidth - menuWidth;

        for(var i = 1; i < elementList.length; i++) {
            var width = i * mediaContentWidth + (i - 1) * 4;
            if(width > realForContentWidth) {
                category.width(width - mediaContentWidth);
                break;
            }
        }
    }
</script>
<jsp:include page="bottom.jsp"/>