package module.sys.controller;

import module.sys.entity.SysRole;
import module.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.R;
import java.util.List;

/**
 * 角色管理
 * Created by lx on 2017/2/25.
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    @Autowired
    private SysRoleService roleService;

    /**
     * 获取所有角色
     * @return
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:role:select")
    public R queryRoleList() {
        List<SysRole> roleList = roleService.queryRoleList();
        return R.ok().put("list", roleList);
    }

}
