package common.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by x on 2017/1/8.
 */
public interface BaseDao<T> {
    void save(T t);

    void save(Map<String, Object> params);

    void saveBatch(List<T> list);

    int delete(T t);

    int delete(Map<String, Object> params);

    T getOne(Object id);

    int update(Map<String, Object> params);

    int update(T t);

    int updateBatch(List<T> list);

    List<T> getList(Map<String, Object> params);

    List<T> getList(Object id);

    int queryTotal();

    int queryTotal(Map<String, Object> params);
}
