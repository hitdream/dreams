<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function() {
		$('#dg').datagrid({
			url : 'FileDataGrid',
			fitColumns : true,
			pagination : true,
			fit : true,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			singleSelect : true,
			columns : [ [ {
				field : 'id',
				title : '序号',
				width : 10,
			//checkbox:true,
			}, {
				field : 'fileName',
				title : '文件名',
				width : 300,
			} ] ],
			toolbar : [ {
				text : "删除",
				iconCls : "icon-remove",
				handler : function() {
					remove();
				}
			} ],
			onRowContextMenu : function(e, rowIndex, rowData) {
				validateSession();
				e.preventDefault();
				// 显示上下文菜单
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});

			},
		});
	});
	function remove() {
		var rows = $('#dg').datagrid('getSelected');
		if (rows) {
			$.messager.confirm('Confirm', '您确定要所删除选中的文件吗？', function(r) {
				if (r) {

					var index = $('#dg').datagrid('getRowIndex', rows);
					$.ajax({
						type : 'post',
						//url : 'delHandler.ashx?id=' + Rows.xsbh+ '&type=stu',
						//加了个type，作用是以后不管什么删除，都可以转到这个ashx中处理  
						success : function() {
							$.messager.alert('提示', '删除成功!', 'info');

						}
					});
					$('#dg').datagrid('deleteRow', index);
					/* for ( var i = 0; i < rows.length; i++) {
						var index = $('#dg').datagrid('getRowIndex', rows[i]);
						if (rows) {
							console.info(rows[i].fileName);
							$('#dg').datagrid('deleteRow', index);
						}
					} */
				}
			});
		}
	}
</script>

<table id="dg"></table>
<div id="menu" class="easyui-menu" style="width: 120px;">
	<div onclick="remove()" data-options="iconCls:'icon-remove'">删除</div>
</div>
