package module.service;


import module.dao.IDemoDao;

public class DemoServiceImpl implements IDemoService{

	public IDemoDao dao;
	public void demo() {
		dao.demo();
	}
	public void setDao(IDemoDao dao) {
		this.dao = dao;
	}

}
