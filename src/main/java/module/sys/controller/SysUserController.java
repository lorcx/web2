package module.sys.controller;

import common.controller.BaseController;
import module.sys.entity.SysUser;
import module.sys.service.ISysRoleService;
import module.sys.service.ISysUserService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.PageUtils;
import util.R;
import util.ShiroUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by x on 2017/1/20.
 */
@RestController
@RequestMapping("/sys/user/")
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysRoleService roleService;

    /**
     * 查询所有用户
     * @param pageSize 每页记录数
     * @param currPage 当前页
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public R getUserList(Integer currPage, Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        PageUtils pageUtil = new PageUtils(pageSize, currPage);
        pageUtil.setParams(params);

        // 查询用户记录
        List<SysUser> userList = userService.queryUserListByPage(pageUtil);
        pageUtil.setList(userList);
        return R.ok().put("page", pageUtil);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping("/allUser/")
    @RequiresPermissions("sys:user:list")
    public R getAllUserList() {
        Map<String, Object> params = new HashMap<String, Object>();
        // 相当于request.setAttribute
        return R.ok().put("list", userService.queryAllList(params));
    }

    /**
     * 用户信息
     *
     * @return
     */
    @RequestMapping("/info")
    public R info() {
        return R.ok().put("user", getUser());
    }

    /**
     * 用户信息
     *
     * @return
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public R info(@PathVariable("userId") String userId) {
        if (StringUtils.isBlank(userId)) {
            return R.error("用户id不能为空");
        }
        SysUser user = userService.getUserById(userId);
        //获取用户的所属角色
        List<String> roleList = roleService.queryRoleIdList(userId);
        user.setRoleIdList(roleList);
        return R.ok().put("user", user);
    }


    /**
     * 修改密码
     *
     * @return
     * @param: password:旧密码
     * @param: newPassword:新密码
     */
    @RequestMapping("/password")
    public R password(String password, String newPassword) {
        if (StringUtils.isBlank(newPassword)) {
            return R.error("新密码不能为空");
        }
        // sha256加密
        password = new Sha256Hash(password).toHex();
        // sha256加密
        newPassword = new Sha256Hash(newPassword).toHex();

        //更新密码
        int count = userService.updatePassword(getUserId(), password, newPassword);
        if (count == 0) {
            return R.error("原密码不正确");
        }

        // 退出
        ShiroUtils.logout();
        return R.ok();
    }

    /**
     * 保存用户
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:user:save")
    public R saveUser(@RequestBody SysUser user) {
        if (StringUtils.isBlank(user.getUserName())) {
            return R.error("用户名不能为空");
        }
        if (StringUtils.isBlank(user.getPassWord())) {
            return R.error("密码不能为空");
        }
        userService.save(user);
        return R.ok();
    }

    /**
     * 更新用户
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:user:update")
    public R updateUser(@RequestBody SysUser user) {
        if (StringUtils.isBlank(user.getUserName())) {
            return R.error("用户名不能为空");
        }
        if (StringUtils.isBlank(user.getId())) {
            return R.error("用户id不能为空");
        }
        if (StringUtils.isBlank(user.getPassWord())) {
            return R.error("密码不能为空");
        }
        userService.update(user);
        return R.ok();
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public R delete(@RequestBody String[] userIds) {
        if (ArrayUtils.contains(userIds, "1")) {
            return R.error("系统管理员不能删除");
        }

        if (ArrayUtils.contains(userIds, getUserId())) {
            return R.error("当前用户不能删除");
        }

        userService.deleteBatch(userIds);
        return R.ok();
    }
}
