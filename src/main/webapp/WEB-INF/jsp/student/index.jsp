<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/8/5
  Time: 下午6:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="首页"/>
</jsp:include>
${sessionScope.student.name}
<%@include file="common/footer.jsp"%>
