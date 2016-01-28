package test;


import org.apache.log4j.Logger;
import org.springframework.util.Assert;

/**
 * Created by dell on 2016/1/28.
 */
public class Test {
    static Logger log = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        Object obj = null;
         Assert.notNull(obj);
//        Assert.hasText("","不能为空");
        log.info("save失败");
    }
}
