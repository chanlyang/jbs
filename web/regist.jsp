<%--
  Created by IntelliJ IDEA.
  User: CHANLYANG
  Date: 2018/9/27
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="<%=basePath%>css/normalize.css">
    <link rel="stylesheet" href="<%=basePath%>css/styleregist.css">
    <link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href='https://fonts.googleapis.com/css?family=Playball' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="header-bg">
    <div class="wrap">
        <div class="h-bg">
            <div class="total">
                <div class="header">
                    <div class="box_header_user_menu">
                        <ul class="user_menu">
                            <li class="act first"><a href="MainServlet">
                                <div class="button-t"><span>返回首页</span></div>
                            </a></li>
                            <li class=""><a href="">
                                <div class="button-t"><span>注册</span></div>
                            </a></li>
                            <li class="last"><a href="">
                                <div class="button-t"><span>登录</span></div>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="banner-top">
                <div class="header-bottom">
                    <div class="header_bottom_right_images">
                        <div class="about_wrapper"><h1>用户注册</h1>
                        </div>
                        <div class="reg_div">
                            <p>注册</p>
                            <p2>${meg}</p2>
                            <form action="RegistServlet" method="post">
                                <ul class="reg_ul">
                                    <li>
                                        <span>用户名：</span>
                                        <input type="text" name="uname" value="" placeholder="4-8位用户名" class="reg_user">
                                        <span class="tip user_hint"></span>
                                    </li>
                                    <li>
                                        <span>密码：</span>
                                        <input type="password" name="password" value="" placeholder="6-16位密码"
                                               class="reg_password">
                                        <span class="tip password_hint"></span>
                                    </li>
                                    <li>
                                        <span>确认密码：</span>
                                        <input type="password" name="repassword" value="" placeholder="确认密码" class="reg_confirm">
                                        <span class="tip confirm_hint"></span>
                                    </li>
                                    <li>
                                        <span>真实姓名：</span>
                                        <input type="text" name="name" value="" placeholder="姓名" class="reg_name">
                                        <span class="tip name_hint"></span>
                                    </li>
                                    <li>
                                        <span>身份证号：</span>
                                        <input type="text" name="cid" value="" placeholder="身份证号" class="reg_cid">
                                        <span class="tip cid_hint"></span>
                                    </li>
                                    <li>
                                        <span>手机号码：</span>
                                        <input type="text" name="phone" value="" placeholder="手机号" class="reg_mobile">
                                        <span class="tip mobile_hint"></span>
                                    </li>
                                    <li>
                                        <button type="submit" name="button" class="red_button">注册</button>
                                    </li>
                                </ul>
                            </form>
                        </div>
                        <script charset="UTF-8" language="javascript" type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
                        <script charset="UTF-8" language="javascript" type="text/javascript" src="<%=basePath%>js/script.js"></script>
                        <div style="text-align:center;">
                        </div>
                    </div>
                </div>
                <div class="header-para">
                    <div class="categories">
                        <div class="list-categories">
                            <div class="first-list">
                                <div class="div_2"><a href="CarAServlet?type=t001">普通轿车</a></div>
                                <div class="div_img">
                                    <img src="<%=basePath%>images/car1.jpg" alt="Cars" title="Cars" width="60"
                                         height="39">
                                </div>
                                <div class="clear"></div>
                            </div>
                            <div class="first-list">
                                <div class="div_2"><a href="CarAServlet?type=t002">豪华轿车</a></div>
                                <div class="div_img">
                                    <img src="<%=basePath%>images/car2.jpg" alt="Cars" title="Cars" width="60"
                                         height="39">
                                </div>
                                <div class="clear"></div>
                            </div>
                            <div class="first-list">
                                <div class="div_2"><a href="CarAServlet?type=t004">新能源车</a></div>
                                <div class="div_img">
                                    <img src="<%=basePath%>images/car3.jpg" alt="Cars" title="Cars" width="60"
                                         height="39">
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                        <div class="box-title">
                            <h1><span class="title-icon"></span><a href="">热门汽车</a></h1>
                        </div>
                        <div class="section group example">
                            <div class="col_1_of_2 span_1_of_2">
                                <img src="<%=basePath%>images/pic21.jpg" alt=""/>
                                <img src="<%=basePath%>images/pic24.jpg" alt=""/>
                                <img src="<%=basePath%>images/pic25.jpg" alt=""/>
                                <img src="<%=basePath%>images/pic27.jpg" alt=""/>
                            </div>
                            <div class="col_1_of_2 span_1_of_2">
                                <img src="<%=basePath%>images/pic22.jpg" alt=""/>
                                <img src="<%=basePath%>images/pic23.jpg" alt=""/>
                                <img src="<%=basePath%>images/pic26.jpg" alt=""/>
                                <img src="<%=basePath%>images/pic28.jpg" alt=""/>
                            </div>
                            <div class="clear"></div>
                        </div>
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



