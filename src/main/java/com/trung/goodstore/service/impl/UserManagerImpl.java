package com.trung.goodstore.service.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.trung.goodstore.model.User;
import com.trung.goodstore.persistence.UserDao;
import com.trung.goodstore.persistence.exception.AccountNotFoundException;
import com.trung.goodstore.persistence.exception.DaoException;
import com.trung.goodstore.service.UserManager;

public class UserManagerImpl extends ManagerImpl implements UserManager {
	protected UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;

	}

	public User loadAccountByname(String username)
			throws AccountNotFoundException, DataAccessException {

		return userDao.loadAccountByname(username);
	}

	public boolean isExists(String username) throws DataAccessException {

		return userDao.isExists(username);
	}

	public boolean isEmailExists(String email) throws DataAccessException {
		return userDao.isEmailExists(email);
	}

	public List<User> getUsers() {
		return userDao.getUsers();
	}

	public Long getNumberUser() {
		return this.userDao.getNumberUser();
	}

	public Integer getTotalSearch(String keyword) throws DaoException {
		return this.userDao.getTotalSearch(keyword);
	}

	public List<User> getUsers(int first, int size) throws DaoException {
		return this.userDao.getUsers(first, size);
	}

	public List<User> search(String keyword, int pos, int pageSize)
			throws DaoException {
		return this.userDao.search(keyword, pos, pageSize);
	}

	public User getUser(String username) {
		
		return this.userDao.getUser(username);
	}

}
