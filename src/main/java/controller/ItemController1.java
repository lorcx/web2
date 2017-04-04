package controller;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 简单实现handler适配器
 * 简单的处理器适配器支持执行实现Controller接口的处理器
 * Created by lx on 2017/4/3.
 */
public class ItemController1 implements HandlerAdapter{

    @Override
    public boolean supports(Object handler) {
        return false;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return null;
    }

    @Override
    public long getLastModified(HttpServletRequest request, Object handler) {
        return 0;
    }
}
