package module.dao.user;

import common.exception.DaoException;
import module.entity.base.BaseUser;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by dell on 2016/1/6.
 */
@SuppressWarnings("all")
public class BaseUserDaoImpl extends HibernateDaoSupport implements IBaseUserDao {
    private static final Logger LOG = Logger.getLogger(BaseUserDaoImpl.class);

    /**
     * 通过id获取用户信息
     * @param id
     * @return
     */
    @Override
    public BaseUser getBaseUserDaoById(String id) throws DaoException {
        Session session = getSession();
        BaseUser baseUser = null;
        try {
            baseUser = (BaseUser) session.get(BaseUser.class,id);
            closeSession(session);
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
        Session session = getSession();
        try {
            session.save(user);
            closeSession(session);
        }catch (Exception e){
            LOG.error("保存用户信息失败！",e.getCause());
        }
    }

    /**
     * <p>根据用户名获取用户信息</p>
     * @param id
     * @return
     */
    @Override
    public BaseUser getUserInfoByName(String UserName) {
        Session session = getSession();
        StringBuilder sql = new StringBuilder();
        sql.append("from BaseUser b where b.userName = '").append(UserName).append("'");
        Query query = session.createQuery(sql.toString());
        BaseUser user = (BaseUser) query.uniqueResult();
        closeSession(session);
        return user;
    }

    /**
     * 关闭session
     * @param session
     */
    public void closeSession(Session session){
        try {
            if(null != session && session.isOpen()){
                session.close();
            }
        }catch (Exception e){
            LOG.error("关闭session失败！",e.getCause());
        }
    }
}
