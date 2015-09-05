package javaweb3.customer.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javaweb3.customer.dao.CustomerDao;
import javaweb3.customer.model.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void addCustomer(Customer customer) {
		customer.setCreatedDate(new Date());
		getHibernateTemplate().save(customer);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAllCustomer() {
		
		return ((List<Customer>)getHibernateTemplate().find("from Customer"));
	}

}
