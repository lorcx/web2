package module.sys.service;

import module.sys.dao.ISysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lx on 2017/2/1.
 */
@Service("sysRoleService")
public class SysRoleService implements ISysRoleService {
    @Autowired
    private ISysRoleMapper roleMapper;

    /**
     * 查询用户所有角色
     * @param userId
     * @return
     */
    @Override
    public List<String> queryRoleIdList(String userId) {
        return roleMapper.queryRoleIdList(userId);
    }
}
