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
    }
};

var ztree;

var menuId = T.p('menuId');

var vm = new Vue({
    el : '#web2',
    data : {
        title : '新增菜单',
        menu : {
            parentName : '',
            parentId : 0,
            menuType : 1,
            orderNum : 0
        }
    },
    created : function () {
        if (menuId) {
            this.title = '修改菜单';
            this.getMenu(menuId);
        }

        // 加载菜单树
        $.get('/sys/menu/select', function (r) {
            ztree = $.fn.zTree.init($('#menuTree'), setting, r.menuList);

            var node = ztree.getNodeByParam('id', vm.menu.parentId);

            if (node) {
                // 展开所有节点
                ztree.selectNode(node);
                vm.menu.parentName = node.menuName;
            }
        });
    },
    methods : {
        getMenu : function(menuId) {
            $.get('/sys/menu/info/' + menuId, function(r) {
                vm.menu = r.menu;
            });
        },
        saveMenu : function (e) {
            // 获取选中的菜单
            var nodes = ztree.getCheckedNodes(true);
            var menuIdList = [];
            for (var i = 0; i < nodes.length; i++) {
                menuIdList.push(nodes[i].id);
            }
            vm.menu.menuIdList = menuIdList;

            var url = vm.menu.id ? '/sys/menu/update' : '/sys/menu/save';
            $.ajax({
                type : 'POST',
                url : url,
                data : JSON.stringify(vm.menu),
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
        menuTree : function () {
          layer.open({
              type : 1,
              offset : '50px',
              skin : 'layui-layer-molv',
              title : '选择菜单',
              area : ['300px', '450px'],
              shade : 0,
              shadeClose : false,
              content : $('#menuLayer'),
              btn : ['确定', '取消'],
              btn1 : function (index) {
                  var node = ztree.getSelectedNodes();
                  // 选择上级菜单
                  vm.menu.parentId = node[0].id;
                  console.log(node[0].id);
                  console.log(node[0].menuName);
                  vm.menu.parentName = node[0].menuName;

                  layer.close(index);
              }
          });
        },
        back : function (e) {
            history.go(-1);
        }
    }
});