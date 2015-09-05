package com.trung.goodstore.web.form;

import org.apache.struts.action.ActionForm;

public class LossPassForm extends ActionForm {
	public static final long serialVersionUID = 123784352453463623L;

	private String email;

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
