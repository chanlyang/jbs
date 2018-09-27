<%--
  Created by IntelliJ IDEA.
  User: 13251666588
  Date: 2018/9/6
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>登录</title>
    <link rel="stylesheet" href="frame/layui/css/layui.css">
    <link rel="stylesheet" href="frame/static/css/style.css">
    <link rel="icon" href="frame/static/image/code.png">
</head>
<body>

<div class="login-main">
    <header class="layui-elip">后台登录</header>
    <form class="layui-form" action="/UserServlet" method="post">
        <div class="layui-input-inline">
            <input type="text" name="uname" lay-verify="uname" placeholder="用户名" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="password" lay-verify="password" placeholder="密码" autocomplete="off"
                   class="layui-input">
            <p>${message}</p>
        </div>
        <div>
            <input type="hidden" name="userid">
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" class="layui-btn">登录</button>
        </div>
        <hr/>
        <p><a href="javascript:;" class="fl">立即注册</a><a href="javascript:;" class="fr">忘记密码？</a></p>
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
