<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 19-7-17
  Time: 下午5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="${title}数据字典"/>
    <jsp:param name="needSwitch" value="true"/>
</jsp:include>

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>${title}数据字典</h2>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
                <form action="${pageContext.request.contextPath}/backstage/dataDictionary/<c:if test="${isEdit}">updateDataDictionary</c:if><c:if test="${not isEdit}">insertDataDictionary.do</c:if>" method="post" id="demo-form2"
                      data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">TYPE_CODE<span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="first-name" name="typeCode" required="required"
                            <c:if test="${isEdit}">readonly</c:if>
                                    value="${dataDictionary.typeCode}"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">TYPE_NAEM<span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="last-name" name="typeName" required="required" value="${dataDictionary.typeName}"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">VALUE_ID<span
                            class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="middle-name" class="form-control col-md-7 col-xs-12" required="required" type="text" name="valueId"
                            <c:if test="${isEdit}">readonly</c:if>
                                    value="${dataDictionary.valueId}"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">VALUE_NAME<span
                                class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="fourth-name" class="form-control col-md-7 col-xs-12" type="text"
                                   name="valueName" value="${dataDictionary.valueName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">是否启用<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="switch">
                                <input id="chkIsEnable" type="checkbox" <c:if test="${dataDictionary.isenable==1 or (not isEdit)}">checked</c:if>/>
                                <input id="isenable" type="hidden" value="<c:choose>
                                <c:when test="${dataDictionary.isenable==1 or (not isEdit)}">1</c:when>
                                <c:otherwise>0</c:otherwise>
                                </c:choose>" name="isenable"/>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="createUser" value="${teacher.id}"/>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-xs-12">备注</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <textarea name="remark" class="form-control col-xs-5">${dataDictionary.remark}</textarea>
                        </div>
                    </div>
                    <div class="ln_solid"></div>
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

<jsp:include page="../../common/footer.jsp" flush="true">
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