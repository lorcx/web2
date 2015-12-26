package module.action.login;

import common.action.BaseAction;
import module.service.login.ILoginService;
import org.apache.log4j.Logger;

/**
 *  登陆
 * Created by lx on 2015/12/25.
 */
@SuppressWarnings("all")
public class LoginAction extends BaseAction{
    private static final long serialVersionUID = 1;
    private static final Logger log = Logger.getLogger(LoginAction.class);
    private ILoginService loginService;

    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }
}
