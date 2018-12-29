package com.etc.serviceimpl;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.dao.UserMapper;
import com.etc.entity.Users;
import com.etc.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	String resource=null;
	InputStream inputStream=null;
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	SqlSession session=null;
	UserMapper um=null;
	public void Conn() throws IOException {

		 resource = "spring-mybatis.xml";
		 inputStream = Resources.getResourceAsStream(resource);
		 session = sqlSessionFactory.openSession();
		 um=session.getMapper(UserMapper.class);
		}
	@Override
	public boolean register(Users user) {
		Boolean flag = false;
		try {
			Conn();
			flag=um.register(user);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return flag;
	}
	@Override
	public List<Users> getAll() {
		List<Users> list=null;
		try {
			Conn();
		 list=um.getAll();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean delete(int id) {
			try {
				Conn();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return um.delete(id);
	}
	
	

}
