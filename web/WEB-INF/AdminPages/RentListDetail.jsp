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
    <title>租赁单查看</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">
<!-- 通用-970*90 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
    <legend>租赁单查看</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="<%=basePath%>RentListInfoServlet" method="post" enctype = "multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">租赁单号</label>
        <div class="layui-input-inline">
            <input type="text" name="rno" autocomplete="off" class="layui-input" value="${rentListInfo.rno}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">员工号</label>
        <div class="layui-input-inline">
            <input type="text" name="sno" autocomplete="off" class="layui-input" value="${rentListInfo.sno}" readonly>
        </div>
        <a href="#" onclick="openwindow1()">详细信息</a>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">客户编号</label>
        <div class="layui-input-inline">
            <input type="text" name="cno" autocomplete="off" class="layui-input" value="${rentListInfo.cno}" readonly>
        </div>
        <a href="#" onclick="openwindow2()">详细信息</a>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">车牌号</label>
        <div class="layui-input-inline">
            <input type="text" name="autocard" autocomplete="off" class="layui-input" value="${rentListInfo.autocard}" readonly>
        </div>
        <a href="#" onclick="openwindow3()">详细信息</a>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">租赁日期</label>
        <div class="layui-input-inline">
            <input type="text" name="rdate" autocomplete="off" class="layui-input" value="<fmt:formatDate value="${rentListInfo.rdate}" pattern="yyyy/MM/dd"/>" readonly>
        </div>
        <label class="layui-form-label">租赁天数</label>
        <div class="layui-input-inline">
            <input type="text" name="rdays" autocomplete="off" class="layui-input" value="${rentListInfo.rdays}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">租赁总金额</label>
        <div class="layui-input-inline">
            <input type="text" name="allmoney" autocomplete="off" class="layui-input" value="￥${rentListInfo.allmoney}" readonly>
        </div>
        <label class="layui-form-label">押金</label>
        <div class="layui-input-inline">
            <input type="text" name="extra" autocomplete="off" class="layui-input" value="￥${rentListInfo.extra}" readonly>
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
<script type="text/javascript">
    function openwindow1() {
        window.open ("<%=basePath%>StaffDetailServlet?sno=${rentListInfo.sno}", "员工详细信息", "height=400, width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no")
    }
    function openwindow2() {
        window.open ("<%=basePath%>CustomDetailServlet?cno=${rentListInfo.cno}", "客户详细信息", "height=320, width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no")
    }
    function openwindow3() {
        window.open ("<%=basePath%>AutoDetailServlet?autocard=${rentListInfo.autocard}", "汽车详细信息", "height=700, width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no")
    }
</script>
</body>
</html>
