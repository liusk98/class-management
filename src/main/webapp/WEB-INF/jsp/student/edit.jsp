<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/8/13
  Time: 上午9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="编辑信息"/>
    <jsp:param name="needSwitch" value="true"/>
</jsp:include>
<div class="row">
    <div class="col-md-4 col-sm-4 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>头像</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content" style="display: block;">
                <form id="formHead">
                    <div class="form-group">
                        <label>当前头像</label>
                        <br/>
                        <img class="img-responsive avatar-view" src="
                        <c:choose>
                            <c:when test="${not empty sessionScope.student.headImg and sessionScope.student.isHeadPass == 1}">
                                ${pageContext.request.contextPath}/${sessionScope.student.headImg}
                            </c:when>
                            <c:when test="${sessionScope.student.isHeadPass == 0 and not empty sessionScope.student.headTemp}">
                                ${pageContext.request.contextPath}/${sessionScope.student.headTemp}
                            </c:when>
                            <c:otherwise>
                                ${pageContext.request.contextPath}/statics/images/head/goku.jpg
                            </c:otherwise>
                        </c:choose>"
                        alt="${sessionScope.student.name}" title="${sessionScope.student.name}"/>
                        <c:if test="${sessionScope.student.stuNo == sessionScope.student.stuNo and not empty sessionScope.student.isHeadPass and sessionScope.student.isHeadPass == 0}">
                            <div style="color: red">
                                待审核
                            </div>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="fileHead">上传新头像</label>
                        <input type="file" id="fileHead"/>
                        <p class="help-block">最佳尺寸: 128px*128px</p>
                    </div>
                    <button type="button" onclick="upload()" class="btn btn-default">上传头像</button>
                </form>
            </div>
        </div>
    </div>
    <div class="col-md-8 col-sm-8 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>资料</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form class="form-horizontal form-label-left" id="studentInfo">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="stuNo">学号</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control" type="text" id="stuNo" name="stuNo"
                                   value="${sessionScope.student.stuNo}" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">学生姓名</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control" type="text" id="name" name="name"
                                   value="${sessionScope.student.name}" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="idCard">身份证号</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control" type="text" id="idCard" name="idCard"
                                   value="${sessionScope.student.idCard}" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="loginName">登录名</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control" type="text" id="loginName" name="loginName"
                                   <c:if test="${sessionScope.student.stuNo != sessionScope.student.loginName}">readonly </c:if>
                                   value="${sessionScope.student.loginName}"/>
                        </div>
                        <div class="col-xs-4"><span class="help-block" id="helpBlock">只允许修改一次</span></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">所属班级</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <label class="control-label">${sessionScope.student.classId.name}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="chkIsEnable">性别</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <div class="switch">
                                <input id="chkIsEnable" type="checkbox"
                                       <c:if test="${sessionScope.student.sex == '男'}">checked</c:if> />
                                <input id="sex" type="hidden" name="sex" value="
                                    <c:choose>
                                        <c:when test="${sessionScope.student.sex == '男'}">男</c:when>
                                        <c:when test="${sessionScope.student.sex == '女'}">女</c:when>
                                        <c:otherwise> </c:otherwise>
                                    </c:choose>"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="birthday">生日</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control date-picker" type="date" name="birthday" id="birthday"
                                   value="<fmt:formatDate value="${sessionScope.student.birthday}" pattern="yyyy-MM-dd"/>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">电话</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control" type="text" id="phone" name="phone"
                                   value="${sessionScope.student.phone}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="province">所在地区</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="row">
                                <div class="col-md-4">
                                    <select class="form-control col-md-3" id="province" name="provinceCode"></select>
                                </div>
                                <div class="col-md-4">
                                    <select class="form-control col-md-3" id="city" name="cityCode"></select>
                                </div>
                                <div class="col-md-4">
                                    <select class="form-control col-md-3" id="area" name="areaCode"></select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">详细地址</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <textarea id="address" name="address"
                                      class="form-control col-xs-5">${sessionScope.student.address}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="signature">个性签名</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <textarea id="signature" name="signature"
                                      class="form-control col-xs-5">${sessionScope.student.signature}</textarea>
                        </div>
                    </div>
                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <button type="button" class="btn btn-success" onclick="save()">保存</button>
                            <button type="button" class="btn btn-default">Cancel</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="divAlert"></label>
                        <div id="divAlert" class="col-md-6 col-sm-6 col-xs-12"></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp">
    <jsp:param name="needSwitch" value="true"/>
</jsp:include>
<script type="text/javascript">
    $(function () {
        $("#chkIsEnable").bootstrapSwitch({
            onText: "男",        //设置on文本
            offText: "女",       //设置off文本
            onColor: "primary",   //设置on文本颜色
            offColor: "success",   //设置off文本颜色
            size: "small",        //设置控件大小，从小到大
            handleWidth: "25",    //设置控件宽度
            //当开关状态改变时触发
            onSwitchChange: function (event, state) {
                if (state === true) {
                    $("#sex").val("男");
                } else {
                    $("#sex").val("女");
                }
            }
        })
    });

    function upload() {
        let formData = new FormData();
        formData.append("fileHead", $("#fileHead")[0].files[0]);
        $.ajax({
            url: "${pageContext.request.contextPath}/student/studentInfo/upload/head",
            type: "POST",
            data: formData,
            contentType: false,
            processData: false,
            success: function (res) {
                alert(res);
            }
        })
    }

    function save() {
        $.ajax({
            url: '${pageContext.request.contextPath}/student/studentInfo/edit.do',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify($("#studentInfo").serializeJson()),
            success: function (data) {
                alert(data);
            }
        })
    }
</script>
<jsp:include page="../backstage/common/pca.jsp">
    <jsp:param name="provinceSelectID" value="province"/>
    <jsp:param name="citySelectID" value="city"/>
    <jsp:param name="areaSelectID" value="area"/>
    <jsp:param name="provinceCode" value="${sessionScope.student.provinceCode}"/>
    <jsp:param name="cityCode" value="${sessionScope.student.cityCode}"/>
    <jsp:param name="areaCode" value="${sessionScope.student.areaCode}"/>
</jsp:include>
