<%--
  Created by IntelliJ IDEA.
  User: CHANLYANG
  Date: 2018/9/3
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.getRequestDispatcher("/MainServlet").forward(request, response);
%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

</body>
</html>
