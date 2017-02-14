package module.sys.service;

import module.sys.dao.ISysUserMapper;
import module.sys.entity.SysUser;
import module.sys.entity.SysUserBean;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by x on 2017/1/20.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("sysUserService")
public class SysUserService implements ISysUserService {
    @Autowired
    private ISysUserMapper userMapper;

    /**
     * 查询所有用户信息
     * @param params
     * @return
     */
    public List<SysUser> queryAllList(Map<String, Object> params) {
        return userMapper.getList(params);
    }

    /**
     * 查询用户的所有授权
     * @param userId
     * @return
     */
    @Override
    public List<String> queryAllPerms(String userId) {
        return userMapper.queryAllPerms(userId);
    }

    /**
     * 根据用户名密码查询用户信息
     * @param userName
     * @param passWord
     * @return
     */
    @Override
    public SysUser getUserByUserNameAndPassword(String userName, String passWord) {
        Map<String,Object> param = new HashMap<>();
        param.put("userName",userName);
        param.put("passWord",passWord);
        return userMapper.getUserByTemplate(param);
    }

    /**
     * 根据主键查询用户信息
     * @return
     */
    public SysUserBean getUserById(String userId) {
        SysUser user = userMapper.getOne(userId);
        SysUserBean userBean = new SysUserBean();
        try {
            BeanUtils.copyProperties(userBean, user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return userBean;
    }

    /**
     * 查询当前用户的所有菜单
     * @param userId
     * @return
     */
    @Override
    public List<String> queryMenuIdByUserId(String userId) {
        return userMapper.queryMenuIdByUserId(userId);
    }

    /**
     * 更新用户密码
     * @param userId
     * @param password
     * @param newPassword
     * @return
     */
    @Override
    public int updatePassword(String userId, String password, String newPassword) {
        Map<String,Object> param = new HashMap<>();
        param.put("userId", userId);
        param.put("passWord", password);
        param.put("newPassWord", newPassword);
        return userMapper.updatePassword(param);
    }

    @Override
    public int queryTotal(Map<String, Object> params) {
        return 0;
    }


}
