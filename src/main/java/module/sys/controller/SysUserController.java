package module.sys.controller;

import common.controller.BaseController;
import module.sys.entity.SysUser;
import module.sys.entity.SysUserBean;
import module.sys.service.ISysRoleService;
import module.sys.service.ISysUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    public R getUserList(Integer pageSize, Integer currPage) {
        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("offset", (page - 1) * limit);
//        params.put("limit", limit);

        PageUtils pageUtil = new PageUtils(pageSize, currPage);
        // 查询用户记录
        List<SysUser> userList = userService.queryUserListByPage(params, pageUtil);
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

}
