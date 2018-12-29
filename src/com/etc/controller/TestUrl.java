package com.etc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.entity.Users;
import com.etc.serviceimpl.UserServiceImpl;

@Controller
@RequestMapping("/dd")
public class TestUrl {
	
	@Resource(name="userServiceImpl")
	UserServiceImpl us;
	@RequestMapping("/h1/{ddd}/{dddd}")
	public String h2(@PathVariable String ddd,@PathVariable String dddd) {
		System.out.println(ddd);
		System.out.println(dddd);
		return "urltest";
	}
	
	
	@RequestMapping("/h1/**/d")
	public String h1() {
		System.out.println("asdasdasdasdasdasdasd");
		return "urltest";
	}
	
	@RequestMapping(value="h3",produces= {"text/html;charset=utf-8","application/json;"})
	@ResponseBody
	public List<Users> h3() {
		
		List<Users> list=us.getAll();
		
		return list;
	}
	@RequestMapping(value="h4",method=RequestMethod.GET,produces= {"text/html;charset=utf-8","application/json;"})
	@ResponseBody
	public List<Users> h4(String userid) {
		int uid=Integer.parseInt(userid);
		System.out.println(uid);
		List<Users> list=null;
		boolean flag=us.delete(uid);
		if(flag) {
			 list=us.getAll();
		}
		return list;
	}
	@RequestMapping(value="a4",method=RequestMethod.DELETE,produces= {"text/html;charset=utf-8","application/json;"})
	@ResponseBody
	public String a4(String userid) {
		System.out.println(userid);
		System.out.println(userid==null);
		if(userid==null) {
			userid="hehe";
		}
		
		return userid;
		
	}
}
