package module.test.controller;

import common.controller.BaseController;
import module.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * 测试框架搭建
 * Created by x on 2017/1/5.
 */
//定义访问的URL
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    // 无需set方法
    @Autowired
    private TestService testService;

    /**
     * 获取所有记录
     *
     * @return
     */
    @RequestMapping("/list")
    public void getAllRecord() {
        List list = testService.getAllRecord();
        logger.info(list.toString());
    }

}
