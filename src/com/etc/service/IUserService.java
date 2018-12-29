package com.etc.service;

import java.util.List;

import com.etc.entity.Users;

public interface IUserService {
	public boolean register(Users user);
	
	public List<Users> getAll();
	
	public boolean delete(int id);
}
