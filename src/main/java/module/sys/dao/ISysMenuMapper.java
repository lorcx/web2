package module.sys.dao;

import common.dao.BaseDao;
import module.sys.entity.SysMenu;

import java.util.List;

/**
 * 菜单dao
 * Created by x on 2017/1/20.
 */
public interface ISysMenuMapper extends BaseDao<SysMenu>{

    public List<SysMenu> queryAllMenu();

    List<SysMenu> getUserMenuList(String userId);

    List<SysMenu> queryListParentId(String menuId);

    List<SysMenu> queryNotButtonList();
}
