package module.sys.service;

import java.util.List;

/**
 * Created by lx on 2017/2/1.
 */
public interface ISysRoleService {
    List<String> queryRoleIdList(String userId);
}
