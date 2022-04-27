<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>新增二手书信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/css/layui.css">
    <style>
        body{margin: 30px;}
    </style>
</head>
<body>

<a href="${pageContext.request.contextPath}/showSelfBookMsg.book">←返回</a>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>增加信息</legend>
</fieldset>

<form class="layui-form" action="${pageContext.request.contextPath}/addBookMsg.book" lay-filter="example" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">书的信息</label>
        <div class="layui-input-inline">
            <input name="newBookMsg"  placeholder="请输入书的信息" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">销售价格</label>
        <div class="layui-input-inline">
            <input name="price"  placeholder="请输入书的价格" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn layui-btn-normal" >确认提交</button>
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