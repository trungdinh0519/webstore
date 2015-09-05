package com.trung.goodstore.web.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class ProvinceForm extends ValidatorForm {
public static final long serialVersionUID=2747259324534L;
private String id;
private String name;
private String code;
private String country;
public ProvinceForm() {
	super();
	// TODO Auto-generated constructor stub
}

/**
 * @return the id
 */
public String getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(String id) {
	this.id = id;
}

/**
 * @return the country
 */
public String getCountry() {
	return country;
}

/**
 * @param country the country to set
 */
public void setCountry(String country) {
	this.country = country;
}

/**
 * @return the code
 */
public String getCode() {
	return code;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param code the code to set
 */
public void setCode(String code) {
	this.code = code;
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
	this.name="";
	this.code="";
}
/* (non-Javadoc)
 * @see org.apache.struts.validator.ValidatorForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
 */
@Override
public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
	// TODO Auto-generated method stub
	ActionErrors errors= super.validate(arg0, arg1);
	return errors;
}

}
