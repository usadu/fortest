package com.etc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.entity.Users;
import com.etc.serviceimpl.UserServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext content=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserServiceImpl us=content.getBean(UserServiceImpl.class);
		Users users=content.getBean(Users.class);
		users.setName("xiao");
		users.setPwd("123");
		System.out.println(us.register(users));
	}

}
