package module.base.user.service;

import common.exception.ServiceException;
import module.base.user.entity.BaseUser;

/**
 * Created by dell on 2016/1/6.
 */
@SuppressWarnings("all")
public interface IBaseUserService {
     BaseUser getBaseUserInfoById(String id) throws ServiceException;

     void saveBaseUser(BaseUser user);

     BaseUser getBaseUserInfoByName(String name)throws ServiceException;
}