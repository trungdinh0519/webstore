package com.trung.goodstore.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.trung.goodstore.persistence.Dao;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
import com.trung.goodstore.service.Manager;



/**
 * @author Trung Fullname:Nguyen Dinh Trung e-mail:trungnd07@gmail.com
 */
public class ManagerImpl implements Manager {
	protected Log log = LogFactory.getLog(this.getClass());

	protected Dao dao;

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public Object getObject(Class clazz, Serializable id)
			throws DataAccessException, ObjectNotFoundException {
		Object obj = dao.getObject(clazz, id);
		return obj;
	}

	public List getObjects(Class clazz) throws DataAccessException {

		return dao.getObjects(clazz);
	}

	public Object removeObject(Class clazz, Serializable id)
			throws DataAccessException {
		return dao.removeObject(clazz, id);
	}

	public void saveObject(Object obj) throws DataAccessException {
		dao.saveObject(obj);
	}

}
