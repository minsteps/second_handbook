<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header layui-bg-green">
        <div class="layui-logo layui-bg-green">管理员后台</div>


        <ul class="layui-nav layui-layout-left layui-bg-green">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}">主页</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right layui-bg-green">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Pages/adminLogin.jsp">退出登录</a></li>
        </ul>

    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="${pageContext.request.contextPath}/Pages/adminBackstage.jsp">管理操作</a>

                </li>
                <li class="layui-nav-item">
                    <dd><a href="javascript:jump('${pageContext.request.contextPath}/banPublish.admin');">出售信息管理</a></dd>
                    <dd><a href="javascript:jump('${pageContext.request.contextPath}/manageVip.admin');">会员权限管理</a></dd>
                    <dd><a href="javascript:jump('${pageContext.request.contextPath}/manageUser.admin');">用户升会员管理</a></dd>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <iframe id="iframe_a" src="${pageContext.request.contextPath}/Pages/welcome.jsp" style="width: 100%"
                height="98%"></iframe>
    </div>

    <div class="layui-footer">
        <em>亲爱的管理员,欢迎您!</em>
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
