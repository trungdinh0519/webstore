package com.trung.goodstore.service;

import java.util.List;

import org.hibernate.criterion.Order;

import com.trung.goodstore.model.Category;
import com.trung.goodstore.model.Product;
import com.trung.goodstore.persistence.ProductDao;
import com.trung.goodstore.persistence.exception.DaoException;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;

public interface ProductManager extends Manager {
	public void setProductDao(ProductDao dao);

	public List getCategoryByCate(Category category) throws DaoException;

	public List getCategoryRoot() throws DaoException;

	public List getCategorys() throws DaoException;

	public long getNumberProductByCatalog(Category category)
			throws DaoException;

	public List getProductByCatalog(Category category, int first, int size,
			List<Order> orders) throws DaoException;

	public long getNumberProductByCatalog2(Category category)
			throws DaoException;

	public List getProductByCatalog2(Category category, int first, int size,
			List<Order> orders) throws DaoException;

	public long getNumberProduct();

	public List getProduct(int first, int size) throws DaoException;

	public long getNumberProduct2();

	public List getProduct2(int first, int size) throws DaoException;

	public Product getProduct(String id) throws DaoException,
			ObjectNotFoundException;

	public List getProductByCatalog(Category category, List<Order> orders)
			throws DaoException;

	public Product getProductByName(String name) throws DaoException,
			ObjectNotFoundException;

	public List<Product> search(String keyword, String categoryId, int pos,
			int pageSize) throws DaoException;

	public Integer getTotalSearch(String keyword, String categoryId)
			throws DaoException;

	public List<Product> search2(String keyword, String categoryId, int pos,
			int pageSize) throws DaoException;

	public Integer getTotalSearch2(String keyword, String categoryId)
			throws DaoException;

	public List getProductNew() throws DaoException;

	public List getProductDiscount() throws DaoException;
}
