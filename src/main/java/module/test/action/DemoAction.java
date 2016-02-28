package module.test.action;


import common.action.BaseAction;
import module.test.entity.Test1;
import module.test.service.IDemoService;
import org.apache.log4j.Logger;

import java.util.Map;

public class DemoAction  extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(DemoAction.class);
	public IDemoService demoService;
	public Test1 test;

	public String demo(){
		demoService.demo();
//		request.setAttribute("user", "123");
//		log.error("abc");
		return null;
	}

	/**
	 * 测试方法
	 * @return
	 */
	public String test(){
//		String a = request.getParameter("a");
//		System.out.println(test.getTname());

		/*getParameterMap 用法*/
		Map m = request.getParameterMap();
		String [] a = (String[]) m.get("a");
		System.out.println(a[1]);


		return null;
	}

	public Test1 getTest() {
		return test;
	}

	public void setTest(Test1 test) {
		this.test = test;
	}

	public void setDemoService(IDemoService demoService) {
		this.demoService = demoService;
	}
}
