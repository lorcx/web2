package module.sys.service;

import module.sys.entity.SysRole;
import util.PageUtils;

import java.util.List;

/**
 * Created by lx on 2017/2/1.
 */
public interface ISysRoleService {
    List<String> queryRoleIdList(String userId);

    List<SysRole> queryRoleListByPage(PageUtils pageUtils);

    List<SysRole> queryRoleList();

    void deleteBatchRole(String[] roleIds);

    public void saveRole(SysRole role);

    SysRole getRoleById(String roleId);

    List<String> queryMenuIdList(String roleId);
}
