package module.sys.dao;

import common.dao.BaseDao;
import module.sys.entity.SysRoleMenu;

import java.util.List;

/**
 * Created by x on 2017/1/20.
 */
public interface ISysRoleMenuMapper extends BaseDao<SysRoleMenu> {
    List<String> queryMenuIdList(String roleId);
}
