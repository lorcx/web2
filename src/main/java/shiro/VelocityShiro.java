package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


/**
 * shiro 权限标签
 * Created by Administrator on 2017/2/5 0005.
 */
public class VelocityShiro {
    /**
     * 是否拥有该权限
     * @return
     */
    public boolean hasPermission(String permission) {
        Subject subject = SecurityUtils.getSubject();
        return subject != null && subject.isPermitted(permission);
    }
}
