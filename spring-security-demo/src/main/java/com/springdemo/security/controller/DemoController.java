package com.springdemo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
    public String showLanding() {
        return "landing";
    }
	
	@GetMapping(value = {"/employees", "/leaders", "/systems"})
	public String showHome() {
		return "home";
	}
}
