package com.trung.goodstore.web.form;

import java.util.Date;

import org.apache.struts.validator.ValidatorForm;

import com.trung.goodstore.model.OrderStatus;
import com.trung.goodstore.model.User;

public class OrderForm extends BaseForm {
	public static final long serialVersionUID = 312432342353453453L;

	private Long id;

	private String number;

	private String user;

	private Date orderDate;

	private String status;

	private String shipToAddress;

	private String shipToAddress2;

	private String shipToCity;

	private String shipToProvince;

	private String shipToPostalCode;

	private String shipToCountry;

	private String shipToFirstName;

	private String shipToLastName;

	private String shipToPhone;

	private String shipToEmail;

	private String billToAddress;

	private String billToAddress2;

	private String billToCity;

	private String billToProvince;

	private String billToPostalCode;

	private String billToCountry;

	private String billToFirstName;

	private String billToLastName;

	private String billToEmail;

	private String billToPhone;

	private Double orderSubTotal;

	private Double orderTax;

	private Double orderTotal;

	private Double shipPrice;

	private Double shipTax;

	private String note;

	private String[] orderStatus = new String[0];

	public String[] getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String[] orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getBillToAddress() {
		return billToAddress;
	}

	public String getBillToAddress2() {
		return billToAddress2;
	}

	public String getBillToCity() {
		return billToCity;
	}

	public String getBillToCountry() {
		return billToCountry;
	}

	public String getBillToEmail() {
		return billToEmail;
	}

	public String getBillToFirstName() {
		return billToFirstName;
	}

	public String getBillToLastName() {
		return billToLastName;
	}

	public String getBillToPhone() {
		return billToPhone;
	}

	public String getBillToPostalCode() {
		return billToPostalCode;
	}

	public String getBillToProvince() {
		return billToProvince;
	}

	public Long getId() {
		return id;
	}

	public String getNote() {
		return note;
	}

	public String getNumber() {
		return number;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Double getOrderSubTotal() {
		return orderSubTotal;
	}

	public Double getOrderTax() {
		return orderTax;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public Double getShipPrice() {
		return shipPrice;
	}

	public Double getShipTax() {
		return shipTax;
	}

	public String getShipToAddress() {
		return shipToAddress;
	}

	public String getShipToAddress2() {
		return shipToAddress2;
	}

	public String getShipToCity() {
		return shipToCity;
	}

	public String getShipToCountry() {
		return shipToCountry;
	}

	public String getShipToEmail() {
		return shipToEmail;
	}

	public String getShipToFirstName() {
		return shipToFirstName;
	}

	public String getShipToLastName() {
		return shipToLastName;
	}

	public String getShipToPhone() {
		return shipToPhone;
	}

	public String getShipToPostalCode() {
		return shipToPostalCode;
	}

	public String getShipToProvince() {
		return shipToProvince;
	}

	public String getStatus() {
		return status;
	}

	public String getUser() {
		return user;
	}

	public void setBillToAddress(String billToAddress) {
		this.billToAddress = billToAddress;
	}

	public void setBillToAddress2(String billToAddress2) {
		this.billToAddress2 = billToAddress2;
	}

	public void setBillToCity(String billToCity) {
		this.billToCity = billToCity;
	}

	public void setBillToCountry(String billToCountry) {
		this.billToCountry = billToCountry;
	}

	public void setBillToEmail(String billToEmail) {
		this.billToEmail = billToEmail;
	}

	public void setBillToFirstName(String billToFirstName) {
		this.billToFirstName = billToFirstName;
	}

	public void setBillToLastName(String billToLastName) {
		this.billToLastName = billToLastName;
	}

	public void setBillToPhone(String billToPhone) {
		this.billToPhone = billToPhone;
	}

	public void setBillToPostalCode(String billToPostalCode) {
		this.billToPostalCode = billToPostalCode;
	}

	public void setBillToProvince(String billToProvince) {
		this.billToProvince = billToProvince;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setOrderSubTotal(Double orderSubTotal) {
		this.orderSubTotal = orderSubTotal;
	}

	public void setOrderTax(Double orderTax) {
		this.orderTax = orderTax;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public void setShipPrice(Double shipPrice) {
		this.shipPrice = shipPrice;
	}

	public void setShipTax(Double shipTax) {
		this.shipTax = shipTax;
	}

	public void setShipToAddress(String shipToAddress) {
		this.shipToAddress = shipToAddress;
	}

	public void setShipToAddress2(String shipToAddress2) {
		this.shipToAddress2 = shipToAddress2;
	}

	public void setShipToCity(String shipToCity) {
		this.shipToCity = shipToCity;
	}

	public void setShipToCountry(String shipToCountry) {
		this.shipToCountry = shipToCountry;
	}

	public void setShipToEmail(String shipToEmail) {
		this.shipToEmail = shipToEmail;
	}

	public void setShipToFirstName(String shipToFirstName) {
		this.shipToFirstName = shipToFirstName;
	}

	public void setShipToLastName(String shipToLastName) {
		this.shipToLastName = shipToLastName;
	}

	public void setShipToPhone(String shipToPhone) {
		this.shipToPhone = shipToPhone;
	}

	public void setShipToPostalCode(String shipToPostalCode) {
		this.shipToPostalCode = shipToPostalCode;
	}

	public void setShipToProvince(String shipToProvince) {
		this.shipToProvince = shipToProvince;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
