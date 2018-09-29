<%--
  Created by IntelliJ IDEA.
  User: 13251666588
  Date: 2018/9/6
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="GB2312" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>��¼</title>
    <link rel="stylesheet" href="frame/layui/css/layui.css">
    <link rel="stylesheet" href="frame/static/css/style.css">
    <link rel="icon" href="frame/static/image/code.png">
</head>
<body>

<div class="login-main">
    <header class="layui-elip">��ӭ��¼</header>
    <form class="layui-form" action="/UserServlet" method="get">
        <div class="layui-input-inline">
            <input type="text" name="uname" lay-verify="uname" placeholder="�û���" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="password" lay-verify="password" placeholder="����" autocomplete="off"
                   class="layui-input">
            <p>${message}</p>
        </div>
        <div>
            <input type="hidden" name="userid">
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" class="layui-btn">��¼</button>
        </div>
        <hr/>
        <p><a href="regist.jsp" class="fl">����ע��</a><a href="javascript:document.location = 'MainServlet';" class="fr">������ҳ</a></p>
    </form>
</div>


<script src="<%=basePath%>/frame/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form'], function () {
        var form = layui.form
            , $ = layui.jquery;
    });
</script>
</body>
</html>
