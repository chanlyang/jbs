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
    <title>汽车变更修改</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">
<!-- 通用-970*90 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
    <legend>汽车变更添加</legend>
</fieldset>

<form class="layui-form layui-form-pane" action="<%=basePath%>ChangeListAddServlet" method="post" enctype = "multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">租单号</label>
        <div class="layui-input-block">
            <select name="rno" id="s">
                <optgroup>租单号</optgroup>
                <option value="${cList.rno}" disabled="disabled" selected>${cList.rno}</option>
                <c:forEach var="rl" items="${rlist}">
                    <option value="${rl.rno}">${rl.rno}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">前车牌号</label>
        <div class="layui-input-inline">
            <input type="text" name="bautocard" autocomplete="off" class="layui-input" value="${cList.bautocard}" readonly>
        </div>
        <label class="layui-form-label">后车牌号</label>
        <div class="layui-input-inline">
            <input type="text" name="nautocard" autocomplete="off" class="layui-input" value="${cList.nautocard}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">操作人</label>
        <div class="layui-input-inline">
            <input type="text" name="person" autocomplete="off" class="layui-input" value="${cList.nautocard}" readonly>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">操作日期</label>
            <div class="layui-input-inline">
                <input type="text" name="date" id="cdate" lay-verify="date" autocomplete="off" class="layui-input" value="${cList.cdate}" readonly>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <input class="layui-btn" lay-submit="" lay-filter="demo2" type="submit" value="提交">
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

        //日期
        laydate.render({
            elem: '#date'
        });
    });
</script>
</body>
</html>
