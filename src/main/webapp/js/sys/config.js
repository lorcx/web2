/**
 * Created by Administrator on 2017/2/13 0013.
 */

var vm = new Vue({
    el : '#web2',
    data : {},
    methods : {
        updateConfig : function () {
            var configId = getSelectedRow();
            if (!configId) {
                return;
            }
            location.href = 'config_add.html?configId=' + configId;
        },
        deleteConfig : function () {
            var configId = getSelectedRows();
            if (!configId) {
                return;
            }
            confirm('确定要删除选中的记录吗？', function() {
                $.ajax({
                    type : 'POST',
                    url : '/sys/config/delete',
                    data : JSON.stringify(configId),
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
        url : '/sys/config/list',
        datatype : 'json',
        caption : '用户信息',
        //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
        colModel : [
            {label : '参数名', name : 'key', width : 100},
            {label : '参数值', name : 'value', width : 100},
            {label : '备注', name : 'remark', width : 240}
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

