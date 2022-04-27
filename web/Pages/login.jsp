<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/style1.css">
</head>
<body style= "background: url(${pageContext.request.contextPath}/src/images/2.jpg) no-repeat fixed;
background-size: cover;">;

<div class="layui-elem-field layui-field-title" style="margin-top: 200px;">
    <div style="text-align: center;"><h1>会员登录</h1></div>
</div>

<form class="layui-form" action="${pageContext.request.contextPath}/userLogin.enter" method="post">

    <div align="center">

        <div class="layui-input-inline">
            <label>账 号: </label><input type="text" name="userId" placeholder="请输入账号" class="layui-input" >
        </div>
        <br><br>

        <div class="layui-input-inline">
            <label>密 码: </label><input type="password" name="password" placeholder="请输入密码" id="password" autocomplete="off"
                   class="layui-input">
        </div>
        <br><br>

        <div align="center">
            <input type="submit" id="entry_btn1" value="登录" class="layui-btn layui-btn-normal">
            <a href="/secondHand/Pages/register.jsp" class="layui-btn layui-btn-normal">注册</a>
            <a href="../index.jsp" class="layui-btn layui-btn-normal">首页</a>

        </div>

    </div>
    <br>
    <br>
    <br>
    <h2 align='center'>${requestScope.Massage }</h2>
</form>
</body>
</html>
