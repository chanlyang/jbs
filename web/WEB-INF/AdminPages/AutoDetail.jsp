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
    <title>汽车查看</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">
<!-- 通用-970*90 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
    <legend>汽车查看</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="<%=basePath%>AutoServlet" method="post" enctype = "multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">车牌号</label>
        <div class="layui-input-inline">
            <input type="text" name="autocard" autocomplete="off" class="layui-input" value="${auto.autocard}" readonly>
        </div>
    </div>
    <div class="layui-form-item">
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
    </div>
    <div class="layui-form-item">
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
        <div class="layui-inline">
            <label class="layui-form-label">日租金</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="dayrent" lay-verify="price" autocomplete="off" class="layui-input" value="${auto.dayrent}" readonly>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">押金</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="extra" lay-verify="price" autocomplete="off" class="layui-input" value="${auto.extra}" readonly>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图片</label><img src="${auto.picurl}" alt="无法显示图片" name="pic"><br><br><br>
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

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //自定义验证规则
        form.verify({
            autocard: function(value){
                if(value.length < 8){
                    return '车牌号为8个字符，格式为：京A-XXXXX';
                }
            }
            ,tname:function (value) {
                if(value.length==0){
                    return '汽车名称不能为空';
                }
            }
            ,price:function(value){
                if(value.length == 0){
                    return '日租金不能为空';
                }
            }
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });
    });
</script>
</body>
</html>
