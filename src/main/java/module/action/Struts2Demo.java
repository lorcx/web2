package module.action;

import com.opensymphony.xwork2.ActionSupport;
import module.entity.Test;


/**
 * struts2测试类
 * @author dell
 *
 */
public class Struts2Demo extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Test test;
	
	public String test1(){
		test.setTid("111");
		test.setTname("bbbb");
//		request.setAttribute("msg", "success");
		return "test1";
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	
}
