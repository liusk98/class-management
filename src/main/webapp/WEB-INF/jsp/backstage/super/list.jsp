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
    <table class="table table-hover">
        <thead>
        <tr>
            <th>教师编号</th>
            <th>教师名称</th>
            <th>登录名称</th>
            <th>创建时间</th>
            <th>上次登录时间</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.listTeacherInfo}" var="teacherInfo">
            <tr id="tableTr${teacherInfo.id}">
                <td>${teacherInfo.id}</td>
                <td>${teacherInfo.name}</td>
                <td>${teacherInfo.loginName}</td>
                <td><fmt:formatDate value="${teacherInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td><fmt:formatDate value="${teacherInfo.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td>${teacherInfo.remark}</td>
                <td><button class="btn btn-primary">操作</button><button onclick="deleteById(${teacherInfo.id})" class="btn btn-warning">开除</button></td>
            </tr>
        </c:forEach>
        </tbody>
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