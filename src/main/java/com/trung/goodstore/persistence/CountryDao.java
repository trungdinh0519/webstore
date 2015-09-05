package com.trung.goodstore.persistence;

import java.util.List;

import com.trung.goodstore.model.Country;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;

public interface CountryDao extends Dao {
	boolean isExistName(String name);

	boolean isExistCode2(String code2);

	boolean isExistCode3(String code3);

	List getCountries();

	Country getCountryByCode2(String code2) throws ObjectNotFoundException;

	Country getCountryByCode3(String code3) throws ObjectNotFoundException;

	Country getCountryByName(String name) throws ObjectNotFoundException;
}
