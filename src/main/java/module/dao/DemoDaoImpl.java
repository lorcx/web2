package module.dao;

import module.entity.Test;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;




public class DemoDaoImpl extends HibernateDaoSupport implements IDemoDao {

	@Override
	public void demo() {
		Session session = getSession();
		Test t = (Test) session.get(Test.class, "1");
		if(t != null)
			System.out.println(t.getTname());
	}

}
