package com.etc.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.etc.entity.City;
import com.etc.entity.Province;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Tools {

	// 将JSon文件转换成集合对象
	private static ArrayList<Province> getJsonData() {
		String str = "";
		try {
			FileInputStream fis = new FileInputStream(Tools.class
					.getClassLoader().getResource("").getPath()
					+ "citys.json");
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				str += line;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		//把一个json格式的文本转成对象 fromJson   
		return gson.fromJson(str, new TypeToken<List<Province>>() {}.getType());
	}

	// 获取所有省份集合
	public static ArrayList<String> getAllProvince() {
		ArrayList<String> provinces = new ArrayList<>();
		for (Province p : getJsonData()) {
			provinces.add(p.getName());
		}
		return provinces;
	}

	// 根据省份获得所有城市
	public static ArrayList<String> getAllCity(int pname) {
		ArrayList<String> citys = new ArrayList<>();
		for (City c : getJsonData().get(pname).getCityList()) {
			citys.add(c.getName());
		}
		return citys;
	}

	// 根据城市获得所有地区
	public static ArrayList<String> getAllArea(int pname,int cname) {
		return getJsonData().get(pname).getCityList().get(cname).getAreaList();
	}

}
