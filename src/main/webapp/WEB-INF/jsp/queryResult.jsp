<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${pageTitle}</title>
    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="<%=path%>/js/Globals.js"></script>
    <script src="<%=path%>/js/index.js"></script>

    <style type="text/css">
        .carousel-inner > .item > a > img, .carousel-inner > .item > img, .img-responsive, .thumbnail a > img,
        .thumbnail > img {
            display: block;
            height: 300px;
            width: 1200px;
            max-width: 100%;
        }
        /* 为标题栏上的选项卡设置底部距离 */
        .tab-topic {
            margin-bottom: 3px;
        }
    </style>
</head>
<body class="myElement" data="/SSM-WEB">
<!-- 顶部导航栏 -->
<%-- <jsp:include page="../../public/nav-top.jsp"></jsp:include> --%>

<hr/>
<!-- 栅格系统 平均分三列 -->
<div class="container" id="summary-container">

    <!-- 分割线暂时注释掉
    <hr class="divider"/> -->
    <div class="row">
        <div class="col-md-12">

            <div class="panel panel-info">

                <!-- 利用一个栅格系统向右偏移完成布局 -->
                <c:choose>
                    <c:when test="${userList.size()==0 }">
                        <div align="center" style="padding-top: 20px"><font color="red">${q}</font>未查询到结果，请换个关键字试试！</div>
                    </c:when>
                    <c:otherwise>
                        <div align="center" style="padding-top: 20px">
                            查询<font color="red">${q}</font>关键字，约${resultTotal}条记录！
                        </div>
                        <c:forEach var="u" items="${userList }" varStatus="status">
                            <div class="panel-heading ">

                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <b>
                                                    <a href="<%=path %>/user/showUser/${u.userId}">${u.username}</a>
                                                </b>
                                                <br/>
                                                    ${u.description}
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-md-offset-2">
                                        <p class="text-muted text-right">
                                                ${u.password}
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <p class="text-right">
							<span class="label label-default">
							<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
							 ${u.password}
							</span>
                                </p>
                            </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>

                <hr class="divider"/>
            </div>

        </div>
    </div>


    <!-- 分页 -->
    <nav class="text-right">
        <ul class="pagination pagination-sm">
            ${pageHtml}
        </ul>
    </nav>
    <!-- 分割线 -->
    <hr class="divider"/>
</div>


<footer>
    <p class="text-center">© 2016 crossoverJie</p>
    <p class="text-center">
    </p>
</footer>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>