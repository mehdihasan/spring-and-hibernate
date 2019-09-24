package com.springdemo.web.dao;

import java.util.List;

import com.springdemo.web.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public void delete(int customerId);

	public List<Customer> searchCustomers(String theSearchName);
}
