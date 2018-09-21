<%--
  Created by IntelliJ IDEA.
  User: CHANLYANG
  Date: 2018/9/20
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="auto" items="${autos}">
        <img src="${auto.pic}">
        <input type="text" value="${auto.pic}">
        <input type="text" value="<%=basePath%>">
    </c:forEach>
</body>
</html>
