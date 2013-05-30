<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#layout_center_tabsMenu').menu(
				{
					onClick : function(item) {
						var curTabTitle = $(this).data('tabTitle');
						var type = $(item.target).attr('type');

						if (type === 'refresh') {
							layout_center_refreshTab(curTabTitle);
							return;
						}

						if (type === 'close') {
							var t = $('#layout_center_tabs').tabs('getTab',
									curTabTitle);
							if (t.panel('options').closable) {
								$('#layout_center_tabs').tabs('close',
										curTabTitle);
							}
							return;
						}

						var allTabs = $('#layout_center_tabs').tabs('tabs');
						var closeTabsTitle = [];

						$.each(allTabs, function() {
							var opt = $(this).panel('options');
							if (opt.closable && opt.title != curTabTitle
									&& type === 'closeOther') {
								closeTabsTitle.push(opt.title);
							} else if (opt.closable && type === 'closeAll') {
								closeTabsTitle.push(opt.title);
							}
						});

						for ( var i = 0; i < closeTabsTitle.length; i++) {
							$('#layout_center_tabs').tabs('close',
									closeTabsTitle[i]);
						}
					}
				});

		$('#layout_center_tabs')
				.tabs(
						{
							fit : true,
							border : false,
							onContextMenu : function(e, title) {
								e.preventDefault();
								$('#layout_center_tabsMenu').menu('show', {
									left : e.pageX,
									top : e.pageY
								}).data('tabTitle', title);
							},
							tools : [
									{
										iconCls : 'icon-reload',
										handler : function() {
											var href = $('#layout_center_tabs')
													.tabs('getSelected').panel(
															'options').href;
											if (href) {/*说明tab是以href方式引入的目标页面*/
												var index = $(
														'#layout_center_tabs')
														.tabs(
																'getTabIndex',
																$(
																		'#layout_center_tabs')
																		.tabs(
																				'getSelected'));
												$('#layout_center_tabs').tabs(
														'getTab', index).panel(
														'refresh');
											} else {/*说明tab是以content方式引入的目标页面*/
												var panel = $(
														'#layout_center_tabs')
														.tabs('getSelected')
														.panel('panel');
												var frame = panel
														.find('iframe');
												try {
													if (frame.length > 0) {
														for ( var i = 0; i < frame.length; i++) {
															frame[i].contentWindow.document
																	.write('');
															frame[i].contentWindow
																	.close();
															frame[i].src = frame[i].src;
														}
														if ($.browser.msie) {
															CollectGarbage();
														}
													}
												} catch (e) {
												}
											}
										}
									},
									{
										iconCls : 'icon-cancel',
										handler : function() {
											var index = $('#layout_center_tabs')
													.tabs(
															'getTabIndex',
															$(
																	'#layout_center_tabs')
																	.tabs(
																			'getSelected'));
											var tab = $('#layout_center_tabs')
													.tabs('getTab', index);
											if (tab.panel('options').closable) {
												$('#layout_center_tabs').tabs(
														'close', index);
											} else {
												$.messager
														.alert(
																'提示',
																'['
																		+ tab
																				.panel('options').title
																		+ ']不可以被关闭',
																'error');
											}
										}
									} ]
						});

		$('#queryfiles').form({
			//	url : '',
			onSubmit : function() {
				// do some check   
				// return false to prevent submit;   
			},
			success : function(data) {

				alert(data);
			}
		});
		$('#querytext').form({
			url : '',
			onSubmit : function() {

			},
			success : function(data) {
				//	layout_center_addTabFun();
				//	console.info(data);
			}
		});
		$('#file').linkbutton({
			iconCls : 'icon-search'
		});
		$('#file').bind('click', function() {
			$('#queryfiles').form('submit');
		});
		$('#text').linkbutton({
			iconCls : 'icon-search'
		});
		$('#text').bind('click', function() {
			$('#querytext').form('submit');
		});
	});

	function layout_center_refreshTab(title) {
		$('#layout_center_tabs').tabs('getTab', title).panel('refresh');
	}

	function layout_center_addTabFun() {
		var t = $('#layout_center_tabs');
		if (t.tabs('exists', '数据展示')) {
			t.tabs('select', '数据展示');
		} else {
			t.tabs('add', {
				title : '数据展示',
				closable : true,
				href : 'user/treeGrid.jsp',
			});
		}
	}
</script>
<div id="layout_center_tabs" style="overflow: hidden;">
	<div title="首页" >
		<div class="easyui-layout" data-options="closable:false,fit:true">
			<div data-options="region:'north',title:'文件操作',border:false"
				style="height: 91px">
				<form method="post" id="queryfiles">
					<table>
						<tr>
							<th>文件检索：</th>
							<td><input class="easyui-validatebox" type="text"
								name="filequery" size="100" data-options="required:true"></input>
								<a id="file" href="javascript:void(0)">查询</a></td>
						</tr>
					</table>
				</form>
				<form id="querytext" method="post">
					<table>
						<tr>
							<th>查询语句：</th>
							<td><input class="easyui-validatebox" type="text"
								name="query" size="100" data-options="required:true"></input> <!-- 	<a id="text" href="javascript:void(0)" >查询</a>  -->
								<input id="text" type="submit"></input></td>
						</tr>
					</table>
				</form>
			</div>

			<div
				data-options="region:'center',title:'文件查看',border:false,href:'${pageContext.request.contextPath}/user/fileListDataGrid.jsp'">
			</div>
		</div>
	</div>
</div>
<div id="layout_center_tabsMenu" style="width: 120px; display: none;">
	<div type="refresh">刷新</div>
	<div class="menu-sep"></div>
	<div type="close">关闭</div>
	<div type="closeOther">关闭其他</div>
	<div type="closeAll">关闭所有</div>
</div>