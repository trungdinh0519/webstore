package com.trung.goodstore.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.trung.goodstore.model.Order;
import com.trung.goodstore.model.OrderItem;
import com.trung.goodstore.model.OrderStatus;
import com.trung.goodstore.model.User;
import com.trung.goodstore.persistence.OrderDao;
import com.trung.goodstore.persistence.UserDao;
import com.trung.goodstore.persistence.exception.DaoException;
import com.trung.goodstore.service.OrderManager;
import com.trung.goodstore.service.exception.FailureException;

public class OrderManagerImpl extends ManagerImpl implements OrderManager {
	private OrderDao orderDao;

	private UserDao userDao;

	public List getOrderItem(Order o) {
		// TODO Auto-generated method stub
		return this.orderDao.getOrderItem(o);
	}

	public void updateStatus(String id, String statusId) throws DaoException,
			FailureException {
		Order order = null;
		OrderStatus status = null;
		try {
			order = this.getOrder(id);
			status = (OrderStatus) this.getObject(OrderStatus.class, new Long(
					statusId));
			if (order != null && status != null) {
				order.setStatus(status);
				this.saveObject(order);
			}
		} catch (FailureException e2) {
			log.error(e2);
			throw e2;

		} catch (Exception e) {
			log.error(e);
		}
	}

	public void delete(String id) {
		try {
			this.orderDao.delete(new Long(id));
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void setOrderDao(OrderDao dao) {
		this.orderDao = dao;
	}

	public int getNumberOrderByStatus(String status) throws DaoException {
		OrderStatus os = null;
		try {
			os = (OrderStatus) this.orderDao.getObject(OrderStatus.class,
					new Long(status.trim()));
		} catch (Exception e) {
			log.debug(e);
		}
		return this.orderDao.getNumberOrderByStatus(os);
	}

	public int getNumberOrderByUser(String username) throws DaoException {
		User user = null;
		try {
			user = (User) this.userDao.getUser(username);
		} catch (Exception e) {
			log.debug(e);
		}
		return this.orderDao.getNumberOrderByUser(user);
	}

	public int getNumberOrderSearch(String keyword, String status,
			Date startDate, Date endDate) throws DaoException {
		OrderStatus os = null;
		try {
			os = (OrderStatus) this.orderDao.getObject(OrderStatus.class,
					new Long(status.trim()));
		} catch (Exception e) {
			log.debug(e);
		}
		System.out.println("************************************10");
		return orderDao.getNumberOrderSearch(keyword, os, startDate, endDate);

	}

	public int getNumberOrderSearch2(String keyword, String username,
			String orderStatus, Date startDate, Date endDate)
			throws DaoException {
		OrderStatus os = null;
		User user = null;
		System.out.println("[getnumberorder] username="+username);
		try {
			user = (User) this.userDao.getUser(username);
			os = (OrderStatus) this.orderDao.getObject(OrderStatus.class,
					new Long(orderStatus.trim()));
			
		} catch (Exception e) {
			log.debug(e);
		}		
		return orderDao.getNumberOrderSearch(keyword, user, os, startDate,
				endDate);
	}

	public List searchOrder(String keyword, String username,
			String orderStatus, int first, int size,
			List<org.hibernate.criterion.Order> orders, Date startDate,
			Date endDate) throws DaoException {
		OrderStatus os = null;
		User user = null;
		try {
			user = (User) this.userDao.getUser(username);
			os = (OrderStatus) this.orderDao.getObject(OrderStatus.class,
					new Long(orderStatus.trim()));
		} catch (Exception e) {
			log.debug(e);
		}
		System.out.println("************************************20");
		return orderDao.searchOrder(keyword, user, os, first, size, orders,
				startDate, endDate);
	}

	public Order getOrder(String id) {
		return this.orderDao.getOrder(new Long(id));
	}

	public List getOrders(String status, int first, int size,
			List<org.hibernate.criterion.Order> orders) throws DaoException {
		OrderStatus os = null;
		try {
			os = (OrderStatus) this.orderDao.getObject(OrderStatus.class,
					new Long(status.trim()));
		} catch (Exception e) {
			log.debug(e);
		}
		return orderDao.getOrders(os, first, size, orders);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List getOrders(String uid, String orderStatus, int first, int size,
			List<org.hibernate.criterion.Order> orders) throws DaoException {
		OrderStatus os = null;
		User user = null;
		try {
			user = (User) this.userDao.getUser(uid);
			os = (OrderStatus) this.orderDao.getObject(OrderStatus.class,
					new Long(orderStatus.trim()));
		} catch (Exception e) {
			log.debug(e);
		}
		return orderDao.getOrders(user, os, first, size, orders);
	}

	public List searchOrder(String keyword, String status, int first, int size,
			List<org.hibernate.criterion.Order> orders, Date startDate,
			Date endDate) throws DaoException {
		OrderStatus os = null;
		try {
			os = (OrderStatus) this.orderDao.getObject(OrderStatus.class,
					new Long(status.trim()));
		} catch (Exception e) {
			log.debug(e);
		}
		System.out.println("************************************20");
		return orderDao.searchOrder(keyword, os, first, size, orders,
				startDate, endDate);
	}

	public void saveOrderItem(OrderItem item) {
		this.orderDao.saveOrderItem(item);
	}

}
