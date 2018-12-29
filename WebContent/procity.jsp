<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'hw2.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!-- jqury库 -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/pca/pp",
		type:"get",
		dataType:"json",
		success:function(data){
			$.each(data,function(i){
				$("#province").append("<option value='"+i+"'>"+data[i]+"</option>");
			});
			
		}
	});
	$("#province").change(function(){
		
		$("#city").prop("length",1);
		$("#area").prop("length",1);
		if($("#province").val()!="default"){
			
		
		$.ajax({
			url:"${pageContext.request.contextPath}/pca/cc",
			type:"get",
			data:{pid:$("#province").val()},
			dataType:"json",
			success:function(data){
				
				$.each(data,function(i){
					$("#city").append("<option value='"+i+"'>"+data[i]+"</option>");
				});
				
			}
		});
		}
	});
	
	$("#city").change(function(){
		$("#area").prop("length",1);
		if($("#city").val()!="default"){
			
		$.ajax({
			url:"${pageContext.request.contextPath}/pca/aa",
			type:"get",
			data:{pid:$("#province").val(),cid:$("#city").val()},
			dataType:"json",
			success:function(data){
				$.each(data,function(i){
					$("#area").append("<option value='"+i+"'>"+data[i]+"</option>");
				});
				
			}
		});
		}
	});
	
});

</script>
  <body>
    <select id="province" >
      <option value="default">请选择省份</option>
    </select>
    <select  id="city">
      <option value="default">请选择市级</option>
    </select>
    <select  id="area" >
      <option value="default">请选择县</option>
    </select>
    
    <%-- <form name="serForm" action="${pageContext.request.contextPath}/pca/upload" method="post"  enctype="multipart/form-data">
	<h1>采用流的方式上传文件</h1>
	<input type="file" name="file">
	<input type="submit" value="upload"/>
	</form>
	
	<form name="Form2" action="${pageContext.request.contextPath}/pca/upload" method="post"  enctype="multipart/form-data">
	<h1>采用multipart提供的file.transfer方法上传文件</h1>
	<input type="file" name="file">
	<input type="submit" value="upload"/>
	</form> --%>
	
	<form name="Form2" action="${pageContext.request.contextPath}/pca/upload" method="post"  enctype="multipart/form-data">
	<h3>上传文件</h3>
	<input type="file" name="file">
	<input type="file" name="file1" >
	<input type="submit" value="upload"/>
	</form>
  </body>
</html>
