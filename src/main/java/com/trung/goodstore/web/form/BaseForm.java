package com.trung.goodstore.web.form;

import java.math.BigDecimal;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class BaseForm extends ValidatorForm {
	
	public boolean isBlankString(String text) {        
		return (text == null || text.length() == 0);
	} 
	
	public boolean isEmpty(FormFile file) {
		return (file == null || isBlankString(file.getFileName()));
	}
	
	public boolean isEmpty(String[] array) {
		return (array == null || array.length <= 0);
	}
	
	public boolean isValidDollar(String text) {
		try {
			new BigDecimal(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	} 

	
	public boolean isInteger(String text) {
		int sz = text.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(text.charAt(i))) return false;
		}
		return true;
	}
}
