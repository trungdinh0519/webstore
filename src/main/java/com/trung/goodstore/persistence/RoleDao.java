package com.trung.goodstore.persistence;

import com.trung.goodstore.model.Role;
import com.trung.goodstore.persistence.exception.RoleNotFoundException;




public interface RoleDao extends Dao {
public Role getRole(String name)throws RoleNotFoundException;
}
