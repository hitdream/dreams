<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>XML元数据管理系统</title>
<jsp:include page="baseStyle.jsp"></jsp:include>
</head>
<body class="easyui-layout">

	<div data-options="region:'north',title:'XML元数据管理'"
		style="height: 80px;" onclick="validateSession()">
		<jsp:include page="user/north.jsp"></jsp:include>
	</div>
	<div data-options="region:'east',title:'日历',split:true" style="width: 200px;overflow: hidden;">
		<jsp:include page="/user/east.jsp"></jsp:include>
	</div>
	<div data-options="region:'west',title:'控制面板',border:false"
		style="width: 200px;" onclick="validateSession()">
		<jsp:include page="user/west.jsp"></jsp:include>
	</div>
	<div
		data-options="region:'center',title:'展示中心',href:'${pageContext.request.contextPath}/user/center.jsp'"
		onclick="validateSession()">
		<%-- 	<div id="dataMan_tab" class="easyui-tabs">
			<div title="数据管理" data-options="fit:true,border:false,closable:true">

				<jsp:include page="user/center2.jsp"></jsp:include>

			</div>
		</div> --%>
	</div>
	<div data-options="region:'south'" style="height: 20px; color: #8E846B">
		<div class="easyui-panel" style="text-align: center">
			版权所有 @<a href="mailto:jenkin_lee@sina.com">jenkin</a>
		</div>
	</div>
	<%
		Map<String, String> name = (Map<String, String>) session
				.getAttribute("name");
		//out.print(name);
	%>
	<c:if test="${name==null}">
		<jsp:include page="user/loginDialog.jsp"></jsp:include>
	</c:if>
	<jsp:include page="user/FTPsetDialog.jsp"></jsp:include>
	<jsp:include page="user/uploadDialog.jsp"></jsp:include>
</body>
</html>