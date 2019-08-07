<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joe
  Date: 2019/7/31
  Time: 下午3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/header.jsp" flush="true">
    <jsp:param name="pageTitle" value="学生列表"/>
    <jsp:param name="needTable" value="true"/>
</jsp:include>
<div class="x_content">
    <div class="row">
        <form class="form-inline">
            <div class="form-group">
                <label for="grade">年级</label>
                <select id="grade" class="form-control">
                    <option value="0">--全部年级--</option>
                </select>
            </div>
            <div class="form-group">
                <label for="classID">班级</label>
                <select id="classID" class="form-control">
                    <option value="0">--全部班级--</option>
                </select>
            </div>
            <div class="form-group">
                <label for="stuNo">学号</label>
                <input class="form-control" type="text" id="stuNo"/>
            </div>
            <br/>
            <div class="form-group">
                <label for="studentName">姓名</label>
                <input class="form-control" type="text" id="studentName">
            </div>
            <div class="form-group">
                <label for="sex">性别</label>
                <select id="sex" class="form-control">
                    <option value="">所有</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <div class="form-group">
                <label for="phone">电话</label>
                <input type="text" id="phone" class="form-control"/>
            </div>
            <br/>
            <div class="form-group">
                <label for="province">省份</label>
                <select id="province" class="form-control">
                    <option>请选择省份</option>
                </select>
            </div>
            <div class="form-group">
                <label for="city">城市</label>
                <select id="city" class="form-control">
                    <option>请选择城市</option>
                </select>
            </div>
            <div class="form-group">
                <label for="area">区域</label>
                <select id="area" class="form-control">
                    <option>请选择区域</option>
                </select>
            </div>
            <div class="form-group">
                <button class="btn btn-primary" type="button" onclick="myQuery()">查询</button>
            </div>
        </form>
    </div>
    <div class="row">
        <button class="btn btn-primary" type="button" onclick="batchEnable()">启用所选</button>
        <button class="btn btn-danger" type="button" onclick="batchDisable()">禁用所选</button>
    </div>
    <table id="studentInfoTable"
           class="table table-bordered table-striped table-hover bulk-action"
           data-toggle="table"
           data-height="460"
           data-pagination="true"
           data-side-pagination="server"
           data-query-params-type=""
           data-method="post"
           data-content-type="application/x-www-form-urlencoded"
           data-ajax="ajaxRequest"
           data-sort-name="stuNo"
    <%--
               data-query-params="queryParams"
    --%>
           data-sort-order="asc"
           data-page-list="[5,10,25,50,100,200,All]"
           data-url="${pageContext.request.contextPath}/backstage/studentInfo/studentInfo.json">
        <thead>
        <tr>
            <th data-field="" data-checkbox="true"></th>
            <th data-field="stuNo" data-sortable="true" data-width="10" data-width-unit="%">学生编号</th>
            <th data-field="name" data-sortable="true">学生名称</th>
            <th data-field="classId.name" data-sort-name="className" data-sortable="true">班级名称</th>
            <th data-field="classId.gradeName" data-sort-name="gradeName" data-sortable="true">年级</th>
            <th data-field="phone">电话号码</th>
            <th data-field="createTeacher.name" data-sort-name="teacherName" data-sortable="true">创建人</th>
            <th data-field="createTime" data-sortable="true">创建时间</th>
            <th data-field="lastLoginTime" data-sortable="true">上次登录时间</th>
            <th data-field="status" data-formatter="changeStatusFormat" data-sortable="true">启用状态</th>
            <th data-formatter="rowsOperate">操作</th>
        </tr>
        </thead>
    </table>
    <div><span>${requestScope.msg}</span></div>
</div>
<jsp:include page="../common/footer.jsp" flush="true">
    <jsp:param name="needTable" value="true"/>
</jsp:include>
<script type="text/javascript">
    function batchEnable() {
        var listStuNo = $("#studentInfoTable").bootstrapTable("getSelections");
        var arrStuNo = new Array();
        $.each(listStuNo, function (index, item) {
            arrStuNo.push(item.stuNo);
        });
        $.ajax({
            url: "${pageContext.request.contextPath}/backstage/studentInfo/enable",
            data: {"arrStuNo": arrStuNo},
            type: "POST",
            dataType: "text",
            success: function (data) {
                if (data == "true") {
                    alert("成功");
                    $("#studentInfoTable").bootstrapTable("refresh");
                } else {
                    alert("失败");
                }
            }
        })
    }

    function batchDisable() {
        var listStuNo = $("#studentInfoTable").bootstrapTable("getSelections");
        var arrStuNo = new Array();
        $.each(listStuNo, function (index, item) {
            arrStuNo.push(item.stuNo);
        });
        $.ajax({
            url: "${pageContext.request.contextPath}/backstage/studentInfo/disable",
            data: {"arrStuNo": arrStuNo},
            type: "POST",
            dataType: "text",
            success: function (data) {
                if (data == "true") {
                    alert("成功");
                    $("#studentInfoTable").bootstrapTable("refresh");
                } else {
                    alert("失败");
                }
            }
        })
    }

    function changeStatusFormat(status) {
        var statusName = "";
        if (status == 0) {
            statusName = "禁用";
        } else if (status == 1) {
            statusName = "启用";
        }
        return statusName;
    }

    function myQuery() {
        $("#studentInfoTable").bootstrapTable("refresh");
    }

    function ajaxRequest(params) {
        var stuNo = $("#stuNo").val();
        var name = $("#studentName").val();
        var gradeID = $("#grade").val();
        var classID = $("#classID").val();
        var sex = $("#sex").val();
        var phone = $("#phone").val();
        var student = {
            "stuNo": stuNo,
            "name": name,
            "sex": sex,
            "phone": phone,
            "classId": {
                "id": classID,
                "gradeID": gradeID
            }
        };
        $.sendTableRequest(params, student);
    }

    function rowsOperate(value, row, index) {
        return '<a href="${pageContext.request.contextPath}/backstage/classInfo/updateClassInfo.html/' + row.id + '" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i> 修改 </a>';
    }
</script>
<jsp:include page="../common/gradeAndClass.jsp" flush="true">
    <jsp:param name="gradeSelectId" value="grade"/>
    <jsp:param name="classSelectId" value="classID"/>
    <jsp:param name="gradeID" value="0"/>
</jsp:include>
