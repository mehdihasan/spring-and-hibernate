package com.springdemo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("")
	public String home(Model model) {
		return "list-customer";
	}

	@RequestMapping("/list")
	public String listCustomers(Model model) {
		return "list-customer";
	}
}
