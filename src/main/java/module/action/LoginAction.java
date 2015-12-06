package module.action;

import common.action.BaseAction;
import org.apache.log4j.Logger;
import util.verification;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

@SuppressWarnings("all")
public class LoginAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(LoginAction.class);
	private HttpServletRequest request;
	private HttpServletResponse response;
	private verification verification;//验证码工具类


	/**
	 * 验证码
	 * @return
	 */
	public String yzm1()throws Exception{
		response.setCharacterEncoding("UTF-8");
		//System.out.println(""+num1+""+operate[oper]+""+num2+"="+result);
		Object[] obj = verification.RandomCount();//验证码
		//将验证结果放大session中，在登陆时验证
		request.getSession().setAttribute("result", obj[0]);
		OutputStream out = response.getOutputStream();
		ImageIO.write((BufferedImage)obj[1], "JPEG", out);
		out.close();
		return null;
	}

	/**
	 * 随机颜色
	 * @param a
	 * @param b
	 * @return
	 */
	public Color getRandomColor(int a,int b) {
		Random random = new Random();
		a = a > 255 ? 255 : a;
		b = b > 255 ? 255 : b;
		int red = a + random.nextInt(b - a);
		int blue = a + random.nextInt(b - a);
		int green = a + random.nextInt(b - a);

		return new Color(red,green,blue);
	}


	public void setVerification(verification verification) {
		this.verification = verification;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

}
