package module.sys.service;

import module.sys.dao.ISysRoleMapper;
import module.sys.dao.ISysRoleMenuMapper;
import module.sys.entity.SysRole;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by lx on 2017/2/1.
 */
@Service("sysRoleService")
public class SysRoleService implements ISysRoleService {
    @Autowired
    private ISysRoleMapper roleMapper;

    @Autowired
    private ISysRoleMenuMapper roleMenuMapper;

    @Autowired
    private ISysRoleMenuService roleMenuService;

    /**
     * 查询用户所有角色
     * @param userId
     * @return
     */
    @Override
    public List<String> queryRoleIdList(String userId) {
        return roleMapper.queryRoleIdList(userId);
    }

    /**
     * 分页查询角色列表
     * @return
     */
    @Override
    public List<SysRole> queryRoleListByPage(PageUtils pageUtils) {
        return roleMapper.getList(pageUtils.getParams());
    }

    /**
     * 查询角色列表
     * @return
     */
    public List<SysRole> queryRoleList() {
        return roleMapper.getList(Collections.emptyMap());
    }

    /**
     * 批量删除角色
     * @param
     */
    @Override
    public void deleteBatchRole(String[] roleIds) {
        roleMapper.deleteBatch(roleIds);
    }

    /**
     * 保存角色
     * @param
     */
    public void saveRole(SysRole role) {
        if (StringUtils.isBlank(role.getId())) {
            role.setId(UUID.randomUUID().toString());
            role.setCreTime(new Date());
            roleMapper.save(role);
        } else {
            roleMapper.update(role);
        }
        // 保存角色菜单管理信息
        roleMenuService.saveRoleMenu(role.getId(), role.getMenuIdList());
    }

    /**
     * 根据角色id查询角色信息
     * @param
     * @return
     */
    @Override
    public SysRole getRoleById(String roleId) {
        return roleMapper.getOne(roleId);
    }

    /**
     * 查询角色关联的菜单
     * @param roleId
     * @return
     */
    @Override
    public List<String> queryMenuIdList(String roleId) {
        return roleMenuMapper.queryMenuIdList(roleId);
    }
}
