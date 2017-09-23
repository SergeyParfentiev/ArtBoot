<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cl" %>

<jsp:include page="top.jsp"/>

<div class="content">
    <div class="main_categories">
        <div style="">
            <div class="categories_menu">
                <cl:categoryList categories="${currentMenu}" classParameter="nav categories_list" source="${source}"/>
            </div>
            <div class="categories_content" style="max-width: 848px; text-align: left; background-color: gray">
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

${source}
${parameter}
${param}
<script>
    $(document).ready(function () {
        calculateChanges();
    });

    $(window).on('resize', function() {
        calculateChanges();
    });
    function calculateChanges() {
        setCategoriesWidth();
        setFooterMargin()
    }

    function setCategoriesWidth() {
        var windowWidth = $(window).width();
        var menuWidth = $(".categories_menu").width();
        var mediaWidth = $(".media_content").width();
        var category = $(".categories_content");
        var realForContentWidth = windowWidth - menuWidth;
        var maxMediaNumber = 3;
        var mediaBorder = 4;
        var setNewWidth = false;
        var width;
        for(var i = 1; i <= maxMediaNumber; i++) {
            width = i * mediaWidth + (i - 1) * mediaBorder;
            if(width > realForContentWidth) {
                category.width(width - mediaWidth - mediaBorder);
                setNewWidth = true;
                break;
            }
        }

        if(!setNewWidth) {
            category.width(width);
        }
    }

    function setFooterMargin() {
        var windowHeight = $(document).height();
        var content = $(".content");
        var footer = $(".footer");
        var contentHeight = content.height();
        var footerMargin = windowHeight - contentHeight - footer.height()
                - parseInt(content.css("margin-top")) - parseInt(content.css("margin-bottom"));
        footer.css("margin-top", footerMargin + "px");
    }
</script>
<jsp:include page="bottom.jsp"/>