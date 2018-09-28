<%--
  Created by IntelliJ IDEA.
  User: 13251666588
  Date: 2018/9/18
  Time: 14:22
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
    <title>汽车管理</title>
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
        <a class="layui-btn btn-add btn-default" id="btn-refresh" href="<%=basePath%>AutoServlet"><i class="layui-icon">&#x1002;</i></a>
         <a class="layui-btn layui-btn-danger radius btn-add" id="btn-add" href="<%=basePath%>AutoAddServlet">添加</a>
    </span>
    <span class="f2">
        <form action="<%=basePath%>AutoServlet" method="post">
        <span class="layui-form-label">搜索条件：</span>
		<div class="layui-input-inline">
            <select name="atype">
                <option value="">汽车类型</option>
                <option value="高级轿车" >高级轿车</option>
                <option value="面包车">面包车</option>
                <option value="客车">客车</option>
				<option value="卡车">卡车</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="bname">
                <option value="">汽车品牌</option>
                <option value="奥迪" >奥迪</option>
                <option value="奔驰">奔驰</option>
                <option value="宝马">宝马</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="tname">
                <option value="">汽车车型</option>
                <option value="A6">A6</option>
                <option value="Q7">Q7</option>
                <option value="TT">TT</option>
                <option value="R8">R8</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="tubo">
                <option value="">汽车排量</option>
                <option value="1.6T">1.6T</option>
                <option value="2.4T">2.4T</option>
                <option value="3.6T">3.6T</option>
				<option value="4.2T">4.2T</option>
            </select>
        </div>
            <button class="layui-btn mgl-20">查询</button>
    </form>
    </span>

</div>

<!-- 表格 -->
<form action="AutoDeleteAllServlet" method="post">
<table class="layui-table" lay-even="" lay-skin="nob">
    <tr><td>选择</td><td>车牌号</td><td>汽车类型</td><td>品牌</td><td>汽车名称</td><td>颜色</td><td>座位数</td><td>档位类型</td><td>排量</td><td>日租金</td><td>押金</td><td>操作</td></tr>
    <c:forEach items="${alist}" var="ainfo">
        <tr><td><input type="checkbox" name="select" value="${ainfo.autocard}"></td><td>${ainfo.autocard}</td><td>${ainfo.atype}</td><td>${ainfo.bname}</td><td>${ainfo.tname}</td><td>${ainfo.color}</td><td>${ainfo.seat}</td>
            <td>${ainfo.gear}</td><td>${ainfo.tubo}</td><td>${ainfo.dayrent}</td><td>${ainfo.extra}</td>
            <td><a class="layui-btn layui-btn-mini" lay-event="detail" href="<%=basePath%>AutoDetailServlet?autocard=${ainfo.autocard}">查看</a>
                <a class="layui-btn layui-btn-mini layui-btn-normal" lay-event="edit" href="<%=basePath%>AutoUpdateServlet?autocard=${ainfo.autocard}">编辑</a>
                <a class="layui-btn layui-btn-mini layui-btn-danger" lay-event="del" href="<%=basePath%>AutoDeleteServlet?autocard=${ainfo.autocard}" onclick="return del()">删除</a></td></tr>
    </c:forEach>
    <tr><td colspan="12">
        <table id="tblTurnPage" cellSpacing="0" cellPadding="1" width="100%" border="0" style="font-family:arial;color:red;font-size:15px;" >
            <tr>
                <td> <input type="submit" class="layui-btn layui-btn-danger radius btn-delect" id="btn-delete-all" value="批量删除"></td>
                <td>总记录数：${tp.allRows}</td>
                <td>总页数：${tp.allPages}</td>
                <td>当前页：${tp.page}</td>
                <td><a href="AutoServlet?page=1&beginDate=${begin}&endDate=${end}">首页|</a>
                    <a href="AutoServlet?page=${tp.page-1}&beginDate=${begin}&endDate=${end}">《前页|</a>
                    <a href="AutoServlet?page=${tp.page+1}&beginDate=${begin}&endDate=${end}">后页》|</a>
                    <a href="AutoServlet?page=${tp.allPages}&beginDate=${begin}&endDate=${end}">末页|</a></td>
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
