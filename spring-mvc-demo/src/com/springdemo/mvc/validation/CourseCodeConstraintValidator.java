package com.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
	implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;
	private String[] courseSuffixes;
	
	@Override
	public void initialize(CourseCode courseCode) {
		this.coursePrefix = courseCode.prefix();
		this.courseSuffixes = courseCode.suffixes();
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		boolean result = true;
		if (code != null) {
			boolean prefixResult = code.startsWith(coursePrefix);
			
			boolean suffixResult = false;
			for (String tempSuffix: courseSuffixes) {
				suffixResult = code.endsWith(tempSuffix);
				
				if (suffixResult) {
					break;
				}
			}
			
			result = prefixResult && suffixResult;
		}
		return result;
	}

}
