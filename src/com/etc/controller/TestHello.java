package com.etc.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etc.entity.Users;
import com.etc.serviceimpl.UserServiceImpl;

@Controller
@RequestMapping("/mvc")
public class TestHello {
	@Resource(name="userServiceImpl")
	UserServiceImpl us;
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	@RequestMapping("/hei")
	public String h1(HttpServletRequest request) {
	System.out.println(request.getParameter("op"));
		return "hello";
	}
	@RequestMapping("/hei1")
	public String h2(HttpServletRequest request) throws UnsupportedEncodingException {
		
		String st=request.getParameter("a");
		System.out.println(st);
		return "hello";
	}
	@RequestMapping("/hei2")
	public ModelAndView h3(Users user) throws UnsupportedEncodingException{
		
		ModelAndView mv=null;
		
		
		boolean flag=us.register(user);
		
		if(flag) {
			 mv=new ModelAndView();
			List<Users> list=us.getAll();
			mv.addObject("list", list);
			mv.setViewName("hello");
		}
		
		
		return mv;
	}
	@RequestMapping("/hei3")
	public String h4(String uid) {
		int uid1=Integer.parseInt(uid);
		us.delete(uid1);
		/*return "forward:/mvc/hei4";*/
		return "redirect:/mvc/hei4";
	}
	@RequestMapping("/hei4")
	public ModelAndView h5() {
		ModelAndView mv=new ModelAndView();
			List<Users> list=us.getAll();
			mv.addObject("list", list);
			mv.setViewName("hello");
		return mv;
		
	}
}
