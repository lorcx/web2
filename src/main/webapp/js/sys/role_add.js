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
          url : 'nourl',
          name : 'menuName'
      }
  },
  check : {
      enable : true,
      nocheckInherit : true
  }
};

var ztree;


var roleId = T.p('roleId');

var vm = new Vue({
    el : '#web2',
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

            if (roleId) {
                vm.title = '修改角色';
                vm.getRole(roleId);
            }
        });

        console.log(111);
    },
    methods : {
        getRole : function(roleId) {
            $.get('/sys/role/info/' + roleId, function(r) {
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

            var url = vm.role.id ? '/sys/role/update' : '/sys/role/save';
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
        },
        back : function (e) {
            history.go(-1);
        }
    }
});