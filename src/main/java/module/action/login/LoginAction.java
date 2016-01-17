package module.action.login;

import common.action.BaseAction;
import common.exception.ServiceException;
import module.entity.base.BaseUser;
import module.service.login.ILoginService;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import util.verification;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Map;

/**
 *  登陆
 * Created by lx on 2015/12/25.
 */
@SuppressWarnings("all")
public class LoginAction extends BaseAction{
    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(LoginAction.class);
    private util.verification verification;//验证码工具类
    private ILoginService loginService;

    /**
     * 进入登陆页面
     * @return
     */
    public String init(){
        System.out.println(ServletActionContext.getRequest().getSession());
        return "login";
    }

    /**
     * 验证码
     * @return
     */
    public String yzm()throws Exception{
        response.setCharacterEncoding("UTF-8");
        //System.out.println(""+num1+""+operate[oper]+""+num2+"="+result);
        Object[] obj = verification.RandomCount();//验证码
        //将验证结果放大session中，在登陆时验证
        request.getSession().setAttribute("result", obj[0]);
        OutputStream out = response.getOutputStream();
        ImageIO.write((BufferedImage) obj[1], "JPEG", out);
        out.flush();
        out.close();
        return null;
    }

    /**
     * 登陆
     * @return
     */
    public String login(){
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean isOk = false;
        try {
            Map<String,Object> map = loginService.login(userName,password);
            isOk = (Boolean)map.get("isOk");
            setSessionInfo(map);
            request.setAttribute("baseUser", map.get("BaseUser"));
        } catch (ServiceException e) {
            log.error("登陆失败！ 用户 ："+userName, e);
        }
        return isOk ? SUCCESS : ERROR;
    }

    /**
     * 设置登陆session信息
     */
    private void setSessionInfo(Map<String,Object> map){
        BaseUser user = (BaseUser) map.get("BaseUser");
        session = ServletActionContext.getRequest().getSession();
        if(null != user){
            session.setAttribute("userName",user.getUserName());//用户登录名
            session.setAttribute("nickName",user.getNickname());//用户昵称
        }
    }

    /**
     * 获取用户的图片信息
     * @return
     */
    public String getUserPic(){
        
        return null;
    }

    public void setVerification(verification verification) {
        this.verification = verification;
    }
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }
}
