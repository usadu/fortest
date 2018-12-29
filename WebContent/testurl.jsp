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
	var param={userid:"111"}
	alert("1");
	$.ajax({
		url:"${pageContext.request.contextPath}/dd/a4",
		type:"delete",
		data:JSON.stringify(param),
		dataType:"json",
		success:function(data1){
			alert(data1);
		}
	})	
})



</script>
</head>
<body>
</body>
</html>