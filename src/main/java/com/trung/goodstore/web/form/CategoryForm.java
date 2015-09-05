package com.trung.goodstore.web.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class CategoryForm extends ValidatorForm {
	public static final long serialVersionUID = 121312312312321L;

	private String id;

	private String name;

	private String desc;

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
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
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.validator.ValidatorForm#validate(org.apache.struts.action.ActionMapping,
	 *      javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {

		ActionErrors errors = super.validate(arg0, arg1);
		//if (StringUtils.isNotEmpty(this.desc.trim())
		////		&& this.desc.length() > 255)
		//	this.desc = desc.substring(0, 255);
		return errors;
	}

}
