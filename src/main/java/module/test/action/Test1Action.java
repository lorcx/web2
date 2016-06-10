package module.test.action;

import common.action.BaseAction;
import module.test.service.ITest1Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lx on 2016/1/31.
 */
public class Test1Action extends BaseAction{
    public ITest1Service test1Service;


    public String commonTest(){
        test1Service.test();
        return null;
    }

    public String test(){
//        test1Service.test();
        return null;
    }

    public static void main(String[] args) {
        System.out.println(1);
        // 测试commondao
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ITest1Service service = (ITest1Service) ac.getBean("test1Service");
        service.test();

    }




    public void setTest1Service(ITest1Service test1Service) {
        this.test1Service = test1Service;
    }
}
