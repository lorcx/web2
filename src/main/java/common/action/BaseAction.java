package common.action;

import com.opensymphony.xwork2.ActionSupport;
import common.PageBean;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 基础action
 * @author lx
 *
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware,RequestAware {

	private static final long serialVersionUID = 1L;
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected HttpSession session;
	//struts2 的session
	protected Map<String, Object> session2;
	//struts2 的request
	protected Map<String, Object> request2;
	protected PageBean page = new PageBean();

	public static boolean isOk = false;//操作是否成功

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		session = request.getSession();
	}

	public void setSession(Map<String, Object> session2) {
		this.session2 = session2;
	}

	public void setRequest(Map<String, Object> request2) {
		this.request2 = request2;
	}

	public PageBean getPage() {
		return page;
	}

	public void setPage(PageBean page) {
		this.page = page;
	}
}
