package javaweb3.customer.dao;

import java.util.List;

import javaweb3.customer.model.Customer;

public interface CustomerDao {
	
	void addCustomer(Customer customer);
	
	List<Customer> findAllCustomer();
}
