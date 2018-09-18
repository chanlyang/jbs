<%--
  Created by IntelliJ IDEA.
  User: 13251666588
  Date: 2018/9/18
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <span class="f2">
        <span class="layui-form-label">搜索条件：</span>
		<div class="layui-input-inline">
            <select name="quiz1">
                <option value="">汽车类型</option>
                <option value="轿车" >轿车</option>
                <option value="面包车">面包车</option>
                <option value="客车">客车</option>
				<option value="卡车">卡车</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="quiz2">
                <option value="">汽车品牌</option>
                <option value="奥迪" >奥迪</option>
                <option value="奔驰">奔驰</option>
                <option value="宝马">宝马</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="quiz3">
                <option value="">汽车车型</option>
                <option value="A6">A6</option>
                <option value="Q7">Q7</option>
                <option value="TT">TT</option>
                <option value="R8">R8</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="quiz4">
                <option value="">汽车排量</option>
                <option value="1.6T">1.6T</option>
                <option value="2.4T">2.4T</option>
                <option value="3.6T">3.6T</option>
				<option value="4.2T">4.2T</option>
            </select>
        </div>
    </span>
    <button class="layui-btn mgl-20">查询</button>
</div>

<!-- 表格 -->
<table class="table4_3" align="center">
    <tr><td>车牌号</td><td>汽车类型</td><td>品牌</td><td>汽车名称</td><td>颜色</td><td>座位数</td><td>档位类型</td><td>排量</td><td>日租金</td></tr>
    <c:forEach items="${alist}" var="ainfo">
        <tr><td>${ainfo.autocard}</td><td>${ainfo.atype}</td><td>${ainfo.bname}</td><td>${ainfo.tname}</td><td>${ainfo.color}</td><td>${ainfo.seat}</td>
            <td>${ainfo.gear}</td><td>${ainfo.tubo}</td><td>${ainfo.dayrent}</td></tr>
    </c:forEach>
    <tr><td colspan="9">
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

<script type="text/javascript" src="../frame/layui/layui.js"></script>
<script type="text/javascript" src="../js/index.js"></script>

<!-- 表格操作按钮集 -->
<script type="text/html" id="barOption">
    <a class="layui-btn layui-btn-mini" lay-event="detail">查看</a>
</script>
</body>
</html>
