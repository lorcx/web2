package module.service.login;

import common.exception.DaoException;
import common.exception.ServiceException;
import module.dao.user.IBaseUserDao;
import module.entity.base.BaseUser;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lx on 2015/12/25.
 */
@SuppressWarnings("all")
public class LoginServiceImpl implements ILoginService {
    private IBaseUserDao userDao;

    /**
     * 登录service
     * @param userName 用户名
     * @param passWord 密码
     * @return 是否登录成功
     */
    @Override
    public Map<String,Object> login(String userName,String passWord) throws ServiceException {
        Map<String,Object> infoMap = new HashMap<String, Object>();
        Boolean isOk = false;//是否登陆成功
        try {
            BaseUser user = userDao.getUserInfoByName(userName);
            isOk = isPasswdOk(user,passWord);
            infoMap.put("isOk",isOk);//是否登陆成功
            if(isOk)
                infoMap.put("BaseUser",user);
        } catch (DaoException e) {
            infoMap.put("isOk",isOk);
            throw new ServiceException("登录service error",e.getCause());
        }
        return infoMap;
    }

    /**
     * 验证密码是否正确
     * @return
     */
    public Boolean isPasswdOk(BaseUser user,String passWord){
        if(null != user){
            if(StringUtils.isNotEmpty(passWord) && StringUtils.isNotEmpty(user.getPassWord()) && user.getPassWord().equals(passWord)){
                return true;
            }
        }
        return false;
    }


    public void setUserDao(IBaseUserDao userDao) {
        this.userDao = userDao;
    }
}
