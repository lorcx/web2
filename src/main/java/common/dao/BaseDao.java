package common.dao;

import java.util.List;
import java.util.Map;

/**
 * Mapper 基础
 * Created by x on 2017/1/8.
 */
public interface BaseDao<T> {
    int save(T t);

    int save(Map<String, Object> params);

    int saveBatch(List<T> list);

    int delete(Object t);

    int delete(Map<String, Object> params);

    T getOne(Object id);

    int update(Map<String, Object> params);

    int update(T t);

    int updateBatch(Map<String, Object> params);

    List<T> getList(Map<String, Object> params);

    List<T> getList(Object id);

    int queryTotal();

    int queryTotal(Map<String, Object> params);

    int deleteBatch(Object[] id);
}
