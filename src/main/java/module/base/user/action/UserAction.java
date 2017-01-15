package module.base.user.action;

import common.exception.ServiceException;
import module.base.user.entity.BaseUser;
import module.base.user.service.BaseUserServiceImpl;
import module.base.user.service.IBaseUserService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户
 * Created by lx on 2016/5/28.
 */
public class UserAction {
    public static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(BaseUserServiceImpl.class);
    private IBaseUserService userService;
    private BaseUser user;
    public String list(){
        return "userList";
    }

    /**
     * 查询用户列表
     * @return
     */
    public String getUserList() throws IOException {
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter pw = response.getWriter();
//        Map<String ,Object> result = new HashMap<String ,Object>();
//        Gson gson = new Gson();
//        String userName = request.getParameter("userName");
//        String nickName = request.getParameter("nickName");
//        if(null == user){
//            user = new BaseUser();
//        }
//        user.setUserName(userName);
//        user.setNickName(nickName);
//        List<BaseUser> userList = Collections.emptyList();
//        try {
//            userList = userService.getUserList(page,user);
//            result.put("list",userList);
//            result.put("page",page);
//        } catch (Exception e) {
//            LOG.error("查询用户列表失败action",e.getCause());
//            result.put("list",userList);
//        } catch (ServiceException e) {
//            LOG.error("查询用户列表失败action", e.getCause());
//            result.put("list",userList);
//        }
//        pw.print(gson.toJson(result));
//        pw.flush();
        return null;
    }

    /**
     * 个人信息
     * @return
     */
    public String userInfoEdit(){
//        try {
//            user = userService.getBaseUserInfoById(session2.get("userId").toString());
//        } catch (ServiceException e) {
//            e.printStackTrace();
//            LOG.error("查询个人信息失败action", e.getCause());
//        }
        return "userEdit";
    }

    /**
     * 保存用户信息
     * @return
     */
    public String saveUserInfo() throws IOException {
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter pw = response.getWriter();
//        Gson gson = new Gson();
//        Map<String,Object> result = new HashMap<String, Object>();
//        try {
//            userService.saveBaseUser(user);
//            updateSession();
//            result.put("nickName",user.getNickName());
//            result.put("isOk", true);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//            LOG.error(" 保存用户信息action", e.getCause());
//            result.put("isOk",false);
//        }
//        pw.print(gson.toJson(result));
//        pw.flush();
        return null;
    }

    /**
     * 更新session信息
     */
    private void updateSession(){
//        session2.put("userName", user.getUserName());//用户登录名
//        session2.put("nickName", user.getNickName());//用户昵称
//        session2.put("userId", user.getId());//用户id
    }


    public void setUserService(IBaseUserService userService) {
        this.userService = userService;
    }

    public BaseUser getUser() {
        return user;
    }

    public void setUser(BaseUser user) {
        this.user = user;
    }
}
