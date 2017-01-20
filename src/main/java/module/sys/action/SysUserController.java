package module.sys.action;

import module.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by x on 2017/1/20.
 */
@RestController
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private ISysUserService userService;

    public R getAllUserList(){
        Map<String, Object> params = new HashMap<String, Object>();
        return R.ok().put("list", userService.queryAllList(params));
    }
}
