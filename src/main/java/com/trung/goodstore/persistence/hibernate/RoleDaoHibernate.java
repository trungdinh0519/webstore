package com.trung.goodstore.persistence.hibernate;

import java.util.List;

import com.trung.goodstore.model.Role;
import com.trung.goodstore.persistence.RoleDao;
import com.trung.goodstore.persistence.exception.RoleNotFoundException;



public class RoleDaoHibernate extends DaoHibernate implements RoleDao {

	public Role getRole(String name) throws RoleNotFoundException {
		List roles = this.getHibernateTemplate().find(
				"from Role where name=?", name);
		if (roles==null||roles.isEmpty()) {
			log.error("Role:" + name + ":Not Found");
			throw new RoleNotFoundException("Role:" + name + ":Not Found");

		}else
		return (Role) roles.get(0);
	}

}
