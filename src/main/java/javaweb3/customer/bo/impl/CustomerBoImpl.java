package javaweb3.customer.bo.impl;

import java.util.List;

import javaweb3.customer.bo.CustomerBo;
import javaweb3.customer.dao.CustomerDao;
import javaweb3.customer.model.Customer;

public class CustomerBoImpl implements CustomerBo{
	CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void addCustomer(Customer customer) {

		customerDao.addCustomer(customer);

	}

	public List<Customer> findAllCustomer() {

		return customerDao.findAllCustomer();
	}
}
