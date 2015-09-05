package com.trung.goodstore.service;

import com.trung.goodstore.model.Role;
import com.trung.goodstore.persistence.RoleDao;
import com.trung.goodstore.persistence.exception.RoleNotFoundException;




public interface RoleManager extends Manager {
	public void setRoleDao(RoleDao roleDao);

	public Role getRole(String name) throws RoleNotFoundException;
}
