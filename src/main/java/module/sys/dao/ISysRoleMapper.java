package module.sys.dao;

import common.dao.BaseDao;
import module.sys.entity.SysRole;
import java.util.List;

/**
 * Created by x on 2017/1/20.
 */
public interface ISysRoleMapper extends BaseDao<SysRole>{
    List<String> queryRoleIdList(String userId);


}
