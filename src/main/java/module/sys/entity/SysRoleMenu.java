package module.sys.entity;

import java.io.Serializable;

public class SysRoleMenu implements Serializable {
    private String id;

    private String menuId;

    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    @Override
    public String toString() {
        return "SysRoleMenu{" +
                "id='" + id + '\'' +
                ", menuId='" + menuId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}