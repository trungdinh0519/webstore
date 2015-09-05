package com.trung.goodstore.service;

import java.util.List;

import com.trung.goodstore.model.Country;
import com.trung.goodstore.persistence.CountryDao;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;

public interface CountryManager extends Manager {
	void setCountryDao(CountryDao dao);
	boolean isExistName(String name);

	boolean isExistCode2(String code2);

	boolean isExistCode3(String code3);
	List<Country> getCountries();
	Country getCountryByCode2(String code2) throws ObjectNotFoundException;

	Country getCountryByCode3(String code3) throws ObjectNotFoundException;

	Country getCountryByName(String name) throws ObjectNotFoundException;
}
