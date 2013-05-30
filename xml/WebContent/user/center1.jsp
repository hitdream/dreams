<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		var editRow = false;
		$("#tt").treegrid({

			height : '500',
			idField : 'code',
			treeField : 'element',
			fit : true,
			fitColumns : true,
			animate : false,
			multiple:true,
			//		pagination : true,
			border : false,
			//		url : 'treegrid.json',
			columns : [ [ {
				field : 'code',
				title : 'code',
				checkbox : true
			}, {
				field : 'element',
				title : '元素名',
				width : 50
			}, {
				field : 'value',
				title : '元素值',
				width : 100,
				editor : {
					type : 'text',
					options : {
						required : true
					}
				}
			},

			] ],
			toolbar : [ {
				text : "添加",
				iconCls : "icon-add",
				handler : function() {
					append();
				}
			}, "-", {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					remove();
				}
			}, "-", {
				text : "修改",
				iconCls : 'icon-edit',
				handler : function() {
					if (editRow) {
						endEdit();
					}
					edit();
				}
			}, "-", {
				text : '取消',
				iconCls : 'icon-undo',
				handler : function() {
					undo();
				}
			}, "-", {
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {
					endEdit();
				}
			} ],
			onBeforeExpand : function(row) {
				$(this).treegrid('options').url = '' + row.id;
			},
			onContextMenu : function(e, row) {
				validateSession();
				e.preventDefault();
				// 显示上下文菜单
				$('#mm').menu('show', {
					left : e.pageX,
					top : e.pageY
				});

			},
			onDblClickRow : function(row) {
				validateSession();
				edit();
			},
			onClickRow : function(row) {
				validateSession();
				
			},
			onAfterEdit : function(row, changes) {
				console.info(row);
			}
		});
		$("#tt").treegrid('loadData', [ {
			"code" : "dfsa",
			"element" : "book",
			"value" : "01",
			"children" : [ {
				"code" : "dskk",
				"element" : "shop",
				"value" : "03",
			}, {
				code : "fsfdsf",
				"element" : "url",
				"value" : "04",
			} ]

		}, {
			"code" : "1",
			"element" : "price",
			"value" : "07"

		}, {
			"code" : "2",
			"element" : "price",
			"value" : "07"

		} ]);
	});
	function append() {
		var node = $('#tt').treegrid('getSelected');
		if (node) {
			$('#tt').treegrid('append', {
				parent : node.code, // 节点有一个'id'值,定义是通过'idField'属性
				data : [ {
					code : "",
					element : '',
					value : ''
				} ]
			});
		}
	}
	function remove() {
		var node = $('#tt').treegrid('getSelected');
		if (node) {
			$('#tt').treegrid('remove', node.code);
		}
	}
	function edit() {
		var node = $('#tt').treegrid('getSelected');
		if (node) {
			$('#tt').treegrid('beginEdit', node.code);
			editRow = true;
		}
	}
	function endEdit() {
		var node = $('#tt').treegrid('getSelected');
		if (node) {
			$('#tt').treegrid('endEdit', node.code);
			editRow = false;
		}
	}
	function undo() {
		var node = $('#tt').treegrid('getSelected');
		if (node) {
			$('#tt').treegrid('cancelEdit', node.code);
		}
	}
	function getOp(){
		var node = $('#tt').treegrid('getSelections');
		console.info(node);
	}

</script>

</head>

<body>

	<div id="cc" class="easyui-layout" style="height:500px"  data-options="fit:true">
		<div data-options="region:'north',title:'文件操作',border:false"
			style="height: 80px">
			<form action="FtpUp" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<th>查询语句：</th>
						<td><input type="text" name="query" size="100"></input> <input
							type="submit" value="查询"></input></td>
					</tr>
			
				</table>

			</form>
		</div>

		<div data-options="region:'center',title:'数据展示',border:false">
			<div id="tt">
				<div id="mm" class="easyui-menu" style="width: 120px;">
					<div onclick="append()" data-options="iconCls:'icon-add'">添加</div>
					<div onclick="remove()" data-options="iconCls:'icon-remove'">删除</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>