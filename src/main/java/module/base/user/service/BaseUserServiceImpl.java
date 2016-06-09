package module.base.user.service;

import common.PageBean;
import common.exception.DaoException;
import common.exception.ServiceException;
import module.base.user.dao.IBaseUserDao;
import module.base.user.entity.BaseUser;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by dell on 2016/1/6.
 */
@SuppressWarnings("all")
public class BaseUserServiceImpl implements IBaseUserService {
    private IBaseUserDao userDao;
    private static final Logger LOG = Logger.getLogger(BaseUserServiceImpl.class);

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
            LOG.error("通过id获取用户信息error id="+id,e.getCause());
            throw new ServiceException("通过id获取用户信息error",e.getCause());
        }
    }

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    @Override
    public void saveBaseUser(BaseUser user) throws ServiceException {
        try {
            userDao.saveEntity(user);
        } catch (Exception e) {
            LOG.error("保存用户信息error = " + user, e.getCause());
            throw new ServiceException("保存用户信息error",e.getCause());
        }
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
            LOG.error("通过name获取用户信息error name=="+name,e.getCause());
            throw new ServiceException("通过id获取用户信息error",e.getCause());
        }
    }

    /**
     * 查询用户列表
     * @return
     * @throws ServiceException
     */
    @Override
    public List<BaseUser> getUserList(PageBean page,BaseUser user) throws ServiceException {
        try {
            return userDao.getUserList(page,user);
        } catch (DaoException e) {
            LOG.error("查询用户列表error",e.getCause());
            throw new ServiceException("查询用户列表失败",e.getCause());
        }
    }

    public void setUserDao(IBaseUserDao userDao) {
        this.userDao = userDao;
    }
}
