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
<div class="x_content">
    <div class="col-md-3 col-sm-3 col-xs-12 profile_left">
        <div class="profile_img">
            <div id="crop-avatar">
                <!-- 头像 -->
               <%-- <img class="img-responsive avatar-view" src="" alt="Avatar" title="Change the avatar"> --%>
            </div>
        </div>
        <h3>${sessionScope.student.name}</h3>

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

        <a class="btn btn-success" href="${pageContext.request.contextPath}/student/studentInfo/edit.html"><i class="fa fa-edit m-right-xs"></i>Edit Profile</a>
        <br>
        <!-- start skills -->
        <!-- end of skills -->
    </div>
</div>
<%@include file="common/footer.jsp" %>
