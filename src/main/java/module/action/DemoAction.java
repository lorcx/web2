package module.action;


import common.action.BaseAction;
import module.entity.test.Test1;
import module.service.IDemoService;
import org.apache.log4j.Logger;

public class DemoAction  extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(DemoAction.class);
	public IDemoService demoService;
	public Test1 test;

	public String demo(){
		demoService.demo();
		request.setAttribute("user", "123");
//		log.error("abc");
		return "success";
	}

	public String test(){
//		String testName = request.getParameter("");
		System.out.println(test.getTname());
		

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
