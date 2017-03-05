package module.sys.service;

import module.sys.dao.ISysMenuMapper;
import module.sys.dao.ISysRoleMenuMapper;
import module.sys.entity.SysMenu;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.PageUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static common.Constant.MenuType;

/**
 * 菜单service
 * Created by lx on 2017/1/30.
 */
@Service("sysMenuService")
public class SysMenuService implements ISysMenuService {

    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysMenuMapper menuMapper;
    @Autowired
    private ISysRoleMenuMapper roleMenuMapper;

    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<SysMenu> getAllMenu(Map<String, Object> params) {
        return menuMapper.getList(params);
    }

    /**
     * 查询用户下所有菜单
     * @param userId
     * @return
     */
    @Override
    public List<SysMenu> getUserMenuList(String userId) {
        //系统管理员
        if (StringUtils.isNotBlank(userId) && userId.equals("1")) {
            return getAllMenuList(null);
        }
        List<String> menuIdList = userService.queryMenuIdByUserId(userId);
        return getAllMenuList(menuIdList);
    }

    /**
     * 获取所有菜单列表
     */
    public List<SysMenu> getAllMenuList(List<String> menuIdList) {
        //查询根菜单列表
        List<SysMenu> menuList = queryListParentId("0", menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);
        return menuList;
    }

    /**
     * 查询菜单列表
     * @return
     */
    @Override
    public List<SysMenu> queryMenuList(Map<String, Object> params) {
        return menuMapper.getList(params);
    }

    /**
     * 查询 菜单 目录
     * @return
     */
    @Override
    public List<SysMenu> queryNotButtonList() {
        return menuMapper.queryNotButtonList();
    }

    /**
     * 根据菜单id查询菜单信息
     * @param menuId
     * @return
     */
    @Override
    public SysMenu getMenuById(String menuId) {
        return menuMapper.getOne(menuId);
    }

    /**
     * 保存菜单
     * @param menu
     */
    @Override
    @Transactional
    public void saveMenu(SysMenu menu) {
        if (StringUtils.isBlank(menu.getId())) {
            menu.setId(UUID.randomUUID().toString());
            menuMapper.save(menu);
        } else {
            menuMapper.update(menu);
        }
    }

    /**
     * 查询菜单列表（分页）
     * @param page
     * @return
     */
    @Override
    public List<SysMenu> queryMenuListByPage(PageUtils page) {
        return menuMapper.getList(page);
    }

    /**
     * 批量删除菜单
     * @param menuIds
     */
    @Override
    @Transactional
    public void deleteBatchMenu(String[] menuIds) {
        menuMapper.deleteBatch(menuIds);
        roleMenuMapper.deleteRoleMenuByMenuId(menuIds);
    }

    /**
     *递归
     */
    private List<SysMenu> getMenuTreeList(List<SysMenu> menuList, List<String> menuIdList) {
        List<SysMenu> subMenuList = new ArrayList<>();

        for (SysMenu menu : menuList) {
            // 目录
            if (menu.getMenuType() == MenuType.CATALOG.getValue()) {
                menu.setSubMenuList(getMenuTreeList(queryListParentId(menu.getId(),menuIdList),menuIdList));
            }
            subMenuList.add(menu);
        }
        return subMenuList;
    }

    /**
     * 查询父菜单
     * @param menuId
     * @param menuIdList
     * @return
     */
    public List<SysMenu> queryListParentId(String menuId, List<String> menuIdList) {
        List<SysMenu> menuList = menuMapper.queryListParentId(menuId);
        if (null == menuIdList) {//查询所有
            return menuList;
        }
        List<SysMenu> userMenuList = new ArrayList<>();
        for (SysMenu sm : menuList) {
            if (menuIdList.contains(sm.getId())) {
                userMenuList.add(sm);
            }
        }
        return userMenuList;
    }
}
