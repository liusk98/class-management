<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/7/29
  Time: 下午4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="班级列表"/>
    <jsp:param name="needTable" value="true"/>
</jsp:include>
<div class="x_content">
    <div class="row">
        <div class="col-md-3 col-sm-3 col-xs-5">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon-grade">年级:</span>
                <select id="grade" class="form-control" aria-describedby="basic-addon-grade">
                    <option value="0">--年级--</option>
                </select>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 col-xs-5">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon-classname">班级名称:</span>
                <input id="className" class="form-control" aria-describedby="basic-addon-classname"/>
            </div>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-3">
            <div class="input-group">
                <button class="btn btn-default" onclick="myQuery()" type="button">查询</button>
            </div>
        </div>
    </div>
    <div class="row">

    </div>
    <table id="classInfoTable" class="table table-bordered table-striped table-hover"
           data-toggle="table"
           data-height="460"
           data-pagination="true"
           data-side-pagination="server"
           data-sort-name="id"
           data-query-params="queryParams"
           data-sort-order="asc"
           data-page-list="[5,10,25,50,100,200,All]"
           data-url="${pageContext.request.contextPath}/backstage/classInfo/classInfo.json">
        <thead>
        <tr>
            <th data-field="id" data-sortable="true" data-width="10" data-width-unit="%">班级编号</th>
            <th data-field="name" data-sortable="true">班级名称</th>
            <th data-field="gradeName" data-sortable="true">年级</th>
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
        $("#classInfoTable").bootstrapTable("refresh");
    }

    function queryParams(params) {
        params.gradeID = $("#grade").val();
        params.name = $("#className").val();
        return params;
    }

    function rowsOperate(value, row, index) {
        return '<a href="${pageContext.request.contextPath}/backstage/classInfo/updateClassInfo.html/' + row.id + '" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i> 修改 </a>';
    }
</script>
<jsp:include page="../common/gradeAndClass.jsp" flush="true">
    <jsp:param name="gradeSelectId" value="grade"/>
</jsp:include>
