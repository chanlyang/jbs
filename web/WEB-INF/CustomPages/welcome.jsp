<%--
  Created by IntelliJ IDEA.
  User: CHANLYANG
  Date: 2018/9/18
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="GB2312" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>首页</title>
    <link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href='https://fonts.googleapis.com/css?family=Playball' rel='stylesheet' type='text/css'>
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/script.js" type="text/javascript"></script>
    <script src="<%=basePath%>js/superfish.js"></script>
    <script type="text/javascript">
        var images = [], x = -1;
        images[0] = "<%=basePath%>images/banner1.jpg";
        images[1] = "<%=basePath%>images/banner2.jpg";
        images[2] = "<%=basePath%>images/banner3.jpg";
        images[3] = "<%=basePath%>images/banner4.jpg";

        function displayNextImage() {//显示下一张
            x = (x === images.length - 1) ? 0 : x + 1; //如果是最后一张，那么切换到第一张
            document.getElementById("img").src = images[x];//把获取到的值给img标签，让他显示
        }

        function displayPreviousImage() {//显示上一张
            x = (x <= 0) ? images.length - 1 : x - 1;//获取数组中的上一个值
            document.getElementById("img").src = images[x]; //把获取到的值给img标签，让他显示
        }

        function startTimer() {//定时器，dom加载后调用
            setInterval(displayNextImage, 2000);  //每隔2秒调用一次显示图片的方法。
        }

    </script>

    <script type="text/javascript">
        function jump(autocard) {
            document.location.href = "RentServlet?car=" + encodeURI(autocard);
        }
    </script>

</head>
<body onload="startTimer()">
<div class="header-bg">
    <div class="wrap">
        <div class="h-bg">
            <div class="total">
                <div class="header">
                    <div class="box_header_user_menu">
                        <c:if test="${uname == null}">
                            <ul class="user_menu">
                                <li class=""><a href="MainServlet">
                                    <div class="button-t"><span>返回首页</span></div>
                                </a></li>
                                <li class=""><a href="regist.jsp">
                                    <div class="button-t"><span>注册</span></div>
                                </a></li>
                                <li class="last"><a href="Login.jsp">
                                    <div class="button-t"><span>登录</span></div>
                                </a></li>
                            </ul>
                        </c:if>
                        <c:if test="${uname != null}">
                            <ul class="user_menu">
                                <li class=""><a href="MainServlet">
                                    <div class="button-t"><span>返回首页</span></div>
                                </a></li>
                                <li class=""><a href="CustomInfoServlet">
                                    <div class="button-t"><span>${uname}</span></div>
                                </a></li>
                                <li class=""><a href="LoginOutServlet">
                                    <div class="button-t"><span>退出登录</span></div>
                                </a></li>
                            </ul>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="banner-top">
                <div class="header-bottom">
                    <div class="header_bottom_right_images">
                        <div id="slideshow">
                            <ul class="slides">
                                <li>
                                    <canvas></canvas>
                                    <img id="img" src="<%=basePath%>images/banner4.jpg"></li>
                            </ul>
                            <span class="arrow previous" onclick="displayNextImage()"></span>
                            <span class="arrow next" onclick="displayPreviousImage()"></span>
                        </div>
                        <div class="content-wrapper">
                            <div class="content-top">
                                <div class="box_wrapper"><h1>普通轿车</h1>
                                </div>
                                <div class="text">
                                    <c:forEach var="car1" items="${autos1}">
                                        <div class="grid_1_of_3 images_1_of_3">
                                            <div class="grid_1">
                                                <a onclick="javascript:document.location.href=encodeURI('RentServlet?car=${car1.autocard}')"><img src="${car1.pic}"
                                                                title="continue reading" alt=""></a>
                                                <div class="grid_desc">
                                                    <p class="title">品牌：${car1.bname} ${car1.tname}</p>
                                                    <p class="title1">车牌号：${car1.autocard}</p>
                                                    <p class="title1">颜色：${car1.color}</p>
                                                    <p class="title1">挡位：${car1.gear}</p>
                                                    <p class="title1">座位数：${car1.seat}</p>
                                                    <p class="title1">排量：${car1.tubo}</p>
                                                    <div class="price" style="height: 19px;">
                                                        <span class="reducedfrom">￥${car1.dayrent}</span>
                                                            <%-- <span class="actual">$12.00</span>--%>
                                                    </div>
                                                    <div class="cart-button">
                                                        <button class="button"
                                                                onclick="javascript:document.location.href=encodeURI('RentServlet?car=${car1.autocard}')">
                                                            <span>立即预约</span></button>
                                                        <div class="clear"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                    </c:forEach>
                                    <div class="clear"></div>
                                    <div class="paging" align="center">
                                        <ul>
                                            <ul>
                                                <li><p>总车数：${tp1.allRows}</p></li>
                                                <li><a href="CarAServlet?type=t001" target="_parent">查看更多</a></li>
                                            </ul>
                                        </ul>
                                    </div>
                                    <div class="clear"></div>
                                </div>

                            </div>
                            <div class="content-top">
                                <div class="box_wrapper"><h1>高端轿车</h1>
                                </div>
                                <div class="text">
                                    <c:forEach var="car2" items="${autos2}">
                                        <div class="grid_1_of_3 images_1_of_3">
                                            <div class="grid_1">
                                                <a onclick="javascript:document.location.href=encodeURI('RentServlet?car=${car2.autocard}')"><img src="${car2.pic}"
                                                                title="continue reading" alt=""></a>
                                                <div class="grid_desc">
                                                    <p class="title">品牌：${car2.bname} ${car2.tname}</p>
                                                    <p class="title1">车牌号：${car2.autocard}</p>
                                                    <p class="title1">颜色：${car2.color}</p>
                                                    <p class="title1">挡位：${car2.gear}</p>
                                                    <p class="title1">座位数：${car2.seat}</p>
                                                    <p class="title1">排量：${car2.tubo}</p>
                                                    <div class="price" style="height: 19px;">
                                                        <span class="reducedfrom">￥${car2.dayrent}</span>
                                                    </div>
                                                    <div class="cart-button">
                                                        <button class="button" onclick="javascript:document.location.href=encodeURI('RentServlet?car=${car2.autocard}')"><span>立即预约</span></button>
                                                        <div class="clear"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                    </c:forEach>
                                    <div class="clear"></div>
                                    <div class="paging" align="center">
                                        <ul>
                                            <ul>
                                                <li><p>总车数：${tp2.allRows}</p></li>
                                                <li><a href="CarAServlet?type=t002" target="_parent">查看更多</a></li>
                                            </ul>
                                        </ul>
                                    </div>
                                    <div class="clear"></div>
                                </div>

                            </div>
                            <div class="content-top">
                                <div class="box_wrapper"><h1>新能源车</h1>
                                </div>
                                <div class="text">
                                    <c:forEach var="car3" items="${autos3}">
                                        <div class="grid_1_of_3 images_1_of_3">
                                            <div class="grid_1">
                                                <a onclick="javascript:document.location.href=encodeURI('RentServlet?car=${car3.autocard}')"><img src="${car3.pic}"
                                                                title="continue reading" alt=""></a>
                                                <div class="grid_desc">
                                                    <p class="title">品牌：${car3.bname} ${car3.tname}</p>
                                                    <p class="title1">车牌号：${car3.autocard}</p>
                                                    <p class="title1">颜色：${car3.color}</p>
                                                    <p class="title1">挡位：${car3.gear}</p>
                                                    <p class="title1">座位数：${car3.seat}</p>
                                                    <p class="title1">排量：${car3.tubo}</p>
                                                    <div class="price" style="height: 19px;">
                                                        <span class="reducedfrom">￥${car3.dayrent}</span>
                                                    </div>
                                                    <div class="cart-button">
                                                        <button class="button" onclick="javascript:document.location.href=encodeURI('RentServlet?car=${car3.autocard}')"><span>立即预约</span></button>
                                                        <div class="clear"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                    </c:forEach>
                                    <div class="clear"></div>
                                </div>
                                <div class="paging" align="center">
                                    <ul>
                                        <li><p>总车数：${tp3.allRows}</p></li>
                                        <li><a href="CarAServlet?type=t004" target="_parent">查看更多</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="header-para">
                    <div class="categories">
                        <div class="list-categories">
                            <c:forEach var="type" items="${type}">
                                <div class="first-list">
                                    <div class="div_2"><a href="CarAServlet?type=${type.tno}">${type.atype}</a></div>
                                    <div class="div_img">
                                        <img src="${type.pic}" alt="Cars" title="Cars" width="60"
                                             height="39">
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </c:forEach>
                        </div>
                        <%--<div class="box">
                            <div class="box-heading"><h1><a href="#">Cart:&nbsp;</a></h1></div>
                            <div class="box-content">
                                Now in your cart&nbsp;<strong> 0 items</strong>
                            </div>
                        </div>--%>
                        <div class="box-title">
                            <h1><span class="title-icon"></span><a href=""> 热门汽车</a></h1>
                        </div>
                        <%-- javascript:document.location.href=encodeURI('RentServlet?car=${car1.autocard}')--%>
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



