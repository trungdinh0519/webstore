package com.trung.goodstore.persistence;

import java.util.Date;
import java.util.List;

import com.trung.goodstore.model.Order;
import com.trung.goodstore.model.OrderItem;
import com.trung.goodstore.model.OrderStatus;
import com.trung.goodstore.model.User;
import com.trung.goodstore.persistence.exception.DaoException;

public interface OrderDao extends Dao {
	void delete(Long id);

	List getOrderItem(Order o);

	List getOrders(OrderStatus orderStatus, int first, int size,
			List<org.hibernate.criterion.Order> orders) throws DaoException;

	List getOrders(User user, OrderStatus orderStatus, int first, int size,
			List<org.hibernate.criterion.Order> orders) throws DaoException;

	int getNumberOrderByStatus(OrderStatus status) throws DaoException;

	public int getNumberOrderByUser(User user) throws DaoException;

	List searchOrder(String keyword, OrderStatus orderStatus, int first,
			int size, List<org.hibernate.criterion.Order> orders,
			Date startDate, Date endDate) throws DaoException;
	List searchOrder(String keyword, User user,OrderStatus orderStatus, int first,
			int size, List<org.hibernate.criterion.Order> orders,
			Date startDate, Date endDate) throws DaoException;
	int getNumberOrderSearch(String keyword, OrderStatus orderStatus,
			Date startDate, Date endDate) throws DaoException;
	
	int getNumberOrderSearch(String keyword,User user, OrderStatus orderStatus,
			Date startDate, Date endDate) throws DaoException;

	Order getOrder(Long id);

	public void saveOrderItem(OrderItem item);
}
