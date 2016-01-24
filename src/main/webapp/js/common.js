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
        dataType : 'json',
        handle : options.callBack
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
function successDispose(responseText, statusText, options){
    if(statusText == 'success'){
        options.handle(responseText);
    }
}

/**
 * 获取cookie
 *   用正则表达式验证 也可以
 *   var loginCookie = document.cookie.split(';')[0].split('=')[0];
 *
 *   dispose：处理
 */
function getCookie(name) {
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}


/**
 * 删除cookie
 */
function delCookie (name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if(cval)
        document.cookie= name + '='+cval+';expires='+exp.toGMTString();
}


