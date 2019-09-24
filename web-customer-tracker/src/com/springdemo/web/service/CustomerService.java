package com.springdemo.web.service;

import java.util.List;

import com.springdemo.web.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public void delete(int customerId);

	public List<Customer> searchCustomers(String theSearchName);
}
