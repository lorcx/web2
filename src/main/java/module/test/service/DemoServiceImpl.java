package module.test.service;


import module.test.dao.IDemoDao;
import module.test.entity.Test1;

public class DemoServiceImpl implements IDemoService{

	public IDemoDao dao;
	public void demo() throws Exception{

			Test1 t = new Test1();
			t.setTid("2");
			t.setTname("a");
			dao.test(t);
//			System.out.println(1/0);
//			Test1 t1 = new Test1();
//			t1.setTid("2");
//			t1.setTname("b");
//			dao.test(t1);
//			throw new RuntimeException("error");

	}
	public void setDao(IDemoDao dao) {
		this.dao = dao;
	}

}
