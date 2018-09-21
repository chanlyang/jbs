<%--
  Created by IntelliJ IDEA.
  User: CHANLYANG
  Date: 2018/9/18
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Home</title>
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
            setInterval(displayNextImage, 2000);  //每隔3秒调用一次显示图片的方法。
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
                        <ul class="user_menu">
                            <li class="act first"><a href="">
                                <div class="button-t"><span>Shipping &amp; Returns</span></div>
                            </a></li>
                            <li class=""><a href="">
                                <div class="button-t"><span>Advanced Search</span></div>
                            </a></li>
                            <li class=""><a href="">
                                <div class="button-t"><span>Create an Account</span></div>
                            </a></li>
                            <li class="last"><a href="">
                                <div class="button-t"><span>Log in</span></div>
                            </a></li>
                        </ul>
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
                                <div class="box_wrapper"><h1>跑车</h1>
                                </div>
                                <div class="grid_1_of_3 images_1_of_3">
                                    <c:forEach var="car1" items="${autos1}">
                                        <div class="grid_1">
                                            <a href="single.html"><img src="${car1.pic}"
                                                                       title="continue reading"
                                                                       alt=""></a>
                                            <div class="grid_desc">
                                                <p class="title">${car1.autocard} ${car1.color} ${car1.tname}</p>
                                                <p class="title1">Lorem ipsum dolor sitconsectetuer adipiscing elit</p>
                                                <div class="price" style="height: 19px;">
                                                    <span class="reducedfrom">￥${car1.dayrent}</span>
                                                    <span class="actual">$12.00</span>
                                                </div>
                                                <div class="cart-button">
                                                    <div class="cart">
                                                        <a href="#"><img src="<%=basePath%>images/cart.png" alt=""/></a>
                                                    </div>
                                                    <button class="button"><span>Details</span></button>
                                                    <div class="clear"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </c:forEach>
                                </div>
                                <div class="clear"></div>
                                <div class="paging" align="center">
                                    <ul>
                                        <li><a href="#" target="_parent">Previous</a></li>
                                        <li><a href="#" target="_parent">1</a></li>
                                        <li><a href="#" target="_parent">2</a></li>
                                        <li><a href="#" target="_parent">3</a></li>
                                        <li><a href="#" target="_parent">4</a></li>
                                        <li><a href="#" target="_parent">5</a></li>
                                        <li><a href="#" target="_parent">6</a></li>
                                        <li><a href="#" target="_parent">Next</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div></div>
                        <div class="content-top">
                            <div class="box_wrapper"><h1>Featured Products</h1>
                            </div>
                            <div class="text">
                                <div class="grid_1_of_3 images_1_of_3">
                                    <c:forEach var="car2" items="${autos2}">
                                        <div class="grid_1">
                                            <a href="single.html"><img src="${car2.pic}"></a>
                                            <div class="grid_desc">
                                                <p class="title">${car2.autocard} ${car2.color} ${car2.tname}</p>
                                                <p class="title1">Lorem ipsum dolor sitconsectetuer adipiscing elit</p>
                                                <div class="price" style="height: 19px;">
                                                    <span class="reducedfrom">$66.00</span>
                                                    <span class="actual">$12.00</span>
                                                </div>
                                                <div class="cart-button">
                                                    <div class="cart">
                                                        <a href="#"><img src="<%=basePath%>images/cart.png" alt=""/></a>
                                                    </div>
                                                    <button class="button"><span>Details</span></button>
                                                    <div class="clear"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </c:forEach>
                                </div>
                                <div class="clear"></div>
                                <div class="paging" align="center">
                                    <ul>
                                        <li><a href="#" target="_parent">Previous</a></li>
                                        <li><a href="#" target="_parent">1</a></li>
                                        <li><a href="#" target="_parent">2</a></li>
                                        <li><a href="#" target="_parent">3</a></li>
                                        <li><a href="#" target="_parent">4</a></li>
                                        <li><a href="#" target="_parent">5</a></li>
                                        <li><a href="#" target="_parent">6</a></li>
                                        <li><a href="#" target="_parent">Next</a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="content-top">
                                <div class="box_wrapper"><h1>Featured Products</h1>
                                </div>
                                <div class="text">
                                    <div class="grid_1_of_3 images_1_of_3">
                                        <c:forEach var="car3" items="${autos3}">
                                            <div class="grid_1">
                                                <a href="single.html"><img src="${car3.pic}"></a>
                                                <div class="grid_desc">
                                                    <p class="title">${car3.autocard} ${car3.color} ${car3.tname}</p>
                                                    <p class="title1">Lorem ipsum dolor sitconsectetuer adipiscing elit</p>
                                                    <div class="price" style="height: 19px;">
                                                        <span class="reducedfrom">$66.00</span>
                                                        <span class="actual">$12.00</span>
                                                    </div>
                                                    <div class="cart-button">
                                                        <div class="cart">
                                                            <a href="#"><img src="<%=basePath%>images/cart.png" alt=""/></a>
                                                        </div>
                                                        <button class="button"><span>Details</span></button>
                                                        <div class="clear"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                        </c:forEach>
                                    </div>
                                    <div class="clear"></div>
                                    <div class="paging" align="center">
                                        <ul>
                                            <li><a href="#" target="_parent">Previous</a></li>
                                            <li><a href="#" target="_parent">1</a></li>
                                            <li><a href="#" target="_parent">2</a></li>
                                            <li><a href="#" target="_parent">3</a></li>
                                            <li><a href="#" target="_parent">4</a></li>
                                            <li><a href="#" target="_parent">5</a></li>
                                            <li><a href="#" target="_parent">6</a></li>
                                            <li><a href="#" target="_parent">Next</a></li>
                                        </ul>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
                <div class="header-para">
                    <div class="categories">
                        <div class="list-categories">
                            <div class="first-list">
                                <div class="div_2"><a href="">高端轿车</a></div>
                                <div class="div_img">
                                    <img src="<%=basePath%>images/car1.jpg" alt="Cars" title="Cars" width="60"
                                         height="39">
                                </div>
                                <div class="clear"></div>
                            </div>
                            <div class="first-list">
                                <div class="div_2"><a href="">普通轿车</a></div>
                                <div class="div_img">
                                    <img src="<%=basePath%>images/car2.jpg" alt="Cars" title="Cars" width="60"
                                         height="39">
                                </div>
                                <div class="clear"></div>
                            </div>
                            <div class="first-list">
                                <div class="div_2"><a href="">新能源车</a></div>
                                <div class="div_img">
                                    <img src="<%=basePath%>images/car3.jpg" alt="Cars" title="Cars" width="60"
                                         height="39">
                                </div>
                                <div class="clear"></div>
                            </div>
                            <div class="first-list">
                                <div class="div_2"><a href="">大型客车</a></div>
                                <div class="div_img">
                                    <img src="<%=basePath%>images/car4.jpg" alt="Cars" title="Cars" width="60"
                                         height="39">
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                        <div class="box">
                            <div class="box-heading"><h1><a href="#">Cart:&nbsp;</a></h1></div>
                            <div class="box-content">
                                Now in your cart&nbsp;<strong> 0 items</strong>
                            </div>
                        </div>
                        <div class="box-title">
                            <h1><span class="title-icon"></span><a href="">Branches</a></h1>
                        </div>
                        <div class="section group example">
                            <div class="col_1_of_2 span_1_of_2">
                                <img src="<%=basePath%>images/pic22.jpg" alt=""/>
                                <img src="<%=basePath%>images/pic23.jpg" alt=""/>
                                <img src="<%=basePath%>images/pic26.jpg" alt=""/>
                                <img src="<%=basePath%>images/pic28.jpg" alt=""/>
                                <div class="col_1_of_2 span_1_of_2">
                                    <img src="<%=basePath%>images/pic22.jpg" alt=""/>
                                    <img src="<%=basePath%>images/pic23.jpg" alt=""/>
                                    <img src="<%=basePath%>images/pic26.jpg" alt=""/>
                                    <img src="<%=basePath%>images/pic28.jpg" alt=""/>
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

