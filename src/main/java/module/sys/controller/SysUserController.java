package module.sys.controller;

import common.controller.BaseController;
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
public class SysUserController extends BaseController{
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysRoleService roleService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/list")
    public R getAllUserList(){
        Map<String, Object> params = new HashMap<String, Object>();
        // 相当于request.setAttribute
        return R.ok().put("list", userService.queryAllList(params));
    }

    /**
     * 用户信息
     * @return
     */
//    @RequestMapping("/info/{userId}")
//    @RequiresPermissions("sys:user:info")
//    public R info (@PathVariable("userId") String userId) {
//        SysUserBean user = userService.getUserById(userId);
//        // 获取用户的所有角色
//        List<String> roleIdList = roleService.queryRoleIdList(userId);
//        user.setRoleIdList(roleIdList);
//        return R.ok().put("user", user);
//    }

    /**
     * 用户信息
     * @return
     */
    @RequestMapping("/info")
    public R info () {
        return R.ok().put("user", getUser());
    }


    /**
     * 修改密码
     * @param: password:旧密码
     * @param: newPassword:新密码
     * @return
     */
    @RequestMapping("/password")
    public R password (String password, String newPassword) {
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
