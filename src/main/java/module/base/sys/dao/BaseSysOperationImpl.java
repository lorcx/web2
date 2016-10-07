package module.base.sys.dao;

import module.base.sys.entity.BaseDept;
import module.base.sys.entity.BaseOperation;
import module.base.sys.entity.BaseRole;

import java.util.List;

/**
 * Created by lx on 2016/10/7.
 */
public class BaseSysOperationImpl implements BaseSysOperationDao{

    @Override
    public List<BaseDept> getAllDepts() {
        return null;
    }

    @Override
    public List<BaseRole> getUserRole(String userId) {
        return null;
    }

    @Override
    public List<BaseOperation> getUserOperation(String userId) {
        return null;
    }
}
