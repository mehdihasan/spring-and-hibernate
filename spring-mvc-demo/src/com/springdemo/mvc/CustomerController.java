package com.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.mvc.model.Customer;

/**
 * @author mehdi
 *
 * @objective: hands on experience on spring validations
 */
@RequestMapping(path = "/customer")
@Controller
public class CustomerController {

	@RequestMapping("/show-form")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	/**
	 * When performing Spring MVC validation, the location of the BindingResult parameter is very important. 
	 * In the method signature, the BindingResult parameter must appear immediately after the model attribute. 
	 */
	@RequestMapping("/process-form")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult bindingResult) {
		
		System.out.println("Last name: |" + customer.getLastName() + "|");
		
		if (bindingResult.hasErrors()) {
			return "customer-form";
		}
		
		return "customer-confirmation";
	}
}
