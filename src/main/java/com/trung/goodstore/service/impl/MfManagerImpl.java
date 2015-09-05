package com.trung.goodstore.service.impl;

import com.trung.goodstore.persistence.MfDao;
import com.trung.goodstore.service.MfManager;

public class MfManagerImpl extends ManagerImpl implements MfManager {
	private MfDao mfDao;
	
	/**
	 * @param mfDao the mfDao to set
	 */
	public void setMfDao(MfDao mfDao) {
		this.mfDao = mfDao;
	}

	/* (non-Javadoc)
	 * @see com.trung.goodstore.service.MfManager#delete(java.lang.String)
	 */
	public void delete(String id) {
		 mfDao.removeManufacturer(new Long(id));
		
	}

	

}
