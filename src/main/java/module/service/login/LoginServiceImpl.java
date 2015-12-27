package module.service.login;

import module.dao.login.ILoginDao;
import module.entity.base.BaseUser;

/**
 * Created by lx on 2015/12/25.
 */
@SuppressWarnings("all")
public class LoginServiceImpl implements ILoginService {
    private ILoginDao loginDao;

    public void setLoginDao(ILoginDao loginDao) {
        this.loginDao = loginDao;
    }

    /**
     * 登录service
     * @param userName 用户名
     * @param passWord 密码
     * @return 是否登录成功
     */
    @Override
    public boolean login(String userName,String passWord) {
        BaseUser user = (BaseUser) loginDao.getUserInfoByName(userName);
        if(null != user){
            if(passWord != null && user.getPassWord() != null && user.getPassWord().equals(user.getPassWord())){
                return true;
            }
        }
        return false;
    }
}
