package com.trung.goodstore.persistence.hibernate;

import java.util.List;

import com.trung.goodstore.model.Country;
import com.trung.goodstore.model.User;
import com.trung.goodstore.persistence.CountryDao;
import com.trung.goodstore.persistence.exception.AccountNotFoundException;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;

public class CountryDaoHibernate extends DaoHibernate implements CountryDao {

	public boolean isExistCode2(String code2) {
		List accs = this.getHibernateTemplate().find(
				"from Country where code2=?", code2);
		if (accs != null && !accs.isEmpty())
			return true;
		else
			return false;

	}

	public boolean isExistCode3(String code3) {
		List accs = this.getHibernateTemplate().find(
				"from Country where code3=?", code3);
		if (accs != null && !accs.isEmpty())
			return true;
		else
			return false;
	}

	public boolean isExistName(String name) {
		List accs = this.getHibernateTemplate().find(
				"from Country where name=?", name);
		if (accs != null && !accs.isEmpty())
			return true;
		else
			return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.trung.goodstore.persistence.CountryDao#getCountries()
	 */
	public List getCountries() {
		return this.getHibernateTemplate().find("from Country order by name");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.trung.goodstore.persistence.CountryDao#getCountryByCode2(java.lang.String)
	 */
	public Country getCountryByCode2(String code2)
			throws ObjectNotFoundException {
		List list = this.getHibernateTemplate().find(
				"from Country where code2=?", code2);
		if (list == null || list.isEmpty()) {
			throw new ObjectNotFoundException("Country code2:" + code2);
		}
		return (Country) list.get(0);

	}

	public Country getCountryByCode3(String code3)
			throws ObjectNotFoundException {
		List list = this.getHibernateTemplate().find(
				"from Country where code3=?", code3);
		if (list == null || list.isEmpty()) {
			throw new ObjectNotFoundException("Country code3:" + code3);
		}
		return (Country) list.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.trung.goodstore.persistence.CountryDao#getCountryByName(java.lang.String)
	 */
	public Country getCountryByName(String name) throws ObjectNotFoundException {
		List list = this.getHibernateTemplate().find(
				"from Country where name=?", name);
		if (list == null || list.isEmpty()) {
			throw new ObjectNotFoundException("Country name:" + name);
		}
		return (Country) list.get(0);
	}

}
