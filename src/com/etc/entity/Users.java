package com.etc.entity;

import org.springframework.stereotype.Component;

@Component
public class Users {
	private int uid;
	private String name;
	private String pwd;
	private String uphoto;
	private String jianli;
	
	
	public String getUphoto() {
		return uphoto;
	}


	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}


	public String getJianli() {
		return jianli;
	}


	public void setJianli(String jianli) {
		this.jianli = jianli;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getName() {
		return name;
	}


	public String getPwd() {
		return pwd;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
public Users() {
	// TODO Auto-generated constructor stub
}


	public Users( String name, String pwd, String uphoto, String jianli) {
	super();
	this.name = name;
	this.pwd = pwd;
	this.uphoto = uphoto;
	this.jianli = jianli;
}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
