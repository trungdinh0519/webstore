package com.trung.goodstore.web.form;

public class ShippingForm extends BaseForm {
	public static final long serialVersionUID = 2423742734723L;

	private String firstname;

	private String lastname;

	private String email;

	private String phone;

	private String address;

	private String city;

	private String province;

	private String province_name;

	private String country;

	private String country_name;

	private String postalCode;
	private String chooseAddShip;

	public String getChooseAddShip() {
		return chooseAddShip;
	}

	public void setChooseAddShip(String chooseAddShip) {
		this.chooseAddShip = chooseAddShip;
	}

	public ShippingForm() {
		super();
		this.province_name = "";
		this.country_name = "";
		this.address = "";
		this.city = "";
		this.country = "VN";
		this.email = "";
		this.firstname = "";
		this.lastname = "";
		this.phone = "";
		this.postalCode = "";
		this.province = "";
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getCountry_name() {
		return country_name;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPhone() {
		return phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getProvince() {
		return province;
	}

	public String getProvince_name() {
		return province_name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}

}
