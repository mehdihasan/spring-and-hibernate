package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/silly")
public class SillyController {

	@RequestMapping("/show-form")
	public String displayTheForm() {
		return "silly";
	}
}