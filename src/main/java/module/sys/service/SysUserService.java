package module.sys.service;

import module.sys.dao.ISysUserMapper;
import module.sys.dao.ISysUserRoleMapper;
import module.sys.entity.SysUser;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.PageUtils;

import java.util.*;

/**
 * Created by x on 2017/1/20.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("sysUserService")
public class SysUserService implements ISysUserService {
    @Autowired
    private ISysUserMapper userMapper;
    @Autowired
    private ISysUserRoleMapper userRoleMapper;




    /**
     * 查询所有用户信息
     * @param params
     * @return
     */
    public List<SysUser> queryAllList(Map<String, Object> params) {
        return userMapper.getList(params);
    }

    /**
     * 查询用户信息（分页）
     * @param pageUtils
     * @return
     */
    @Override
    public List<SysUser> queryUserListByPage(PageUtils pageUtils) {
        return userMapper.getUserListByPage(pageUtils);
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
    public SysUser getUserById(String userId) {
        SysUser user = userMapper.getOne(userId);
//        SysUserBean userBean = new SysUserBean();
//        try {
//            BeanUtils.copyProperties(userBean, user);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        return user;
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
    @Transactional
    public int updatePassword(String userId, String password, String newPassword) {
        Map<String,Object> param = new HashMap<>();
        param.put("userId", userId);
        param.put("passWord", password);
        param.put("newPassWord", newPassword);
        return userMapper.updatePassword(param);
    }

    /**
     * 删除用户
     * @param userIds
     */
    @Override
    @Transactional
    public void deleteBatch(String[] userIds) {
        userMapper.deleteBatch(userIds);
        userRoleMapper.deleteBatchByUserId(userIds);
    }

    /**
     * 保存用户
     * @param user
     */
    @Override
    @Transactional
    public void save(SysUser user) {
        user.setId(UUID.randomUUID().toString());
        user.setCreTime(new Date());
        user.setPassWord(new Sha256Hash(user.getPassWord()).toHex());
        userMapper.save(user);
    }

    /**
     * 更新
     * @param user
     */
    @Override
    @Transactional
    public void update(SysUser user) {
        user.setPassWord(new Sha256Hash(user.getPassWord()).toHex());
        userMapper.update(user);
    }

}
