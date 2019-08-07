<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/8/6
  Time: 上午11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    $(function () {
        $.getJSON("${pageContext.request.contextPath}/backstage/dataDictionary/listDataDictionary.json?typeCode=GRADE", "", function (data) {
            <c:if test="${param.gradeID != 0}">
            $(data).each(function (index, item) {
                var gradeID = ${param.gradeID};
                var sel = "";
                if (gradeID == item.valueId) {
                    sel = "selected";
                }
                $("#${param.gradeSelectId}").append($("<option " + sel + ">").val(item.valueId).text(item.valueName));
            });
            </c:if>
            <c:if test="${param.gradeID == 0}">
            $(data).each(function (index, item) {
                $("#${param.gradeSelectId}").append($("<option>").val(item.valueId).text(item.valueName));
            });
            </c:if>
        });
        <c:if test="${not empty param.classSelectId}">
        $("#${param.gradeSelectId}").change(function () {
            $("#${param.classSelectId}").empty();
            $("#${param.classSelectId}").append($("<option>").val(0).text("--班级--"));
            if ($(this).val() > 0) {
                $.getJSON("${pageContext.request.contextPath}/backstage/classInfo/listClassInfo.json?gradeId=" + $(this).val(), "", function (data) {
                    $(data).each(function (index, item) {
                        $("#${param.classSelectId}").append($("<option>").val(item.id).text(item.name));
                    })
                })
            }
        })
        </c:if>
    })
</script>