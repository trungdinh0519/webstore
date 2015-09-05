package com.trung.goodstore.persistence;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.trung.goodstore.persistence.exception.ObjectNotFoundException;


public interface Dao {
	public Object getObject(Class clazz, Serializable id) throws DataAccessException,ObjectNotFoundException;
	public List getObjects(Class clazz) throws DataAccessException ;
	public Object removeObject(Class clazz, Serializable id)  throws DataAccessException,ObjectNotFoundException;
	public void saveObject(Object obj) throws DataAccessException;

}
