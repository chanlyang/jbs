<%--
  Created by IntelliJ IDEA.
  User: 13251666588
  Date: 2018/9/18
  Time: 14:22
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
    <title>租赁单</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <!--<link rel="stylesheet" href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">-->
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">
<script type="text/javascript">
    function del() {
        if(!confirm("您确认删除吗？")){
            window.event.returnValue = false;
        }
    }
</script>
<!-- 工具集 -->
<div class="my-btn-box">
     <span class="fl">
        <a class="layui-btn btn-add btn-default" id="btn-refresh" href="<%=basePath%>RentListServlet"><i class="layui-icon">&#x1002;</i></a>
    </span>
    <form action="<%=basePath%>RentListServlet" method="post">
    <span class="f3">
        <span class="layui-form-label">搜索条件：</span>
        <div class="layui-input-inline">
            <input type="text" name="rno" autocomplete="off" placeholder="请输入租赁单号" class="layui-input" value="${rno}">
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <div class="layui-input-inline">
            <input type="text" name="cuname" autocomplete="off" placeholder="请输入顾客编号" class="layui-input" value="${cuname}">
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <div class="layui-input-inline">
            <input type="text" name="autocard" autocomplete="off" placeholder="请输入车牌号" class="layui-input" value="${autocard}">
        </div>
    </span>
        <span class="fr">
        <input type="submit" class="layui-btn mgl-20" value="查询">
        </span>
    </form>

</div>

<!-- 表格 -->
<form action="AutoDeleteAllServlet" method="post">
    <table class="layui-table" lay-even="" lay-skin="nob">
        <tr><td>选择</td><td>租赁单号</td><td>客户编号</td><td>车牌号</td><td>租赁日期</td><td>租赁天数</td><td>操作</td></tr>
        <c:forEach items="${rentListInfoList}" var="rl">
            <tr><td><input type="checkbox" name="select" value="${rl.rno}"></td><td>${rl.rno}</td><td>${rl.cuname}</td><td>${rl.autocard}</td>
                <td> <fmt:formatDate value="${rl.rdate}" pattern="yyyy/MM/dd"/> </td><td>${rl.rdays}</td>
                <td><a class="layui-btn layui-btn-mini" lay-event="detail" href="<%=basePath%>RentListDetailServlet?rno=${rl.rno}&uname=${rl.cuname}&autocard=${rl.autocard}">查看</a>
                    <a class="layui-btn layui-btn-mini layui-btn-danger" lay-event="del" href="<%=basePath%>RentListDeleteServlet?rno=${rl.rno}" onclick="return del()">删除</a></td></tr>
        </c:forEach>
        <tr><td colspan="7">
            <table id="tblTurnPage" cellSpacing="0" cellPadding="1" width="100%" border="0" style="font-family:arial;color:red;font-size:15px;" >
                <tr>
                    <td> <input type="submit" class="layui-btn layui-btn-danger radius btn-delect" id="btn-delete-all" value="批量删除"></td>
                    <td>总记录数：${tp.allRows}</td>
                    <td>总页数：${tp.allPages}</td>
                    <td>当前页：${tp.page}</td>
                    <td><a href="RentListInfoServlet?page=1&beginDate=${begin}&endDate=${end}">首页|</a>
                        <a href="RentListInfoServlet?page=${tp.page-1}&beginDate=${begin}&endDate=${end}">《前页|</a>
                        <a href="RentListInfoServlet?page=${tp.page+1}&beginDate=${begin}&endDate=${end}">后页》|</a>
                        <a href="RentListInfoServlet?page=${tp.allPages}&beginDate=${begin}&endDate=${end}">末页|</a></td>
                    <td >跳转到:第<input type="text" size="3" >页</td>
                    <td><input type="button" class="layui-btn layui-btn-danger radius btn-delect" value="go"></td>

                </tr>
            </table>

        </td></tr>
    </table>

</form>
<script type="text/javascript" src="../frame/layui/layui.js"></script>
<script type="text/javascript" src="../js/index.js"></script>

</body>
</html>
