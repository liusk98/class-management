<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 19-7-15
  Time: 上午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../../common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="教师列表"/>
</jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap-table.min.css">
<div class="x_content">
    <table id="teacherTable" class="table table-bordered table-striped table-hover"
            data-toggle="table"
            data-height="460"
            data-pagination="true"
            data-side-pagination="server"
            data-sort-name="id"
            data-sort-order="asc"
            data-page-list="[5,10,25,50,100,200,All]"
            data-url="${pageContext.request.contextPath}/teacherinfo/teacherList.json">
        <thead>
        <tr>
            <th data-field="id" data-sortable="true" data-width="10" data-width-unit="%">教师编号</th>
            <th data-field="name" data-sortable="true">教师名称</th>
            <th data-field="loginName" data-sortable="true">登录名称</th>
            <th data-field="createTime" data-formatter="changeDateFormat" data-sortable="true">创建时间</th>
            <th data-field="lastLoginTime" data-formatter="changeDateFormat" data-sortable="true">上次登录时间</th>
            <th data-field="status" data-formatter="changeStatusFormat">状态</th>
            <th data-field="remark">备注</th>
            <%--<th>操作</th>--%>
        </tr>
        </thead>
    </table>
    <div><span>${requestScope.msg}</span></div>
</div>
<%@include file="../../common/footer.jsp" %>
<script type="text/javascript">
    function deleteById(id)
    {
       $.getJSON("deleteTeacherInfo.do",{id:id},function (msg) {
           alert(msg);
           var trId = '#tableTr'+id;
           $(trId).remove();
       })
    }
</script>
<script src="${pageContext.request.contextPath}/statics/js/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/locale/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript">
    //转换日期格式(时间戳转换为datetime格式)
    function changeDateFormat(cellval) {
        var dateVal = cellval + "";
        if (cellval != null) {
            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
            var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
            var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
            var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
            return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
        }
    }

    //状态转换
    function changeStatusFormat(status) {
        var statusName = "";
        if (status == 0) {
            statusName = "禁用";
        } else if (status == 1) {
            statusName = "启用";
        }
        return statusName;
    }
</script>





