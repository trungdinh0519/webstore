package com.trung.goodstore.persistence;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.trung.goodstore.model.User;
import com.trung.goodstore.persistence.exception.AccountNotFoundException;
import com.trung.goodstore.persistence.exception.DaoException;

public interface UserDao extends Dao {
	public boolean isExists(String username) throws DataAccessException;

	public boolean isEmailExists(String email) throws DataAccessException;

	public User loadAccountByname(String username)
			throws AccountNotFoundException, DataAccessException;

	List<User> getUsers();

	List<User> getUsers(int first, int size) throws DaoException;

	Long getNumberUser();

	List<User> search(String keyword, int pos, int pageSize)
			throws DaoException;

	Integer getTotalSearch(String keyword) throws DaoException;
	User getUser(String username);
}
