package test;

import common.dao.HbiGeneraldaoImpl;
import module.entity.test.*;

import java.util.List;

/**
 * 公共dao测试类
 * Created by lx on 2016/1/31.
 */
@SuppressWarnings("all")
public class CommonDaoTestImpl extends HbiGeneraldaoImpl<Test1,String > implements ICommonDaoTest  {

    public void test(){
        Test1 t = new Test1();
        t.setTid("203");
        t.setTname("1111111c");
//        saveEntity(t);
        Test1 t2 = get("203");
//        System.out.println(t2.getTname());
        StringBuilder hql = new StringBuilder("from Test1 where id = ?");
        String args[] = {"123"};
        List list = find(hql.toString(),args);
        System.out.println(list.size());

//        delEntity(t);
    }

}
