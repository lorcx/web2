package module.sys.sys.dao;

import module.sys.sys.entity.BaseDept;
import module.sys.sys.entity.BaseOperation;
import module.sys.sys.entity.BaseRole;

import java.util.List;

/**
 * Created by lx on 2016/10/7.
 */
public interface BaseSysOperationDao {
    /**
     * 获取所有部门
     * @return
     */
     public List<BaseDept> getAllDepts();

    /**
     * 根据用户id，获取用户的所有角色
     * @return
     */
     public List<BaseRole> getUserRole(String userId);

    /**
     * 获取用户所有的操作权限（url等）
     * @param userId
     * @return
     */
     public List<BaseOperation> getUserOperation(String userId);
}
