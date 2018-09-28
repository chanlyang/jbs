<%--
  Created by IntelliJ IDEA.
  User: 13251666588
  Date: 2018/9/7
  Time: 14:16
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
    <title>客户管理</title>
    <link rel="stylesheet" href="<%=basePath%>frame/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>frame/static/css/style.css">
    <link rel="icon" href="<%=basePath%>frame/static/image/code.png">
</head>
<body class="body">
<!-- 工具集 -->
<script type="text/javascript">
    function del() {
        if(!confirm("您确认删除吗？")){
            window.event.returnValue = false;
        }
    }
</script>
<div class="my-btn-box">
    <span class="fl">
        <a class="layui-btn layui-btn-danger radius btn-delect" id="btn-delete-all">批量删除</a>
        <a class="layui-btn btn-add btn-default" id="btn-refresh" href="<%=basePath%>CustomServlet"><i class="layui-icon">&#x1002;</i></a>
    </span>
    <form action="<%=basePath%>CustomServlet" method="post">
    <span class="f3">

        <span class="layui-form-label">搜索条件：</span>
        <div class="layui-input-inline">
            <input type="text" name="name" autocomplete="off" placeholder="请输入客户用户名" class="layui-input" value="${name}">
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <div class="layui-input-inline">
            <input type="text" name="cname" autocomplete="off" placeholder="请输入客户姓名" class="layui-input" value="${cname}">
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <div class="layui-inline">
            <div class="layui-input-inline">
                <input type="text" name="birthday" id="date" lay-verify="date" placeholder="请选择出生日期" autocomplete="off" class="layui-input" value="${birthday}">
            </div>
        </div>
    </span>
        <span class="fr">
        <input type="submit" class="layui-btn mgl-20" value="查询">
        </span>
    </form>
</div>

<!-- 表格 -->
<table class="layui-table" lay-even="" lay-skin="nob">
    <tr><td>选择</td><td>客户用户名</td><td>客户姓名</td><td>身份证号</td><td>电话号码</td><td>出生日期</td><td>操作</td></tr>
    <c:forEach items="${clist}" var="cinfo">
        <tr><td><input type="checkbox" name="select" value="${cinfo.uname}"></td><td>${cinfo.uname}</td><td>${cinfo.cname}</td><td>${cinfo.cidcard}</td><td>${cinfo.phonenum}</td>
            <td> <fmt:formatDate value="${cinfo.birthday}" pattern="yyyy/MM/dd"/> </td>
            <td><a class="layui-btn layui-btn-mini" lay-event="detail" href="<%=basePath%>CustomDetailServlet?uname=${cinfo.uname}">查看</a>
                <a class="layui-btn layui-btn-mini layui-btn-normal" lay-event="edit" href="<%=basePath%>CustomUpdateServlet?uname=${cinfo.uname}">编辑</a>
                <a class="layui-btn layui-btn-mini layui-btn-danger" lay-event="del" href="<%=basePath%>CustomDeleteServlet?uname=${cinfo.uname}" onclick="return del()">删除</a></td></tr>
    </c:forEach>
    <tr><td colspan="7">
        <table id="tblTurnPage" cellSpacing="0" cellPadding="1" width="100%" border="0" style="font-family:arial;color:red;font-size:12px;">
            <tr>
                <td>总记录数：${tp.allRows}</td>
                <td>总页数：${tp.allPages}</td>
                <td>当前页：${tp.page}</td>
                <td><a href="CustomServlet?page=1&uname=${uname}&beginDate=${begin}&endDate=${end}">首页|</a>
                    <a href="CustomServlet?page=${tp.page-1}&uname=${uname}&beginDate=${begin}&endDate=${end}">《前页|</a>
                    <a href="CustomServlet?page=${tp.page+1}&uname=${uname}&beginDate=${begin}&endDate=${end}">后页》|</a>
                    <a href="CustomServlet?page=${tp.allPages}&uname=${uname}&beginDate=${begin}&endDate=${end}">末页|</a></td>
                <td >跳转到:第<input type="text" size="3" >页<input type="button" value="go"></td>
            </tr>
        </table></td></tr>
</table>

<script type="text/javascript" src="<%=basePath%>frame/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index.js"></script>

<!-- 表格操作按钮集 -->
<script type="text/html" id="barOption">
    <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini layui-btn-normal" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-mini layui-btn-danger" lay-event="del">删除</a>
</script>
<script>
    layui.use(['laydate'], function(){
        var laydate = layui.laydate;
        laydate.render({
            elem: '#date'
        });
    });
    function forward() {
        window.location("<%=basePath%>CustomServlet");
    }
</script>
</body>
</html>
