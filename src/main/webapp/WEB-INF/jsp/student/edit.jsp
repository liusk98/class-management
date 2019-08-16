<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</jsp:include>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
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
                        <img width="128px" height="128px" src="
                         <c:if test="${empty student.headImg}">
                            ${pageContext.request.contextPath}/statics/images/head/goku.jpg
                         </c:if>
                         <c:if test="${not empty student.headImg}">
                            ${pageContext.request.contextPath}/${student.headImg}
                         </c:if>
                        "/>
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
</div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>资料</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form class="form-horizontal form-label-left">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">学号</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control" type="text" id="stuNo" value="${sessionScope.student.stuNo}" readonly />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">学生姓名</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control" type="text" id="name" value="${sessionScope.student.name}" readonly />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">身份证号</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control" type="text" id="idCard" value="${sessionScope.student.idCard}" readonly />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">登录名</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control" type="text" id="loginName" value="${sessionScope.student.loginName}" />
                        </div>
                        <div class="col-xs-4"><span class="help-block" id="helpBlock">只允许修改一次</span></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">所属班级</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <span>${sessionScope.student.classId.name}</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">性别</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">生日</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control" type="date" id="birthday" value="${sessionScope.student.birthday}" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">电话</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input class="form-control" type="text" id="phone" value="${sessionScope.student.phone}" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">所在地区</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="row">
                        <div class="col-md-4">
                            <select id="province" class="form-control col-md-3"></select>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control col-md-3" id="city"></select>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control col-md-3" id="area"></select>
                        </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">详细地址</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <textarea id="address" class="form-control col-xs-5">${sessionScope.student.address}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">个性签名</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <textarea id="signature" class="form-control col-xs-5">${sessionScope.student.signature}</textarea>
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
                        <label class="control-label col-md-3 col-sm-3 col-xs-12"></label>
                        <div id="divAlert" class="col-md-6 col-sm-6 col-xs-12"></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp" flush="false"></jsp:include>
<script type="text/javascript">
    function upload() {
        var formData = new FormData();
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
</script>