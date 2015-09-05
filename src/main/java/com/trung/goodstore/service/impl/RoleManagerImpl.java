package com.trung.goodstore.service.impl;

import com.trung.goodstore.model.Role;
import com.trung.goodstore.persistence.RoleDao;
import com.trung.goodstore.persistence.exception.RoleNotFoundException;
import com.trung.goodstore.service.RoleManager;



public class RoleManagerImpl extends ManagerImpl implements RoleManager {
protected RoleDao roleDao;
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao=roleDao;
	}

	public Role getRole(String name) throws RoleNotFoundException {
		return roleDao.getRole(name);
	}

}
