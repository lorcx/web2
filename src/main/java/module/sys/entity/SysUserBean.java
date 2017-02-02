package module.sys.entity;

import java.util.List;

/**
 * Created by lx on 2017/2/1.
 */
public class SysUserBean extends SysUser {
    private List<String> roleIdList;

    public List<String> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<String> roleIdList) {
        this.roleIdList = roleIdList;
    }
}
