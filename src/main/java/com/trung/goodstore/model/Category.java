package com.trung.goodstore.model;

import java.lang.Long;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @author Trung Dinh
 * 
 */
public class Category extends BaseObject {
	public static final long serialVersionUID = 123456789001L;
	public Category() {}
	public Category(String name) {
		this.name = name;
	}
	private Long id;
	private String name;
	private Category parent;
	private String desc;	
	private Set products=new HashSet();
	private Set childCategories=new HashSet();
	
	
	/**
	 * @return the childCategories
	 */
	public Set getChildCategories() {
		return childCategories;
	}
	/**
	 * @param childCategories the childCategories to set
	 */
	public void setChildCategories(Set childCategories) {
		this.childCategories = childCategories;
	}
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
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	

	public Category getParent() {
		return parent;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public void setParent(Category parent) {
		this.parent = parent;
	}

	public int hashCode() {
		final int PRIME = 31;
		int result = 29;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		final Category other = (Category) obj;
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

	public String toString() {

		return this.getName();
	}

}