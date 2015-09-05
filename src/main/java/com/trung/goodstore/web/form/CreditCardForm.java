package com.trung.goodstore.web.form;

public class CreditCardForm extends BaseForm {
	public static final long serialVersionUID = 12234481107677893L;

	private String type;

	private String number;

	private String expdate_month;

	private String expdate_year;

	private String firstname;

	private String lastname;

	private String cvv2_number;

	public CreditCardForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCvv2_number() {
		return cvv2_number;
	}

	public String getExpdate_month() {
		return expdate_month;
	}

	public String getExpdate_year() {
		return expdate_year;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public void setCvv2_number(String cvv2_number) {
		this.cvv2_number = cvv2_number;
	}

	public void setExpdate_month(String expdate_month) {
		this.expdate_month = expdate_month;
	}

	public void setExpdate_year(String expdate_year) {
		this.expdate_year = expdate_year;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setType(String type) {
		this.type = type;
	}

}
