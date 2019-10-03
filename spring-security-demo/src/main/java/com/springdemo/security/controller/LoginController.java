package com.springdemo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springdemo.security.config.Url;

@Controller
public class LoginController {

	@GetMapping(Url.LOGIN)
	public String customLoginPage() {
		return "simple-login";
	} 
}
