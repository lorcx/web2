package common.dao;

import common.PageBean;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 通用hbernate dao
 * http://my.oschina.net/boonya/blog/290587
 * Created by dell on 2016/1/28.
 */
@SuppressWarnings("unchecked")
public class HbiGeneraldaoImpl<T,PK extends Serializable> extends HibernateDaoSupport implements IHbiGeneraldao<T,PK> {

    protected Logger log = Logger.getLogger(HbiGeneraldaoImpl.class);
    protected SessionFactory sessionFactory;
    protected Session session;
    protected Class<?> entityClass;

    public HbiGeneraldaoImpl() {
        this.entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public HbiGeneraldaoImpl(SessionFactory sessionFactory,Class<T> entityClass) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
    }


    /**
     * 保存
     * @param o
     */
    public void saveEntity(Object o) {
        Assert.notNull(o);
        getHibernateTemplate().saveOrUpdate(o);
        log.info("save entity:"+o);
    }

    /**
     * 删除
     * @param o
     */
    public void delEntity(Object o) {
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

    public T get(final PK id) {
        Assert.notNull(id);
        return (T)getHibernateTemplate().get(entityClass,id);
    }

    public List find(String hql, Object... args) {
        return createQuery(hql,args).list();
    }

    public PageBean find(PageBean page, String hql, Object... values){
        Assert.notNull(page);
        Query query = createQuery(hql,values);
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
        return null;
    }

    public PageBean findByCriteria(PageBean page, Criterion... criterions) {
        return null;
    }

    public List<T> findByProperty(String property, Object value) {
        return null;
    }

    public T findUniqueByProperty(String property, Object value) {
        return null;
    }

    public Query createQuery(String queryString, Object... args) {
        return null;
    }

    public Criteria createCriteria(Criterion... criterions) {
        return null;
    }

    public boolean isPropertyUnique(String propertyName, Object newValue, Object orgValue) {
        return false;
    }

    public int countQueryResult(PageBean page, Criteria c) {
        return 0;
    }
}
