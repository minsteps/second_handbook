<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>二手书销售信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">

</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>信息管理</legend>
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
            <th>书本信息</th>
            <th>价格</th>
            <th>‍书主</th>
            <th>发布状态</th>
            <th>管理</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${!empty requestScope.selfBookMsg}">
            <c:forEach items="${requestScope.selfBookMsg}" var="s" >
                <tr>
                    <td>${s.msg}</td>
                    <td>${s.price}元</td>
                    <td>${s.bookOwner}</td>
                    <td>${s.publish}</td>
                    <th>
                        <a href="${pageContext.request.contextPath}/updateMsg.book?book_id=${s.book_id}" class="layui-btn layui-btn-primary layui-btn-xs">编辑</a>
                        <a href="${pageContext.request.contextPath}/publishNewBook.book?book_id=${s.book_id}" class="layui-btn layui-btn-normal layui-btn-xs">发布</a>
                    </th>
                    </td>
                </tr>
            </c:forEach>
        </c:if>


        </tbody>
    </table>
</div>
<br>
<br>
<br>
<a href="${pageContext.request.contextPath}/Pages/addBookMsg.jsp" class="layui-btn layui-btn-xs" >新增二手书信息</a>


</body>
</html>