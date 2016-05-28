package module.base.user.service;

import common.exception.ServiceException;
import module.base.user.entity.BaseUser;

import java.util.List;

/**
 * Created by dell on 2016/1/6.
 */
@SuppressWarnings("all")
public interface IBaseUserService {
     BaseUser getBaseUserInfoById(String id) throws ServiceException;

     void saveBaseUser(BaseUser user);

     BaseUser getBaseUserInfoByName(String name)throws ServiceException;

     List<BaseUser> getUserList(BaseUser user)throws ServiceException;
}
