package module.service.tree;

import common.exception.ServiceException;
import module.entity.tree.SsfFaLocation;

import java.util.List;


public interface ITreeService {
	
	public List<SsfFaLocation> getBaseDate()throws ServiceException;
	
	public SsfFaLocation getEditBase(String tid)throws ServiceException;
	
	public void addBaseDate(SsfFaLocation location)throws ServiceException;
}
