package module.dao.user;

import module.entity.base.BaseUser;
import org.apache.log4j.Logger;
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
    public BaseUser getBaseUserDaoById(String id) {
        Session session = getSession();
        return (BaseUser) session.get(BaseUser.class,id);
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
        }catch (Exception e){
            LOG.error("保存用户信息失败！",e.getCause());
        }
    }
}
