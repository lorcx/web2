package common.dao;

import common.PageBean;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 通用hbernate dao
 * http://my.oschina.net/boonya/blog/290587
 * <p/>
 * http://my.oschina.net/moson/blog/518659
 * Created by dell on 2016/1/28.
 */
@SuppressWarnings("all")
public class HbiGeneraldaoImpl<T, PK extends Serializable> extends HibernateDaoSupport {

    protected Logger log = Logger.getLogger(HbiGeneraldaoImpl.class);
    //    protected SessionFactory sessionFactory;
//    protected Session session;
    protected Class<?> entityClass;

    public HbiGeneraldaoImpl() {
        //(ParameterizedType)getClass().getGenericSuperclass() 取的是<T,pk> 中的类型 [0] T [1] Pk
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

//    public HbiGeneraldaoImpl(SessionFactory sessionFactory,Class<T> entityClass) {
//        this.sessionFactory = sessionFactory;
//        this.entityClass = entityClass;
//    }


    /**
     * 保存
     *
     * @param
     */
    public void saveEntity(T o) {
        Assert.notNull(o);
        getHibernateTemplate().saveOrUpdate(o);
        log.info("save entity:" + o);
    }

    /**
     * 删除实体
     *
     * @param
     */
    public void delEntity(T o) {
        Assert.notNull(o);
        getHibernateTemplate().delete(o);
        log.info("delEntity:" + o);
    }

    /**
     * 根据id删除
     *
     * @param p
     */
    public void delById(PK p) {
        Assert.notNull(p);
        delEntity(get(p));
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    public T get(final PK id) {
        Assert.notNull(id);
        return (T) getHibernateTemplate().get(entityClass, id);
    }

    /**
     * 不带分页的hql查询
     *
     * @param hql
     * @param args
     * @return
     */
    public List<T> findList(String hql, Object... args) {
        return createQuery(hql, args).list();
    }

    /**
     * 分页查询
     *
     * @param page
     * @param hql
     * @param values
     * @return
     */
    public List<T> findListByPage(PageBean page, String hql, Object... values) {
        Assert.notNull(page);
        Query query = createQuery(hql, values);
        int firstPage = ((page.getCurrentNum() - 1) * page.getShowCount());//起始页
        int lastPage = page.getCurrentNum() * page.getShowCount();//结束页
        query.setFirstResult(firstPage);
        query.setMaxResults(lastPage);
        List<T> list = query.list();
        page.setTotalNum(list.size());//总个数
        page.setTotalPageNum(page.getTotalPageNum());//计算总页数
        return list;
    }

    /**
     * 获取总记录数
     */
    private int queryCount(String hql,Object... values) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(1) from (").append(hql).append(")");
        return Integer.valueOf(findUnique(sb.toString(),values).toString());
    }

    /**
     * 根据hql查询，返回单个实体
     *
     * @param hql
     * @param args
     * @return
     */
    public T findUnique(String hql, Object... args) {
        return (T) createQuery(hql, args).uniqueResult();
    }

    /**
     * 创建query
     *
     * @param queryString
     * @param args
     * @return
     */
    private Query createQuery(String queryString, Object... args) {
        Assert.hasText(queryString);
        Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                query.setParameter(i, args[i]);
            }
        }
        return query;
    }

    /**
     * 获取Criteria
     *
     * @param criterions
     * @return
     */
    private Criteria createCriteria(Criterion... criterions) {
        Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(entityClass);
        if (criterions != null && criterions.length > 0) {
            for (Criterion cr : criterions) {
                c.add(cr);
            }
        }
        return c;
    }

    /**
     * 查询条件追加前缀
     * @return
     */
    public StringBuilder prefix(StringBuilder hql,int n){
        StringBuilder sb = n > 0 ? hql.append(" and ") : hql.append(" where ");
        n++;
        return sb;
    }
}
