package common.dao;

import common.PageBean;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 通用hbernate dao
 * http://my.oschina.net/boonya/blog/290587
 *
 * http://my.oschina.net/moson/blog/518659
 * Created by dell on 2016/1/28.
 */
@SuppressWarnings("unused")
public class HbiGeneraldaoImpl<T,PK extends Serializable> extends HibernateDaoSupport {

    protected Logger log = Logger.getLogger(HbiGeneraldaoImpl.class);
//    protected SessionFactory sessionFactory;
    protected Session session;
    protected Class<?> entityClass;

    public HbiGeneraldaoImpl() {
        //(ParameterizedType)getClass().getGenericSuperclass() 取的是<T,pk> 中的类型 [0] T [1] Pk
        this.entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public HbiGeneraldaoImpl(SessionFactory sessionFactory,Class<T> entityClass) {
//        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
    }


    /**
     * 保存
     * @param
     */
    public void saveEntity(T o) {
        Assert.notNull(o);
        getHibernateTemplate().saveOrUpdate(o);
        log.info("save entity:"+o);
    }

    /**
     * 删除
     * @param
     */
    public void delEntity(T o) {
        Assert.notNull(o);
        getHibernateTemplate().delete(o);
        log.info("delEntity:"+o);
    }

    public void delById(PK p) {
        Assert.notNull(p);
        delEntity(get(p));
    }

    public List<T> findAll() {
        return findCriteria();
    }

    public PageBean findAll(PageBean p) {
        return findByCriteria(p);
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    public T get(final PK id) {
        Assert.notNull(id);
        return (T)getHibernateTemplate().get(entityClass,id);
    }

    public List find(String hql, Object... args) {
        return createQuery(hql,args).list();
    }

    public PageBean find(PageBean page, String hql, Object... values){
        Assert.notNull(page);
        Query query = createQuery(hql, values);
//        query.setFirstResult();
//        query.setMaxResults();
        return page;
    }

    public T findUnique(String hql, Object... args) {
        return (T)createQuery(hql,args).uniqueResult();
    }

    public int findInt(String hql, Object... args) {
        return (Integer)findUnique(hql,args);
    }

    public Long findLong(String hql, Object... args) {
        return (Long)findUnique(hql,args);
    }

    public List<T> findCriteria(Criterion... criterions) {
        return createCriteria(criterions).list();
    }

    public PageBean findByCriteria(PageBean page, Criterion... criterions) {
        Assert.notNull(page);
        Criteria criteria = createCriteria(criterions);

        page.setTotalNum(countQueryResult(page,criteria));

        criteria.setFirstResult(1);
        criteria.setMaxResults(page.getTotalPageNum());

        return null;
    }

    public List<T> findByProperty(String property, Object value) {
        Assert.hasText(property);
        return createCriteria(Restrictions.eq(property,value)).list();
    }

    public T findUniqueByProperty(String property, Object value) {
        Assert.hasText(property);
        return (T)createCriteria(Restrictions.eq(property,value)).uniqueResult();
    }

    public Query createQuery(String queryString, Object... args) {
        Assert.hasText(queryString);
        Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
        if(args != null){
            for(int i = 0;i < args.length;i++){
                query.setParameter(i,args[i]);
            }
        }
        return query;
    }

    public Criteria createCriteria(Criterion... criterions) {
        Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(entityClass);
        for(Criterion cr : criterions){
            c.add(cr);
        }
        return c;
    }

    public boolean isPropertyUnique(String propertyName, Object newValue, Object orgValue) {
        if (newValue == null || newValue.equals(orgValue))
            return true;

        Object object = findUniqueByProperty(propertyName, newValue);
        return (object == null);
    }

    public int countQueryResult(PageBean page, Criteria c) {
        CriteriaImpl crimpl = (CriteriaImpl)c;
        Projection proj = crimpl.getProjection();
        ResultTransformer rtf = crimpl.getResultTransformer();
        List<CriteriaImpl.OrderEntry> list = null;
        return 0;
    }
}
