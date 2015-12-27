package module.dao.login;

import module.entity.base.BaseUser;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by lx on 2015/12/25.
 */
@SuppressWarnings("all")
public class LoginDaoImpl extends HibernateDaoSupport implements ILoginDao {
    private static final Logger LOG = Logger.getLogger(LoginDaoImpl.class);

    /**
     * <p>根据用户id获取用户信息</p>
     * @param id
     * @return
     */
    @Override
    public BaseUser getUserInfoById(String id) {
        Session session = getSession();
        return (BaseUser) session.get(BaseUser.class,id);
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
        return (BaseUser) query.uniqueResult();
    }
}
