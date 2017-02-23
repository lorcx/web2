/**
 * Created by lx on 2017/2/23 0023.
 */
var userId = T.p("userId");

var vm = new Vue({
    el : '#web2',
    data : {
        title : '新增管理员',
        roleList : {},
        user : {
            status : 1,
            roleIdList : []
        }
    },
    created : function () {
        if (null != userId) {
            this.title = "修改管理员",
            this.getUser(userId);
        }
        this.getRoleList();
    },
    methods : {
        getUser : function(userId) {
            $.get('/sys/user/info/' + userId, function(r) {
                this.user = r.user;
            });
        },
        getRoleList : function () {
            $.get('/sys/role/select', function(r) {
                this.roleList = r.list;
            });
        },
        saveOrUpdate : function(e) {
            var url = this.user.userId == null ? '/sys/user/save' : '/sys/user/update';
            $.ajax({
                type : 'POST',
                url : url,
                data : JSON.stringify(this.user),
                success : function (r) {
                    if (r.code == 200) {
                        alert('操作成功', function (index) {
                            this.back();
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