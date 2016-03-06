package module.base.user.dao;

import common.dao.HbiGeneraldaoImpl;
import common.exception.DaoException;
import module.base.user.entity.BaseUser;
import org.apache.log4j.Logger;

/**
 * Created by dell on 2016/1/6.
 */
@SuppressWarnings("all")
public class BaseUserDaoImpl extends HbiGeneraldaoImpl<BaseUser,String> implements IBaseUserDao {
    private static final Logger LOG = Logger.getLogger(BaseUserDaoImpl.class);

    /**
     * 通过id获取用户信息
     * @param id
     * @return
     */
    @Override
    public BaseUser getBaseUserDaoById(String id) throws DaoException {
        try {
            BaseUser baseUser = get(id);
            return baseUser;
        }catch (Exception e){
            throw new DaoException("通过id获取用户信息出错",e.getCause());
        }
    }

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    @Override
    public void saveBaseUser(BaseUser user) {
        try {
            saveEntity(user);
        }catch (Exception e){
            LOG.error("保存用户信息失败！",e.getCause());
        }
    }

    /**
     * <p>根据用户名获取用户信息</p>
     * @param id
     * @return
     */
    public BaseUser getUserInfoByName(String UserName) throws DaoException {
        StringBuilder sql = new StringBuilder();
        sql.append("from BaseUser b where b.userName = ?");
        try {
            BaseUser user = findUnique(sql.toString(), UserName);
            return user;
        }catch (Exception e){
           throw new DaoException("根据用户名获取用户信息失败",e);
        }
    }


}
