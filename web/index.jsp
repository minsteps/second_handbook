<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/style.css">
</head>
<body style="background: url(src/images/2.jpg) no-repeat fixed;
    background-size: cover;">
<div >
    <div class="body1" style="text-align: center;">
        <a class="layui-btn-radius layui-btn-primary"><h1>欢迎来到二手书交易平台!</h1></a>
    </div>
    <div class="body2" style="text-align: center;"><a href="${pageContext.request.contextPath}/Pages/login.jsp"
                                                      class="layui-btn layui-btn-radius layui-btn-primary"><h3>会员登录</h3>
    </a></div>
    <div class="body3" style="text-align: center"><a href="${pageContext.request.contextPath}/Pages/adminLogin.jsp"
                                                     class="layui-btn layui-btn-radius layui-btn-primary"><h3>管理员登录</h3>
    </a></div>
</div>

</body>
</html>

