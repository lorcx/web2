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
     void saveEntity(T t);

     void delEntity(T t);

     void delById(PK p);

     List<T> findAll();

     PageBean findAll(PageBean p);

     T get(final PK id);

     List<T> findList(String hql,Object ... args);

     PageBean find(PageBean page, String hql, Object... values);

     T findUnique (String hql,Object ...args);

     List<T> findCriteria(Criterion... criterions);

     PageBean findByCriteria(PageBean page,Criterion... criterions);

     List<T> findByProperty(String property,Object value);

     T findUniqueByProperty(String property,Object value);

     boolean isPropertyUnique(String propertyName,Object newValue,Object orgValue);

     int countQueryResult(PageBean page,Criteria c);
}
