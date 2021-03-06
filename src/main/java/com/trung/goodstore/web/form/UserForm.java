/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.trung.goodstore.web.form;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.trung.goodstore.model.Address;
import com.trung.goodstore.model.Role;

/**
 * MyEclipse Struts Creation date: 11-06-2007
 * 
 * XDoclet definition:
 * 

 */
public class UserForm extends ValidatorForm {
	public static final long serialVersionUID = 123343243243432L;

	/*
	 * Generated Methods
	 */
	protected String username;// primary key
	protected String password;
	protected String confirmPassword;
	protected String firstname;
	protected String lastname;
	protected String phone;
	protected String email;
	protected String website;
	protected Long version;
	protected Address address;
	protected String[] roles;
	protected boolean enabled;
	protected boolean accountExpired;
	protected boolean accountLocked;
	protected boolean credentialsExpired;
	
	public UserForm() {super();
	address = new Address();
	roles=new String[0];
	this.enabled=true;
	this.accountExpired=false;
	this.accountLocked=false;
	this.credentialsExpired=false;
	
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public boolean isAccountExpired() {
		return accountExpired;
	}
	public boolean isAccountLocked() {
		return accountLocked;
	}
	public Address getAddress() {
		return address;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}
	public String getEmail() {
		return email;
	}
	public boolean isEnabled() {
		return enabled;
	}
	
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public String[] getRoles() {
		return roles;
	}
	public String getUsername() {
		return username;
	}
	public String getWebsite() {
		return website;
	}
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Override
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		super.reset(arg0, arg1);
		this.enabled=true;
		this.accountExpired=false;
		this.accountLocked=false;
		this.credentialsExpired=false;
		this.address=new Address();
		this.confirmPassword="";
		this.email="";
		this.firstname="";
		this.lastname="";
		this.password="";
		this.phone="";
		this.roles=new  String[0];
		this.username="";
		this.version=0L;
		this.website="";
	}
	
}