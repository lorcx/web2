/**
 * Created by lx on 2017/2/26.
 */

var vm = new Vue({
    el : '#web2',
    data : {},
    methods : {
        updateMenu : function() {
            var menuId = getSelectedRow();
            if (!menuId) {
                return;
            }
            location.href = 'menu_add.html?menuId=' + menuId;
        },
        deleteMenu : function() {
            var menuIds = getSelectedRows();
            if (!menuIds) {
                return;
            }
            confirm('确定要删除选中的记录吗？', function(){
                $.ajax({
                    type : 'POST',
                    url : '/sys/menu/delete',
                    data : JSON.stringify(menuIds),
                    success : function(r) {
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

$(function () {
    $('#jqGrid').jqGrid({
        url : '/sys/menu/list',
        datatype : 'json',
        caption : '角色信息',
        colModel : [
            {label : '菜单名称', name : 'menuName', width : 60},
            {label : '上级菜单', name : 'parentName', width : 60},
            {label : '菜单图标', name : 'icon', width : 50, formatter : function(value, options, row) {
                return !value ? '' : '<i class="'+value+' fa-lg"></i>';
            }},
            {label : '菜单url', name : 'url', width : 100},
            {label : '授权标识', name : 'perms', width : 100},
            {label : '类型', name : 'menuType', width : 50, formatter : function(value, options, row)  {
                switch (value) {
                    case 0 :
                        return '<span class="label label-primary">目录</span>';
                    case 1 :
                        return '<span class="label label-success">菜单</span>';
                    case 2 :
                        return '<span class="label label-warning">按钮</span>';
                }
            }},
            {label : '排序号', name : 'orderNum', width : 50}
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

    $('#jqGrid').jqGrid('navGrid', '#jqGridPager', {edit : false, add : false, del : false});
});