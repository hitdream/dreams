<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="baseStyle.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$.messager.alert('提示','对不起，您的IP被限制登录!','info');


	});
</script>
</head>
<body>

<div id="error">

</div>
</body>
</html>