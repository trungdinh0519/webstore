package javaweb3.customer.bo;

import java.util.List;

import javaweb3.customer.model.Customer;

public interface CustomerBo {
	
	void addCustomer(Customer customer);
	
	List<Customer> findAllCustomer();
}
