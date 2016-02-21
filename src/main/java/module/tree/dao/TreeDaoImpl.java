package module.tree.dao;

import common.exception.DaoException;
import module.tree.entity.SsfFaLocation;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.math.BigDecimal;
import java.util.List;

public class TreeDaoImpl extends HibernateDaoSupport implements ITreeDao{

	//	private Session session = getSession();
	private Logger log = Logger.getLogger(TreeDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<SsfFaLocation> getBaseDate() throws DaoException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from ssf_fa_location t　start with pid=0 connect by prior id = pid ");
		//	 sb.append(" where t.id = t1.pid ");
		Session session = getSession();
		SQLQuery q = session.createSQLQuery(sb.toString());
		q.addEntity(SsfFaLocation.class);
		List<SsfFaLocation> list = null;
		try{
			list = q.list();
		}catch (Exception e) {
			e.printStackTrace();
			log.error("获取树失败",e.getCause());
			throw new DaoException();
		}
		return list;
	}


	public SsfFaLocation getEditBase(String tid) throws DaoException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from ssf_fa_location t where id =? ");
		Session session = getSession();
		SQLQuery q = session.createSQLQuery(sb.toString());
		q.setBigDecimal(0, new BigDecimal(tid.trim()));
		q.addEntity(SsfFaLocation.class);
		return (SsfFaLocation) q.uniqueResult();
	}


	@Override
	public void addBaseDate(SsfFaLocation location) throws DaoException {
		Session session = getSession();
		try{
			session.save(location);
		}catch (Exception e) {
			e.printStackTrace();
		}
		Transaction tr = session.beginTransaction();
		tr.commit();
	}

}
