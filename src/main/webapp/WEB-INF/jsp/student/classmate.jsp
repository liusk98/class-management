<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/8/16
  Time: 上午9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="同班同学"/>
    <jsp:param name="needTable" value="true"/>
</jsp:include>
<div class="x_content">
    <table id="studentInfoTable"
           class="table table-bordered table-striped table-hover bulk-action"
           data-toggle="table"
           data-height="460"
           data-pagination="true"
           data-side-pagination="server"
           data-query-params-type=""
           data-method="post"
           data-content-type="application/x-www-form-urlencoded"
           data-ajax="ajaxRequest"
           data-sort-name="stuNo"
           data-sort-order="asc"
           data-page-list="[5,10,25,50,100,200,All]"
           data-url="${pageContext.request.contextPath}/student/studentInfo/classmate.json">
        <thead>
        <tr>
            <th data-field="" data-checkbox="true"></th>
            <th data-field="stuNo" data-sortable="true" data-width="10" data-width-unit="%">学号</th>
            <th data-field="name" data-sortable="true">学生名称</th>
            <th data-field="sex" data-sortable="true">性别</th>
            <th data-field="phone">电话号码</th>
            <th data-field="createTime" data-sortable="true">创建时间</th>
            <th data-field="lastLoginTime" data-sortable="true">上次登录时间</th>
            <th data-field="status" data-formatter="changeStatusFormat" data-sortable="true">启用状态</th>
            <th data-formatter="rowsOperate">操作</th>
        </tr>
        </thead>
    </table>
    <div><span>${requestScope.msg}</span></div>
</div>
<jsp:include page="common/footer.jsp" flush="true">
    <jsp:param name="needTable" value="true"/>
</jsp:include>
<script type="text/javascript">

    function changeStatusFormat(status) {
        var statusName = "";
        if (status == 0) {
            statusName = "禁用";
        } else if (status == 1) {
            statusName = "启用";
        }
        return statusName;
    }

    function myQuery() {
        $("#studentInfoTable").bootstrapTable("refresh");
    }

    function ajaxRequest(params) {
        var student = {};
        $.sendTableRequest(params, student);
    }

    function rowsOperate(value, row, index) {
        return '<a href="${pageContext.request.contextPath}/student/studentInfo/detail/' + row.stuNo + '" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i> 查看详情 </a>';
    }
</script>
