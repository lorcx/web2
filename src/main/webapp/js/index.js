/**
 * Created by lx on 2017/2/1.
 */
var menuItem = Vue.extend({
    name : 'menu-item',
    props : {
        item : {}
    },
    template : [
        '<li>',
        '<a v-if="item.type === 0" href="javascript:;">',
        '<span>{{item.name}}</span>',
        '<i class="fa fa-angle-left pull-right"></i>',
        '</a>',
        '<ul>',
        '<menu-item :item="item" v-for="item in item.list"></menu-item>',
        '</ul>',
        '<a v-if="item-type === 1" :href="\'#\'+item.url">',
        '<i v-if="item.icon != null" :class="item.icon"></i>',
        '<i v-else class="fa fa-circle-o"></i>',
        '{{item.name}}',
        '</a>',
        '</li>'
    ].join('')
});

// 注册菜单组件
Vue.component('menuItem', menuItem);

var vm = new Vue({
    el : '#web2app',
    data : {
        user : {},
        menuList : {},
        main : 'sys/main.html',
        password : '',
        newPassword : '',
        navTitle : '控制台'
    },
    methods : {
        getMenuList : function (e) {
            $.getJSON('/sys/menu/user?_' + $.now(), function (r) {
               vm.menuList = r.menuList;
            });
        },
        getUser : function () {
            $.getJSON('/sys/user/info?_' + $.now(), function (r) {
                vm.user = r.user;
            });
        },
        updatePassword : function (r) {
           layer.open({
               type : 1,
               skin : 'layui-layer-moly',
               title : '修改密码',
               area : ['550px','270px'],
               shadeClose : false,
               content : $('#passwordLayer'),
               btn : ['修改','取消'],
               btn1 : function (i) {
                   var data = 'password=' + vm.password + '&newPassword=' + vm.newPassword;
                   $.ajax({
                       type : 'POST',
                       data : data,
                       dataType : 'json',
                       url : '/sys/user/password',
                       success : function (r) {
                           if (r.code == 0) {
                               layer.close(i);
                               layer.alert('修改成功'，function (i) {
                                   location.reload();
                               });
                           } else {
                               layer.alert(r.msg);
                           }
                       }
                   });
               }
           });
        }
    },
    created : function () {
        this.getMenuList();
        this.getUser();
    },
    updated : function () {
        //路由

    }
});