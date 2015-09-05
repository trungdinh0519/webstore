package com.trung.goodstore.persistence.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.trung.goodstore.model.Category;
import com.trung.goodstore.model.Product;
import com.trung.goodstore.persistence.ProductDao;
import com.trung.goodstore.persistence.exception.DaoException;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;

/**
 * 
 * @author trung dinh
 * 
 */
public class ProductDaoHibernate extends DaoHibernate implements ProductDao {

	public List getCategoryByCate(final Category category) throws DaoException {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Category.class);
				criteria.add(Expression.eq("parent.id", category.getId()));
				criteria.addOrder(Order.asc("name"));
				return criteria.list();
			}
		});
	}

	public List getCategoryRoot() throws DaoException {
		String query = "from Category ";
		query += " where parent is null order by name";
		return this.getHibernateTemplate().find(query);
	}

	public List getCategorys() throws DaoException {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Category.class);
				criteria.addOrder(Order.asc("name"));
				return criteria.list();
			}
		});

	}

	public Product getProduct(Long id) throws DaoException,
			ObjectNotFoundException {
		Object obj = this.getHibernateTemplate().get(Product.class, id);
		if (obj == null) {
			log.debug("Object not found.");
			throw new ObjectNotFoundException("Object not found");
		}
		return (Product) obj;
	}

	public List getProductByCatalog(final Category category, final int first,
			final int size, final List<Order> orders) throws DaoException {
		// System.out.println("[JSHOP]:order.name:" + orders.toString());
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Product.class);
				criteria.add(Expression.eq("category", category));
				if (orders != null && !orders.isEmpty()) {
					for (int i = 0; i < orders.size(); i++) {
						Order order = orders.get(i);
						criteria.addOrder(order);
					}
				}
				criteria.setFirstResult(first);
				criteria.setMaxResults(size);
				return criteria.list();
			}
		});
	}

	public List getProductByCatalog(final Category category,
			final List<Order> orders) throws DaoException {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Product.class);
				criteria.add(Expression.eq("category", category));
				if (orders != null && !orders.isEmpty()) {
					for (int i = 0; i < orders.size(); i++) {
						Order order = orders.get(i);
						criteria.addOrder(order);
					}
				}
				return criteria.list();
			}
		});
	}

	public List getProductByCatalog2(final Category category, final int first,
			final int size, final List<Order> orders) throws DaoException {
		// System.out.println("[JSHOP]:order.name:" + orders.toString());
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Product.class);
				criteria.add(Expression.eq("category", category));
				criteria.add(Expression.eq("active", new Boolean(true)));
				if (orders != null && !orders.isEmpty()) {
					for (int i = 0; i < orders.size(); i++) {
						Order order = orders.get(i);
						criteria.addOrder(order);
					}
				}
				criteria.setFirstResult(first);
				criteria.setMaxResults(size);
				return criteria.list();
			}
		});
	}

	public long getNumberProductByCatalog(final Category category)
			throws DaoException {
		Long number = (Long) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Query query = session
								.createQuery("select count(p) from Product p where p.category=:category");
						query.setParameter("category", category);
						query.setMaxResults(1);
						return query.uniqueResult();
					}
				});
		return number;
	}

	public Integer getNumberProductByCatalog2(final Category category)
			throws DaoException {
		Integer number = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria criteria = session
								.createCriteria(Product.class);
						criteria.add(Expression.eq("category", category));
						criteria
								.add(Expression.eq("active", new Boolean(true)));

						return criteria.list().size();
					}
				});
		return number;
	}

	public long getNumberProduct() {
		Long number = (Long) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Query query = session
								.createQuery("select count(p) from Product p");
						query.setMaxResults(1);
						return query.uniqueResult();
					}
				});
		return number;
	}

	public Integer getNumberProduct2() {
		Integer number = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria criteria = session
								.createCriteria(Product.class);
						//criteria.setMaxResults(1);
						criteria
								.add(Expression.eq("active", new Boolean(true)));
						return criteria.list().size();
					}
				});
		return number;
	}

	public Product getProductByName(String name) throws DaoException,
			ObjectNotFoundException {
		List obj = this.getHibernateTemplate().find(
				"from Product p where p.name=?", name);
		if (obj == null || obj.isEmpty()) {
			log.debug("Product not found");
			throw new ObjectNotFoundException("Product not found");
		}
		return (Product) obj.get(0);
	}

	public List getProduct(final int first, final int size) throws DaoException {

		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Product.class);
				criteria.setFirstResult(first);
				criteria.setMaxResults(size);
				return criteria.list();
			}
		});
	}

	public List getProduct2(final int first, final int size)
			throws DaoException {

		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Product.class);
				criteria.add(Expression.eq("active", new Boolean(true)));
				criteria.setFirstResult(first);
				criteria.setMaxResults(size);
				return criteria.list();
			}
		});
	}

	public List search(final String keyword, final Category category,
			final int pos, final int pageSize) throws DaoException {

		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				String key = keyword;
				Criteria criteria = session.createCriteria(Product.class);

				if (category != null)
					criteria.add(Expression.and(Expression.eq("category",
							category), Expression.like("name", "%" + keyword
							+ "%")));
				else {
					criteria.add(Expression.like("name", "%" + key + "%"));
				}
				
				criteria.addOrder(Order.asc("name"));
				criteria.setFirstResult(pos);
				criteria.setMaxResults(pageSize);
				return criteria.list();
			}
		});

	}

	public Integer getTotalSearch(final String keyword, final Category category)
			throws DaoException {

		return (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria criteria = session
								.createCriteria(Product.class);
						// criteria.add(Expression.eq("active", new
						// Boolean(true)));
						if (category != null)
							criteria.add(Expression.and(Expression.eq(
									"category", category), Expression.like(
									"name", "%" + keyword + "%")));
						else {
							criteria.add(Expression.like("name", "%" + keyword
									+ "%"));
						}
						criteria.addOrder(Order.asc("name"));

						return criteria.list().size();
					}
				});

	}

	public List getProductNew() throws DaoException {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Product.class);
				criteria.add(Expression.eq("active", new Boolean(true)));
				criteria.addOrder(Order.asc("cdate"));
				criteria.setFirstResult(0);
				criteria.setMaxResults(8);
				return criteria.list();
			}
		});
	}

	public List getProductDiscount() throws DaoException {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Product.class);
				criteria.add(Expression.eq("active", new Boolean(true)));
				criteria.addOrder(Order.asc("cdate"));
				criteria.add(Expression.gt("discount", new Double(0.0)));
				criteria.setFirstResult(0);
				criteria.setMaxResults(8);
				return criteria.list();
			}
		});
	}

	public List search2(final String keyword, final Category category,
			final int pos, final int pageSize) throws DaoException {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				String key = keyword;
				Criteria criteria = session.createCriteria(Product.class);
				criteria.add(Expression.eq("active", new Boolean(true)));
				Criterion cri=Expression.eq("", "123");
				Criterion cri2=Expression.and(Expression.eq("category",
						category), Expression.like("name", "%" + keyword
								+ "%"));
				if (category != null)
					criteria.add(Expression.and(Expression.eq("category",
							category), Expression.like("name", "%" + keyword
									+ "%")));
				
				else {
					criteria.add(Expression.like("name", "%" + key + "%"));
				}
				criteria.addOrder(Order.asc("name"));
				criteria.setFirstResult(pos);
				criteria.setMaxResults(pageSize);
				return criteria.list();
			}
		});
	}

	public Integer getTotalSearch2(final String keyword, final Category category)
			throws DaoException {

		return (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Criteria criteria = session
								.createCriteria(Product.class);
						criteria
								.add(Expression.eq("active", new Boolean(true)));
						if (category != null)
							criteria.add(Expression.and(Expression.eq(
									"category", category), Expression.like(
									"name", "%" + keyword + "%")));
						else {
							criteria.add(Expression.like("name", "%" + keyword
									+ "%"));
						}
						criteria.addOrder(Order.asc("name"));

						return criteria.list().size();
					}
				});

	}

}
