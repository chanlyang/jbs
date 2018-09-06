<%--
  Created by IntelliJ IDEA.
  User: 13251666588
  Date: 2018/9/6
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>首页 · JBS后台工作人员系统</title>
    <link rel="stylesheet" href="<%=basePath%>/frame/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>/frame/static/css/style.css">
    <link rel="icon" href="<%=basePath%>/frame/static/image/code.png">
</head>
<body>

<!-- layout admin -->
<div class="layui-layout layui-layout-admin"> <!-- 添加skin-1类可手动修改主题为纯白，添加skin-2类可手动修改主题为蓝白 -->
    <!-- header -->
    <div class="layui-header my-header">
        <a href="AdminMain.html">
            <!--<img class="my-header-logo" src="" alt="logo">-->
            <div class="my-header-logo">JBS后台工作人员系统</div>
        </a>
        <div class="my-header-btn">
            <button class="layui-btn layui-btn-small btn-nav"><i class="layui-icon">&#xe65f;</i></button>
        </div>

        <!-- 顶部右侧添加选项卡监听 -->
        <ul class="layui-nav my-header-user-nav" lay-filter="side-top-right">
            <li class="layui-nav-item">
                <a class="name" href="javascript:;"><i class="layui-icon">&#xe629;</i>主题</a>
                <dl class="layui-nav-child">
                    <dd data-skin="0"><a href="javascript:;">默认</a></dd>
                    <dd data-skin="1"><a href="javascript:;">纯白</a></dd>
                    <dd data-skin="2"><a href="javascript:;">蓝白</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a class="name" href="javascript:;"><img src="./frame/static/image/code.png" alt="logo"> Staff </a>
                <dl class="layui-nav-child">
                    <dd><a href="/"><i class="layui-icon">&#x1006;</i>退出</a></dd>
                </dl>
            </li>
        </ul>

    </div>
    <!-- side -->
    <div class="layui-side my-side">
        <div class="layui-side-scroll">
            <!-- 左侧主菜单添加选项卡监听 -->
            <ul class="layui-nav layui-nav-tree" lay-filter="side-main">
                <li class="layui-nav-item  layui-nav-itemed">
                    <a href="javascript:;"><i class="layui-icon">&#xe620;</i>租车管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/RentList.html"><i class="layui-icon">&#xe621;</i>租赁单</a></dd>
                        <dd><a href="javascript:;" href-url="demo/BackList.html"><i class="layui-icon">&#xe621;</i>还车单</a></dd>
                        <dd><a href="javascript:;" href-url="demo/AutoChange.html"><i class="layui-icon">&#xe621;</i>租车变更处理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe628;</i>汽车信息查询</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/AutoQuery.html"><i class="layui-icon">&#xe621;</i>汽车查询</a></dd>
                        <dd><a href="javascript:;" href-url="demo/MoneyChangeQuery.html"><i class="layui-icon">&#xe621;</i>租金变更记录查询</a></dd>
                        <dd><a href="javascript:;" href-url="demo/HistoryQuery.html"><i class="layui-icon">&#xe621;</i>租/还车记录查询</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a target="_blank" href=""><i class="layui-icon">&#xe61e;</i>JBS租车网</a></li>
            </ul>
        </div>
    </div>
    <!-- body -->
    <div class="layui-body my-body">
        <div class="layui-tab layui-tab-card my-tab" lay-filter="card" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="1"><span><i class="layui-icon">&#xe638;</i>欢迎页</span></li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <iframe id="iframe" src="" frameborder="0"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- footer -->
    <div class="layui-footer my-footer">

    </div>
</div>

<!-- 右键菜单 -->
<div class="my-dblclick-box none">
    <table class="layui-tab dblclick-tab">
        <tr class="card-refresh">
            <td><i class="layui-icon">&#x1002;</i>刷新当前标签</td>
        </tr>
        <tr class="card-close">
            <td><i class="layui-icon">&#x1006;</i>关闭当前标签</td>
        </tr>
        <tr class="card-close-all">
            <td><i class="layui-icon">&#x1006;</i>关闭所有标签</td>
        </tr>
    </table>
</div>

<script type="text/javascript" src="<%=basePath%>/frame/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>/frame/static/js/vip_comm.js"></script>
<script type="text/javascript">
    layui.use(['layer','vip_nav'], function () {

        // 操作对象
        var layer       = layui.layer
            ,vipNav     = layui.vip_nav
            ,$          = layui.jquery;

        // 顶部左侧菜单生成 [请求地址,过滤ID,是否展开,携带参数]
        vipNav.top_left('<%=basePath%>/json/nav_top_left.json','side-top-left',false);
        // 主体菜单生成 [请求地址,过滤ID,是否展开,携带参数]
        vipNav.main('<%=basePath%>/json/nav_main.json','side-main',true);

        // you code ...


    });
</script>
</body>
</html>
