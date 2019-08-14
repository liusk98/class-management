<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/8/5
  Time: 下午6:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="首页"/>
</jsp:include>
<div class="x_content">
    <div class="col-md-3 col-sm-3 col-xs-12 profile_left">
        <div class="profile_img">
            <div id="crop-avatar">
                <!-- 头像 -->
                <img class="img-responsive avatar-view" src="
                <c:if test="${sessionScope.student.stuNo == student.stuNo}">
                    <c:choose>
                        <c:when test="${student.isHeadPass == 0}">${pageContext.request.contextPath}/${student.headTemp}</c:when>
                        <c:when test="${student.isHeadPass == 1 or student.isHeadPass == 2 and not empty student.headImg}">${pageContext.request.contextPath}/${student.headImg}</c:when>
                        <c:otherwise>${pageContext.request.contextPath}/statics/images/head/goku.jpg</c:otherwise>
                    </c:choose>
                </c:if>
                <c:if test="${sessionScope.student.stuNo != student.stuNo}">
                    <c:choose>
                        <c:when test="${student.isHeadPass == 1}">${pageContext.request.contextPath}/${student.headImg}</c:when>
                        <c:when test="${student.isHeadPass == 2 or student.isHeadPass == 0 and not empty student.headImg}">${pageContext.request.contextPath}/${student.headImg}</c:when>
                        <c:otherwise>${pageContext.request.contextPath}/statics/images/head/goku.jpg</c:otherwise>
                    </c:choose>
                </c:if>
                    " alt="${student.name}" title="${student.name}">
                <c:if test="${sessionScope.student.stuNo == student.stuNo and not empty student.isHeadPass and student.isHeadPass == 0}">
                <div style="color: red">
                    待审核
                </div>
                </c:if>
            </div>
        </div>
        <h3>${student.name}</h3>

        <ul class="list-unstyled user_data">
            <li><i class="fa fa-map-marker user-profile-icon"></i> San Francisco, California, USA
            </li>

            <li>
                <i class="fa fa-briefcase user-profile-icon"></i> Software Engineer
            </li>

            <li class="m-top-xs">
                <i class="fa fa-external-link user-profile-icon"></i>
                <a href="http://www.liushaokang.cn/" target="_blank">www.kimlabs.com</a>
            </li>
        </ul>
        <c:if test="${sessionScope.student.stuNo == student.stuNo}">
        <a class="btn btn-success" href="${pageContext.request.contextPath}/student/studentInfo/edit.html"><i
                class="fa fa-edit m-right-xs"></i>Edit Profile</a>
        </c:if>
        <br>
        <!-- start skills -->
        <!-- end of skills -->
    </div>
</div>
<%@include file="common/footer.jsp" %>
