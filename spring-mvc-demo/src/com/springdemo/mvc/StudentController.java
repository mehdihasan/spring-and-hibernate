package com.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.mvc.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@RequestMapping("/show-form")
	public String showForm(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("student", student);
		model.addAttribute("theCountryOptions", countryOptions); 
		
		return "student-form";
	}
	
	@RequestMapping("/process-form")
	public String processForm(@ModelAttribute("student") Student student) {
		
		System.out.println("Student : " + student.getFirstName() + ", " + student.getLastName());
		
		return "student-confirmation";
	}
}
