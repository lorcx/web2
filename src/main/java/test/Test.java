package test;


import org.apache.log4j.Logger;

/**
 * Created by dell on 2016/1/28.
 */
public class Test extends  ParentTest{
    static Logger log = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        System.out.println(1);
//        new Test();
//        Object obj = null;
//         Assert.notNull(obj);
//        Assert.hasText("","不能为空");
//        log.info("save失败");

//        List list = new ArrayList();


    }
}

class ParentTest{
    public ParentTest() {
        System.out.println(2);
        getClass();

    }
}