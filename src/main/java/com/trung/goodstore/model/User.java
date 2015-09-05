package com.trung.goodstore.model;

import java.lang.Long;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * @author Trung Dinh. e-mail:trungnd07@gmail.com
 */
public class User extends BaseObject implements UserDetails {
	public static final long serialVersionUID = 999123456789013L;

	protected String username;// primary key
	protected String password;
	protected String confirmPassword;
	protected String firstName;
	protected String lastName;
	protected String phone;
	protected String email;
	protected String website;
	protected Address address = new Address();
	protected Set<Role> roles = new HashSet<Role>();
	protected Long version;
	protected boolean enabled;
	protected boolean accountExpired;
	protected boolean accountLocked;
	protected boolean credentialsExpired;
	
	/**
	 * @return the accountExpired
	 */
	public boolean isAccountExpired() {
		return accountExpired;
	}

	/**
	 * @return the accountLocked
	 */
	public boolean isAccountLocked() {
		return accountLocked;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @return the credentialsExpired
	 */
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param accountExpired
	 *            the accountExpired to set
	 */
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	/**
	 * @param accountLocked
	 *            the accountLocked to set
	 */
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @param credentialsExpired
	 *            the credentialsExpired to set
	 */
	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public GrantedAuthority[] getAuthorities() {

		return (GrantedAuthority[]) roles.toArray(new GrantedAuthority[0]);
	}

	public boolean isAccountNonExpired() {
		// 
		return !this.isAccountExpired();
	}

	public boolean isAccountNonLocked() {

		return !this.isAccountLocked();
	}

	public boolean isCredentialsNonExpired() {

		return !this.isCredentialsExpired();
	}

	public void addRole(Role role) {
		getRoles().add(role);
	}

	public int hashCode() {
		final int PRIME = 31;
		int result = 29;
		result = PRIME * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this,
				ToStringStyle.DEFAULT_STYLE).append("username", this.username)
				.append("enabled", this.enabled).append("accountExpired",
						this.accountExpired).append("credentialsExpired",
						this.credentialsExpired).append("accountLocked",
						this.accountLocked);

		GrantedAuthority[] auths = this.getAuthorities();
		if (auths != null) {
			sb.append("Granted Authorities: ");

			for (int i = 0; i < auths.length; i++) {
				if (i > 0) {
					sb.append(", ");
				}
				sb.append(auths[i].toString());
			}
		} else {
			sb.append("No Granted Authorities");
		}
		return sb.toString();
	}
}