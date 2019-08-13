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
                            ${pageContext.request.contextPath}/statics/images/head/${student.headImg}
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
<jsp:include page="common/footer.jsp" flush="false"></jsp:include>
<script type="text/javascript">
    function upload() {
        var formData = new FormData();
        formData.append("fileHead", $("#fileHead")[0].files[0]);
        $.ajax({
            url: "${pageContext.request.contextPath}/student/studentInfo/uploadHead",
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