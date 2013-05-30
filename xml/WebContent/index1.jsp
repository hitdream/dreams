<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XML元数据管理系统</title>
<link rel="stylesheet" type="text/css"
	href="easyui-1.8.0/themes/sunny/easyui.css">
<link rel="stylesheet" type="text/css"
	href="easyui-1.8.0/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyui-1.8.0/demo/demo.css">
<script type="text/javascript" src="easyui-1.8.0/jquery-1.8.0.min.js">
	
</script>
<script type="text/javascript" src="easyui-1.8.0/jquery.easyui.min.js">
	
</script>
<script type="text/javascript"
	src="../easyui-1.8.0/locale/easyui-lang-zh_CN.js">
	
</script>
<style type="text/css">
#login_box {
	height: 170px;
	width: 275px;
	margin-right: auto;
	margin-left: auto;
	margin-top: 60px;
	background-color: #DDEEF6;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-border-radius: 10px;
	padding: 10px;
	-webkit-box-shadow: 0px 0px 10px #cccccc;
	-moz-box-shadow: 0px 0px 10px #cccccc;
	box-shadow: 0px 0px 10px #cccccc;
}

#input_label {
	float: left;
	width: 270px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	clear: both;
	color: #999;
	padding-top: 5px;
	padding-bottom: 2px;
}

#user,#pwd {
	float: left;
	clear: both;
	width: 250px;
	padding: 5px;
	border: 1px solid #ACE;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-border-radius: 5px;
}

#button {
	float: left;
	clear: both;
	width: 75px;
	padding: 5px;
	border: 1px solid #ACE;
	background: #b3dced; /* old browsers */
	background: -moz-linear-gradient(top, #b3dced 0%, #29b8e5 50%, #bce0ee 100%);
	/* firefox */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #b3dced),
		color-stop(50%, #29b8e5), color-stop(100%, #bce0ee) ); /* webkit */
	filter: progid:DXImageTransform.Microsoft.gradient(        startColorstr='#b3dced',
		endColorstr='#bce0ee', GradientType=0 ); /* ie */
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-border-radius: 10px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #FFF;
	margin-top: 10px;
	text-shadow: 0 -1px 0 #3399DD;
}

#links_wrap {
	clear: both;
	padding-top: 5px;
	padding-right: 5px;
	padding-bottom: 5px;
}

body {
	background-color: #DDEEef;

	
}
</style>
<script type="text/javascript">
	$(function() {
		$('#index_loadForm').form({
			url : 'CheckLoad',

			success : function(data) {
				console.info(data);
				var obj = jQuery.parseJSON(data);
				if (obj.success) {
					
				/* 	$('#p').progressbar({
						value : 0,
						width:200,
					});
					var value = $('#p').progressbar('getValue');

					while(value < 100) {

						console.info(value);
						
						value += Math.floor(Math.random() * 5);

						$('#p').progressbar('setValue', value);
					} */
					self.location='user/main.jsp';
				}
				$.messager.show({
					title : '提示',
					msg : obj.msg,
					showType : 'slide'
				});

			}

		});
	});
</script>
</head>

<body>
	<div id="login_box">
		<form id="index_loadForm" action="" method="post" name="form">
			<table width="270" cellspacing="0" cellpadding="0" border="0">
				<tbody>
					<tr>
						<td width="299"></td>
					</tr>
					<tr>
						<td>
							<p>
								<span id="input_label">用户名</span> <input id="user"
									class="easyui-validatebox" type="text" name="name"
									data-options="required:true,missingMessage:'用户名不能为空'">
							</p>
						</td>
					</tr>
					<tr>
						<td><span id="input_label">密码</span> <input id="pwd"
							class="easyui-validatebox" type="password" name="pwd"
							data-options="required:true,missingMessage:'密码不能为空'"></td>
					</tr>
					<tr>
						<td><input id="button" type="submit" value="登录" name="button"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id='p' align='center'></div>
</body>
</html>
