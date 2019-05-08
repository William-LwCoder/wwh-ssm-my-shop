<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2019/4/25
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 用户管理</title>
    <jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp" />

    <jsp:include page="../includes/menu.jsp" />

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">用户管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">

                    <!-- 提示消息 -->
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>

                            <div class="row" style="margin-top: 10px;padding-left: 12px;padding-right: 20px;">
                                <form:form cssClass="form-horizontal" id="searchForm" action="/user/search" method="post" modelAttribute="tbUser">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="username" class="col-sm-3 control-label">姓名：</label>

                                                <div class="col-sm-9">
                                                    <form:input path="username" cssClass="form-control" placeholder="姓名" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="phone" class="col-sm-3 control-label">手机：</label>

                                                <div class="col-sm-9">
                                                    <form:input path="phone" cssClass="form-control" placeholder="手机" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="email" class="col-sm-3 control-label">邮箱：</label>

                                                <div class="col-sm-9">
                                                    <form:input path="email" cssClass="form-control" placeholder="邮箱" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <button type="submit" class="btn btn-info pull-right">搜索</button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>

                            <div class="row">
                                <div class="col-xs-12">
                                    <a href="/user/form" class="btn btn-sm btn-primary"><i class="fa fa-plus"></i> 新增</a>
                                    <a href="#" class="btn btn-sm btn-danger"><i class="fa fa-trash-o"></i> 删除</a>
                                    <a href="#" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>
                                    <a href="#" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck-master" /></th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>手机号</th>
                                    <th>邮箱</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbUsers}" var="tbUser">
                                    <tr>
                                        <td><input id="${tbUser.id}" type="checkbox" class="minimal" /></td>
                                        <td>${tbUser.id}</td>
                                        <td>${tbUser.username}</td>
                                        <td>${tbUser.phone}</td>
                                        <td>${tbUser.email}</td>
                                        <td><fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                        <td>
                                            <a href="#" class="btn btn-sm btn-default"><i class="fa fa-search"></i> 查看</a>
                                            <a href="#" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>
                                            <a href="#" class="btn btn-sm btn-danger"><i class="fa fa-trash-o"></i> 删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="../includes/copyright.jsp" />
</div>
<!-- ./wrapper -->

<jsp:include page="../includes/footer.jsp" />
<script>
    $(function () {
        var _checkbox = App.getCheckbox();


    });
</script>
</body>
</html>
