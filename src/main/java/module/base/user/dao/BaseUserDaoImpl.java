package module.base.user.dao;

import common.PageBean;
import common.dao.HbiGeneraldaoImpl;
import common.exception.DaoException;
import module.base.user.entity.BaseUser;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.List;

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
        StringBuilder hql = new StringBuilder();
        hql.append("from BaseUser b where b.userName = ?");
        try {
            BaseUser user = findUnique(hql.toString(), UserName);
            return user;
        }catch (Exception e){
           throw new DaoException("根据用户名获取用户信息失败",e);
        }
    }

    /**
     * 获取系统用户列表
     * @return
     * @throws DaoException
     */
    @Override
    public List<BaseUser> getUserList(PageBean page,BaseUser user) throws DaoException {
        StringBuilder hql = new StringBuilder();
        hql.append("select new map(u.id as id,u.nickName as nickName,u.userName as userName,u.creDate as creDate) from BaseUser u ");
        int n = 0;
        if(StringUtils.isNotEmpty(user.getUserName())){
            prefix(hql,n).append("u.userName like '%").append(user.getUserName()).append("%'");
            n++;
        }
        if(StringUtils.isNotEmpty(user.getNickName())){
            prefix(hql,n).append("u.nickName like '%").append(user.getNickName()).append("%'");
            n++;
        }
        hql.append(" order by u.creDate ");
        List<BaseUser> list = null;
        try {
            list = findListByPage(page, hql.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询条件追加前缀
     * @return
     */
    private StringBuilder prefix(StringBuilder hql,int n){
        StringBuilder sb = n > 0 ? hql.append(" and ") : hql.append(" where ");
        n++;
        return sb;
    }

}
