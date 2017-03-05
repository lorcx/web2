package module.sys.service;

import module.sys.entity.SysUser;
import util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by x on 2017/1/20.
 */
public interface ISysUserService {

    List<SysUser> queryAllList(Map<String,Object> params);

    List<SysUser> queryUserListByPage(PageUtils pageUtils);

    List<String> queryAllPerms(String userId) ;

    SysUser getUserByUserNameAndPassword(String userName, String passWord);

    SysUser getUserById(String userId);

    List<String> queryMenuIdByUserId(String userId);

    int updatePassword(String userId, String password, String newPassword);

    void deleteBatch(String[] userIds);

    void saveOrUpdateUser(SysUser user);
}
