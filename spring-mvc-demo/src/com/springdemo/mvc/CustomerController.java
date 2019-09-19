package com.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

	// add an initbinder ... to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
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
		System.out.println("Postal Code: |" + customer.getPostalCode() + "|");
		System.out.println("Binding result: " + bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "customer-form";
		}
		
		return "customer-confirmation";
	}
}
