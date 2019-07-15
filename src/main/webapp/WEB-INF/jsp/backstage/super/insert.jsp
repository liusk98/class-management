<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 19-7-15
  Time: 上午8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="新增教师"/>
</jsp:include>
<div>
    <h1>新增教师</h1>
</div>
<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2>新增教师
                <small>增加一名教师</small>
            </h2>
            <h3 style="color: red;">${requestScope.msg}</h3>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <br>
            <form action="insert.do" method="post" data-parsley-validate="" class="form-horizontal form-label-left">
                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">姓名<span
                            class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="name" name="name" required="required"
                               class="form-control col-md-7 col-xs-12">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="loginName">登录名<span
                            class="required">*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="loginName" name="loginName" required="required"
                               class="form-control col-md-7 col-xs-12">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="remark">备注</label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <textarea class="resizable_textarea form-control" id="remark" name="remark"
                                  placeholder="Remark..."
                                  style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 54px; margin-left: 0px; margin-right: 0px; width: 739px;"></textarea>
                    </div>
                </div>
                <div class="ln_solid"></div>
                <div class="form-group">
                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button type="button" class="btn btn-primary">取消</button>
                        <button type="submit" class="btn btn-success">提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="../../common/footer.jsp" %>
