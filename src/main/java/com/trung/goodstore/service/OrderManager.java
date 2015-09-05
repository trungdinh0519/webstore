package com.trung.goodstore.service;

import java.util.Date;
import java.util.List;

import com.trung.goodstore.model.Order;
import com.trung.goodstore.model.OrderItem;
import com.trung.goodstore.model.OrderStatus;
import com.trung.goodstore.model.User;
import com.trung.goodstore.persistence.OrderDao;
import com.trung.goodstore.persistence.UserDao;
import com.trung.goodstore.persistence.exception.DaoException;

public interface OrderManager extends Manager {
	void setOrderDao(OrderDao dao);

	void setUserDao(UserDao userDao);

	void delete(String id);

	List getOrderItem(Order o);

	List getOrders(String orderStatus, int first, int size,
			List<org.hibernate.criterion.Order> orders) throws DaoException;

	List getOrders(String uid, String orderStatus, int first, int size,
			List<org.hibernate.criterion.Order> orders) throws DaoException;

	int getNumberOrderByStatus(String status) throws DaoException;

	public int getNumberOrderByUser(String user) throws DaoException;

	List searchOrder(String keyword, String username, String orderStatus,
			int first, int size, List<org.hibernate.criterion.Order> orders,
			Date startDate, Date endDate) throws DaoException;

	int getNumberOrderSearch2(String keyword, String username,
			String orderStatus, Date startDate, Date endDate)
			throws DaoException;

	List searchOrder(String keyword, String orderStatus, int first, int size,
			List<org.hibernate.criterion.Order> orders, Date startDate,
			Date endDate) throws DaoException;

	int getNumberOrderSearch(String keyword, String orderStatus,
			Date startDate, Date endDate) throws DaoException;

	Order getOrder(String id);

	void updateStatus(String id, String statusId) throws DaoException;

	void saveOrderItem(OrderItem item);
}
