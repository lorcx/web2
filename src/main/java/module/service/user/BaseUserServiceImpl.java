package module.service.user;

import module.dao.user.IBaseUserDao;
import module.entity.base.BaseUser;

/**
 * Created by dell on 2016/1/6.
 */
@SuppressWarnings("all")
public class BaseUserServiceImpl implements IBaseUserService {
    private IBaseUserDao userDao;

    /**
     * 通过id获取用户信息
     * @param id
     * @return
     */
    @Override
    public BaseUser getBaseUserInfoById(String id) {
        return userDao.getBaseUserDaoById(id);
    }

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    @Override
    public BaseUser saveBaseUser(BaseUser user) {
        return null;
    }

    public void setUserDao(IBaseUserDao userDao) {
        this.userDao = userDao;
    }
}
