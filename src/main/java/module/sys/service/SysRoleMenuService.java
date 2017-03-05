package module.sys.service;

import module.sys.dao.ISysRoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/2/26.
 */
@Service("sysRoleMenuService")
public class SysRoleMenuService implements ISysRoleMenuService {

    @Autowired
    private ISysRoleMenuMapper rmMapper;

    /**
     * 保存角色菜单关联信息
     * @param roleId
     * @param menuIdList
     */
    @Override
    @Transactional
    public void saveRoleMenu(String roleId, List<String> menuIdList) {
        // 删除关联信息
        if (menuIdList.size() == 0) {
            return;
        }

        rmMapper.delete(roleId);

        // 保存关联信息
        Map<String, Object> params = new HashMap<>(30);
        params.put("roleId", roleId);
        params.put("menuIdList", menuIdList);
        rmMapper.save(params);
    }

}
