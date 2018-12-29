<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	alert("hello")
	$.getJSON("${pageContext.request.contextPath}/dd/h3",
			function(data){
		
		forlist(data);
		});
		
		$(".delet").click(function(){
			alert($(this).val());
			$.ajax({
				url:"${pageContext.request.contextPath}/dd/h4",
				type:"get",
				data:{userid:$(this).val()},
				dataType:"json",
				success:function(data1){
					$("#foruser").html("");
					forlist(data);
				}
			})	
		});
	});


function forlist(data){
$.each(data,function(i){
			$("#foruser").append("<tr>"+
					"<td class='uid'>"+data[i].uid+"</td>"+
					"<td>"+data[i].name+"</td>"+
					"<td>"+data[i].pwd+"</td>"+
					"<td>"+"<button class='delet' value="+data[i].uid+">删除</button ></td>"+
					"<tr>")
});
}
</script>
</head>
<body>
	<table>
	<thead>
	<tr>
	<td>用户编号</td>
	<td>用户名</td>
	<td>密码</td>
	<tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="user">
	<tr>
	<td>${user.uid}</td>
	<td>${user.name}</td>
	<td>${user.pwd}</td>
	<td><a href="${pageContext.request.contextPath }/mvc/hei3?uid=${user.uid}"><button>删除</button></a></td>
	<tr>
	</c:forEach>
	
	
	</tbody>
	
	
	</table>
	
	<table>
	<thead>
	<tr>
	<td>用户编号</td>
	<td>用户名</td>
	<td>密码</td>
	<tr>
	</thead>
	<tbody id="foruser">

	
	
	</tbody>
	
	
	</table>
</body>
</html>