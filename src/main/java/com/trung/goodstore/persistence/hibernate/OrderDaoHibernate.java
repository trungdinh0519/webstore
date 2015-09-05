package com.trung.goodstore.persistence.hibernate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.trung.goodstore.model.Order;
import com.trung.goodstore.model.OrderItem;
import com.trung.goodstore.model.OrderStatus;
import com.trung.goodstore.model.Product;
import com.trung.goodstore.model.User;

import com.trung.goodstore.persistence.OrderDao;
import com.trung.goodstore.persistence.exception.DaoException;

public class OrderDaoHibernate extends DaoHibernate implements OrderDao {

	public void delete(final Long id) {
		Order order = (Order) this.getHibernateTemplate().get(Order.class, id);
		List items = this.getOrderItem(order);
		try {
			this.getHibernateTemplate().deleteAll(items);
			this.getHibernateTemplate().delete(order);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List getOrders(final User user, final OrderStatus orderStatus,
			final int first, final int size,
			final List<org.hibernate.criterion.Order> orders)
			throws DaoException {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Order.class);
				if (orderStatus != null) {
					System.out.println("status not null");
					criteria.add(Expression.eq("status", orderStatus));
				}
				if (user != null) {
					System.out.println("user not null");
					criteria.add(Expression.eq("user", user));
				}
				for (int i = 0; i < orders.size(); i++) {
					System.out.println("add order:" + i);
					criteria.addOrder(orders.get(i));
				}
				criteria.setFirstResult(first);
				criteria.setMaxResults(size);
				return criteria.list();
			}
		});
	}

	public List getOrderItem(final Order o) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria cri = session.createCriteria(OrderItem.class);
				cri.add(Expression.eq("order", o));
				return cri.list();
			}
		});
	}

	public void saveOrderItem(final OrderItem item) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				try {
					Product p = (Product) session.get(Product.class, item
							.getProduct().getId());
					item.setProduct(p);
					Order o = (Order) session.get(Order.class, item.getOrder()
							.getId());
					item.setOrder(o);
					session.saveOrUpdate(item);
					if (item.getQuantity() > 0) {

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		});
	}

	public int getNumberOrderByStatus(final OrderStatus status)
			throws DaoException {
		Integer number = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria criteria = session.createCriteria(Order.class);
						if (status != null)
							criteria.add(Expression.eq("status", status));
						return criteria.list().size();
					}
				});
		return number.intValue();
	}

	public int getNumberOrderByUser(final User user) throws DaoException {
		Integer number = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria criteria = session.createCriteria(Order.class);
						if (user != null)
							criteria.add(Expression.eq("user", user));
						return criteria.list().size();
					}
				});
		return number.intValue();
	}

	public List getOrders(final OrderStatus orderStatus, final int first,
			final int size, final List<org.hibernate.criterion.Order> orders)
			throws DaoException {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Order.class);
				if (orderStatus != null) {
					System.out.println("status not null");
					criteria.add(Expression.eq("status", orderStatus));
				}
				for (int i = 0; i < orders.size(); i++) {
					System.out.println("add order:" + i);
					criteria.addOrder(orders.get(i));
				}
				criteria.setFirstResult(first);
				criteria.setMaxResults(size);
				return criteria.list();
			}
		});

	}

	public int getNumberOrderSearch(final String keyword,
			final OrderStatus orderStatus, final Date startDate,
			final Date endDate) throws DaoException {
		Integer number = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria criteria = session.createCriteria(Order.class);
						Criterion cri1 = Expression.eq("status", orderStatus);
						Criterion cri2 = Expression.or(Expression.like(
								"billToFirstName", "%" + keyword + "%"),
								Expression.like("billToLastName", "%" + keyword
										+ "%"));
						Criterion cri3 = Expression.and(Expression.ge(
								"orderDate", startDate), Expression.le(
								"orderDate", endDate));

						if (StringUtils.isNotEmpty(keyword)
								&& StringUtils.isNumeric(keyword.trim()))
							try {
								cri2 = Expression.eq("id", new Long(keyword
										.trim()));
							} catch (Exception e) {
								e.printStackTrace();
								log.error(e);
							}

						if (startDate != null && endDate != null
								&& orderStatus != null) {
							criteria.add(Expression.and(Expression.and(cri1,
									cri2), cri3));
						} else if (orderStatus != null) {
							criteria.add(Expression.and(cri1, cri2));
						} else if (startDate != null && endDate != null) {
							System.out
									.println("****************************3cccc");
							criteria.add(Expression.and(cri2, cri3));
						} else {
							criteria.add(cri2);
						}
						return criteria.list().size();
					}
				});
		return number.intValue();
	}

	public int getNumberOrderSearch(final String keyword, final User user,
			final OrderStatus orderStatus, final Date startDate,
			final Date endDate) throws DaoException {
		Integer number = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria criteria = session.createCriteria(Order.class);
						if (user != null){
							criteria.add(Expression.eq("user", user));
							System.out.println("user not null");
						}
							
						Criterion cri1 = Expression.eq("status", orderStatus);
						Criterion cri2 = Expression.or(Expression.like(
								"billToFirstName", "%" + keyword + "%"),
								Expression.like("billToLastName", "%" + keyword
										+ "%"));
						Criterion cri3 = Expression.and(Expression.ge(
								"orderDate", startDate), Expression.le(
								"orderDate", endDate));

						if (StringUtils.isNotEmpty(keyword)
								&& StringUtils.isNumeric(keyword.trim()))
							try {
								cri2 = Expression.eq("id", new Long(keyword
										.trim()));
							} catch (Exception e) {
								e.printStackTrace();
								log.error(e);
							}

						if (startDate != null && endDate != null
								&& orderStatus != null) {
							criteria.add(Expression.and(Expression.and(cri1,
									cri2), cri3));
						} else if (orderStatus != null) {
							criteria.add(Expression.and(cri1, cri2));
						} else if (startDate != null && endDate != null) {
							System.out
									.println("****************************3cccc");
							criteria.add(Expression.and(cri2, cri3));
						} else {
							criteria.add(cri2);
						}
						return criteria.list().size();
					}
				});
		return number.intValue();
	}

	public List searchOrder(final String keyword, final User user,
			final OrderStatus orderStatus, final int first, final int size,
			final List<org.hibernate.criterion.Order> orders,
			final Date startDate, final Date endDate) throws DaoException {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Order.class);
				if (user != null)
					criteria.add(Expression.eq("user", user));
				Criterion cri1 = Expression.eq("status", orderStatus);
				Criterion cri2 = Expression.or(Expression.like(
						"billToFirstName", "%" + keyword + "%"), Expression
						.like("billToLastName", "%" + keyword + "%"));
				Criterion cri3 = Expression.and(Expression.ge("orderDate",
						startDate), Expression.le("orderDate", endDate));

				if (StringUtils.isNotEmpty(keyword)
						&& StringUtils.isNumeric(keyword.trim()))
					try {
						cri2 = Expression.eq("id", new Long(keyword.trim()));
					} catch (Exception e) {
						e.printStackTrace();
						log.error(e);
					}

				if (startDate != null && endDate != null && orderStatus != null) {
					criteria.add(Expression.and(Expression.and(cri1, cri2),
							cri3));
				} else if (orderStatus != null) {
					criteria.add(Expression.and(cri1, cri2));
				} else if (startDate != null && endDate != null) {
					System.out.println("****************************3cccc");
					criteria.add(Expression.and(cri2, cri3));
				} else {
					criteria.add(cri2);
				}
				for (int i = 0; i < orders.size(); i++) {
					criteria.addOrder(orders.get(i));
				}
				criteria.setFirstResult(first);
				criteria.setMaxResults(size);
				return criteria.list();
			}
		});
	}

	public List searchOrder(final String keyword,
			final OrderStatus orderStatus, final int first, final int size,
			final List<org.hibernate.criterion.Order> orders,
			final Date startDate, final Date endDate) throws DaoException {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Order.class);
				Criterion cri1 = Expression.eq("status", orderStatus);
				Criterion cri2 = Expression.or(Expression.like(
						"billToFirstName", "%" + keyword + "%"), Expression
						.like("billToLastName", "%" + keyword + "%"));
				Criterion cri3 = Expression.and(Expression.ge("orderDate",
						startDate), Expression.le("orderDate", endDate));

				if (StringUtils.isNotEmpty(keyword)
						&& StringUtils.isNumeric(keyword.trim()))
					try {
						cri2 = Expression.eq("id", new Long(keyword.trim()));
					} catch (Exception e) {
						e.printStackTrace();
						log.error(e);
					}

				if (startDate != null && endDate != null && orderStatus != null) {
					criteria.add(Expression.and(Expression.and(cri1, cri2),
							cri3));
				} else if (orderStatus != null) {
					criteria.add(Expression.and(cri1, cri2));
				} else if (startDate != null && endDate != null) {
					System.out.println("****************************3cccc");
					criteria.add(Expression.and(cri2, cri3));
				} else {
					criteria.add(cri2);
				}
				for (int i = 0; i < orders.size(); i++) {
					criteria.addOrder(orders.get(i));
				}
				criteria.setFirstResult(first);
				criteria.setMaxResults(size);
				return criteria.list();
			}
		});
	}

	public Order getOrder(Long id) {

		return (Order) this.getHibernateTemplate().get(Order.class, id);
	}

}
