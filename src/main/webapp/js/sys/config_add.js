/**
 * Created by lx on 2017/2/23 0023.
 */
var configId = T.p("configId");

var vm = new Vue({
    el : '#web2',
    data : {
        title : '新增参数',
        config : {}
    },
    created : function () {
        if (null != configId) {
            this.title = "修改参数",
                this.getInfo(configId);
        }
    },
    methods : {
        getInfo : function(configId) {
            $.get('/sys/config/info/' + configId, function(r) {
                vm.config = r.config;
            });
        },
        saveOrUpdate : function(e) {
            var url =  vm.config.id ? '/sys/config/update' : '/sys/config/save';
            $.ajax({
                type : 'POST',
                url : url,
                data : JSON.stringify(vm.config),
                success : function (r) {
                    if (r.code == 200) {
                        alert('操作成功', function (index) {
                            vm.back();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        back : function (e) {
            history.go(-1);
        }
    }

});