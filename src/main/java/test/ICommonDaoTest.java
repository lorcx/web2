package test;

import common.dao.IHbiGeneraldao;
import module.entity.test.Test1;

/**
 * Created by lx on 2016/1/31.
 */
public interface ICommonDaoTest extends IHbiGeneraldao<Test1,String > {
    void test();
}
