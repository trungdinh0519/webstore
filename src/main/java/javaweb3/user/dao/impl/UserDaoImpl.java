/**
 * 
 */
package javaweb3.user.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javaweb3.user.dao.UserDao;
import javaweb3.user.model.User;

/**
 * @author admin
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javaweb3.user.dao.UserDao#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String username) {

		@SuppressWarnings("rawtypes")

		List users = getHibernateTemplate().find("from User where username=?", username);

		if (users != null && !users.isEmpty()) {
			return (User) users.get(0);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javaweb3.user.dao.UserDao#findAllUser()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUser() {
		List<User> users = (List<User>) getHibernateTemplate().find("from User");

		return users;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javaweb3.user.dao.UserDao#isExist(java.lang.String)
	 */
	@Override
	public boolean isExist(String username) {

		@SuppressWarnings("rawtypes")
		List users = getHibernateTemplate().find("from User where username=?", username);
		if (users == null || users.isEmpty()) {
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javaweb3.user.dao.UserDao#saveUser(javaweb3.user.model.User)
	 */
	@Override
	public void addUser(User user) {
		user.setCreateDate(new Date());
		user.setUpdateDate(new Date());
		user.setDelFlg(0);
		getHibernateTemplate().save(user);
	}

	/* (non-Javadoc)
	 * @see javaweb3.user.dao.UserDao#updateUser(javaweb3.user.model.User)
	 */
	@Override
	public void updateUser(User user) {

		user.setUpdateDate(new Date());
		getHibernateTemplate().save(user);
	}
}
