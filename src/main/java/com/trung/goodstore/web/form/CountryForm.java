package com.trung.goodstore.web.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import org.apache.struts.validator.ValidatorForm;

public class CountryForm extends ValidatorForm {
public static final long serialVersionUID=121247854604678L;
private String id;

private String name;

private String code2;

private String code3;

public CountryForm() {}

/**
 * @return the code2
 */
public String getCode2() {
	return code2;
}

/**
 * @return the code3
 */
public String getCode3() {
	return code3;
}

/**
 * @return the id
 */
public String getId() {
	return id;
}

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param code2 the code2 to set
 */
public void setCode2(String code2) {
	this.code2 = code2;
}

/**
 * @param code3 the code3 to set
 */
public void setCode3(String code3) {
	this.code3 = code3;
}

/**
 * @param id the id to set
 */
public void setId(String id) {
	this.id = id;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/* (non-Javadoc)
 * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
 */
@Override
public void reset(ActionMapping arg0, HttpServletRequest arg1) {
	// TODO Auto-generated method stub
	super.reset(arg0, arg1);
}

/* (non-Javadoc)
 * @see org.apache.struts.validator.ValidatorForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
 */
@Override
public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
	// TODO Auto-generated method stub
	ActionErrors errors= super.validate(arg0, arg1);
	if(StringUtils.isNotEmpty(this.code3)&&this.code3.length()!=3){
		errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
					"errors.country.code3"));
	}
	return errors;
}

}
