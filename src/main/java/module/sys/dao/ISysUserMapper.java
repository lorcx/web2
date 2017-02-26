package module.sys.dao;

import common.dao.BaseDao;
import module.sys.entity.SysUser;
import util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * userDao
 * Created by x on 2017/1/20.
 */
public interface ISysUserMapper extends BaseDao<SysUser> {
    List<String> queryAllPerms(String userId);

    SysUser getUserByTemplate(Map<String, Object> param);

    List<String> queryMenuIdByUserId(String userId);

    int updatePassword(Map<String, Object> params);

    List<SysUser> getUserListByPage(PageUtils pageUtils);
}
