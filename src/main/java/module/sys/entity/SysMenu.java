package module.sys.entity;


import java.io.Serializable;
import java.util.List;

public class SysMenu implements Serializable{
    private String id;

    private String menuName;

    private String icon;

    private String url;

    private String perms;

    private Integer orderNum;

    private Integer menuType;

    private String parentId;

    // ztree 属性
    private Boolean open;

    // 子菜单
    private List<SysMenu> subMenuList;

    // 上级菜单名称
    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public List<SysMenu> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<SysMenu> subMenuList) {
        this.subMenuList = subMenuList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", perms='" + perms + '\'' +
                ", orderNum=" + orderNum +
                ", menuType=" + menuType +
                ", parentId='" + parentId + '\'' +
                ", subMenuList=" + subMenuList +
                '}';
    }
}