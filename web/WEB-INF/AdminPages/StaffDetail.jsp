<%--
  Created by IntelliJ IDEA.
  User: 13251666588
  Date: 2018/9/19
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>员工信息查看</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">
<!-- 通用-970*90 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
    <legend>员工信息查看</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="<%=basePath%>StaffServlet" method="post" enctype = "multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">员工号</label>
        <div class="layui-input-inline">
            <input type="text" name="uname" autocomplete="off" class="layui-input" value="${staff.uname}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">员工姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="sname" autocomplete="off" class="layui-input" value="${staff.sname}" readonly>
        </div>
        <label class="layui-form-label">性别</label>
        <div class="layui-input-inline">
            <input type="text" name="sex" autocomplete="off" class="layui-input" value="${staff.sex}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-inline">
            <input type="text" name="phonenum" autocomplete="off" class="layui-input" value="${staff.phonenum}" readonly>
        </div>
        <label class="layui-form-label">出生日期</label>
        <div class="layui-input-inline">
            <input type="text" name="birthday" autocomplete="off" class="layui-input" value="<fmt:formatDate value="${staff.birthday}" pattern="yyyy/MM/dd"/>" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证</label>
        <div class="layui-input-inline">
            <input type="text" name="sidcard" autocomplete="off" class="layui-input" value="${staff.sidcard}" readonly>
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
