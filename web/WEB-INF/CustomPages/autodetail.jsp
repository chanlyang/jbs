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
    <title>��������</title>
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
                        <c:if test="${uname == null}">
                            <ul class="user_menu">
                                <li class=""><a href="MainServlet">
                                    <div class="button-t"><span>������ҳ</span></div>
                                </a></li>
                                <li class=""><a href="regist.jsp">
                                    <div class="button-t"><span>ע��</span></div>
                                </a></li>
                                <li class="last"><a href="Login.jsp">
                                    <div class="button-t"><span>��¼</span></div>
                                </a></li>
                            </ul>
                        </c:if>
                        <c:if test="${uname != null}">
                            <ul class="user_menu">
                                <li class=""><a href="MainServlet">
                                    <div class="button-t"><span>������ҳ</span></div>
                                </a></li>
                                <li class=""><a href="CustomInfoServlet">
                                    <div class="button-t"><span>${uname}</span></div>
                                </a></li>
                                <li class=""><a href="LoginOutServlet">
                                    <div class="button-t"><span>�˳���¼</span></div>
                                </a></li>
                            </ul>
                        </c:if>
                    </div>
                </div>
            </div>

            <div class="banner-top">
                <div class="header-bottom">
                    <div class="header_bottom_right_images">

                        <div class="content-wrapper">
                            <div class="content-top">
                                <div class="about_wrapper"><h1>���г���</h1>
                                </div>
                                <div class="text">
                                    <c:forEach var="car" items="${auto}">
                                        <div class="grid_1_of_3 images_1_of_3">
                                            <div class="grid_1">
                                                <a href=""><img src="${car.pic}"></a>
                                                <div class="grid_desc">
                                                    <p class="title">Ʒ�ƣ�${car.bname} ${car.tname}</p>
                                                    <p class="title1">���ƺţ�${car.autocard}</p>
                                                    <p class="title1">��ɫ��${car.color}</p>
                                                    <p class="title1">��λ��${car.gear}</p>
                                                    <p class="title1">��λ����${car.seat}</p>
                                                    <p class="title1">������${car.tubo}</p>
                                                    <div class="price" style="height: 19px;">
                                                        <span class="reducedfrom">��${car.dayrent}</span>
                                                            <%--<span class="actual">$12.00</span>--%>
                                                    </div>
                                                    <div class="cart-button">
                                                        <button class="button" onclick="javascript:document.location.href=encodeURI('RentServlet?car=${car.autocard}')"><span>����ԤԼ</span></button>
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
                                <li><a>���У�${tp.allRows}</a></li>
                                <li><a>��ҳ����${tp.allPages}</a></li>
                                <li><a>��ǰҳ��${tp.page}</a></li>
                                <li><a href="CarAServlet?page=1&type=${type}" target="_parent">��ҳ</a></li>
                                <li><a href="CarAServlet?page=${tp.page-1}&type=${type}" target="_parent">��һҳ</a></li>
                                <li><a href="CarAServlet?page=${tp.page+1}&type=${type}" target="_parent">��һҳ</a></li>
                                <li><a href="CarAServlet?page=${tp.allPages}&type=${type}" target="_parent">βҳ</a></li>
                            </ul>
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
                                <h1><span class="title-icon"></span><a href="">��������</a></h1>
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



