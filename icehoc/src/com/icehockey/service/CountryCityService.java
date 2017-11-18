package com.icehockey.service;

import com.icehockey.dao.CityDao;
import com.icehockey.dao.CountryDao;
import com.icehockey.entity.City;
import com.icehockey.entity.Country;

public class CountryCityService {
	CountryDao countryDao = new CountryDao();
	CityDao cityDao = new CityDao();

	Country country = null;
	City city = null;

	public Country queryCountry(int countryId) {// 通过角色名称查找角色对象并返回
		country = countryDao.getCountry(countryId);
		if (country != null) {
			System.out.println(country.toString());
		}
		return country;
	}

	public City queryCity(int cityId) {// 通过角色名称查找角色对象并返回
		city = cityDao.getCity(cityId);
		if (country != null) {
			System.out.println(country.toString());
		}
		return city;
	}
}
