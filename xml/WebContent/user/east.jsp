<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<script type="text/javascript" charset="utf-8">
	$(function() {

		$('#onlineDatagrid').datagrid(
				{
					url : '${pageContext.request.contextPath}/OnlineUsers',
					title : '',
					iconCls : '',
					fit : true,
					fitColumns : true,
					pagination : true,
					pageSize : 10,
					pageList : [ 10 ],
					nowarp : false,
					border : false,
					idField : 'id',
					sortName : 'logindatetime',
					sortOrder : 'desc',
					frozenColumns : [ [ {
						title : '编号',
						field : 'id',
						width : 150,
						hidden : true
					} ] ],
					columns : [ [ {
						title : '登录名',
						field : 'name',
						width : 100,
						sortable : true,

					}, {
						title : 'IP',
						field : 'ip',
						width : 150,
						sortable : true,
					}, {
						title : '登录时间',
						field : 'loadtime',
						width : 150,
						sortable : true,
						hidden : true
					} ] ],
					onClickRow : function(rowIndex, rowData) {
					},
					onLoadSuccess : function(data) {
						$('#onlinePanel').panel('setTitle',
								'( ' + data.total + ' )人在线');
					}
				}).datagrid('getPager').pagination({
			showPageList : false,
			showRefresh : false,
			beforePageText : '',
			afterPageText : '/{pages}',
			displayMsg : ''
		});

		$('#calendar').calendar({
			fit : true,
			current : new Date(),
			border : false,
			onSelect : function(date) {
				$(this).calendar('moveTo', new Date());
			}
		});

		$('#onlinePanel').panel({
			tools : [ {
				iconCls : 'icon-reload',
				handler : function() {
					$('#onlineDatagrid').datagrid('load', {});
				}
			} ]
		});

		window.setInterval(function() {
			$('#onlineDatagrid').datagrid('load', {});
		}, 1000 * 60 * 10);

	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',border:false"
		style="height: 180px; overflow: hidden;">
		<div id="calendar"></div>
	</div>
	<div data-options="region:'center',border:false"
		style="overflow: hidden;">
		<div id="onlinePanel" data-options="fit:true,border:false"
			title="用户在线列表">
			<table id="onlineDatagrid"></table>
		</div>
	</div>
</div>