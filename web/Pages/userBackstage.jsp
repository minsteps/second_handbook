<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户后台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">用户后台</div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}">主页</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:jump('${pageContext.request.contextPath}/userMessage.book');">
                    <img src="${pageContext.request.contextPath}/src/images/user.jpg" class="layui-nav-img">
                    用户信息
                </a>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Pages/login.jsp">退出登录</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">

                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="${pageContext.request.contextPath}/Pages/userBackstage.jsp">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:jump('${pageContext.request.contextPath}/bookMessage');">编辑二手书信息</a></dd>
                        <dd><a href="javascript:jump('${pageContext.request.contextPath}/publishedMsg.do');">已发布信息</a></dd>
                        <dd><a href="javascript:jump('${pageContext.request.contextPath}/queryComment.book');">他人留言信息</a></dd>
                        <dd><a href="javascript:jump('${pageContext.request.contextPath}/querySelfComment.book');">我的回复信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:jump('${pageContext.request.contextPath}/lookOthersBook.book');">查看他人二手书信息</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <iframe id="iframe_a" src="${pageContext.request.contextPath}/Pages/welcome.jsp" style="width: 100%" height="98%"></iframe>
    </div>

    <div class="layui-footer">
        2021有你真好!
    </div>
</div>


<script src="${pageContext.request.contextPath}/src/js/layui.js"></script>
<script>
    //JavaScript代码区域
    function jump(url) {
        parent.document.getElementById("iframe_a").src = url;
    };

    layui.use('element', function () {
        var element = layui.element;
    });
</script>
</body>
</html>


