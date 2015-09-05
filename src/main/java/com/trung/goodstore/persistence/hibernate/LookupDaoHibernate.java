package com.trung.goodstore.persistence.hibernate;

import java.util.List;

import com.trung.goodstore.persistence.LookupDao;

public class LookupDaoHibernate extends DaoHibernate implements LookupDao {
   public List getRoles() {
        log.debug("retrieving all role names...");

        return getHibernateTemplate().find("from Role order by name");
    }
}
