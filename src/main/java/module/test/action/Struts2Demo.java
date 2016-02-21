package module.test.action;

import common.action.BaseAction;
import common.exception.ServiceException;
import module.base.user.entity.BaseUser;
import module.base.user.service.IBaseUserService;
import module.test.entity.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;


/**
 * struts2测试类
 * @author dell
 *
 */
public class Struts2Demo extends BaseAction{
	private static final long serialVersionUID = 1L;
	private Test test;
	private IBaseUserService userService;

	/**
	 * 下载图片
	 *
	 */
	public String downPic(){
		String userName = request.getParameter("userName");
		response.addHeader("Content-Disposition", "attachment;filename=" + userName + ".bmp");
		try {
			BaseUser user = userService.getBaseUserInfoByName(userName);
			Blob blob = user.getPic();
			int size = (int)blob.length();
			byte[] b = blob.getBytes(1,size);
			OutputStream out = response.getOutputStream();
			out.write(b);
			out.flush();

		} catch (ServiceException e) {
			LOG.error("下载图片失败！",e);
		} catch (SQLException e) {
			LOG.error("下载图片失败！", e);
		} catch (IOException e) {
			LOG.error("下载图片失败！", e);
		}
		return null;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public void setUserService(IBaseUserService userService) {
		this.userService = userService;
	}
	
}
