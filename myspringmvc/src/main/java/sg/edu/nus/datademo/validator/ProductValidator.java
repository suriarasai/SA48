package sg.edu.nus.datademo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sg.edu.nus.datademo.model.Product;

public class ProductValidator implements Validator {

	/** This Validator validates *just* Person instances **/
	public boolean supports(Class clazz) {
		return Product.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		Product p = (Product) obj;
		if (p.getDescription().length() > 100) {
			e.rejectValue("description", "description");
		}

	}

}
