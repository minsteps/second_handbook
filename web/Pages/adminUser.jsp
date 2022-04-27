<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>管理权限</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">

</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>用户升会员管理</legend>
</fieldset>


<div class="layui-form">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>🆔用户账号</th>
            <th>👮用户名称</th>
            <th>🖐权限管理</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${!empty requestScope.userUp}">
            <c:forEach items="${requestScope.userUp}" var="s" >
                <tr>
                    <td>${s.user_id}</td>
                    <td>${s.username}</td>
                    <th>
                        <a href="${pageContext.request.contextPath}/becomeVip.admin?user_id=${s.user_id}" class="layui-btn layui-btn-warm">升级为VIP</a>
                    </th>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>
</div>

</body>
</html>