/*****公共js*****/

/**
 * 异步提交 ajaxForm
 * 使用方法 ：	$("#login_form").attr('action','/login!login.action');
 *              $("#login_form").asyncSubmit(loginProcess);
 * 如果使用ajaxSubmit则需要return false
 */
$.fn.asyncSubmit = function (_handle){
    var url = $(this).attr('action');
    var defaultOptions = {
        url : url,
        type : 'post',
        beforeSubmit : beforeSubmit,
        dataType : 'json',
        success : function (responseText, statusText, options) {
            if (statusText == 'success') {
                if ($.isFunction(_handle))
                    _handle(responseText);
            } else {
                alert("提交失败！");
            }
        }
    };
    //$.extend(defaultOptions,options);
    $(this).ajaxForm(defaultOptions);
    $(this).submit();
    //return false;
};

/**
 * 表单提交前
 * formData : 表单提交数据  name :''
 *  jqForm : jquery对象
 * options : 表单提交参数
 */
function beforeSubmit(formData, jqForm, options){
    show_loading();

    //return true;
}

/**
 * 成功处理
 * dispose：处理
 */
//function successDispose(responseText, statusText, options){
//
//    if(statusText == 'success'){
//      options.success(responseText);
//    }
//}

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


