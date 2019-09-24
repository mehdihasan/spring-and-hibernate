package com.springdemo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.web.dao.CustomerDao;
import com.springdemo.web.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerDao.getCastomers();
		
		System.out.println("Customers: " + customers);
		model.addAttribute("customers", customers);
		
		return "list-customer";
	}
}
