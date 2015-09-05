package com.trung.goodstore.model;


/**
 * 
 * @author Trung Dinh
 *
 */
public class CreditCardType extends BaseObject{
	public CreditCardType() {}
	public static final long serialVersionUID = 123456789007L;
	private Long id;
	private String Code;
	private String name;
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 29;
		result = PRIME * result + ((Code == null) ? 0 : Code.hashCode());
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
		final CreditCardType other = (CreditCardType) obj;
		if (Code == null) {
			if (other.Code != null)
				return false;
		} else if (!Code.equals(other.Code))
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
