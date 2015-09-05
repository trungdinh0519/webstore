package com.trung.goodstore.model;

import java.lang.String;

import org.acegisecurity.GrantedAuthority;

public class Role extends BaseObject implements GrantedAuthority{
	public static final long serialVersionUID = 123456789014L;
	public Role() {}
	private Long id;
	private String name;
	private String desc;
	public String getdesc() {
		return desc;
	}
	public void setdesc(String desc) {
		this.desc = desc;
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
	public String getAuthority() {
        return getName();
    }
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		final Role other = (Role) obj;
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