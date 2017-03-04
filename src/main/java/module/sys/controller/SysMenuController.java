package module.sys.controller;

import common.Constant.MenuType;
import common.controller.BaseController;
import common.exception.RRException;
import module.sys.entity.SysMenu;
import module.sys.service.ISysMenuService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.PageUtils;
import util.R;

import java.util.HashMap;
import java.util.List;

;

/**
 * 菜单
 * Created by lx on 2017/2/1.
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController{
    @Autowired
    private ISysMenuService menuService;

    /**
     * 获取菜单列表（分页）
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public R menuList(Integer currPage, Integer pageSize) {
        PageUtils page = new PageUtils(pageSize, currPage);
        page.setParams(new HashMap<String, Object>());
        List<SysMenu> menuList = menuService.queryMenuListByPage(page);
        page.setList(menuList);
        return R.ok().put("page", page);
    }


    /**
     * 批量删除菜单
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:menu:delete")
    public R deleteBatchMenu(@RequestBody String[] menuIds) {
        menuService.deleteBatchMenu(menuIds);
        return R.ok();
    }

    /**
     * 保存菜单
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:menu:save")
    public R saveMenu(@RequestBody SysMenu menu) {
        verifyForm(menu);
        menuService.saveMenu(menu);
        return R.ok();
    }

    /**
     * 更新菜单
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public R updateMenu(@RequestBody SysMenu menu) {
        verifyForm(menu);
        menuService.saveMenu(menu);
        return R.ok();
    }

    /**
     * 获取当前用户下的菜单列表
     *
     */
    @RequestMapping("/user")
    public R user() {
        List<SysMenu> menuList = menuService.getUserMenuList(getUserId());
        return R.ok().put("menuList", menuList);
    }


    /**
     * 角色授权菜单
     */
    @RequestMapping("/perms")
    @RequiresPermissions("sys:menu:perms")
    public R persm() {
        List<SysMenu> menuList = menuService.queryMenuList(new HashMap<String, Object>());
        return R.ok().put("menuList", menuList);
    }

    /**
     * 选择菜单（添加，修改菜单）
     * @return
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:menu:list")
    public R selectMenu() {
        List<SysMenu> noButtonList = menuService.queryNotButtonList();

        // 设置一级菜单
        SysMenu root = new SysMenu();
        root.setId("0");
        root.setMenuName("一级菜单");
        root.setParentId("-1");
        root.setOpen(true);
        noButtonList.add(root);
        return R.ok().put("menuList", noButtonList);
    }

    /**
     * 验证参数是否正确
     */
    private void verifyForm(SysMenu menu) {
        if (StringUtils.isBlank(menu.getMenuName())) {
            throw new RRException("菜单名称不能为空");
        }

        if (null != menu.getMenuName()) {
            throw new RRException("上级菜单名称不能为空");
        }

        // 菜单
        if (menu.getMenuType() == MenuType.MENU.getValue()) {
            if (StringUtils.isBlank(menu.getUrl())) {
                throw new RRException("菜单url不能为空");
            }
        }

        // 上级菜单
        int parentType = MenuType.CATALOG.getValue();
        if (menu.getMenuType() != 0) {
            SysMenu parentMenu = menuService.getMenuById(menu.getParentId());
            parentType = parentMenu.getMenuType();
        }

        // 目录、菜单
        if (menu.getMenuType() == MenuType.CATALOG.getValue() ||
                menu.getMenuType() == MenuType.MENU.getValue()) {
            if (parentType != MenuType.CATALOG.getValue()) {
                throw new RRException("上级菜单只能为目录");
            }
            return;
        }

        if (menu.getMenuType() == MenuType.BUTTON.getValue()) {
            if (parentType != MenuType.MENU.getValue()) {
                throw new RRException("上级菜单只能为菜单类型");
            }
            return;
        }

    }
}
