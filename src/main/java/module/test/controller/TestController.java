package module.test.controller;

import common.controller.BaseController;
import module.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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


    /**
     * sping mvc 跳转方式一
     * 使用HttpServletResponse 重定向到另一个视图(其他不变 )
     */
    @RequestMapping("/redirect")
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("进入....................");
        resp.sendRedirect("/test.jsp");
    }

    /**
     * 直接返回jsp页面的名称（无渲染器）
     *
     */
    @RequestMapping("/str")
    public String hello() {
        return "/test.jsp";
    }

    /**
     * 直接返回jsp页面的名称（无渲染器）
     *
     */
    @RequestMapping("/str1")
    public String hello1() {
//        return "forward:/test.jsp";
        return "redirect:/test.jsp";
    }

    /**
     * 直接返回jsp页面的名称（有渲染器）
     *
     */
    @RequestMapping(value = "/str2", method = RequestMethod.GET)
    @ResponseBody
    public String hello2() {
//        return "forward:/test.jsp";
        return "redirect:/test";
    }


    /**
     * ModelAndView返回
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/mav")
    @ResponseBody
    public ModelAndView handlerRequset1(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "hello");
        mav.setViewName("test");
        return mav;
    }
}
