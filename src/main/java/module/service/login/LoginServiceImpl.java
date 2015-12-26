package module.service.login;

import module.dao.login.ILoginDao;

/**
 * Created by lx on 2015/12/25.
 */
@SuppressWarnings("all")
public class LoginServiceImpl implements ILoginService {
    private ILoginDao loginDao;

    public void setLoginDao(ILoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
