package common.dao;

import common.PageBean;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2016/1/28.
 */
@SuppressWarnings("all")
public interface IHbiGeneraldao<T,PK extends Serializable> {
    public void saveEntity(T t);

    public void delEntity(T t);

    public void delById(PK p);

    public List<T> findAll();

    public PageBean findAll(PageBean p);

    public T get(final PK id);

    public List find(String hql,Object ... args);

    public PageBean find(PageBean page, String hql, Object... values);

    public T findUnique (String hql,Object ...args);

    public List<T> findCriteria(Criterion... criterions);

    public PageBean findByCriteria(PageBean page,Criterion... criterions);

    public List<T> findByProperty(String property,Object value);

    public T findUniqueByProperty(String property,Object value);

    public boolean isPropertyUnique(String propertyName,Object newValue,Object orgValue);

    public int countQueryResult(PageBean page,Criteria c);
}
