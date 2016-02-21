package module.login.action;

import com.google.gson.Gson;
import common.action.BaseAction;
import common.exception.ServiceException;
import module.base.user.entity.BaseUser;
import module.login.service.ILoginService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import util.verification;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
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
        return "login";
    }

    /**
     * 验证码
     * @return
     */
    public String yzm()throws Exception{
        response.setCharacterEncoding("UTF-8");
//        response.reset();
//        response.setHeader("content-type", "image/jpeg");
        Object[] obj = verification.RandomCount();//验证码 0 结果 1图片

        //结果加到cookie   要先放到response中的cookie 在放到流中
        Cookie cookie = new Cookie("captcha", obj[0].toString());
        cookie.setMaxAge(3600);//失效时间
        cookie.setPath("/");
        response.addCookie(cookie);

        //写入到流
        OutputStream out = response.getOutputStream();
        ImageIO.write((BufferedImage) obj[1], "JPEG", out);
        out.flush();
//        out.close();//系统自动关闭
        return null;
    }

    /**
     * 登陆
     * @return
     */
    public String login() throws IOException {
        response.setCharacterEncoding("utf-8");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("captcha");//验证码
        Map<String,Object> results = new HashMap<String,Object>();
        //检查验证码
        validateYZM(captcha,results);

        try {
            if(isOk){//验证码通过
                results = loginService.login(userName,password);
                isOk = (Boolean)results.get("isOk");
                if(isOk){
                    setSessionInfo(results);//设置登陆session信息
                }else {
                    results.put("msg","用户名或密码错误，请重新输入！");
                }
            }
            results.put("isOk",isOk);
            Gson gson = new Gson();
            String maps = gson.toJson(results);
            response.getWriter().print(maps);
//            request.setAttribute("isOk",results.get("isOk"));
//            request.setAttribute("baseUser",results.get("BaseUser"));
        } catch (ServiceException e) {
            log.error("登陆失败！ 用户 ："+userName, e.getCause());
        }
        return null;
    }

    /**
     * 检查验证码
     */
    private void validateYZM(String captcha,Map<String,Object> results){
        Cookie[] cookies = request.getCookies();
        for(Cookie ck : cookies){
            if(StringUtils.isNotEmpty(ck.getName()) && ck.getName().equals("captcha")){ //获取cookie中的验证码信息
                if(StringUtils.isEmpty(captcha) || !captcha.equals(ck.getValue())){//验证码不正确
                    results.put("msg","验证码不正确，请重新输入！");
                }else {
                    isOk = true;
                }
            }else{
                results.put("msg","验证码不正确，请重新输入！");
            }
        }
    }

    /**
     * 设置登陆session信息
     */
    private void setSessionInfo(Map<String,Object> map){
        BaseUser user = (BaseUser) map.get("BaseUser");
        if(null != user){
//            session2.put("userName", user.getUserName());//用户登录名
//            session2.put("nickName", user.getNickname());//用户昵称
            session2.put("userInfo",user);
        }
    }


    /**
     * 跳转到主页
     * @return
     */
    public String toMain(){
        BaseUser user = (BaseUser) session2.get("userInfo");
        request.setAttribute("baseUser",user);
        return "main";
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
