var App = function () {

    // iCheck
    var _masterCheckbox;
    var _checkbox;

    // 用于存放 ID 的数组
    var _idArray;

    /**
     * 激活 iCheck
     */
    var handlerInitICheck = function () {
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });
    };

    /**
     * Checkbox 全选功能
     */
    var handlerCheckboxAll = function () {
        // 获取控制端 Checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck-master');

        // 获取全部 Checkbox 集合
        _checkbox = $('input[type="checkbox"].minimal');

        _masterCheckbox.on("ifClicked", function (e) {
            // 返回 true 表示未选中
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }

            // 选中状态
            else {
                _checkbox.iCheck("check");
            }
        });
    };

    /**
     * 批量删除
     * @param url
     */
    var hadnlerDeleteMulti = function (url) {
        _idArray = new Array();

        // 将选中元素的 ID 放入数组中
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });

        // 判断用户是否选择了数据项
        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择任何数据项，请至少选择一项");
        }
        else {
            $("#modal-message").html("您确定删除数据项吗？");
        }

        // 点击删除按钮时弹出模态框
        $("#modal-default").modal("show");

        // 如果用户选择了数据项则调用删除方法
        $("#btnModalOk").unbind("click").bind("click", function () {
            del();
        });

        /**
         * 当前私有函数的私有函数，删除数据
         */
        function del() {
            $("#modal-default").modal("hide");

            // 如果没有选择数据项的处理
            if (_idArray.length === 0) {
                // todo
            }
            // 删除数据
            else {
                setTimeout(function () {
                    $.ajax({
                        url: url,
                        type: "POST",
                        data: {"ids" : _idArray.toString()},
                        datatype: "JSON",
                        success: function (data) {
                            // 请求成功后，无论是成功还是失败都需要弹出模态框进行提示，所以这里需要先解绑原来的 click 事件
                            $("#btnModalOk").unbind("click");

                            // 请求成功
                            if (data.status == 200) {
                                // 刷新页面
                                $("#btnModalOk").bind("click", function () {
                                    window.location.reload();
                                });
                            }

                            // 请求失败
                            else {
                                // 确定按钮的事件改为隐藏模态框
                                $("#btnModalOk").bind("click", function () {
                                    $("#modal-default").modal("hide");
                                });
                            }

                            // 因为无论如何都需要提示信息，所以这里的模态框是必须调用的
                            $("#modal-message").html(data.message);
                            $("#modal-default").modal("show");
                        }
                    });
                }, 500);

            }
        }
    };

    /**
     * 初始化 Datatables
     * @param url
     * @param columns
     */
    var handlerInitDatatables = function (url, columns) {
        var _dataTable = $("#dataTable").DataTable({
            "paging": true,
            "info": true,
            "lengthChange": false,
            "ordering": false,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "deferRender": true,
            "ajax": {
                "url": url
            },
            "columns": columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function(settings, json) {
                handlerInitICheck();
                handlerCheckboxAll();
            }
        });

        return _dataTable;
    };

    /**
     * 显示详情
     * @param url
     */
    var handlerShowDetail = function (url) {
        // 这里是通过 ajax 请求 html 的方式将 jsp 装载进模态框中
        $.ajax({
            url: url,
            type: "get",
            dataType: "html",
            success: function (data) {
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");
            }
        });
    };

    return {
        /**
         * 初始化
         */
        init: function () {
            handlerInitICheck();
            handlerCheckboxAll();
        },

        /**
         * 批量删除
         * @param url
         */
        deleteMulti: function (url) {
            hadnlerDeleteMulti(url);
        },

        /**
         * 初始化 Datatables
         * @param url
         * @param columns
         * @returns {jQuery}
         */
        initDatatables: function (url, columns) {
            return handlerInitDatatables(url, columns)
        },

        /**
         * 显示详情
         * @param url
         */
        showDetail: function (url) {
            handlerShowDetail(url);
        }
    }
}();

$(document).ready(function () {
    App.init();
});