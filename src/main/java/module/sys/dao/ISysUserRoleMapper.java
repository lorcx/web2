package module.sys.dao;

import common.dao.BaseDao;
import module.sys.entity.SysUserRole;

/**
 * Created by x on 2017/1/20.
 */
public interface ISysUserRoleMapper extends BaseDao<SysUserRole>{
    int deleteBatchByUserId(Object[] id);
}
