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
    <title>租赁单详细</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">
<!-- 通用-970*90 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
    <legend>租赁单详细</legend>
</fieldset>
<form class="layui-form" action="<%=basePath%>RentAllListServlet" method="post">
    <div class="layui-form-item" align="center">
        <label class="layui-form-label">租赁单号</label>
        <div class="layui-input-inline">
            <input type="text" name="rno" autocomplete="off" class="layui-input" value="${rentListInfo.rno}" readonly>
        </div>
    </div>
    <br>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>客户详细</legend>
    </fieldset>
    <br>
    <div class="layui-form-item">
        <label class="layui-form-label">客户编号</label>
        <div class="layui-input-inline">
            <input type="text" name="uname" autocomplete="off" class="layui-input" value="${custom.uname}" readonly>
        </div>
        <label class="layui-form-label">客户姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="cname" autocomplete="off" class="layui-input" value="${custom.cname}" readonly>
        </div>
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-inline">
            <input type="text" name="cidcard" autocomplete="off" class="layui-input" value="${custom.cidcard}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-inline">
            <input type="text" name="phonenum" autocomplete="off" class="layui-input" value="${custom.phonenum}" readonly>
        </div>
        <label class="layui-form-label">出生日期</label>
        <div class="layui-input-inline">
            <input type="text" name="birthday" autocomplete="off" class="layui-input" value="<fmt:formatDate value="${custom.birthday}" pattern="yyyy/MM/dd"/>" readonly>
        </div>
    </div>
    <br>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>汽车详细</legend>
    </fieldset>
    <br>
    <div class="layui-form-item">
        <label class="layui-form-label">车牌号</label>
        <div class="layui-input-inline">
            <input type="text" name="autocard" autocomplete="off" class="layui-input" value="${auto.autocard}" readonly>
        </div>
        <label class="layui-form-label">汽车类别</label>
        <div class="layui-input-inline">
            <input type="text" name="atype" autocomplete="off" class="layui-input" value="${auto.atype}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">汽车品牌</label>
        <div class="layui-input-inline">
            <input type="text" name="bname" autocomplete="off" class="layui-input" value="${auto.bname}" readonly>
        </div>
        <label class="layui-form-label">汽车名称</label>
        <div class="layui-input-inline">
            <input type="text" name="tname" autocomplete="off" class="layui-input" value="${auto.tname}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">基本信息</label>
        <div class="layui-input-inline">
            <input type="text" name="color" autocomplete="off" class="layui-input" value="${auto.color}" readonly>
        </div>
        <div class="layui-input-inline">
            <input type="text" name="seat" autocomplete="off" class="layui-input" value="${auto.seat}" readonly>
        </div>
        <div class="layui-input-inline">
            <input type="text" name="gear" autocomplete="off" class="layui-input" value="${auto.gear}" readonly>
        </div>
        <div class="layui-input-inline">
            <input type="text" name="tubo" autocomplete="off" class="layui-input" value="${auto.tubo}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图片</label>
        <img src="${auto.picurl}" alt="无法显示图片" name="pic">
    </div>
    <br>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>租金详细</legend>
    </fieldset>
    <br>
    <div class="layui-form-item">
        <label class="layui-form-label">租赁日期</label>
        <div class="layui-input-inline">
            <input type="text" name="rdate" autocomplete="off" class="layui-input" value="<fmt:formatDate value="${rentListInfo.rdate}" pattern="yyyy/MM/dd"/>" readonly>
        </div>
        <label class="layui-form-label">租赁天数</label>
        <div class="layui-input-inline">
            <input type="text" name="rdays" autocomplete="off" class="layui-input" value="${rentListInfo.rdays}" readonly>
        </div>
        <label class="layui-form-label">日租金</label>
        <div class="layui-input-inline" style="width: 100px;">
            <input type="text" name="dayrent" lay-verify="price" autocomplete="off" class="layui-input" value="${auto.dayrent}" readonly>
        </div>
        <label class="layui-form-label">押金</label>
        <div class="layui-input-inline">
            <input type="text" name="extra" autocomplete="off" class="layui-input" value="￥${auto.extra}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">租赁总金额</label>
        <div class="layui-input-inline">
            <input type="text" name="allmoney" autocomplete="off" class="layui-input" value="￥${rentListInfo.allmoney}">
        </div>
        <label class="layui-form-label">操作人</label>
        <div class="layui-input-inline">
            <input type="text" name="suname" autocomplete="off" class="layui-input" value="${name}">
        </div>
    </div>
    <div class="layui-form-item" align="center">
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
