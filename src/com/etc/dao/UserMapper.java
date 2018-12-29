package com.etc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.etc.entity.Users;
@Repository
public interface UserMapper {
	public boolean register(Users user);
	
	public List<Users> getAll();
	
	public boolean delete(int id);
}
