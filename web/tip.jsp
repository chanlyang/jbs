<%--
  Created by IntelliJ IDEA.
  User: 13251666588
  Date: 2018/9/17
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>提示页面</title>
    <link rel="stylesheet" href="frame/layui/css/layui.css">
    <link rel="stylesheet" href="frame/static/css/style.css">
    <link rel="icon" href="frame/static/image/code.png">
</head>
<body class="body">

<div class="my-page-box">
    <i class="layui-icon">&#xe60c;</i>
    <p class="msg">This is msg</p>
    <p class="text">友情提示,${meg}</p>
    <div class="my-btn-box">
        <a class="layui-btn layui-btn-small" href="MainServlet">返回首页</a>
    </div>
</div>

<script type="text/javascript" src="frame/layui/layui.js"></script>
<script type="text/javascript">
    // you code ...
</script>
</body>
</html>
