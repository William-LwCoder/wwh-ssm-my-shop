<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2019/5/21
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 用户详情</title>
    <jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="box-body">
    <table id="dataTable" class="table">
        <tbody>
            <tr>
                <td>用户名：</td>
                <td>${tbUser.username}</td>
            </tr>
            <tr>
                <td>手机号：</td>
                <td>${tbUser.phone}</td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td>${tbUser.email}</td>
            </tr>
            <tr>
                <td>创建时间：</td>
                <td><fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            </tr>
            <tr>
                <td>更新时间：</td>
                <td><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            </tr>
        </tbody>
    </table>
</div>

<jsp:include page="../includes/footer.jsp" />
</body>
</html>
