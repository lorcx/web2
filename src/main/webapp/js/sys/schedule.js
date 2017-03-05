/**
 * Created by Administrator on 2017/2/13 0013.
 */

var vm = new Vue({
    el : '#web2',
    data : {},
    methods : {
        updateSchedule : function () {
            var scheduleId = getSelectedRow();
            if (!scheduleId) {
                return;
            }
            location.href = 'schedule_add.html?scheduleId=' + scheduleId;
        },
        deleteSchedule : function () {
            var scheduleId = getSelectedRows();
            if (!scheduleId) {
                return;
            }
            console.log(JSON.stringify(scheduleId));
            confirm('确定要删除选中的记录吗？', function() {
                $.ajax({
                    type : 'POST',
                    url : '/sys/schedule/delete',
                    data : JSON.stringify(scheduleId),
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
        },
        pause : function () {
            var scheduleId = getSelectedRow();
            if (!scheduleId) {
                return null;
            }

            confirm('确定要暂停选中的记录吗？', function() {
                $.ajax({
                    type : 'POST',
                    url : '/sys/schedule/pause',
                    data : JSON.stringify(scheduleId),
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
        },
        resume : function () {
            var scheduleId = getSelectedRow();
            if (!scheduleId) {
                return null;
            }

            confirm('确定要恢复选中的记录吗？', function() {
                $.ajax({
                    type : 'POST',
                    url : '/sys/schedule/pause',
                    data : JSON.stringify(scheduleId),
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
        },
        runOnce : function () {
            var scheduleId = getSelectedRow();
            if (!scheduleId) {
                return null;
            }

            confirm('确定要立即执行选中的记录吗？', function() {
                $.ajax({
                    type : 'POST',
                    url : '/sys/schedule/run',
                    data : JSON.stringify(scheduleId),
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
        url : '/sys/schedule/list',
        datatype : 'json',
        caption : '用户信息',
        //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
        colModel : [
            {label : 'bean名称', name : 'beanName', width : 100},
            {label : '方法名称', name : 'methodName', width : 100},
            {label : '参数', name : 'params', width : 100},
            {label : 'cron表达式', name : 'cronExpression', width : 100},
            {label : '备注', name : 'remark', width : 100},
            {label : '状态',  name : 'status', width :60, formatter : function (value, options, row) {
                return value == 0 ?
                    '<span class="label label-success">正常</span>' :
                    '<span class="label label-danger">暂停</span>';
            }}
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

