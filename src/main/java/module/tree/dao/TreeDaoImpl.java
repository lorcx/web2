package module.tree.dao;

import common.exception.DaoException;
import module.tree.entity.SsfFaLocation;
import org.apache.log4j.Logger;
import java.math.BigDecimal;
import java.util.List;

public class TreeDaoImpl implements ITreeDao{

	private Logger log = Logger.getLogger(TreeDaoImpl.class);

	public List<SsfFaLocation> getBaseDate() throws DaoException {
//		StringBuilder sb = new StringBuilder();
//		sb.append(" select * from Ssf_Fa_Location t");
//		List<SsfFaLocation> list;
//		try{
//			list = findListBySql(sb.toString());
//		}catch (Exception e) {
//			e.printStackTrace();
//			log.error("获取树失败",e.getCause());
//			throw new DaoException();
//		}
		return null;
	}


	public SsfFaLocation getEditBase(String tid) throws DaoException {
//		StringBuilder sb = new StringBuilder();
//		sb.append(" select * from ssf_fa_location t where id =? ");
//		Session session = getSession();
//		SQLQuery q = session.createSQLQuery(sb.toString());
//		q.setBigDecimal(0, new BigDecimal(tid.trim()));
//		q.addEntity(SsfFaLocation.class);
//		return (SsfFaLocation) q.uniqueResult();
		return null;
	}


	@Override
	public void addBaseDate(SsfFaLocation location) throws DaoException {
//		Session session = getSession();
//		try{
//			session.save(location);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		Transaction tr = session.beginTransaction();
//		tr.commit();
	}

}
