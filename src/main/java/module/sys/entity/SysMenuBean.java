package module.sys.entity;

import java.util.List;

/**
 * Created by lx on 2017/2/1.
 */
public class SysMenuBean extends SysMenu {
    private List<SysMenu> subMenuList;

    public List<SysMenu> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<SysMenu> subMenuList) {
        this.subMenuList = subMenuList;
    }
}
