package com.trung.goodstore.service.impl;

import java.util.List;

import com.trung.goodstore.model.Country;
import com.trung.goodstore.persistence.CountryDao;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
import com.trung.goodstore.service.CountryManager;

public class CountryManagerImpl extends ManagerImpl implements CountryManager {
	private CountryDao countryDao;

	public void setCountryDao(CountryDao dao) {
		this.countryDao = dao;
	}

	public boolean isExistCode2(String code2) {
		return this.countryDao.isExistCode2(code2);
	}

	public boolean isExistCode3(String code3) {
		return this.countryDao.isExistCode3(code3);
	}

	public boolean isExistName(String name) {
		return this.countryDao.isExistName(name);
	}

	/* (non-Javadoc)
	 * @see com.trung.goodstore.service.CountryManager#getCountries()
	 */
	public List<Country> getCountries() {
		// TODO Auto-generated method stub
		return (List<Country>)countryDao.getCountries();
	}

	/* (non-Javadoc)
	 * @see com.trung.goodstore.service.CountryManager#getCountryByCode2(java.lang.String)
	 */
	public Country getCountryByCode2(String code2) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		return this.countryDao.getCountryByCode2(code2);
	}

	/* (non-Javadoc)
	 * @see com.trung.goodstore.service.CountryManager#getCountryByCode3(java.lang.String)
	 */
	public Country getCountryByCode3(String code3) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		return this.countryDao.getCountryByCode3(code3);
	}

	/* (non-Javadoc)
	 * @see com.trung.goodstore.service.CountryManager#getCountryByName(java.lang.String)
	 */
	public Country getCountryByName(String name) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		return this.countryDao.getCountryByName(name);
	}
	

}
