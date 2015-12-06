package module.service.tree;

import common.exception.DaoException;
import common.exception.ServiceException;
import module.dao.tree.ITreeDao;
import module.entity.tree.SsfFaLocation;
import org.apache.log4j.Logger;
import java.util.List;


public class TreeServiceImpl implements ITreeService {
	private ITreeDao treeDao;
	private Logger log = Logger.getLogger(TreeServiceImpl.class);
	public void setTreeDao(ITreeDao treeDao) {
		this.treeDao = treeDao;
	}

	public List<SsfFaLocation> getBaseDate() throws ServiceException {
		try {
			return	treeDao.getBaseDate();
		} catch (DaoException e) {
			e.printStackTrace();
			log.error("获取树失败",e.getCause());
		}
		return null;
	}

 
	public SsfFaLocation getEditBase(String tid) throws ServiceException {
		SsfFaLocation location = null;
		try {
			location = treeDao.getEditBase(tid);
		} catch (DaoException e) {
			e.printStackTrace();
			log.error("获取树失败",e.getCause());
		}
		return location;
	}

	public void addBaseDate(SsfFaLocation location) throws ServiceException {
		//try {
		//	treeDao.addBaseDate(location);
		//} catch (DaoException e) {
		//	e.printStackTrace();
		//}
		
	}

}
