package com.springdemo.mvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=2, message = "must be bigger than 1 character")
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
