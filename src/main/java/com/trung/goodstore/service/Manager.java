package com.trung.goodstore.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.trung.goodstore.persistence.Dao;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;

/**
 * @author Trung Fullname:Nguyen Dinh Trung  e-mail:trungnd07@gmail.com 
 * common interface manager
 */
public interface Manager {
	public void setDao(Dao dao);
	public Object getObject(Class clazz,Serializable id) throws DataAccessException;
	public List getObjects(Class clazz) throws DataAccessException,ObjectNotFoundException ;
	public Object removeObject(Class clazz,Serializable id)  throws DataAccessException;
	public void saveObject(Object obj) throws DataAccessException;
}
