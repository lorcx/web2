package module.sys.service;

import module.sys.dao.ISysRoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/2/26.
 */
@Service("sysRoleMenuService")
public class SysRoleMenuService implements ISysRoleMenuService {

    @Autowired
    private ISysRoleMenuMapper roleMenuMapper;

    /**
     * 保存角色菜单关联信息
     * @param roleId
     * @param menuList
     */
    @Override
    public void saveRoleMenu(String roleId, List<String> menuIdList) {
        // 删除关联信息
        if (menuIdList.size() == 0) {
            return;
        }

        roleMenuMapper.delete(roleId);

        // 保存关联信息
        Map<String, Object> params = new HashMap<>(10);
        params.put("roleId", roleId);
        params.put("menuIdList", menuIdList);
        roleMenuMapper.save(params);
    }
}
