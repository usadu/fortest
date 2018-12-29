<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div align="center" >
		<form action="${pageContext.request.contextPath}/pca/upload" method="post"  enctype="multipart/form-data">
		用&nbsp;户&nbsp;名:<input type="text" name="name" placeholder="请输入用户名">
		<hr>
		密 &nbsp;&nbsp;&nbsp;码:<input type="text" name="pwd" placeholder="请输入密码">
		<hr>
		确认密码:<input type="text"  placeholder="确认密码">
		<hr>
		头像:<input type="file" name="file">
		<hr>
		简历:<input type="file" name="file">
		<hr>
		<input type="submit" value="注册">
		</form>
</div>
</body>
</html>