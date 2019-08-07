$.extend({

    /**
     * 发送表格查询的请求
     * @param params bootstrap-table 基本参数
     * @param entity 查询条件
     */
    "sendTableRequest": function (params, entity) {
        params.data.data = entity;
        $.ajax({
            url: params.url,
            data: JSON.stringify(params.data),
            type: params.type,
            contentType: "application/json",
            dataType: "json",
            success: function (data) {
                params.success(data);
            }
        })
    }
})