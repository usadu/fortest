package com.etc.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.etc.entity.Users;
import com.etc.serviceimpl.UserServiceImpl;
import com.etc.utils.Tools;
import com.sun.org.glassfish.gmbal.ParameterNames;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

@Controller
@RequestMapping("/pca")
public class ProController {
	@RequestMapping("/pp")
	@ResponseBody
	public ArrayList<String> hh() {
		ArrayList<String> list=Tools.getAllProvince();
		System.out.println(list);
		return list;
		
	}
	@RequestMapping("/cc")
	@ResponseBody
	public ArrayList<String> cc(int pid) {
		ArrayList<String> list=Tools.getAllCity(pid);
		
		return list;
		
	}
	@RequestMapping("/aa")
	@ResponseBody
	public ArrayList<String> aa(int pid,int cid) {
		ArrayList<String> list=Tools.getAllArea(pid, cid);
		return list;
	}
	/*@RequestMapping("/upload")
	public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException
	{
		
		 long  startTime=System.currentTimeMillis();
         //����ǰ�����ĳ�ʼ����  CommonsMutipartResolver ���ಿ�ֽ�������
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //���form���Ƿ���enctype="multipart/form-data"
        
        if(multipartResolver.isMultipart(request))
        {
            //��request��ɶಿ��request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //��ȡmultiRequest �����е��ļ���
            Iterator<String> iter=multiRequest.getFileNames();
             
            while(iter.hasNext())
            {
                //һ�α��������ļ�
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="E:/springUpload/"+file.getOriginalFilename();
                    //�ϴ�
                    file.transferTo(new File(path));
                }
                 
            }
           
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("������������ʱ�䣺"+String.valueOf(endTime-startTime)+"ms");
        return "/success"; 
		
	}*/
	@Resource
	UserServiceImpl usi;
	@RequestMapping("/upload")
	public String  springUpload(Users user,@RequestParam("file")MultipartFile[] files) throws IllegalStateException, IOException
	{	
		String uphoto="";
		String jianli="";
		String filePath="E://springUpload/";
              for (int i = 0; i < files.length; i++) {
            	  MultipartFile file=files[i];
            	  SimpleDateFormat date=new SimpleDateFormat();
            	  String  time=date.format(new Date());
            	 String filename= file.getOriginalFilename();
            	 if(i==0) {
            		 uphoto=filePath+time+"_"+filename;
            	 }
            	 if(i==1) {
            		 jianli=filePath+time+"_"+filename;
            	 }
            	File f=new File(filePath+filename);
            	 file.transferTo(f);
              } 
              Users u= new Users(user.getName(),user.getPwd(),uphoto,jianli);
              usi.register(u);
              
        return "/success"; 
		
	}
}
