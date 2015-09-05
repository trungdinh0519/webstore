package com.trung.goodstore.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trung.goodstore.model.Role;
import com.trung.goodstore.persistence.LookupDao;
import com.trung.goodstore.service.LookupManager;


public class LookupManagerImpl extends ManagerImpl implements LookupManager {
	private LookupDao ludao;

	public Map<String, Role> getAllRoles() {
		List roles = ludao.getRoles();
		Map<String, Role> map = new HashMap<String, Role>();
		Role role = null;
		for (int i = 0; i < roles.size(); i++) {
			role = (Role) roles.get(i);
			map.put(role.getName(), role);
		}
		return map;
	}

	public void setLookupDao(LookupDao dao) {
		this.ludao = dao;
	}

}
