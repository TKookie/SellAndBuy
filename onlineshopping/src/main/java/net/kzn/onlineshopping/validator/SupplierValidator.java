package net.kzn.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.kzn.shoppingbackend.dto.Supplier;

public class SupplierValidator implements Validator {

	
	@Override
	public boolean supports(Class<?> clazz) {
		return Supplier.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Supplier supplier = (Supplier) target;
		if(supplier.getFile() == null || supplier.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select a file to upload!");
			return;
		}
		if(! (supplier.getFile().getContentType().equals("image/jpeg") || 
				supplier.getFile().getContentType().equals("image/png")) ||
				supplier.getFile().getContentType().equals("image/gif")
			 )
			{
				errors.rejectValue("file", null, "Please select an image file to upload!");
				return;	
			}

	}
}
