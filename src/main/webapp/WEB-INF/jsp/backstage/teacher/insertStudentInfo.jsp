<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/7/31
  Time: 下午3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="${title}学生"/>
</jsp:include>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>${title}学生信息</h2>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
                <form action="${pageContext.request.contextPath}/backstage/studentInfo/<c:if test="${isEdit}">updateStudentInfo.do</c:if><c:if test="${not isEdit}">insertStudentInfo.do</c:if>" method="post" id="demo-form2"
                      data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="studentName">学生姓名<span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="studentName" name="name" required="required"
                                   value="${studentInfo.name}"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="card">身份证号<span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="card" name="idCard" required="required"
                                   value="${studentInfo.idCard}"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="grade">所属班级<span
                                class="required">*</span>
                        </label>
                        <div class="col-md-3 col-sm-3 col-xs-6">
                            <select id="grade" class="form-control">
                                <option>--请选择年级--</option>
                                <c:forEach items="${listGrade}" var="grade">
                                    <option value="${grade.valueId}"
                                    <c:if test="${isEdit}">
                                        <c:if test="">selected</c:if>
                                    </c:if>
                                    >${grade.valueName}</option>
                                </c:forEach>
                            </select>
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-6">
                                <select name="classID" class="form-control">
                                    <option value="0">--请选择班级--</option>
                                </select>
                            </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-xs-12">备注</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <textarea name="remark" class="form-control col-xs-5">${studentInfo.remark}</textarea>
                        </div>
                    </div>
                    <div class="ln_solid"></div>
                    <c:if test="${isEdit}">
                        <input type="hidden" name="id" value="${studentInfo.stuNo}">
                    </c:if>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <button type="submit" class="btn btn-primary">${title}</button>
                            <button type="reset" class="btn btn-success">重置</button>
                        </div>
                    </div>
                </form>
                <span class="message">${msg}</span>
            </div>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>
<script type="text/javascript">
    $(function () {
        var grade = $("#grade");
        $(grade).change(function () {
            var gradeId = grade.val();
            listClassInfo(gradeId);
        });
    });
    function listClassInfo(gradeId) {
        $.ajax({
            url:"${pageContext.request.contextPath}/backstage/classInfo/listClassInfo.json",
            data:{gradeId:gradeId},
            dataType:"json",
            success:function (result) {
                $(":input[name=classID]").html("<option value='0'>--请选择班级--</option>");
                $.each(result, function (index, item) {
                    var value = "<option value='" + item.id + "'>" + item.name + "</option>";
                    $(":input[name=classID]").append(value);
                });
            }
        })
    }
</script>
