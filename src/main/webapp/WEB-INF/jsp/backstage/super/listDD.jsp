<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 19-7-17
  Time: 下午5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="数据字典列表"/>
    <jsp:param name="needTable" value="true"/>
</jsp:include>
<div class="x_content">
    <table id="teacherTable" class="table table-bordered table-striped table-hover"
            data-toggle="table"
            data-height="460"
            data-pagination="true"
            data-side-pagination="server"
            data-sort-name="ddid"
            data-sort-order="asc"
            data-page-list="[5,10,25,50,100,200,All]"
            data-url="${pageContext.request.contextPath}/teacherinfo/dataDictionaryList.json">
        <thead>
        <tr>
            <th data-field="ddid" data-sortable="true" data-width="10" data-width-unit="%">字典编号</th>
            <th data-field="typeCode" data-sortable="true">类型编码</th>
            <th data-field="typeName" data-sortable="true">类型名称</th>
            <th data-field="valueId" data-sortable="true">类型的值</th>
            <th data-field="valueName" data-sortable="true">数据值名称</th>
            <th data-field="createUser" data-sortable="true">创建人ID</th>
            <th data-field="createTime" data-formatter="changeDateFormat" data-sortable="true">创建时间</th>
            <th data-field="isenable" data-formatter="changeStatusFormat">启用状态</th>
            <th data-field="remark">备注</th>
            <%--<th>操作</th>--%>
        </tr>
        </thead>
    </table>
    <div><span>${requestScope.msg}</span></div>
</div>
<jsp:include page="../../common/footer.jsp" flush="true">
    <jsp:param name="needTable" value="true"/>
</jsp:include>
<script type="text/javascript">
    //转换日期格式(时间戳转换为datetime格式)
    function changeDateFormat(cellval) {
        var dateVal = cellval + "";
        if (cellval != null) {
            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
            var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
            var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
            var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
            return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
        }
    }

    //状态转换
    function changeStatusFormat(status) {
        var statusName = "";
        if (status == 0) {
            statusName = "禁用";
        } else if (status == 1) {
            statusName = "启用";
        }
        return statusName;
    }
</script>