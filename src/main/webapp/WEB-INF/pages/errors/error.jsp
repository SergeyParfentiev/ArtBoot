<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>${errorMsg}</title>
    <style>
        body {  background-color: #2a2627;  margin:20px;}
        h1 { color: #ffffff; }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/errors.css">
</head>
<body>

    <h1 id="err">${errorMsg}</h1>

</body>
</html>