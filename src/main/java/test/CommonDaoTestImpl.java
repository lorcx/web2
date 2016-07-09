package test;

import common.dao.HbiGeneraldaoImpl;
import module.test.entity.Test1;

/**
 * 公共dao测试类
 * Created by lx on 2016/1/31.
 */
@SuppressWarnings("all")
public class CommonDaoTestImpl extends HbiGeneraldaoImpl<Test1,String > implements ICommonDaoTest  {

    public void test(){
//        Test1 t = new Test1();
//        t.setTid("203");
//        t.setTname("1111111c");
////        saveEntity(t);
//        Test1 t2 = get("203");
//        System.out.println(t2.getTname());
//        StringBuilder hql = new StringBuilder("select new map(u.id as id,u.nickName as nickName,u.userName as userName,u.creDate as creDate) from BaseUser u");
//        long n = getDataTotal("select distinct nickName,userName from BaseUser",null);
//        System.out.println(n);
//        Object count = findUnique(hql.toString());
//        System.out.println("============="+count);
//        List list = find(hql.toString(),args);
//        System.out.println(list.size());

//        delEntity(t);
    }

    /**
     * 将hql语句生成对应的count hql
     * @return orignalHql 原来的hql
     */
    private String toCountHql (StringBuilder orignalHql){
        String queryParam = orignalHql.substring(orignalHql.indexOf("select"),orignalHql.indexOf("from"));
        System.out.println(queryParam);
        return "";
    }


}
