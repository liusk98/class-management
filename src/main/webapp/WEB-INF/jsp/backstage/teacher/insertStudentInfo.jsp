<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/7/31
  Time: 下午3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../common/header.jsp" flush="true">
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
<%@include file="../../common/footer.jsp" %>
