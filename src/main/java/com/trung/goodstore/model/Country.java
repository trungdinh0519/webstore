package com.trung.goodstore.model;

/**
 * 
 * @author Trung Dinh
 * 
 */
/*
 * @hibernate.class table="ssh_country"
 */
public class Country extends BaseObject {
	public Country() {
		super();
	}

	public static final long serialVersionUID = 123456789003L;

	private Long id;

	private String name;

	private String code2;

	private String code3;

	//private Set<Province> provinces = new HashSet<Province>();

	//public void addStateOrProvince(Province stateOrProvince) {
	//	stateOrProvince.setCountry(this);
	///	//this.provinces.add(stateOrProvince);
	//}

	/*
	 * @hibernate.property column="country_code2" length="2" not-null="true"
	 * unique="true"
	 */
	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	/*
	 * @hibernate.property column="country_code3" length="3" not-null="true"
	 * unique="true"
	 */
	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}

	/*
	 * @hibernate.id column="country_id" generator-class="native" @return
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * @hibernate.property column="country_name" length="64" not-null="true"
	 * unique="true"
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//public Set<Province> getProvinces() {
	//	return provinces;
	//}

	//public void setProvinces(Set<Province> provinces) {
	//	this.provinces = provinces;
	//}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 29;
		result = PRIME * result + ((code2 == null) ? 0 : code2.hashCode());
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		final Country other = (Country) obj;
		if (code2 == null) {
			if (other.code2 != null)
				return false;
		} else if (!code2.equals(other.code2))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName();
	}

}
