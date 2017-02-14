package module.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面控制器
 * Created by Administrator on 2017/2/14 0014.
 */
@Controller
public class SysPageController {

    /**
     * 重定向到制定页面
     * @return
     */
    @RequestMapping("/{module}/**/{url}.html")
    public String gotoPage(@PathVariable("url") String url, @PathVariable String module) {
        return "/" + module + "/" + url +".html";
    }
}
