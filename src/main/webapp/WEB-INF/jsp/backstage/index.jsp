<%--
  Created by IntelliJ IDEA.
  User: Joe
  Date: 2019/7/11
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="首页"/>
</jsp:include>
${sessionScope.teacher.name}
<%@include file="../common/footer.jsp"%>
