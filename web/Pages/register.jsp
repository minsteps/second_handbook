<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/src/js/jquery-1.7.2.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/style1.css" media="all">
</head>
<body style= "background: url(${pageContext.request.contextPath}/src/images/2.jpg) no-repeat fixed;
        background-size: cover;">


<div class="layui-elem-field layui-field-title" style="margin-top: 200px;">
    <div style="text-align: center;"><h1>注 册 页 面</h1></div>
</div>

<form class="layui-form" action="${pageContext.request.contextPath}/register" method="post">

    <div align="center">

        <label>账　号:</label>
        <div class="layui-input-inline">
            <input type="text" name="userId" placeholder="请输入账号" class="layui-input" id="userId">
        </div>
        <br><br>

        <label>用户名:</label>
        <div class="layui-input-inline">
            <input type="text" name="username" placeholder="请输入用户名" class="layui-input">
        </div>
        <br><br>

        <label>密　码:</label>
        <div class="layui-input-inline">
            <input type="password" name="password" placeholder="请输入密码" id="password" autocomplete="off"
                   class="layui-input" id="password">
        </div>
        <br><br>

        <div align="center">
            <input type="submit" id="entry_btn1" value="会员注册" class="layui-btn layui-btn-normal" id="sub_btn">
            <a href="${pageContext.request.contextPath}/Pages/login.jsp" class="layui-btn layui-btn-normal">返回登录</a>
        </div>

        <br>
        <br>
        <br>

        <h2 class="errorMsg" align='center'>${requestScope.registerMassage }</h2>


    </div>
</form>
</body>
</html>
