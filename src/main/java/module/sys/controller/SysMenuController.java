package module.sys.controller;

import common.controller.BaseController;
import module.sys.entity.SysMenu;
import module.sys.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.R;

import java.util.List;

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
     * 用户菜单列表
     *
     */
    public R user() {
        List<SysMenu> menuList = menuService.getUserMenuList(getUserId());
        return R.ok().put("menuList", menuList);
    }
}
