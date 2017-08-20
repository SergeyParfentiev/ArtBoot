<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Select</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
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
                window.location.href = '/ru/main';
            } else {
                window.location.href = '/en/main';
            }
        }
    </script>
</head>
<body>
</body>
</html>
