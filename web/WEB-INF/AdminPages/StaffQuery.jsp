<%--
  Created by IntelliJ IDEA.
  User: 13251666588
  Date: 2018/9/18
  Time: 10:47
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
    <title>Data-Table 表格</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <!--<link rel="stylesheet" href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">-->
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">
<style>
    .table4_3 table {
        width:100%;
        margin:15px 0;
        border:0;
    }
    .table4_3 th {
        background-color:#86A5FF;
        color:#FFFFFF
    }
    .table4_3,.table4_3 th,.table4_3 td {
        font-size:1.2em;
        text-align:center;
        padding:4px;
        border-collapse:collapse;
        white-space: nowrap;
    }
    .table4_3 th,.table4_3 td {
        border: 1px solid #b9cbfe;
        border-width:1px 0 1px 0;
    }
    .table4_3 tr {
        border: 1px solid #b9cbfe;
    }
    .table4_3 tr:nth-child(odd){
        background-color:#d6e1fe;
    }
    .table4_3 tr:nth-child(even){
        background-color:#fdfdfd;
    }
</style>
<!-- 工具集 -->
<div class="my-btn-box">
    <span class="fl">
        <a class="layui-btn layui-btn-danger radius btn-delect" id="btn-delete-all">批量删除</a>
        <a href="StaffAdd.html" class="layui-btn btn-add btn-default" id="btn-add">添加</a>
        <a class="layui-btn btn-add btn-default" id="btn-refresh" href="<%=basePath%>StaffServlet"><i class="layui-icon">&#x1002;</i></a>
    </span>
    <form action="<%=basePath%>StaffServlet" method="post">
    <span class="f3">
        <span class="layui-form-label">搜索条件：</span>
        <div class="layui-input-inline">
            <input type="text" name="sno" autocomplete="off" placeholder="请输入员工编号" class="layui-input" value="${sno}">
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <div class="layui-input-inline">
            <input type="text" name="sname" autocomplete="off" placeholder="请输入员工姓名" class="layui-input" value="${sname}">
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <div class="layui-input-inline">
            <select name="color" class="layui-select">
                <option value="">请选择性别</option>
                <option value="male">男</option>
                <option value="female">女</option>
            </select>
        </div>
    </span>
        <span class="fr">
        <input type="submit" class="layui-btn mgl-20" value="查询">
        </span>
    </form>
</div>

<!-- 表格 -->
<table align="center" class="table4_3">
    <tr><td>选择</td><td>员工号</td><td>员工姓名</td><td>性别</td><td>电话号码</td><td>出生日期</td><td>身份证</td><td>操作</td></tr>
    <c:forEach items="${slist}" var="sinfo">
        <tr><td><input type="checkbox" name="select" value="${sinfo.sno}"></td><td>${sinfo.sno}</td><td>${sinfo.sname}</td><td>${sinfo.sex}</td><td>${sinfo.phonenum}</td>
            <td> <fmt:formatDate value="${sinfo.birthday}" pattern="yyyy/MM/dd"/> </td><td>${sinfo.sidcard}</td>
            <td><a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
                <a class="layui-btn layui-btn-mini layui-btn-normal" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-mini layui-btn-danger" lay-event="del">删除</a></td></tr>
    </c:forEach>
    <tr><td colspan="6">
        <table id="tblTurnPage" cellSpacing="0" cellPadding="1" width="100%" border="0" style="font-family:arial;color:red;font-size:12px;">
            <tr>
                <td>总记录数：${tp.allRows}</td>
                <td>总页数：${tp.allPages}</td>
                <td>当前页：${tp.page}</td>
                <td><a href="StaffServlet?page=1&uname=${uname}&beginDate=${begin}&endDate=${end}">首页|</a>
                    <a href="StaffServlet?page=${tp.page-1}&uname=${uname}&beginDate=${begin}&endDate=${end}">《前页|</a>
                    <a href="StaffServlet?page=${tp.page+1}&uname=${uname}&beginDate=${begin}&endDate=${end}">后页》|</a>
                    <a href="StaffServlet?page=${tp.allPages}&uname=${uname}&beginDate=${begin}&endDate=${end}">末页|</a></td>
                <td >跳转到:第<input type="text" size="3" >页<input type="button" value="go"></td>
            </tr>
        </table></td></tr>
</table>

<script type="text/javascript" src="../frame/layui/layui.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
<!-- 表格操作按钮集 -->
<script type="text/html" id="barOption">
    <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini layui-btn-normal" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-mini layui-btn-danger" lay-event="del">删除</a>
</script>
</body>
</html>
