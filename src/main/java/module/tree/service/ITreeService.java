package module.tree.service;

import common.exception.ServiceException;
import module.tree.entity.SsfFaLocation;

import java.util.List;


public interface ITreeService {
	
	public List<SsfFaLocation> getBaseDate()throws ServiceException;
	
	public SsfFaLocation getEditBase(String tid)throws ServiceException;
	
	public void addBaseDate(SsfFaLocation location)throws ServiceException;
}
