package com.trung.goodstore.persistence.hibernate;

import java.util.List;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.trung.goodstore.model.Product;
import com.trung.goodstore.model.User;
import com.trung.goodstore.persistence.UserDao;
import com.trung.goodstore.persistence.exception.AccountNotFoundException;
import com.trung.goodstore.persistence.exception.DaoException;

public class UserDaoHibernate extends DaoHibernate implements UserDao,
		UserDetailsService {

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		List accs = this.getHibernateTemplate().find(
				"from User where username=?", username);
		if (accs == null || accs.isEmpty()) {
			throw new UsernameNotFoundException("User:" + username
					+ " not found...");
		}
		return (UserDetails) accs.get(0);

	}

	public User loadAccountByname(String username) throws DataAccessException,
			AccountNotFoundException {
		List accs = this.getHibernateTemplate().find(
				"from User where username=?", username);
		if (accs == null || accs.isEmpty()) {
			throw new AccountNotFoundException("User:" + username
					+ " not found...");
		}
		return (User) accs.get(0);

	}

	public boolean isExists(String username) throws DataAccessException {
		List accs = this.getHibernateTemplate().find(
				"from User where username=?", username);
		if (accs != null && !accs.isEmpty())
			return true;
		else
			return false;
	}

	public boolean isEmailExists(String email) throws DataAccessException {
		List accs = this.getHibernateTemplate().find("from User where email=?",
				email);
		if (accs != null && !accs.isEmpty())
			return true;
		else
			return false;
	}

	public List<User> getUsers() {
		List l = this.getHibernateTemplate().find(
				"from User u order by upper(u.username)");
		return (List<User>) l;
	}

	public Long getNumberUser() {
		Long number = (Long) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Query query = session
								.createQuery("select count(u) from User u");
						query.setMaxResults(1);
						return query.uniqueResult();
					}
				});
		return number;
	}

	public Integer getTotalSearch(final String keyword) throws DaoException {
		return (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria criteria = session.createCriteria(User.class);
						criteria.add(Expression.like("username", "%" + keyword
								+ "%"));
						criteria.addOrder(Order.asc("username"));
						return criteria.list().size();
					}
				});
	}

	public List<User> getUsers(final int first, final int size)
			throws DaoException {
		List users = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria criteria = session.createCriteria(User.class);
						criteria.setFirstResult(first);
						criteria.setMaxResults(size);
						return criteria.list();
					}
				});
		return (List<User>) users;
	}

	public List<User> search(final String keyword, final int pos,
			final int pageSize) throws DaoException {
		List users = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria criteria = session.createCriteria(User.class);
						criteria.add(Expression.like("username", "%" + keyword
								+ "%"));
						criteria.addOrder(Order.asc("username"));
						criteria.setFirstResult(pos);
						criteria.setMaxResults(pageSize);
						return criteria.list();
					}
				});
		return (List<User>) users;
	}

	public User getUser(String username) {
		Object obj = this.getHibernateTemplate().get(User.class, username);
		return (User) obj;
	}
}
