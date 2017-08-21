<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--<title>Select language</title>--%>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/spin.min.js"></script>
    <script>
        $(document).ready(function () {
            createSpinner('selectLanguageSpinner');
            getLocation();
        });

        function getLocation() {
            $.ajax({
                type: "GET",
                url: 'http://ipapi.co/json/',
                success: function(data) {
                    setLocation(data['country']);
                },
                error: function (data) {
                    $.ajax({
                        type: "POST",
                        url: 'http://geoplugin.net/json.gp?jsoncallback=?',
                        success: function(data) {
                            setLocation(data['geoplugin_countryCode']);
                        },
                        error: function (data) {
                            setLocation(data);
                        }
                    });
                }
            });
        }

        function setLocation(country) {
            if(country != undefined && (country == 'UA' || country == 'RU' || country == "BY" || country == 'KZ')) {
                window.location.href = '/ru/home';
            } else {
                window.location.href = '/en/home';
            }
        }

        function createSpinner(id) {
            var opts = {
                lines: 13, // Число линий для рисования
                length: 0, // Длина каждой линии
                width: 20, // Толщина линии
                radius: 40, // Радиус внутреннего круга
                corners: 1, // Скругление углов (0..1)
                rotate: 0, // Смещение вращения
                direction: 1, // 1: по часовой стрелке, -1: против часовой стрелки
                color: '#000', // #rgb или #rrggbb или массив цветов
                speed: 2.2, // Кругов в секунду
                trail: 17, // Послесвечение
                shadow: false, // Тень(true - да; false - нет)
                hwaccel: false, // Аппаратное ускорение
                className: 'spinner', // CSS класс
                zIndex: 2e9, // z-index (по-умолчанию 2000000000)
                top: '50%', // Положение сверху относительно родителя
                left: '50%' // Положение слева относительно родителя
            };
            var target = document.getElementById(id);
            var spinner = new Spinner(opts).spin(target);
        }
    </script>
</head>
<body>
    <div id="selectLanguageSpinner"></div>
</body>
</html>
