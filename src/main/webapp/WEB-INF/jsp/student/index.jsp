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
    <div class="col-md-6 col-sm-6 col-xs-12 profile_left">
        <div class="profile_img">
            <div id="crop-avatar">
                <!-- 头像 -->
                <img class="img-responsive avatar-view" width="250" height="140" src="
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
            <!-- 地址 -->
            <li>
                <i class="fa fa-map-marker user-profile-icon"></i>
                ${student.provinceName}&nbsp;${student.cityName}&nbsp;${student.areaName}
            </li>

            <!-- 年级 班级 -->
            <li>
                <i class="fa fa-briefcase user-profile-icon"></i>
                ${student.classId.gradeName}&nbsp;${student.classId.name}
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
    <div class="col-md-6 col-sm-6 col-xs-12">
        <div class="x_panel">
            <div class="x_content">
                <div class="" role="tabpanel" data-example-id="togglable-tabs">
                    <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Home</a>
                        </li>
                        <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">Profile</a>
                        </li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
                            <ul id="ulLog" class="list-unstyled timeline">

                            </ul>
                            <a id="aMore" href="javascript:loadLog()">更多...</a>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
                            <p>${student.signature}</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp" %>
<script type="text/javascript">
    let queryTime;

    /**
     * 创建新的日期节点
     * @param date
     * @returns {string}
     */
    function createNewDate(date) {
        let li = $("<li d='" + date + "'><div class='block'><div class='tags'><a href='' class='tag'>" + date + "</a></div></div></li>");
        $("#ulLog").append(li);
        return li;
    }

    /**
     * 为时间线增加一条数据
     * @param date 所属日期
     * @param time  操作时间
     * @param content 内容描述
     */
    function addLogContent(date, time, content) {
        // 找到对应的日期节点
        let li = $("#ulLog").children("li[d='" + date + "']");
        // 日期还不存在
        if (li.length == 0) {
            li = createNewDate(date);
        }
        var div = $(li.children()[0]);
        div.append($("<div class='block_content'><div class='byline'><span>" + time + "</span></div><p class='excerpt'>" + content + "</p></div>"))
    }
    function loadLog() {
        $.getJSON("${pageContext.request.contextPath}/operate/query", "createTime="+queryTime+"&stuNo="+${student.stuNo}, function (data) {
            if (data.length > 0) {
                $(data).each(function (index, item) {
                    let dateTemp = item.createTime.split(" ")[0];
                    let timeTemp = item.createTime.split(" ")[1];
                    addLogContent(dateTemp, timeTemp, item.logDesc);
                    queryTime = item.createTime;
                });
                if (data.length < 10) {
                    $("#aMore").hide();
                }
            }
        });
    }

    $(function () {
        let day2 = new Date();
        queryTime = day2.getFullYear()+"-"+(day2.getMonth() + 1)+"-"+day2.getDate()+" "+day2.getHours()+":"+day2.getMinutes()+":"+day2.getSeconds();
        loadLog();
    })
</script>
