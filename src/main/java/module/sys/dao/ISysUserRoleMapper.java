package module.sys.dao;

import common.dao.BaseDao;
import module.sys.entity.SysUserRole;

import java.util.Map;

/**
 * Created by x on 2017/1/20.
 */
public interface ISysUserRoleMapper extends BaseDao<SysUserRole>{
    int deleteBatchByUserId(Object[] id);

    void deleteBatchByRoleId(String[] roleIds);

    int saveUserRole(Map<String, Object> params);
}
