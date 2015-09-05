package com.trung.goodstore.web.form;

import org.apache.struts.validator.ValidatorForm;

public class ShipMethodForm extends ValidatorForm {
	public static final long serialVersionUID = 121247854604678L;

	private String id;

	private String name;

	private String desc;

	public ShipMethodForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDesc() {
		return desc;
	}

	

	public String getName() {
		return name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
