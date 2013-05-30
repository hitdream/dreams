<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		$('#dataMan').tree({
			data : [ {
				text : '系统管理',
				state : 'open',
				children : [  {
						text : 'FTP设置'
					} ]
			} ,
			{
				text : '文件管理',
				state : 'closed',
				children : [ {
					text : '文件上传'
				} ]
			},{
				text:'数据管理',
				state:'closed',
				children:[{
					text:'数据展示'
				}]
			}],
			onSelect : function(node) {
				var tab = $('#layout_center_tabs');
				console.info(tab.tabs('exists', '数据管理'));
				console.info(node);
				if (node.text == "FTP设置") {
					$('#user_FTPsetDialog').dialog('open');
					$('#user_FTPsetDialog_FTPForm input').val('');
					$('#port').val(21);
				}
				if (node.text == "文件上传") {
					$('#user_uploadDialog').dialog('open');
					$('#user_uploadDialog_uploadForm input').val('');
				}
				if (node.text == "数据展示" && (!tab.tabs('exists', '数据展示'))) {
					tab.tabs('add', {
						title : '数据展示',
						closable : true,
						href : 'user/treeGrid.jsp',
					});
				}else if(tab.tabs('exists', '数据展示')){
					tab.tabs('select','数据展示');
				}
			},
			onClick : function(node) {
				validateSession();
			}

		});

	});
</script>
</head>
<body>
	<div id="aa" class="easyui-accordion" fit:true border:false
		style="overflow: hidden;">
		<div title="数据管理">
			<div id="dataMan"></div>

		</div>

	</div>
</body>
</html>