/*****公共js*****/

/**
 * 异步提交 ajaxForm
 * 使用方法 ：	$("#login_form").attr('action','/login!login.action');
 *              $("#login_form").asyncSubmit(loginProcess);
 * 如果使用ajaxSubmit则需要return false
 */
$.fn.asyncSubmit = function (options,_handle){
    var defaultOptions = {
        url : $(this).attr('action'),
        type : 'post',
        beforeSubmit : function (formData, jqForm, options){
            show_loading();
        },
        dataType : 'json',
        contentId : 'content',
        success : function (responseText, statusText, options) {
            if (statusText == 'success') {
                if ($.isFunction(_handle)){
                    //successDispose(responseText,_handle);
                    close_loading();
                    if(responseText.page){
                        loadPaginator(responseText.page);
                    }
                    _handle(responseText);
                }
            } else {
                alert("提交失败！");
            }
        }
    };
    $.extend(defaultOptions,options);
    $(this).ajaxForm(defaultOptions);
    $(this).submit();
    //return false;
};

/**
 * 加载分页
 */
function loadPaginator(page){
    var pageCount = page.totalPageNum;//总页数
    var currentPage = page.currentNum;//当前页
    var options = {
        currentPage: currentPage,
        totalPages: pageCount,
        size:"normal",
        bootstrapMajorVersion: 3,
        alignment:"right",
        numberOfPages:5,
        itemTexts: function (type, page, current) {
            switch (type) {
                case 'first':
                    return '首页';
                case 'prev':
                    return '上一页';
                case 'next':
                    return '下一页';
                case 'last':
                    return '末页';
                case 'page':
                    return page;
            }
        },
        //点击事件，用于通过Ajax来刷新整个list列表
        onPageClicked: function(event,originalEvent,type,page){
            $("#currentPage").val(page);
            queryForm();
        }
    }
    $('#paginator').bootstrapPaginator(options);
}

/**
 * 生成分页区域 (暂时没用)
 */
//function buildPaginator(tabId){
//    var obj = $('#pageDiv');
//    if(obj){
//       // obj.remove();
//    }
//    var pageDiv = '<div id="pageDiv" style="text-align: center;">';
//    pageDiv += '<ul id="paginator"></ul>';
//    pageDiv += '<s:hidden name="page.currentNum" id="currentPage"/>';
//    pageDiv += '</div>';
//    $('#'+tabId).after(pageDiv);
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

/**
 * 打开窗口
 */
function openWindow(url,title,width,height){
    var iWidth=width; //弹出窗口的宽度;
    var iHeight=height; //弹出窗口的高度;
    var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
    var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
    window.open(url,title,'height='+iHeight+', width='+iWidth+', top='+iTop+', left='+iLeft+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}
