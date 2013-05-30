<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Map" %>
<head>

<script type="text/javascript" charset="utf-8">
	function logoutFun(b) {

		if (b) {		//登出操作，让session失效
			$.getJSON('${pageContext.request.contextPath}/Logout',
							function(result) {
				console.info(result);
								if (b) {
									location.replace('${pageContext.request.contextPath}/index.jsp');
								} 
							});
		}
	}
	function validateSession(){   //验证session是否过期 
		var checkSession='<%= session.getAttribute("name") %>';
		 // console.info(checkSession);
		  if(checkSession==null||checkSession==""){
			
		  $.messager.confirm('提示','由于会话过期，您已经登出系统，是否重新登录？',function(r){
			  if(r)
				  { 
				  location.replace('${pageContext.request.contextPath}/index.jsp');
				  }
		  });

	}
	}
	
</script>
</head>
<body>
<div style="position: absolute; right: 0px; bottom: 0px;">
	<a href="javascript:void(0);" class="easyui-menubutton"
		data-options="menu:'#layout_north_zxMenu',iconCls:'icon-back'">注销</a>
</div>
<div id="layout_north_zxMenu" style="width: 100px; display: none;">
	<div onclick="logoutFun(true);">退出系统</div>
</div>
<div id="sessionInfoDiv"
	style="position: absolute; right: 60px; top: 60px;">
	<%
		 
	Map<String, String> name = (Map<String, String>) session.getAttribute("name");
	//	session.setMaxInactiveInterval(2);
		//System.out.println(name);
		String user="";
		String remoteIP = "";
		if(name!=null){
		 user= name.get("name");
		 remoteIP=name.get("IP");
		}
		
	%>
	<c:if test="${name!= null}">[<strong><%=user %></strong>]，欢迎你！您使用[<strong><%=remoteIP%></strong>]IP登录！</c:if>
</div>
</body>