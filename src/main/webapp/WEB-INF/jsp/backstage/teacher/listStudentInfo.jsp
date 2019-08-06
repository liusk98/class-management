<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/7/31
  Time: 下午3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="学生列表"/>
    <jsp:param name="needTable" value="true"/>
</jsp:include>
<div class="x_content">
    <div class="col-md-3 col-sm-3 col-xs-6">
        <select id="grade" class="form-control">
            <option value="0">--全部年级--</option>
        </select>
    </div>
    <div class="col-md-3 col-sm-3 col-xs-6">
        <select id="classID" class="form-control">
            <option value="0">--全部班级--</option>
        </select>
    </div>
    <div class="col-xs-5">
        <button class="btn btn-default" onclick="myQuery()">查询</button>
    </div>
    <table id="studentInfoTable" class="table table-bordered table-striped table-hover"
           data-toggle="table"
           data-height="460"
           data-pagination="true"
           data-side-pagination="server"
           data-sort-name="stuNo"
           data-query-params="queryParams"
           data-sort-order="asc"
           data-page-list="[5,10,25,50,100,200,All]"
           data-url="${pageContext.request.contextPath}/backstage/studentInfo/studentInfo.json">
        <thead>
        <tr>
            <th data-field="stuNo" data-sortable="true" data-width="10" data-width-unit="%">学生编号</th>
            <th data-field="loginName" data-sortable="true">登录名称</th>
            <th data-field="name" data-sortable="true">学生名称</th>
            <th data-field="sex" data-sortable="true">性别</th>
            <th data-field="classId.name" data-sort-name="className" data-sortable="true">班级名称</th>
            <th data-field="classId.gradeName" data-sort-name="gradeName" data-sortable="true">年级</th>
            <th data-field="createTeacher.name" data-sort-name="teacherName" data-sortable="true">创建人</th>
            <th data-field="createTime" data-sortable="true">创建时间</th>
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
    function myQuery() {
        $("#studentInfoTable").bootstrapTable("refresh");
    }

    function queryParams(params) {
        //params.classID = $(":input[name=classID]").val();
        //params.classId.gradeID = array;
        return params;
    }

    function rowsOperate(value, row, index) {
        return '<a href="${pageContext.request.contextPath}/backstage/classInfo/updateClassInfo.html/' + row.id + '" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i> 修改 </a>';
    }
</script>
<jsp:include page="../common/gradeAndClass.jsp" flush="true">
    <jsp:param name="gradeSelectId" value="grade"/>
    <jsp:param name="classSelectId" value="classID"/>
</jsp:include>
