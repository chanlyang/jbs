<%--
  Created by IntelliJ IDEA.
  User: CHANLYANG
  Date: 2018/9/27
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="GB2312" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>所有汽车</title>
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
                                <div class="button-t"><span>个人中心</span></div>
                            </a></li>
                            <li class=""><a href="">
                                <div class="button-t"><span>注册</span></div>
                            </a></li>
                            <li class="last"><a href="Login.jsp">
                                <div class="button-t"><span>登录</span></div>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="banner-top">
                <div class="header-bottom">
                    <div class="header_bottom_right_images">

                        <div class="content-wrapper">
                            <div class="content-top">
                                <div class="about_wrapper"><h1>豪华轿车</h1>
                                </div>
                                <div class="text">
                                    <c:forEach var="car" items="${auto}">
                                        <div class="grid_1_of_3 images_1_of_3">
                                            <div class="grid_1">
                                                <a href="single.html"><img src="${car.pic}"></a>
                                                <div class="grid_desc">
                                                    <p class="title">品牌：${car.bname} ${car3.tname}</p>
                                                    <p class="title1">颜色：${car.color}</p>
                                                    <p class="title1">挡位：${car.gear}</p>
                                                    <p class="title1">座位数：${car.seat}</p>
                                                    <p class="title1">排量：${car.tubo}</p>
                                                    <div class="price" style="height: 19px;">
                                                        <span class="reducedfrom">$${car.dayrent}</span>
                                                        <span class="actual">$12.00</span>
                                                    </div>
                                                    <div class="cart-button">
                                                        <div class="cart">
                                                            <button class="button"><span>Details</span></button>
                                                        </div>
                                                        <button class="button"><span>Cart</span></button>
                                                        <div class="clear"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                    </c:forEach>
                                    <div class="clear"></div>
                                </div>
                            </div>
                        </div>
                        <div class="paging">
                            <ul>
                                <li><a>共有：${tp.allRows}</a></li>
                                <li><a>总页数：${tp.allPages}</a></li>
                                <li><a>当前页：${tp.page}</a></li>
                                <li><a href="CarAServlet?page=1&type=${type}" target="_parent">首页</a></li>
                                <li><a href="CarAServlet?page=${tp.page-1}&type=${type}" target="_parent">上一页</a></li>
                                <li><a href="CarAServlet?page=${tp.page+1}&type=${type}" target="_parent">下一页</a></li>
                                <li><a href="CarAServlet?page=${tp.allPages}&type=${type}" target="_parent">尾页</a></li>
                            </ul>
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
                                <h1><span class="title-icon"></span><a href="">汽车图片</a></h1>
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



