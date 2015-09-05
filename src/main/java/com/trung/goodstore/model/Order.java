package com.trung.goodstore.model;

import java.lang.Double;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Trung Fullname:Nguyen Dinh Trung e-mail:trungnd07@gmail.com
 */
public class Order extends BaseObject {
	public Order() {
	}

	public static final long serialVersionUID = 123456789021L;

	private Long id;

	private String number;

	private Date orderDate;

	private OrderStatus status;

	private User user;

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

	private Set orderItem = new HashSet();

	public void add(OrderItem oi) {
		oi.setOrder(this);
		this.getOrderItem().add(oi);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Set getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Set orderItem) {
		this.orderItem = orderItem;
	}

	public Double getOrderSubTotal() {
		return orderSubTotal;
	}

	public void setOrderSubTotal(Double orderSubTotal) {
		this.orderSubTotal = orderSubTotal;
	}

	public Double getOrderTax() {
		return orderTax;
	}

	public void setOrderTax(Double orderTax) {
		this.orderTax = orderTax;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Double getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(Double shipPrice) {
		this.shipPrice = shipPrice;
	}

	public Double getShipTax() {
		return shipTax;
	}

	public void setShipTax(Double shipTax) {
		this.shipTax = shipTax;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	/**
	 * @return the billToAddress
	 */
	public String getBillToAddress() {
		return billToAddress;
	}

	/**
	 * @return the billToAddress2
	 */
	public String getBillToAddress2() {
		return billToAddress2;
	}

	/**
	 * @return the billToCity
	 */
	public String getBillToCity() {
		return billToCity;
	}

	/**
	 * @return the billToCountry
	 */
	public String getBillToCountry() {
		return billToCountry;
	}

	/**
	 * @return the billToEmail
	 */
	public String getBillToEmail() {
		return billToEmail;
	}

	/**
	 * @return the billToFirstName
	 */
	public String getBillToFirstName() {
		return billToFirstName;
	}

	/**
	 * @return the billToLastName
	 */
	public String getBillToLastName() {
		return billToLastName;
	}

	/**
	 * @return the billToPhone
	 */
	public String getBillToPhone() {
		return billToPhone;
	}

	/**
	 * @return the billToPostalCode
	 */
	public String getBillToPostalCode() {
		return billToPostalCode;
	}

	/**
	 * @return the billToProvince
	 */
	public String getBillToProvince() {
		return billToProvince;
	}

	public String getShipToAddress() {
		return shipToAddress;
	}

	/**
	 * @return the shipToAddress2
	 */
	public String getShipToAddress2() {
		return shipToAddress2;
	}

	/**
	 * @return the shipToCity
	 */
	public String getShipToCity() {
		return shipToCity;
	}

	/**
	 * @return the shipToCountry
	 */
	public String getShipToCountry() {
		return shipToCountry;
	}

	/**
	 * @return the shipToEmail
	 */
	public String getShipToEmail() {
		return shipToEmail;
	}

	/**
	 * @return the shipToFirstName
	 */
	public String getShipToFirstName() {
		return shipToFirstName;
	}

	/**
	 * @return the shipToLastName
	 */
	public String getShipToLastName() {
		return shipToLastName;
	}

	/**
	 * @return the shipToPhone
	 */
	public String getShipToPhone() {
		return shipToPhone;
	}

	/**
	 * @return the shipToPostalCode
	 */
	public String getShipToPostalCode() {
		return shipToPostalCode;
	}

	/**
	 * @return the shipToProvince
	 */
	public String getShipToProvince() {
		return shipToProvince;
	}

	/**
	 * @param billToAddress
	 *            the billToAddress to set
	 */
	public void setBillToAddress(String billToAddress) {
		this.billToAddress = billToAddress;
	}

	/**
	 * @param billToAddress2
	 *            the billToAddress2 to set
	 */
	public void setBillToAddress2(String billToAddress2) {
		this.billToAddress2 = billToAddress2;
	}

	/**
	 * @param billToCity
	 *            the billToCity to set
	 */
	public void setBillToCity(String billToCity) {
		this.billToCity = billToCity;
	}

	/**
	 * @param billToCountry
	 *            the billToCountry to set
	 */
	public void setBillToCountry(String billToCountry) {
		this.billToCountry = billToCountry;
	}

	/**
	 * @param billToEmail
	 *            the billToEmail to set
	 */
	public void setBillToEmail(String billToEmail) {
		this.billToEmail = billToEmail;
	}

	/**
	 * @param billToFirstName
	 *            the billToFirstName to set
	 */
	public void setBillToFirstName(String billToFirstName) {
		this.billToFirstName = billToFirstName;
	}

	/**
	 * @param billToLastName
	 *            the billToLastName to set
	 */
	public void setBillToLastName(String billToLastName) {
		this.billToLastName = billToLastName;
	}

	/**
	 * @param billToPhone
	 *            the billToPhone to set
	 */
	public void setBillToPhone(String billToPhone) {
		this.billToPhone = billToPhone;
	}

	/**
	 * @param billToPostalCode
	 *            the billToPostalCode to set
	 */
	public void setBillToPostalCode(String billToPostalCode) {
		this.billToPostalCode = billToPostalCode;
	}

	/**
	 * @param billToProvince
	 *            the billToProvince to set
	 */
	public void setBillToProvince(String billToProvince) {
		this.billToProvince = billToProvince;
	}

	/**
	 * @param shipToAddress
	 *            the shipToAddress to set
	 */
	public void setShipToAddress(String shipToAddress) {
		this.shipToAddress = shipToAddress;
	}

	/**
	 * @param shipToAddress2
	 *            the shipToAddress2 to set
	 */
	public void setShipToAddress2(String shipToAddress2) {
		this.shipToAddress2 = shipToAddress2;
	}

	/**
	 * @param shipToCity
	 *            the shipToCity to set
	 */
	public void setShipToCity(String shipToCity) {
		this.shipToCity = shipToCity;
	}

	/**
	 * @param shipToCountry
	 *            the shipToCountry to set
	 */
	public void setShipToCountry(String shipToCountry) {
		this.shipToCountry = shipToCountry;
	}

	/**
	 * @param shipToEmail
	 *            the shipToEmail to set
	 */
	public void setShipToEmail(String shipToEmail) {
		this.shipToEmail = shipToEmail;
	}

	/**
	 * @param shipToFirstName
	 *            the shipToFirstName to set
	 */
	public void setShipToFirstName(String shipToFirstName) {
		this.shipToFirstName = shipToFirstName;
	}

	/**
	 * @param shipToLastName
	 *            the shipToLastName to set
	 */
	public void setShipToLastName(String shipToLastName) {
		this.shipToLastName = shipToLastName;
	}

	/**
	 * @param shipToPhone
	 *            the shipToPhone to set
	 */
	public void setShipToPhone(String shipToPhone) {
		this.shipToPhone = shipToPhone;
	}

	/**
	 * @param shipToPostalCode
	 *            the shipToPostalCode to set
	 */
	public void setShipToPostalCode(String shipToPostalCode) {
		this.shipToPostalCode = shipToPostalCode;
	}

	/**
	 * @param shipToProvince
	 *            the shipToProvince to set
	 */
	public void setShipToProvince(String shipToProvince) {
		this.shipToProvince = shipToProvince;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 29;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		final Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getNumber();
	}

}