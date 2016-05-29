package module.base.user.action;

import com.google.gson.Gson;
import common.action.BaseAction;
import common.exception.ServiceException;
import module.base.user.entity.BaseUser;
import module.base.user.service.BaseUserServiceImpl;
import module.base.user.service.IBaseUserService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户
 * Created by lx on 2016/5/28.
 */
@SuppressWarnings("unused")
public class UserAction extends BaseAction{
    private static final Logger LOG = Logger.getLogger(BaseUserServiceImpl.class);
    private IBaseUserService userService;
    private BaseUser user = new BaseUser();

    public String list(){
        return "userList";
    }

    /**
     * 查询用户列表
     * @return
     */
    public String getUserList() throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        Map result = new HashMap();
        Gson gson = new Gson();
        String userName = request.getParameter("userName");
        String nickName = request.getParameter("nickName");
        user.setUserName(userName);
        user.setNickName(nickName);
        try {
            List<BaseUser> userList = userService.getUserList(page,user);
            result.put("list",userList);
            result.put("page",page);
        } catch (Exception e) {
            LOG.error("查询用户列表失败action",e.getCause());
            result.put("list",null);
        } catch (ServiceException e) {
            LOG.error("查询用户列表失败action", e.getCause());
            result.put("list",null);
        }
        pw.print(gson.toJson(result));
        pw.flush();
        return null;
    }

    public void setUserService(IBaseUserService userService) {
        this.userService = userService;
    }
}
