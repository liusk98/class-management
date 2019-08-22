<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/8/14
  Time: 下午2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="学生列表"/>
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
           data-url="${pageContext.request.contextPath}/backstage/studentInfo/studentInfo.json">
        <thead>
        <tr>
            <th data-field="" data-checkbox="true"></th>
            <th data-formatter="rowNumber">序号</th>
            <th data-field="stuNo" data-sortable="true" data-width="10" data-width-unit="%">学生编号</th>
            <th data-field="name" data-sortable="true">学生名称</th>
            <th data-field="" data-sortable="true" data-formatter="headImg">待审核头像</th>
            <th data-formatter="rowsOperate">操作</th>
        </tr>
        </thead>
    </table>
    <div><span>${requestScope.msg}</span></div>
</div>
<jsp:include page="../common/footer.jsp" flush="true">
    <jsp:param name="needTable" value="true"/>
</jsp:include>
<script type="text/javascript">
    function headImg(value, row, index) {
        return "<img height='110px' width='110px' src='${pageContext.request.contextPath}/" + row.headTemp + "' />";
    }

    function rowNumber(value, row, index) {
        let options = $('#studentInfoTable').bootstrapTable('getOptions');
        return options.pageSize * (options.pageNumber - 1) + index + 1;
    }

    function rowsOperate(value, row, index) {
        let permit = "<button class='btn btn-primary btn-xs' onclick='audit(" + row.stuNo + ",1)'><i class='glyphicon glyphicon-ok'></i> 通过</button>";
        let ban = "<button class='btn btn-danger btn-xs' onclick='audit(" + row.stuNo + ",2)'><i class='glyphicon glyphicon-remove'></i>禁止</button>";
        return permit + ban;
    }

    function audit(stuNo, result) {
        $.ajax({
            url: "${pageContext.request.contextPath}/backstage/studentInfo/audit",
            data: {
                stuNo: stuNo,
                result: result
            },
            type: "GET",
            dataType: "text",
            success: function (data) {
                alert(data);
                myQuery();
            }
        })
    }

    function myQuery() {
        $("#studentInfoTable").bootstrapTable("refresh");
    }

    function ajaxRequest(params) {
        let student = {isHeadPass: 0};
        $.sendTableRequest(params, student);
    }
</script>
