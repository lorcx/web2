/**
 * Created by lx on 2017/2/26.
 */
var setting = {
    data : {
        simpleData : {
            enable : true,
            idKey : 'id',
            pIdKey : 'parentId',
            rootPId : -1
        },
        key : {
            url : 'nourl'
        }
    },
    check : {
        enable : true,
        nocheckInherit : true
    }
};

var ztree;


var menuId = T.p('menuId');

var vm = new Vue({
    el : 'web2',
    data : {
        title : '新增角色',
        role : {}
    },
    created : function () {
        // 加载菜单树
        $.get('/sys/menu/perms', function (r) {
            ztree = $.fn.zTree.init($('#menuTree'), setting, r.menuList);
            // 展开所有节点
            ztree.expandAll(true);

            if (menuId) {
                vm.title = '修改角色';
                vm.getRole(menuId);
            }
        });
    },
    methods : {
        getRole : function(menuId) {
            $.get('/sys/role/info/' + menuId, function(r) {
                vm.role = r.role;

                // 勾选角色所拥有的菜单
                var menuIds = vm.role.menuIdList;
                for (var i = 0; i < menuIds.length; i++) {
                    var node = ztree.getNodeByParam('id', menuIds[i]);
                    ztree.checkNode(node, true, false);
                }
            });
        },
        saveRole : function (e) {
            // 获取选中的菜单
            var nodes = ztree.getCheckedNodes(true);
            var menuIdList = [];
            for (var i = 0; i < nodes.length; i++) {
                menuIdList.push(nodes[i].id);
            }
            vm.role.menuIdList = menuIdList;

            var url = vm.role.menuId ? '/sys/role/save' : '/sys/role/update';
            $.ajax({
                type : 'POST',
                url : url,
                data : JSON.stringify(vm.role),
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
        }
    }
});