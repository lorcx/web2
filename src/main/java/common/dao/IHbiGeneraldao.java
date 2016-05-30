package common.dao;

import common.PageBean;

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

     T get(final PK id);

     List<T> findList(String hql,Object ... args);

     List<T> findListByPage(PageBean page, String hql, Object... values);

     T findUnique (String hql,Object ...args);
}
