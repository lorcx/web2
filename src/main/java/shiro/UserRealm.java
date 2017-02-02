package shiro;

import module.sys.entity.SysMenu;
import module.sys.entity.SysUser;
import module.sys.service.ISysMenuService;
import module.sys.service.ISysUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 域认证
 * Created by lx on 2017/1/30.
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysMenuService menuService;

    /**
     * 授权(验证权限时调用)
     * authorization 授权，认可；批准，委任
     * principal主要的；资本的
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        String userId = user.getId();

        List<String> permsList = Collections.emptyList();
        // 系统管理员拥有最高权限
        if (userId.equals("1")) {
            List<SysMenu> menuList = menuService.getAllMenu(new HashMap<String, Object>());
            permsList = new ArrayList<>(menuList.size());
            for (SysMenu menu : menuList) {
                permsList.add(menu.getPerms());
            }
        } else {
           permsList = userService.queryAllPerms(userId);
        }

        Set<String> permsSet = new HashSet<>();
        for (String perms : permsList) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     * Authentication证明；鉴定；证实
     * token令牌
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        // 查询用户信息
        SysUser user = userService.getUserByUserNameAndPassword(userName, password);

        if (null == user) {// 用户不存在
            throw new UnknownAccountException("账号或密码不正确");
        }

        if ("0".equals(user.getStatus())) {//账号被锁定
            throw new LockedAccountException("账号被锁定，请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
