package module.study.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * spring mvc 全局异常处理
 * Created by lx on 2017/4/3.
 */
@ControllerAdvice
public class ContollerExcetionHandler {
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        System.out.println("全局异常处理");
        return mav;
    }
}
