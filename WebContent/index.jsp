<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	alert("hello")
})

</script>
</head>
<body>
	<a href="mvc/hei2?op=哈哈">登录</a>
	<form action="mvc/hei2" method="post">
		<input type="text" name="name">
		<input type="text" name="pwd">
		<button type="submit">注册</button>
	</form>
</body>
</html>