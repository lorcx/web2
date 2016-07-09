package common.dao;

import common.PageBean;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.ast.QueryTranslatorImpl;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
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
        return createQuery(hql,"h",args).list();
    }


    /**
     * 不带分页的sql查询
     *
     * @param hql
     * @param args
     * @return
     */
    public List<T> findListBySql(String sql, Object... args) {
        return createQuery(sql, "s", args).list();
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
        Query query = createQuery(hql,"h",values);
        int firstPage = ((page.getCurrentNum() - 1) * page.getShowCount());//起始页
        int lastPage = page.getCurrentNum() * page.getShowCount();//结束页
        query.setFirstResult(firstPage);
        query.setMaxResults(lastPage);
        List<T> list = query.list();
        page.setTotalNum(toCountHql(hql,values));//总个数
        page.setTotalPageNum(page.getTotalPageNum());//计算总页数
        return list;
    }

    /**
     * 获取总记录数
     */
    private int toCountHql(String hql, Object[] values) {
        QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(hql, hql,
                Collections.EMPTY_MAP, (SessionFactoryImplementor) this
                .getSessionFactory());
        queryTranslator.compile(Collections.EMPTY_MAP, false);
        String tempSQL = queryTranslator.getSQLString();
        String countSQL = "select count(*) from (" + tempSQL + ") tmp_count_t";
        return Integer.parseInt(findUniqueSql(countSQL,values).toString());
    }

    /**
     * 根据hql查询，返回单个实体
     *
     * @param hql
     * @param args
     * @return
     */
    public T findUnique(String hql, Object... args) {
        return (T) createQuery(hql,"h",args).uniqueResult();
    }

    /**
     * 根据sql查询，返回单个实体
     *
     * @param hql
     * @param args
     * @return
     */
    public T findUniqueSql(String hql, Object... args) {
        return (T) createQuery(hql,"s",args).uniqueResult();
    }

    /**
     * 创建hql query
     *
     * @param queryString
     * @param args
     * @return
     */
    private Query createQuery(String queryStr,String flag, Object... args) {
        Assert.hasText(queryStr);
        Assert.hasText(flag);
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = null;
        if(flag.equals("s") || flag.equalsIgnoreCase("sql")){
            query = session.createSQLQuery(queryStr);//addEntity(entityClass)
        }
        if(flag.equals("h") || flag.equalsIgnoreCase("hql")){
            query = session.createQuery(queryStr);
        }
        if (args != null) {
            for (int i = 0,len = args.length; i < len; i++) {
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
