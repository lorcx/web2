package module.action;


import common.action.BaseAction;
import module.service.IDemoService;
import org.apache.log4j.Logger;

public class DemoAction  extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(DemoAction.class);
	public IDemoService demoService;

	public String demo(){
		demoService.demo();
		request.setAttribute("user", "123");
//		log.error("abc");
		return "success";
	}

	public void setDemoService(IDemoService demoService) {
		this.demoService = demoService;
	}
}
