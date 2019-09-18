package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/show-form")
	public String showForm() {
		return "hellowworld-form";
	}
	
	@RequestMapping("process-form")
	public String processForm() {
		return "helloworld";
	}
}
