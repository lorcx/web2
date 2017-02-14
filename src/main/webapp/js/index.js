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
        '<a v-if="item.menuType === 0" href="javascript:;">',
        '<i v-if="item.icon !=null" :class="item.icon"></i>',
        '<span>{{item.menuName}}</span>',
        '<i class="fa fa-angle-left pull-right"></i>',
        '</a>',
        '<ul v-if="item.menuType === 0" class="treeview-menu">',
        '<menu-item :item="item" v-for="item in item.subMenuList"></menu-item>',
        '</ul>',
        '<a v-if="item.menuType === 1" :href="\'#\'+item.url">',
        '<i v-if="item.icon != null" :class="item.icon"></i>',
        '<i v-else class="fa fa-circle-o"></i>',
        '{{item.menuName}}',
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
        main : '/sys/main.html',
        password : '',
        newPassword : '',
        navTitle : '控制台'
    },
    methods : {
        /**
         * 获取菜单信息
         * @param e
         */
        getMenuList : function () {
            $.getJSON('/sys/menu/user?_' + $.now(), function (re) {
               vm.menuList = re.menuList;
            });
        },
        /**
         * 获取当前用户
         */
        getUser : function () {
            $.getJSON('/sys/user/info?_' + $.now(), function (r) {
                vm.user = r.user;
            });
        },
        /**
         * 修改密码
         * @param r
         */
        updatePassword : function (r) {
           layer.open({
               type : 1,
               skin : 'layui-layer-molv',
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
                           if (r.code == 200) {
                               layer.close(i);
                               layer.alert('修改成功', function (i) {
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
        var router = new Router();
        routerList(router, vm.menuList);
        router.start();
    }
});


function routerList(router, menuList) {
    for (var key in menuList) {
        var menu = menuList[key];
        if (menu.menuType == 0) {
            routerList(router, menu.subMenuList);
        } else if (menu.menuType == 1) {
            router.add('#' + menu.url, function () {
                var url = window.location.hash;

                //替换iframe的url
                vm.main = url.replace('#', '');
                //导航菜单展开
                $('.treeview-menu li').removeClass('active');
                var aUrl = $('a[href="' + url + '"]');
                aUrl.parents('li').addClass('active');
                vm.navTitle = aUrl.text();
            });
        }
    }
}