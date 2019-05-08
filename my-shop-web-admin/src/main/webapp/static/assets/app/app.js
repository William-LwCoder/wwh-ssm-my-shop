var App = function () {

    var _masterCheckbox;
    var _checkbox;

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

    return {
        init: function () {
            handlerInitICheck();
            handlerCheckboxAll();
        },

        getCheckbox: function () {
            return _checkbox;
        }
    }
}();

$(document).ready(function () {
    App.init();
});