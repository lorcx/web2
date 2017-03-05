package module.sys.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lx on 2017/2/26.
 */
@Service("sysRoleMenuService")
public interface ISysRoleMenuService {
    void saveRoleMenu(String roleId, List<String> menuList);
}
