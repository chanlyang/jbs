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
    <title>StaffAdd</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">


<blockquote class="layui-elem-quote layui-text">
    鉴于小伙伴的普遍反馈，先温馨提醒两个常见“问题”：1. <a href="http://www.layui.com/doc/base/faq.html#form" target="_blank">为什么select/checkbox/radio没显示？</a> 2. <a href="http://www.layui.com/doc/modules/form.html#render" target="_blank">动态添加的表单元素如何更新？</a>
</blockquote>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>修改员工</legend>
</fieldset>

<form class="layui-form" action="<%=basePath%>StaffUpdateServlet" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">员工编号</label>
        <div class="layui-input-block">
            <input type="text" name="uname" lay-verify="staffid" autocomplete="off" value="${staff.uname}" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">员工姓名</label>
        <div class="layui-input-block">
            <input type="text" name="sname" lay-verify="name" value="${staff.sname}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="text" name="sex" lay-verify="name" value="${staff.sex}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-block">
            <input type="text" name="sidcard" lay-verify="identity" value="${staff.sidcard}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">电话号码</label>
            <div class="layui-input-inline">
                <input type="tel" name="phonenum" lay-verify="phone" autocomplete="off" class="layui-input" value="${staff.phonenum}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-inline">
                <input type="text" name="birthday" id="date" lay-verify="date" value="<fmt:formatDate value="${staff.birthday}" pattern="yyyy/MM/dd"/>" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">修改</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


<script src="../frame/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#date'
        });
    });
</script>
</body>
</html>