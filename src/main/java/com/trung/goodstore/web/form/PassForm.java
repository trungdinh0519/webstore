package com.trung.goodstore.web.form;

public class PassForm extends BaseForm {
	public static final long serialVersionUID = 1243253564565896L;
	private String username;
	private String olePass;

	private String newPass;

	private String cfPass;

	public PassForm() {
		super();
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCfPass() {
		return cfPass;
	}

	public void setCfPass(String cfPass) {
		this.cfPass = cfPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public String getOlePass() {
		return olePass;
	}

	public void setOlePass(String olePass) {
		this.olePass = olePass;
	}

}
