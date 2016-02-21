package module.base.user.dao;

import common.dao.IHbiGeneraldao;
import common.exception.DaoException;
import module.base.user.entity.BaseUser;

/**
 * Created by dell on 2016/1/6.
 */
@SuppressWarnings("all")
public interface IBaseUserDao extends IHbiGeneraldao<BaseUser,String > {
    BaseUser getBaseUserDaoById(String id) throws DaoException;

    void saveBaseUser(BaseUser user);

    BaseUser getUserInfoByName(String UserName) throws DaoException;
}