package com.trung.goodstore.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class Address extends BaseObject implements Serializable {
	private static final long serialVersionUID = 3617859655330969141L;

	protected String address;
	protected String address2;
	protected String city;
	protected String province;
	protected String country;
	protected String postalCode;

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getCountry() {
		return country;
	}

	public String getPostalCode() {
		return postalCode;
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

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Address))
			return false;

		final Address address1 = (Address) o;

		if (address != null ? !address.equals(address1.address)
				: address1.address != null)
			return false;
		if (city != null ? !city.equals(address1.city) : address1.city != null)
			return false;
		if (country != null ? !country.equals(address1.country)
				: address1.country != null)
			return false;
		if (postalCode != null ? !postalCode.equals(address1.postalCode)
				: address1.postalCode != null)
			return false;
		if (province != null ? !province.equals(address1.province)
				: address1.province != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (address != null ? address.hashCode() : 31);
		result = 29 * result + (city != null ? city.hashCode() : 0);
		result = 29 * result + (province != null ? province.hashCode() : 0);
		result = 29 * result + (country != null ? country.hashCode() : 0);
		result = 29 * result + (postalCode != null ? postalCode.hashCode() : 0);
		return result;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("country", this.country)
				.append("address", this.address).append("province",
						this.province).append("postalCode", this.postalCode)
				.append("city", this.city).toString();
	}
}
