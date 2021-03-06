/**
 * Created by Administrator on 2017/2/13 0013.
 */

var vm = new Vue({
    el : '#web2',
    data : {},
    methods : {
        updateUser : function () {
            var userId = getSelectedRow();
            if (!userId) {
                return;
            }
            location.href = 'user_add.html?userId=' + userId;
        },
        deleteUser : function () {
            var userId = getSelectedRows();
            if (!userId) {
                return;
            }
            console.log(JSON.stringify(userId));
            confirm('确定要删除选中的记录吗？', function() {
                $.ajax({
                    type : 'POST',
                    url : '/sys/user/delete',
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

(function () {
    $('#jqGrid').jqGrid({
        url : '/sys/user/list',
        datatype : 'json',
        caption : '用户信息',
        //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
        colModel : [
            {label : '用户名', name : 'userName', width : 75},
            {label : '昵称', name : 'userName', width : 45},
            {label : '邮箱', name : 'email', width : 90},
            {label : '手机号', name : 'phone', width : 100},
            {label : '状态', name : 'status', width : 80, formatter : function (value, option, row) {
                return value == 0 ?
                    '<span class="label label-danger">禁用</span>' :
                    '<span class="label label-success">正常</span>';

            }},
            {label : '创建时间',  name : 'creTime', width :80}
        ],
        emptyrecords: "没有查询到相关数据!",
        viewrecords : true, //是否显示行数
        height : 400,
        rowNum : 10,
        pgbuttons : true,
        shrinkToFit : true,
        rowList : [10, 30, 50], //可调整每页显示的记录数
        rownumbers : true,
        rownumWidth : 25,
        autowidth : true,
        multiselect : true, //是否支持多选
        pager : '#jqGridPager',
        jsonReader : {
            root : 'page.list', //包含实际数据的数组
            page : 'page.currPage', // 当前页
            total : 'page.totalPage', // 总页数
            records : 'page.totalCount',
            repeatitems: false
        },
        prmNames : {
            page : 'currPage',
            rows : 'pageSize',
            order : 'order'
        },
        gridComplete : function () {
            $('#jqGrid').closest('.ui-jqgrid-bdiv').css({'overflow-x' : 'hidden'});
        }
    });

    $('#jqGrid').jqGrid('navGrid', '#jqGridPager', {edit : false, add : false, del : false});
})();

