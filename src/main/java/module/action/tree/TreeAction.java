package module.action.tree;

import common.action.BaseAction;
import common.exception.ServiceException;
import module.entity.tree.SsfFaLocation;
import module.service.tree.ITreeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class TreeAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(TreeAction.class);
	private ITreeService treeService;
	private SsfFaLocation location;

	public SsfFaLocation getLocation() {
		return location;
	}

	public void setLocation(SsfFaLocation location) {
		this.location = location;
	}

	public void setTreeService(ITreeService treeService) {
		this.treeService = treeService;
	}

	public String test(){
		String s1 = "{id:1, pId:0, name:\"test1\" , open:true}";
		String s2 = "{id:2, pId:1, name:\"test2\"}";
		String s3 = "{id:3, pId:1, name:\"test3\"}";
		String s4 = "{id:4, pId:2, name:\"test4\"}";
		List<String> lstTree = new ArrayList<String>();
		lstTree.add(s1);
		lstTree.add(s2);
		lstTree.add(s3);
		lstTree.add(s4);
		//利用Json插件将Array转换成Json格式
		try {
			JSONArray ja = new JSONArray();
			ja.fromObject(lstTree).toString();
			response.getWriter().print(JSONArray.fromObject(lstTree).toString());
		} catch (IOException e) {
			e.printStackTrace();
			log.error("初始化ztree出错",e.getCause());
		}
		return null;
	}

	/**
	 * 初始化树
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public String getBaseDate() throws Exception{
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw =  response.getWriter();
		JSONArray ja = new JSONArray();
		List<SsfFaLocation> list = null;
		List treeList = new ArrayList();
		try {
			list = treeService.getBaseDate();
			treeList.add("{id:0, pId:-1, name:\"所有地区\", loc_level : 0}");
			for (SsfFaLocation sf : list) {
				treeList.add("{id:" + sf.getId() + ", pId:" + sf.getPid() + ", name:'" + sf.getName() + "',loc_level : "+sf.getLocLevel()+"}");
			}
			if(list != null && list.size() > 0){
				pw.print(ja.fromObject(treeList));
			}

		} catch (ServiceException e) {
			e.printStackTrace();
			pw.print(ja);
			log.error("获取树失败",e.getCause());
		}
		return null;
	}

	/**
	 * 表单页面
	 * @return
	 */
	public String editBaseData(){
		String level = request.getParameter("level");
		String tid = request.getParameter("tid");
	//	try {
			//location = treeService.getEditBase(tid);

	//	} catch (ServiceException e) {
	//		e.printStackTrace();
	//		log.error("获取表单失败",e.getCause());
	//	}
		request.setAttribute("level", level);
		request.setAttribute("tid", tid);
		//request.setAttribute("locLevel",location.getLocLevel().toString());
		return "edit";
	}

	@SuppressWarnings("all")
	public String addBaseDate() throws Exception{
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw =  response.getWriter();
		location.setId(new BigDecimal(5000));
		location.setPid(new BigDecimal(156));
		location.setLocLevel(new BigDecimal(2));
		location.setLocPath(",156,5000,");
		JSONObject json = JSONObject.fromObject(location);
		pw.print(json);
		//try {
		//treeService.addBaseDate(location);
		//	} catch (ServiceException e) {
//			e.printStackTrace();
		//	}
		return null;
	}
}
