<%--
  Created by IntelliJ IDEA.
  User: 13251666588
  Date: 2018/9/19
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>租金更改查看</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">
<!-- 通用-970*90 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
    <legend>租金更改查看</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="<%=basePath%>ChangeMoneyServlet" method="post" enctype = "multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">编号</label>
        <div class="layui-input-inline">
            <input type="text" name="cid" autocomplete="off" class="layui-input" value="${changeMoney.cid}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">车牌号</label>
        <div class="layui-input-inline">
            <input type="text" name="autocard" autocomplete="off" class="layui-input" value="${changeMoney.autocard}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">更改时间</label>
        <div class="layui-input-inline">
            <input type="text" name="cdate" autocomplete="off" class="layui-input" value="${changeMoney.cdate}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">更改前租金</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="brent" value="￥${changeMoney.brent}" autocomplete="off" class="layui-input" readonly>
            </div>
            <div class="layui-form-mid">-</div>
            <label class="layui-form-label">更改后租金</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="arent" value="￥${changeMoney.arent}" autocomplete="off" class="layui-input" readonly>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <input class="layui-btn" lay-filter="demo2" type="submit" value="返回">
    </div>
    <br>
    <div>${msg}</div>
    <br>
</form>

<script src="../frame/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
    });
</script>
</body>
</html>
