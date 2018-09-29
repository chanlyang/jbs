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
    <title>汽车添加</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">
<!-- 通用-970*90 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
    <legend>汽车添加</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="<%=basePath%>AutoAddServlet" method="post" enctype="multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">车牌号</label>
        <div class="layui-input-inline">
            <input type="text" name="autocard" lay-verify="autocard" placeholder="请输入车牌号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">汽车类别</label>
        <div class="layui-input-block">
            <select name="atype" lay-filter="aihao">
                <optgroup>汽车类别</optgroup>
                <option value="" disabled="disabled" selected>请选择汽车类别</option>
                <c:forEach var="tp" items="${atlist}">
                    <option value="${tp.tno}">${tp.atype}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">汽车品牌</label>
        <div class="layui-input-block">
            <select name="bno" lay-filter="aihao">
                <optgroup >汽车品牌</optgroup>
                <option value="" disabled="disabled" selected>请选择汽车品牌</option>
                <c:forEach var="brand" items="${blist}">
                    <option value="${brand.bno}">${brand.bname}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">汽车名称</label>
        <div class="layui-input-inline">
            <input type="text" name="tname" lay-verify="tname" placeholder="请输入汽车名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">基本信息</label>
        <div class="layui-input-inline">
            <select name="color">
                <option value="">颜色</option>
                <option value="黑色">黑色</option>
                <option value="银色">银色</option>
                <option value="红色">红色</option>
                <option value="白色">白色</option>
                <option value="蓝色">蓝色</option>
                <option value="棕色">棕色</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="seat">
                <option value="">座位数</option>
                <option value="2">2位</option>
                <option value="4">4位</option>
                <option value="7">7位</option>
                <option value="13">13位</option>
                <option value="35">35位</option>
                <option value="50">50位</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="gear">
                <option value="">档位类型</option>
                <option value="自动挡">自动挡</option>
                <option value="手动挡">手动挡</option>
                <option value="手自一体">手自一体</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="tubo">
                <option value="">排量</option>
                <option value="1.2T">1.2T</option>
                <option value="1.6T">1.6T</option>
                <option value="2.0T">2.0T</option>
                <option value="2.4T">2.4T</option>
                <option value="3.6T">3.6T</option>
                <option value="4.2T">4.2T</option>
                <option value="5.0T">5.0T</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">日租金</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="dayrent" lay-verify="price" placeholder="￥" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">押金</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="extra" lay-verify="price" placeholder="￥" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上传图片</label><input class = "layui-btn" type="file" name="pic"><br><br><br>
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
