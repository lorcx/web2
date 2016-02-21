package module.tree.dao;

import common.exception.DaoException;
import module.tree.entity.SsfFaLocation;
import java.util.List;


public interface ITreeDao {

	public List<SsfFaLocation> getBaseDate() throws DaoException;

	public SsfFaLocation getEditBase(String tid)throws DaoException;
	
	public void addBaseDate(SsfFaLocation location)throws DaoException;

}
