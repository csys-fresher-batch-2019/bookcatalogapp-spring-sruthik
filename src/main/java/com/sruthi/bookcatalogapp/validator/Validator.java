package com.sruthi.bookcatalogapp.validator;

import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.exception.ValidatorException;

public class Validator {
	
	public static void validateRegisterForm(Users u) throws ValidatorException {
		
		if ( u.getUserName() == null || "".equals(u.getUserName().trim())) {
			
				throw new ValidatorException("Name cannot be blank/empty");
			
		}
		if(u.getUserMailId() == null || "".equals(u.getUserMailId().trim())) {
			
				throw new ValidatorException("Mail-id cannot be blank/empty");
			
		}
		if(u.getSetPassword() == null || "".equals(u.getSetPassword().trim())) {
			
				throw new ValidatorException("Password cannot be blank/empty");
			
		}
		if(u.getConfirmPassword() == null || "".equals(u.getConfirmPassword().trim())) {
			
				throw new ValidatorException("Confirm your password");
			
		}
		if(u.getPhNo()== 0) {
			
				throw new ValidatorException("Phone-number cannot be blank/empty");
			
		}
	}
    
}
