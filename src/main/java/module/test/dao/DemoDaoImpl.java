package module.test.dao;

import common.dao.HbiGeneraldaoImpl;
import module.test.entity.Test1;


/**
 * 测试dao
 */
public class DemoDaoImpl extends HbiGeneraldaoImpl<Test1, String> implements IDemoDao {


    @Override
    public void test()throws Exception {
//		ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml");
//		id ac.getBean("DemoDAO");
//        try {
            Test1 t = new Test1();
            t.setTid("656");
            t.setTname("玉兔");
            saveEntity(t);

            Test1 t1 = new Test1();
            t1.setTid("799");
            t1.setTname("bbf");
            saveEntity(t1);
            throw new RuntimeException("报错吧");


//            log.info("操作成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }


//    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        IDemoDao demoDao = (IDemoDao) ac.getBean("DemoDAO");
//        demoDao.test();
//    }
}
