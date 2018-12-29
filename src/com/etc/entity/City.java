package com.etc.entity;

import java.util.ArrayList;

public class City {
	private String name;
	private ArrayList<String> areaList;
	
	public ArrayList<String> getAreaList() {
		return areaList;
	}

	public void setAreaList(ArrayList<String> areaList) {
		this.areaList = areaList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
