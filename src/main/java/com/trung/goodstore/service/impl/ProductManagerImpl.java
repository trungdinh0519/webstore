package com.trung.goodstore.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Order;

import com.trung.goodstore.model.Category;
import com.trung.goodstore.model.Product;
import com.trung.goodstore.persistence.ProductDao;
import com.trung.goodstore.persistence.exception.DaoException;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
import com.trung.goodstore.service.ProductManager;

public class ProductManagerImpl extends ManagerImpl implements ProductManager {

	protected ProductDao productDao;

	public void setProductDao(ProductDao dao) {
		this.productDao = dao;
	}

	public List getProductDiscount() throws DaoException {
		// TODO Auto-generated method stub
		return this.productDao.getProductDiscount();
	}

	public List getProductNew() throws DaoException {
		// TODO Auto-generated method stub
		return this.productDao.getProductNew();
	}

	public List getCategoryByCate(Category category) throws DaoException {
		return productDao.getCategoryByCate(category);
	}

	public List getCategoryRoot() throws DaoException {
		return productDao.getCategoryRoot();
	}

	public List getCategorys() throws DaoException {
		return productDao.getCategorys();
	}

	public long getNumberProductByCatalog(Category category)
			throws DaoException {
		return this.productDao.getNumberProductByCatalog(category);
	}

	public long getNumberProductByCatalog2(Category category)
			throws DaoException {
		return this.productDao.getNumberProductByCatalog2(category);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.trung.goodstore.service.ProductManager#getNumberProduct()
	 */
	public long getNumberProduct() {
		return this.productDao.getNumberProduct();
	}

	public long getNumberProduct2() {
		return this.productDao.getNumberProduct2();
	}

	public Product getProduct(String id) throws DaoException,
			ObjectNotFoundException {
		if (StringUtils.isEmpty(id) || !StringUtils.isNumeric(id)) {
			throw new ObjectNotFoundException("Product not found");
		}
		return productDao.getProduct(new Long(id));
	}

	public List getProductByCatalog(Category category, int first, int size,
			List<Order> orders) throws DaoException {
		return productDao.getProductByCatalog(category, first, size, orders);
	}

	public List getProductByCatalog2(Category category, int first, int size,
			List<Order> orders) throws DaoException {
		return productDao.getProductByCatalog2(category, first, size, orders);
	}

	public List getProductByCatalog(Category category, List<Order> orders)
			throws DaoException {
		return productDao.getProductByCatalog(category, orders);
	}

	public Product getProductByName(String name) throws DaoException,
			ObjectNotFoundException {
		return this.productDao.getProductByName(name);
	}

	public List getProduct(int first, int size) throws DaoException {
		return productDao.getProduct(first, size);
	}

	public List getProduct2(int first, int size) throws DaoException {
		return productDao.getProduct2(first, size);
	}

	public Integer getTotalSearch(String keyword, String categoryId)
			throws DaoException {
		Category category = null;
		if (StringUtils.isNotEmpty(categoryId)
				&& StringUtils.isNumeric(categoryId)) {
			try {
				category = (Category) this.getObject(Category.class, new Long(
						categoryId));
			} catch (DaoException daoE) {
				daoE.printStackTrace();
			}
		}
		return productDao.getTotalSearch(keyword, category);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.trung.goodstore.service.ProductManager#search(java.lang.String,
	 *      java.lang.String, int, int)
	 */
	public List<Product> search(String keyword, String categoryId, int pos,
			int pageSize) throws DaoException {
		Category category = null;
		if (StringUtils.isNotEmpty(categoryId)
				&& StringUtils.isNumeric(categoryId)) {
			try {
				category = (Category) this.getObject(Category.class, new Long(
						categoryId));
			} catch (DaoException daoE) {
				daoE.printStackTrace();
			}
		}
		return (List<Product>) productDao.search(keyword, category, pos,
				pageSize);

	}

	public Integer getTotalSearch2(String keyword, String categoryId)
			throws DaoException {
		Category category = null;
		if (StringUtils.isNotEmpty(categoryId)
				&& StringUtils.isNumeric(categoryId)) {
			try {
				category = (Category) this.getObject(Category.class, new Long(
						categoryId));
			} catch (DaoException daoE) {
				daoE.printStackTrace();
			}
		}
		return productDao.getTotalSearch2(keyword, category);

	}

	public List<Product> search2(String keyword, String categoryId, int pos,
			int pageSize) throws DaoException {
		Category category = null;
		if (StringUtils.isNotEmpty(categoryId)
				&& StringUtils.isNumeric(categoryId)) {
			try {
				category = (Category) this.getObject(Category.class, new Long(
						categoryId));
			} catch (DaoException daoE) {
				daoE.printStackTrace();
			}
		}
		return (List<Product>) productDao.search2(keyword, category, pos,
				pageSize);

	}

}
