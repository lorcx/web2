package module.test.dao;

import common.dao.HbiGeneraldaoImpl;
import module.test.entity.Test1;


/**
 * 测试dao
 */
public class DemoDaoImpl extends HbiGeneraldaoImpl<Test1, String> implements IDemoDao {


    @Override
    public void test(Test1 t) throws Exception {
//		ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml");
//		id ac.getBean("DemoDAO");
//      StringBuilder sql = new StringBuilder();
//      BaseUser b = new BaseUser();
//      b.setUserName("admin");
//      get("1");
//        sql.append("from BaseUser b where b.userName = ?");
//        b = findUnique(sql.toString(),b);
//        try {
//
        findByCriteria(null);
//        countQueryResult(null,);
//        List<Test1> list = findAll();
//        for(Test1 t1 : list){
//            System.out.println(t1.getTname());
//            System.out.println(t1.getTid());
//        }
//        saveEntity(t);
//        delEntity(t);
//        delById("1");
////            log.info("操作成功");
//       } catch (Exception e) {
//          e.printStackTrace();
//        }

    }


//    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        IDemoDao demoDao = (IDemoDao) ac.getBean("DemoDAO");
//        demoDao.test();
//    }
}
