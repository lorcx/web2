package module.login.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.R;
import util.ShiroUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 登录
 * Created by lx on 2017/1/28.
 */
@Controller
public class LoginController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Producer producer;

    @RequestMapping(value = "captcha.jpg")
    public void captcha(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Cache-Control", "no-store, no-cache");
        resp.setContentType("image/jpeg");

        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);

        req.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        OutputStream out = resp.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    /**
     * 登录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    public R login(String username, String password, String captcha) {
        logger.info(username + '-' + password + '-' + captcha);
        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if (!captcha.equalsIgnoreCase(kaptcha)) {
            return R.error("验证码不正确");
        }

        try {
            Subject subject = ShiroUtils.getSubject();
            password = new Sha256Hash(password).toHex();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error(e.getMessage());
        } catch (LockedAccountException e) {
            return R.error(e.getMessage());
        } catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }

        return R.ok();
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:login.html";
    }
}
