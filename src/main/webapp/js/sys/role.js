/**
 * Created by lx on 2017/2/26.
 */

var vm = new Vue({
    el : 'web2',
    data : {},
    methods : {
        updateRole : function() {
            var roleId = getSelectedRow();
            if (!roleId) {
                return;
            }
            location.href = 'role_add.html?roleId=' + roleId;
        },
        deleteRole : function() {
            var roleIds = getSelectedRows();
            if (!roleIds) {
                return;
            }
            confirm('确定要删除选中的记录吗？', function(){
                $.ajax({
                    type : 'POST',
                    url : '/sys/role/delete',
                    data : JSON.stringify(roleIds),
                    success : function(r) {
                        if (r.code == 200) {
                            alert('操作成功', function(index){
                                $('#jqGrid').trigger('reloadGrdid');
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


$(function () {
    $('#jqGrid').jqGrid({
        url : '/sys/role/list',
        datatype : 'json',
        colModel : [
            {label : '角色名称', name : 'roleName', width : 45},
            {label : '备注', name : 'remark', width : 100},
            {label : '创建时间', name : 'createTime', width : 80}
        ],
        viewrecords : true,
        height : 400,
        rowNum : 10,
        rowList : [10, 30, 50],
        rownumbers : true,
        rownumWidth : 25,
        autoWidth : true,
        multiselect : true,
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
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});