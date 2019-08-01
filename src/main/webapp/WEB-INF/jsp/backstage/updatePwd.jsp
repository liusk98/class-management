<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 19-7-17
  Time: 下午2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="更改密码"/>
</jsp:include>
<div class="x_content">
    <br>
    <form action="updatePwd.do" method="post" data-parsley-validate="" class="form-horizontal form-label-left">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="oldPwd">原密码<span
                    class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="password" id="oldPwd" name="oldPwd" required="required"
                       class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="newPwd">新密码<span
                    class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="password" id="newPwd" name="newPwd" required="required"
                       class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        <input type="hidden" name="id" value="${teacher.id}">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="rePwd">确认密码<span
                    class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="password" id="rePwd" name="rePwd" required="required"
                       class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        <div class="ln_solid"></div>
        <div class="form-group">
            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                <button type="button" class="btn btn-primary">取消</button>
                <button type="submit" onclick="submit()" class="btn btn-success">提交</button>
            </div>
        </div>
    </form>
    <div>
        <span style="color: lightblue">${msg}</span>
    </div>
</div>
<%@include file="common/footer.jsp" %>
<script type="text/javascript">
    $(function () {

    })
    function submit() {
        var newPwd = $("#newPwd").val();
        var rePwd = $("#rePwd").val();
        if (newPwd == rePwd) {
            return true;
        }
        return false;
    }
</script>