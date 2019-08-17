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
});

(function ($) {
    $.fn.serializeJson = function () {
        var serializeObj = {};
        var array = this.serializeArray();
        var str = this.serialize();
        $(array).each(function () {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    }
})(jQuery);