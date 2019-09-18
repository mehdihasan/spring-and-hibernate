package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/show-form")
	public String showForm() {
		return "hellowworld-form";
	}
	
	@RequestMapping("/view-form-end-result")
	public String viewFormResult() {
		return "helloworld";
	}
	
	@RequestMapping("/process-form")
	public String processForm(HttpServletRequest req, Model model) {
		
		String theName = req.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "YO! " + theName;
		
		model.addAttribute("message", result);
		
		return "helloworld-model";
	}
}
