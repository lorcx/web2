/*****公共js*****/
/**
 * 异步提交
 * 使用方法 ：$("#login_form").asyncSubmit();
 */
$.fn.asyncSubmit = function (options){
    var url = $(this).attr('action');
    var defaultOptions = {
        url : url,
        type : 'POST',
        beforeSubmit : beforeSubmit,
        success : successDispose,
        dataType : 'json'
    };
    $.extend(defaultOptions,options);
    $(this).ajaxSubmit(defaultOptions);
};

/**
 * 表单提交前
 */
function beforeSubmit(){
    show_loading();
}

/**
 * 成功处理
 * dispose：处理
 */
function successDispose(options){
    console.log(options);
}
