<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		var FtpParam = {
			url : '${pageContext.request.contextPath}/FtpUp',

			success : function(data) {
				console.info(data);
				var obj = jQuery.parseJSON(data);
				if (obj.success) {
					$('#user_uploadDialog').dialog('close');
				}
				$.messager.show({
					title : '提示',
					msg : obj.msg,
					showType : 'slide'
				});

			}

		};
		$('#user_uploadDialog_uploadForm').form(FtpParam);
		$('#user_uploadDialog').show().dialog({
			modal : true,
			title : '文件上传',
			closable : true,
			closed : true,
			buttons : [ {
				text : '确定',
				handler : function() {
					$('#user_uploadDialog_uploadForm').submit();
				}
			} ]
		});

	});
</script>
</head>
<body>
	<div id="user_uploadDialog"
		style="display: none; width: 330px; height: 110px; overflow: hidden;">

		<form method="post" id="user_uploadDialog_uploadForm" enctype="multipart/form-data">
			<table>
				<tr>
					<th>请选择上传文件：</th>
					<td><input type="file" name="file" class="easyui-validatebox"
						style="width: 150px;" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>