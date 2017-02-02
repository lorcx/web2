package common.controller;


import module.sys.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ShiroUtils;

/**
 * 公共基类
 * Created by x on 2017/1/5.
 */
public abstract class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUser getUser() {
        return ShiroUtils.getUser();
    }

    protected  String getUserId() {
        return ShiroUtils.getUserId();
    }
}
