package module.sys.controller;

import module.sys.entity.SysRole;
import module.sys.service.ISysRoleService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.PageUtils;
import util.R;

import java.util.HashMap;
import java.util.List;

/**
 * 角色管理
 * Created by lx on 2017/2/25.
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    @Autowired
    private ISysRoleService roleService;

    /**
     * 角色管理列表
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:role:list")
    public R list(Integer currPage, Integer pageSize) {
        PageUtils pu = new PageUtils(pageSize, currPage);
        pu.setParams(new HashMap<String, Object>());
        List<SysRole> roleList = roleService.queryRoleListByPage(pu);
        pu.setList(roleList);
        return R.ok().put("page", pu);
    }


    /**
     * 新增角色
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:role:save")
    public R insertRole(@RequestBody SysRole role) {
        if (StringUtils.isBlank(role.getRoleName())) {
            return R.error("角色名称不能为空");
        }
        roleService.saveRole(role);
        return R.ok();
    }

    /**
     * 更新角色
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:role:update")
    public R updateRole(@RequestBody SysRole role) {
        if (StringUtils.isBlank(role.getId())) {
            return R.error("角色id不能为空");
        }
        if (StringUtils.isBlank(role.getRoleName())) {
            return R.error("角色名称不能为空");
        }
        roleService.saveRole(role);
        return R.ok();
    }

    /**
     * 删除角色
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public R deleteRole(@RequestBody String[] roleIds) {
        roleService.deleteBatchRole(roleIds);
        return R.ok();
    }

    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public R roleInfo(@PathVariable String roleId) {
        SysRole role = roleService.getRoleById(roleId);

        List<String> menuIdList = roleService.queryMenuIdList(roleId);
        role.setMenuIdList(menuIdList);
        return R.ok().put("role", role);
    }

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
