package com.etc.entity;

import java.util.List;

public class Province {
	private String name;
	private List<City> cityList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	
	public Province(String name, List<City> cityList) {
		super();
		this.name = name;
		this.cityList = cityList;
	}
	
}
