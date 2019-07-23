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
    <jsp:param name="needSwitch" value="true"/>
</jsp:include>
<div class="x_content">
    <table id="dataDictionaryTable" class="table table-bordered table-striped table-hover"
           data-toggle="table"
           data-height="460"
           data-pagination="true"
           data-side-pagination="server"
           data-sort-name="valueId"
           data-sort-order="asc"
           data-loadsuccess="test"
           data-page-list="[5,10,25,50,100,200,All]"
           data-url="${pageContext.request.contextPath}/backstage/dataDictionary/dataDictionaryList.json">
        <thead>
        <tr>
            <th data-field="typeCode" data-sortable="true">类型编码</th>
            <th data-field="typeName" data-sortable="true">类型名称</th>
            <th data-field="valueId" data-sortable="true">类型的值</th>
            <th data-field="valueName" data-sortable="true">数据值名称</th>
            <th data-field="createUser" data-sortable="true">创建人ID</th>
            <th data-field="createTime" data-sortable="true">创建时间</th>
            <th data-field="isenable" data-formatter="changeStatusFormat">启用状态</th>
            <th data-field="remark" data-formatter="rowsOperate">操作</th>
        </tr>
        </thead>
    </table>
    <div><span>${requestScope.msg}</span></div>
</div>
<jsp:include page="../../common/footer.jsp" flush="true">
    <jsp:param name="needTable" value="true"/>
    <jsp:param name="needSwitch" value="true"/>
</jsp:include>
<script type="text/javascript">
    // 存取当前的开关，以便ajax返回后可抓取
    var currentSwitch;

    $(function () {
        $('#dataDictionaryTable').on('load-success.bs.table', function () {
            $("[name=chkStatus]").bootstrapSwitch({
                onText: "启用",        //设置on文本
                offText: "禁用",       //设置off文本
                onColor: "primary",   //设置on文本颜色
                offColor: "danger",   //设置off文本颜色
                size: "mini",        //设置控件大小，从小到大
                //当开关状态改变时触发
                onSwitchChange: function (event, state) {
                    var typeCode = $(this).parents("tr").children("td:eq(0)").text();
                    var valueId = $(this).parents("tr").children("td:eq(2)").text();
                    currentSwitch = $(this);
                    $.ajax({
                        url: "${pageContext.request.contextPath}/backstage/dataDictionary/changeEnableDataDictionary",
                        data: {"typeCode": typeCode, "valueId" : valueId, enable : state},
                        type: "POST",
                        dataType: "text",
                        success: function (data) {
                            if (data == "true") {

                            } else {
                                currentSwitch.bootstrapSwitch("state", !state, true);
                            }
                        }
                    })
                }
            })
        })
    })

    //状态转换
    function changeStatusFormat(status, row, index) {
        var statusName = "";
        if (status == 0) {
            statusName = "<input id='create-switch" + index + "' type='checkbox' name='chkStatus'>";
        } else if (status == 1) {
            statusName = "<input id='create-switch" + index + "' type='checkbox' name='chkStatus' checked>";
        }
        return statusName;
    }

    //操作列
    function rowsOperate(value, row, index) {
        return '<a href="${pageContext.request.contextPath}/backstage/dataDictionary/updateDataDictionary/'+row.typeCode+'/'+row.valueId+'" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i> View </a>';
    }
</script>