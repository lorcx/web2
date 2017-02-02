package module.sys.service;

import module.sys.entity.SysUser;
import module.sys.entity.SysUserBean;

import java.util.List;
import java.util.Map;

/**
 * Created by x on 2017/1/20.
 */
public interface ISysUserService {

    List<SysUser> queryAllList(Map<String,Object> params);

    List<String> queryAllPerms(String userId) ;

    SysUser getUserByUserNameAndPassword(String userName, String passWord);

    SysUserBean getUserById(String userId);

    List<String> queryMenuIdByUserId(String userId);

}
