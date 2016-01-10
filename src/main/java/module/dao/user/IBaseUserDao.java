package module.dao.user;

import common.exception.DaoException;
import module.entity.base.BaseUser;

/**
 * Created by dell on 2016/1/6.
 */
@SuppressWarnings("all")
public interface IBaseUserDao {
    BaseUser getBaseUserDaoById(String id) throws DaoException;

    void saveBaseUser(BaseUser user);

    BaseUser getUserInfoByName(String UserName) throws DaoException;
}
