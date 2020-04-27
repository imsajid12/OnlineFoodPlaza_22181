package com.food.dao;

import java.util.List;

import com.food.pojo.Customer;

public interface CustomerDao {
	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(int custId);
	
	List<Customer> showAllCustomer();
	List<Customer> searchCustomerByName(String custName);
	Customer searchCustomerById(int custId);
	Customer searchCustomerByEmail(String custEmail);
}
