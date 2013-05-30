<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		var FtpParam = {
			url : '${pageContext.request.contextPath}/FtpSet',

			success : function(data) {
				console.info(data);
				var obj = jQuery.parseJSON(data);
				if (obj.success) {
					$('#user_FTPsetDialog').dialog('close');
					location.replace('${pageContext.request.contextPath}/index.jsp');
				}
				$.messager.show({
					title : '提示',
					msg : obj.msg,
					showType : 'slide'
				});

			}

		};
		$('#user_FTPsetDialog_FTPForm').form(FtpParam);
		$('#user_FTPsetDialog').show().dialog({
			modal : true,
			title : 'FTP设置',
			closable : true,
			closed : true,
			buttons : [ {
				text : '确定',
				handler : function() {
					$('#user_FTPsetDialog_FTPForm').submit();
				}
			} ]
		});

	});
</script>
</head>
<body>
	<div id="user_FTPsetDialog"
		style="display: none; width: 300px; height: 210px; overflow: hidden;">

		<form method="post" id="user_FTPsetDialog_FTPForm">
			<table>
				<tr>
					<th>FTP地址</th>
					<td><input type="text" name="url" class="easyui-validatebox"
						style="width: 150px;" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>端口号</th>
					<td><input id="port" name="port" style="width: 150px;"></td>
				</tr>
				<tr>
					<th>用户名：</th>
					<td><input type="text" name="ftpUser"
						class="easyui-validatebox" style="width: 150px;"
						data-options="required:true" /></td>
				</tr>
				<tr>
					<th>密码：</th>
					<td><input type="password" name="ftpPassword"
						class="easyui-validatebox" style="width: 150px;"
						data-options="required:true" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>