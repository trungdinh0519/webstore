package com.trung.goodstore.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.trung.goodstore.model.Category;
import com.trung.goodstore.model.Product;
import com.trung.goodstore.persistence.exception.DaoException;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;

public interface ProductDao extends Dao {
	public List search2(final String keyword, final Category category,
			final int pos, final int pageSize) throws DaoException;

	public Integer getTotalSearch2(final String keyword, final Category category)
			throws DaoException;

	public List getCategoryByCate(Category category) throws DaoException;

	public List getCategoryRoot() throws DaoException;

	public List getCategorys() throws DaoException;

	public Product getProduct(Long id) throws DaoException,
			ObjectNotFoundException;

	public List getProductByCatalog(Category category, int first, int size,
			List<Order> order) throws DaoException;

	public List getProductByCatalog2(Category category, int first, int size,
			List<Order> order) throws DaoException;

	public List getProductByCatalog(Category category, List<Order> orders)
			throws DaoException;

	public long getNumberProduct();

	public Integer getNumberProduct2();

	public long getNumberProductByCatalog(Category category)
			throws DaoException;

	public Integer getNumberProductByCatalog2(Category category)
			throws DaoException;

	public Product getProductByName(String name) throws DaoException,
			ObjectNotFoundException;

	public List getProduct(int first, int size) throws DaoException;

	public List getProduct2(int first, int size) throws DaoException;

	public List search(String keyword, Category category, int pos, int pageSize)
			throws DaoException;

	public Integer getTotalSearch(String keyword, Category category)
			throws DaoException;

	public List getProductNew() throws DaoException;

	public List getProductDiscount() throws DaoException;
}
