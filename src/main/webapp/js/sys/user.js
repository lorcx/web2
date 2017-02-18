/**
 * Created by Administrator on 2017/2/13 0013.
 */
(function () {
    $('#jqGrid').jqGrid({
        url : '/sys/user/list',
        dataType : 'json',
        colModel : [
            {label : '用户名id', name : 'userId', width : 45, key : true},
            {label : '用户名', name : 'userName', width : 75},
            {label : '邮箱', name : 'email', width : 90},
            {label : '手机号', name : 'mobile', width : 100},
            {label : '状态', name : 'status', width : 80, formatter : function () {
                return value == 0 ?
                    '<span class="label label-danger">禁用</span>' :
                    '<span class="label label-danger">正常</span>';

            }},
            {label : '创建时间',  name : 'createTime', width :80}
        ],
        viewrecords : true,
        height : 400,
        rowNum : 10,
        rowList : [10, 30, 50],
        rownumbers : true,
        rownumWidth : 25,
        autowidth : true,
        multiselect : true,
        pager : '#jqGridPager',
        jsonReader : {
            root : 'page.list',
            page : 'page.currPage',
            total : 'page.totalPage',
            records : 'page.totalCount'
        },
        prmNames : {
            page : 'page',
            rows : 'limit',
            order : 'order'
        },
        gridComplete : function () {
            //隐藏grid底部滚动条
            $('#jqGrid').closest('.ui-jqgrid-bdiv').css({'overflow-x' : 'hidden'});
        }
    });
})();


var vm = new Vue({
    el : '#web2',
    data : {},
    method : {
        update : function (e) {
            var userId = getSelectedRow();
            if (!userId) {
                return;
            }
            location.href = 'user_add.html?userId=' + userId;
        },
        del : function (e) {
            var userId = getSelectedRow();
            if (!userId) {
                return;
            }
            confirm('确定要删除选中的记录吗？',function() {
                $.ajax({
                    type : 'POST',
                    url : '../sys/user/delete',
                    data : JSON.stringify(userId),
                    success : function (r) {
                        if (r.code == 200) {
                            alert('操作成功', function(index) {
                                $('#jqGrid').trigger('reloadGrid');
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        }
    }

});