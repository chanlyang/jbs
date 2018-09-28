<%--
  Created by IntelliJ IDEA.
  User: CHANLYANG
  Date: 2018/9/28
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Single</title>
    <link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href='https://fonts.googleapis.com/css?family=Playball' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<%=basePath%>frame/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>frame/static/css/style.css">
    <link rel="icon" href="<%=basePath%>frame/static/image/code.png">
</head>
<body>
<div class="header-bg">
    <div class="wrap">
        <div class="h-bg">
            <div class="total">
                <div class="header">
                    <div class="box_header_user_menu">
                        <ul class="user_menu">
                            <li class=""><a href="MainServlet">
                                <div class="button-t"><span>返回首页</span></div>
                            </a></li>
                            <li class=""><a href="">
                                <div class="button-t"><span>${uname}</span></div>
                            </a></li>
                            <li class=""><a href="LoginOutServlet">
                                <div class="button-t"><span>退出登录</span></div>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="banner-top">
                <div class="header-bottom">
                    <div class="header_bottom_right_images">
                        <form class="layui-form" action="RentPageServlet" method="post">
                            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                                <legend>个人信息</legend>
                            </fieldset>
                            <br>
                            <div class="layui-form-item">
                                <label class="layui-form-label">客户编号</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="cno" autocomplete="off" class="layui-input"
                                           value="${custom.cno}" readonly>
                                </div>
                                <label class="layui-form-label">客户姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="cname" autocomplete="off" class="layui-input"
                                           value="${custom.cname}" readonly>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">身份证号</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="cidcard" autocomplete="off" class="layui-input"
                                           value="${custom.cidcard}" readonly>
                                </div>
                                <label class="layui-form-label">电话号码</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="phonenum" autocomplete="off" class="layui-input"
                                           value="${custom.phonenum}" readonly>
                                </div>
                            </div>
                            <br>
                            <c:if test="${ai!=null}">
                                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                                    <legend>您的预约信息</legend>
                                </fieldset>
                                <br>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">车牌号</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="autocard" autocomplete="off" class="layui-input"
                                               value="${ai.autocard}" readonly>
                                    </div>
                                    <label class="layui-form-label">汽车类别</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="atype" autocomplete="off" class="layui-input"
                                               value="${ai.tname}" readonly>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">汽车品牌</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="bname" autocomplete="off" class="layui-input"
                                               value="${ai.bname}${ai.cname}" readonly>
                                    </div>
                                    <label class="layui-form-label">日租金</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="tname" autocomplete="off" class="layui-input"
                                               value="${ai.dayrent}" readonly>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">取车日期</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="date" autocomplete="off" class="layui-input"
                                               value="<fmt:formatDate value="${ai.begindate}" pattern="yyyy-MM-dd"/>"
                                               readonly>
                                    </div>
                                    <label class="layui-form-label">租车天数</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="tname" autocomplete="off" class="layui-input"
                                               value="${ai.days}" readonly>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">基本信息</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="color" autocomplete="off" class="layui-input"
                                               value="${ai.color}" readonly>
                                    </div>
                                    <div class="layui-input-inline">
                                        <input type="text" name="seat" autocomplete="off" class="layui-input"
                                               value="${ai.seat}" readonly>
                                    </div>
                                    <div class="layui-input-inline">
                                        <input type="text" name="gear" autocomplete="off" class="layui-input"
                                               value="${ai.gear}" readonly>
                                    </div>
                                    <div class="layui-input-inline">
                                        <input type="text" name="tubo" autocomplete="off" class="layui-input"
                                               value="${ai.tubo}" readonly>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">图片</label>
                                    <img src="${ai.pic}" alt="无法显示图片" name="pic">
                                </div>
                            </c:if>
                            <c:if test="${ai==null}">
                                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                                    <legend>您还没有预约租车</legend>
                                </fieldset>
                            </c:if>
                            <%--javascript:myform.action='RentPageServlet?cno=${cri.cno}&autocard=${cri.autocard}';myform.submit()--%>
                            <div class="layui-form-item" align="center">
                                <a class="layui-btn" lay-filter="demo2"
                                   href="MainServlet">返回</a>
                            </div>
                        </form>

                        <script src="<%=basePath%>frame/layui/layui.js" charset="utf-8"></script>
                        <script>
                            layui.use(['form', 'layedit', 'laydate'], function () {
                                var form = layui.form
                                    , layer = layui.layer
                                    , layedit = layui.layedit
                                    , laydate = layui.laydate;
                                //日期
                                laydate.render({
                                    elem: '#date1'
                                });
                                //日期
                                laydate.render({
                                    elem: '#date2'
                                });
                            });
                        </script>
                        <div style="text-align:center;">
                        </div>
                    </div>
                </div>
                <div class="header-para">
                    <div class="categories">
                        <div class="list-categories">
                            <c:forEach var="ctype" items="${ctype}">
                                <div class="first-list">
                                    <div class="div_2"><a href="CarAServlet?type=${ctype.tno}">${ctype.atype}</a>
                                    </div>
                                    <div class="div_img">
                                        <img src="${ctype.pic}" alt="Cars" title="Cars" width="60"
                                             height="39">
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="box-title">
                            <h1><span class="title-icon"></span><a href="">热门汽车</a></h1>
                        </div>
                        <div class="section group example">
                            <c:forEach var="hot" items="${hot}">
                                <div class="col_1_of_2 span_1_of_2">
                                    <a onclick="javascript:document.location.href=encodeURI('RentServlet?car=${hot.autocard}')">
                                        <img src="${hot.pic}" alt=""/>
                                    </a>
                                </div>
                            </c:forEach>
                            <div class="clear"></div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="clear"></div>
                <div class="footer-bottom">
                    <div class="copy">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>

</body>
</html>





