package com.trung.goodstore.model;

import java.util.HashSet;
import java.util.Set;

public class Manufacturer extends BaseObject {
	public Manufacturer() {	}
	public static final long serialVersionUID = 123456789016L;
	private String desc;
	private String email;
	private Long id;
	private String name;
	private String url;
	private Set products=new HashSet();
	
	/**
	 * @return the products
	 */
	public Set getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(Set products) {
		this.products = products;
	}
	public String getDesc() {
		return desc;
	}
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 29;
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
		final Manufacturer other = (Manufacturer) obj;
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
		
		return this.getName();
	}
	
}
