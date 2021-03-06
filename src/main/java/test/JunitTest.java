package test;

import module.test.service.TestService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

/**
 * Created by x on 2017/1/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class JunitTest {
    @Autowired
    private TestService testService;

    @org.junit.Test
    public void getListTest() {
        List list = testService.getAllRecord();
        for (Object t : list) {
            System.out.println(((module.test.entity.Test)t).getTid());
        }
    }
}
