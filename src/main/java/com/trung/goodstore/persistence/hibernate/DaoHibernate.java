package com.trung.goodstore.persistence.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trung.goodstore.persistence.Dao;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
/**
 * 
 * @author trung dinh
 *
 */
public class DaoHibernate extends HibernateDaoSupport implements Dao {
	protected Log log = LogFactory.getLog(getClass());

	public Object getObject(Class clazz, Serializable id)
			throws DataAccessException,ObjectNotFoundException {
		log.debug("get Object");
		Object obj = this.getHibernateTemplate().get(clazz, id);
	//	System.out.println("***********************"+obj);
		if (obj == null) {
			log.error("Object not found...");
			throw new ObjectNotFoundException("Object not found.");
		}
		this.getHibernateTemplate().clear();//.evict(obj);
		return obj;

	}

	public List getObjects(Class clazz) throws DataAccessException {

		return this.getHibernateTemplate().loadAll(clazz);
	}

	public Object removeObject(Class clazz, Serializable id)
			throws DataAccessException,ObjectNotFoundException {
		Object obj = getObject(clazz, id);
		this.getHibernateTemplate().delete(obj);
		this.getHibernateTemplate().flush();
		log.debug("xoa doi tuong thuoc lop :" + clazz.getName()
				+ " , co dinh danh id");
		return obj;
	}

	public void saveObject(Object obj) throws DataAccessException {
		this.getHibernateTemplate().saveOrUpdate(obj);
		this.getHibernateTemplate().flush();
		log.debug("save or update object");
	}
	
	

}
