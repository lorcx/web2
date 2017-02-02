package module.sys.dao;

import java.util.List;

/**
 * Created by x on 2017/1/20.
 */
public interface ISysRoleMapper {
    List<String> queryRoleIdList(String userId);
}
