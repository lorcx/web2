package module.dao.tree;

import common.exception.DaoException;
import module.entity.tree.SsfFaLocation;
import java.util.List;


public interface ITreeDao {

	public List<SsfFaLocation> getBaseDate() throws DaoException;

	public SsfFaLocation getEditBase(String tid)throws DaoException;
	
	public void addBaseDate(SsfFaLocation location)throws DaoException;

}
