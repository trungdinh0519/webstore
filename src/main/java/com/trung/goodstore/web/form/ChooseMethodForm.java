package com.trung.goodstore.web.form;

import org.apache.struts.action.ActionForm;

public class ChooseMethodForm extends ActionForm {
	public static final long serialVersionUID = 1345436547868L;

	private String shipmethod;




	public String getShipmethod() {
		return shipmethod;
	}


	public void setShipmethod(String shipmethod) {
		this.shipmethod = shipmethod;
	}

	public ChooseMethodForm() {
		super();

	}

}
