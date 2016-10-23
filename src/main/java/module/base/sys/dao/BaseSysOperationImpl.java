package module.base.sys.dao;

import common.dao.HbiGeneraldaoImpl;
import module.base.sys.entity.BaseDept;
import module.base.sys.entity.BaseOperation;
import module.base.sys.entity.BaseRole;

import java.util.List;

/**
 * 系统基本操作数据层
 * Created by lx on 2016/10/7.
 */
public class BaseSysOperationImpl extends HbiGeneraldaoImpl implements BaseSysOperationDao{
    /**
     * 获取所有部门信息
     * @return
     */
    public List<BaseDept> getAllDepts() {
        StringBuilder sql = new StringBuilder();
        sql.append(" select bd.id, bd.dept_name,bd.super_id, bd.status,bd.cre_date,bd.dept_code,bd.order_no,bd.dept_abbr,bd.dept_level ");
        sql.append(" from base_dept bd start with bd.id = '0' connect by prior bd.id = bd.super_id ");
        findListBySql(sql.toString());
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
