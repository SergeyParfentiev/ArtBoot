<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cl" %>

<jsp:include page="top.jsp"/>

<div class="content"">
    <jsp:include page="ajaxIndex.jsp"/>
</div>
<script>
    $(document).ready(function () {
        calculateChanges();
    });

    $(window).on('resize', function() {
        calculateChanges();
    });
    function calculateChanges() {
        setCategoriesWidth();
//        setFooterMargin();
//        setHeaderSize();
        setHeaderSize();
        setBreadCrumbsSize();
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
        if(mediaWidth == null) {
            mediaWidth = 280;
        }
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
        footer.css("margin-top", footerMargin);
    }

    function setBreadCrumbsSize() {
        var mainCategories = $(".main_categories");
        var mainCategoriesMargin = parseInt(mainCategories.css("margin-left"));
        var mainCategoriesWidth = mainCategories.width();
        var breadCrumb = $(".breadcrumbs");
        var navbarHeight = $(".navbar").height();
        breadCrumb.css("margin-top", navbarHeight + 20);
        breadCrumb.width(mainCategoriesWidth);
        breadCrumb.css("margin-left", mainCategoriesMargin);
        breadCrumb.css("margin-right", mainCategoriesMargin);
    }

    function setHeaderSize() {
        var mainCategories = $(".main_categories");
        var mainCategoriesMargin = parseInt(mainCategories.css("margin-left"));
        var mainCategoriesWidth = mainCategories.width();
        var navbar = $(".navbar");
        navbar.width(mainCategoriesWidth);
        navbar.css("margin-left", mainCategoriesMargin);
        navbar.css("margin-right", mainCategoriesMargin);
    }
</script>
<jsp:include page="bottom.jsp"/>