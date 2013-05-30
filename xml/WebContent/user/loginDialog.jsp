<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		var formParam = {
			url : '${pageContext.request.contextPath}/Login',

			success : function(data) {
				console.info(data);
				var obj = jQuery.parseJSON(data);
				if (obj.success) {
					$('#user_login_loginDialog').dialog('close');
					$.messager.progress({
						interval : 100,
						msg : '正在准备数据...',
						text : ''
					});
					setTimeout(function() {
						$.messager.progress('close');
					}, 1900);
					setTimeout(
							function() {
								location
										.replace('${pageContext.request.contextPath}/index.jsp');
							}, 2000);

				}
				$.messager.show({
					title : '提示',
					msg : obj.msg,
					showType : 'slide'
				});

			}

		};
		$('#admin_login_loginForm').form(formParam);
		$('#user_login_loginForm').form(formParam);

		$('#user_login_loginDialog').show().dialog({
			modal : true,
			title : '系统登录',
			closable : false,
			buttons : [ {
				text : '登录',
				handler : function() {
					var tab = $('#user_login_loginTab').tabs('getSelected');
					tab.find('form').submit();
				}
			} ]
		});
		$('#user_login_loginTab').tabs({
			fit : true,
			border : false,

		});
	});
</script>
</head>
<body>
	<div id="user_login_loginDialog"
		style="display: none; width: 300px; height: 210px; overflow: hidden;">
		<div id="user_login_loginTab">
			<div title="管理员登录" style="overflow: hidden;">
				<div align="center">
					<form method="post" id="admin_login_loginForm">
						<table>
							<tr>
								<th>登录名</th>
								<td><input name="name" class="easyui-validatebox"
									data-options="required:true" value="admin" /></td>
							</tr>
							<tr>
								<th>密码</th>
								<td><input type="password" name="pwd"
									class="easyui-validatebox" data-options="required:true"
									style="width: 150px;" value="admin" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div title="普通用户登录" style="overflow: hidden;">
				<div align="center">
					<form method="post" id="user_login_loginForm">
						<table>
							<tr>
								<th>登录名</th>
								<td><input name="name" style="width: 155px;" value="務卓" />
								</td>
							</tr>
							<tr>
								<th>密码</th>
								<td><input type="password" name="pwd"
									class="easyui-validatebox" data-options="required:true"
									style="width: 150px;" value="jenkin" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>