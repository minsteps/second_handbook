<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>用户信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/style2.css">
    <style>
        body{margin: 30px;}
    </style>
</head>
<body>

<a href="${pageContext.request.contextPath}/Pages/welcome.jsp">←返回</a>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>用户信息</legend>
</fieldset>

<form class="layui-form" lay-filter="example" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名:
            <c:forEach items="${requestScope.userMsg}" var="s">
                ${s.username}
            </c:forEach>
        </label>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">VIP :
            <c:forEach items="${requestScope.userMsg}" var="s">
                <c:if test="${s.vip == 1}">会员</c:if>
                <c:if test="${s.vip == 0}">平民</c:if>
            </c:forEach>
        </label>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <a href=${pageContext.request.contextPath}/Pages/changeUserMsg.jsp>
                <input type="button" value='修改信息'class="layui-btn layui-btn-normal">
            </a>
        </div>

    </div>

</form>

<script src="${pageContext.request.contextPath}/src/js/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['laypage','table'], function(){
        var table = layui.table
            ,laypage = layui.laypage;
    });
</script>
</body>
</html>