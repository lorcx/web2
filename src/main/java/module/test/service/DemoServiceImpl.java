package module.test.service;


import module.test.dao.IDemoDao;

public class DemoServiceImpl implements IDemoService{

	public IDemoDao dao;
	public void demo() {
		try {
			dao.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setDao(IDemoDao dao) {
		this.dao = dao;
	}

}
