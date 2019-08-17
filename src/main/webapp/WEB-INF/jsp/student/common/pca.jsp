<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/8/17
  Time: 下午6:51
  省份、城市、区域三级联动
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    let provinceCode = "${param.provinceCode}";
    let cityCode = "${param.cityCode}";
    let areaCode = "${param.areaCode}";
    $(function () {
        //加载省份列表
        $("#${param.provinceSelectID}").append($("<option>").val("0").text("--- 省份 ---"));
        $.getJSON("${pageContext.request.contextPath}/backstage/province/province.json", function (data) {
            $(data).each(function (index, item) {
                let option = $("<option>").val(item.code).text(item.name);
                if (option.val() === provinceCode) {
                    option.prop("selected", true);
                }
                $("#${param.provinceSelectID}").append(option);
            });
            $("#${param.provinceSelectID}").change();
        });
        //加载城市列表
        <c:if test="${not empty param.citySelectID}">
        $("#${param.provinceSelectID}").change(function () {
            $("#${param.citySelectID}").empty();
            $("#${param.citySelectID}").append($("<option>").val("0").text("--- 城市 ---"));
            $.getJSON("${pageContext.request.contextPath}/backstage/city/city.json", {provincecode: $(this).val()}, function (data) {
                $(data).each(function (index, item) {
                    let option = $("<option>").val(item.code).text(item.name);
                    if (option.val() === cityCode) {
                        option.prop("selected", true);
                    }
                    $("#${param.citySelectID}").append(option);
                });
                $("#${param.citySelectID}").change();
            });
        });
        </c:if>
        <c:if test="${not empty param.areaSelectID}">
        $("#${param.citySelectID}").change(function () {
            $("#${param.areaSelectID}").empty();
            $("#${param.areaSelectID}").append($("<option>").val("0").text("--- 区域 ---"));
            $.getJSON("${pageContext.request.contextPath}/backstage/area/area.json", {citycode: $(this).val() }, function (data) {
                $(data).each(function (index, item) {
                    let option = $("<option>").val(item.code).text(item.name);
                    if (option.val() === areaCode) {
                        option.prop("selected", true);
                    }
                    $("#${param.areaSelectID}").append(option);
                });
            });
        });
        </c:if>
    });
</script>
