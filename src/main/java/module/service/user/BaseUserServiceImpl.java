package module.service.user;

import common.exception.DaoException;
import common.exception.ServiceException;
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
    public BaseUser getBaseUserInfoById(String id) throws ServiceException {
        try {
            return userDao.getBaseUserDaoById(id);
        } catch (DaoException e) {
           throw new ServiceException("通过id获取用户信息error",e.getCause());
        }
    }

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    @Override
    public void saveBaseUser(BaseUser user) {

    }

    /**
     * 通过name获取用户信息
     * @param id
     * @return
     */
    @Override
    public BaseUser getBaseUserInfoByName(String name) throws ServiceException {
        try {
            return userDao.getUserInfoByName(name);
        } catch (DaoException e) {
            throw new ServiceException("通过id获取用户信息error",e.getCause());
        }
    }

    public void setUserDao(IBaseUserDao userDao) {
        this.userDao = userDao;
    }
}
