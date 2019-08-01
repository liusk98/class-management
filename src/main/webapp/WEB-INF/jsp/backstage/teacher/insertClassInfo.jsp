<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/7/29
  Time: 下午4:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="${title}班级"/>
    <jsp:param name="needSwitch" value="true"/>
</jsp:include>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>${title}班级信息</h2>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
                <form action="${pageContext.request.contextPath}/backstage/classInfo/<c:if test="${isEdit}">updateClassInfo.do</c:if><c:if test="${not isEdit}">insertClassInfo.do</c:if>" method="post" id="demo-form2"
                      data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">班级名称<span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="first-name" name="name" required="required"
                                   value="${classInfo.name}"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">所属年级<span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select id="last-name" name="gradeID" class="form-control col-xs-5">
                                <option>--请选择年级--</option>
                                <c:forEach items="${listGrade}" var="grade">
                                    <option value="${grade.valueId}" <c:if test="${classInfo.gradeID == grade.valueId}">selected</c:if>>${grade.valueName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-xs-12">备注</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <textarea name="remark" class="form-control col-xs-5">${classInfo.remark}</textarea>
                        </div>
                    </div>
                    <div class="ln_solid"></div>
                    <c:if test="${isEdit}">
                        <input type="hidden" name="id" value="${classInfo.id}">
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
<jsp:include page="../common/footer.jsp" flush="true">
    <jsp:param name="needSwitch" value="true"/>
</jsp:include>
<script type="text/javascript">
    $(function () {
        $("#chkIsEnable").bootstrapSwitch({
            onText: "启用",        //设置on文本
            offText: "禁用",       //设置off文本
            onColor: "primary",   //设置on文本颜色
            offColor: "danger",   //设置off文本颜色
            size: "small",        //设置控件大小，从小到大
            handleWidth: "35",    //设置控件宽度
            //当开关状态改变时触发
            onSwitchChange: function (event, state) {
                var ProductId = event.target.defaultValue;
                if (state == true) {
                    $("#isenable").val(1);
                } else {
                    $("#isenable").val(0);
                }
            }
        })
    })
</script>
