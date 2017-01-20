package module.sys.dao;

import common.PageBean;
import common.exception.DaoException;
import module.sys.entity.BaseUser;

import java.util.List;

/**
 * Created by dell on 2016/1/6.
 */
@SuppressWarnings("all")
public interface IBaseUserDao {
    BaseUser getBaseUserDaoById(String id) throws DaoException;

    BaseUser getUserInfoByName(String UserName) throws DaoException;

    List<BaseUser> getUserList(PageBean page,BaseUser user) throws DaoException;
}
