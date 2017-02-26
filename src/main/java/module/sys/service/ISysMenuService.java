package module.sys.service;

import module.sys.entity.SysMenu;
import util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/1/30.
 */
public interface ISysMenuService {

    public List<SysMenu> getAllMenu(Map<String, Object> params);

    List<SysMenu> getUserMenuList(String userId);

    public List<SysMenu> queryListParentId(String menuId, List<String> menuIdList);

    public List<SysMenu> getAllMenuList(List<String> menuIdList);

    List<SysMenu> queryMenuListByPage(PageUtils page);

    void deleteBatchMenu(String[] menuIds);

    public List<SysMenu> queryMenuList(Map<String, Object> params);

    List<SysMenu> queryNotButtonList();

    SysMenu getMenuById(String menuId);

    void saveMenu(SysMenu menu);
}
