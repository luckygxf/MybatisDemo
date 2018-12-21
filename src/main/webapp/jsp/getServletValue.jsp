<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<h2>
    <%
        String name = (String) request.getAttribute("name");
    %>
    <%=name%>
</h2>
</body>
</html>