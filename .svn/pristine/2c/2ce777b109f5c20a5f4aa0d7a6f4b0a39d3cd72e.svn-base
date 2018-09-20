$(function(){
	/* //新增档案信息
	function addSave(){
		alert($("#companyform").serialize());
	$.ajax({
		type : "POST",
		url : baseURL + "company/save",
		contentType : "application/json",
		datatype : "json",
		data : $("#companyform").serialize(),
		success : function(data) {
			console.log(data);
		}
	});
	} */
	var zTreeObj;
	// zTree 的参数配置，深入使用参考 API 文档（setting 配置详解）
	function zTreeOnClick(event, treeId, treeNode) {
		var companyid = treeNode.id;
		$.ajax({
			type : "POST",
			url : baseURL + "company/listId/" + companyid,
			data : {},
			success : function(data) {
				console.log("点击树的节点展示的数据");
				console.log(data.list.rows);
				$('#tb_departments').bootstrapTable('load', data.list);
			}
		});

	};
	var setting = {
		callback : {
			onClick : zTreeOnClick
		}
	};
	// zTree 的数据属性，深入使用参考 API 文档（zTreeNode 节点数据详解）
	$.ajax({
		type : "POST",
		url : baseURL + "company/initList",
		data : {},
		success : function(data) {
			$(document).ready(
					function() {
						zTreeObj = $.fn.zTree.init($("#tree-obj"), setting,
								data.jsonObject);
						$("#search-bt").click(searchNodes);
					});
		}
	});

	//按钮查询节点
	function searchNodes() {
		var keywords = $("#keyword").val();
		if (keywords == null || keywords == "undefined" || keywords == "") {
			keywords = "all";
		}
		$.ajax({
			type : "POST",
			url : baseURL + "company/selectList/" + keywords,
			data : {},
			success : function(data) {
				$(document).ready(
						function() {
							zTreeObj = $.fn.zTree.init($("#tree-obj"), setting,
									data.jsonObject);
							$("#search-bt").click(searchNodes);
						});
			}
		});
	}

	$(function() {
		//1.初始化Table
		var oTable = new TableInit();
		oTable.Init();
		$.ajax({
			type : "POST",
			url : baseURL + "company/listAll",
			data : {},
			success : function(data) {
				$('#tb_departments').bootstrapTable('load', data.jsonObject);
			}
		});

		//2.初始化Button的点击事件
		var oButtonInit = new ButtonInit();
		oButtonInit.Init();
	});
	var TableInit = function() {
		var oTableInit = new Object();
		//初始化Table
		oTableInit.Init = function() {
			$('#tb_departments').bootstrapTable({
				url : '', //请求后台的URL（*）
				method : 'get', //请求方式（*）
				toolbar : '#toolbar', //工具按钮用哪个容器
				striped : true, //是否显示行间隔色
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination : true, //是否显示分页（*）
				sortable : false, //是否启用排序
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*）
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
				pageNumber : 1, //初始化加载第一页，默认第一页
				pageSize : 10, //每页的记录行数（*）
				pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
				search : false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch : false,
				showColumns : true, //是否显示所有的列
				showRefresh : false, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行
				height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
				uniqueId : "ID", //每一行的唯一标识，一般为主键列
				showToggle : false, //是否显示详细视图和列表视图的切换按钮
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				data : [],
				columns : [ {
					checkbox : true
				}, {
					field : 'province',
					title : '地区',
					align : "center",
					valign : "middle"
				}, {
					field : 'khyyh',
					title : '企业编号',
					align : "center",
					valign : "middle"
				}, {
					field : 'Name',
					title : '企业简称',
					align : "center",
					valign : "middle"
				}, {
					field : 'companyname',
					title : '企业全称',
					align : "center",
					valign : "middle"
				}, {
					field : 'type',
					title : '单位类型',
					align : "center",
					valign : "middle"
				}, {
					field : 'property',
					title : '企业性质',
					align : "center",
					valign : "middle"
				}, {
					field : 'jffs_xl',
					title : '质运行容量',
					align : "center",
					valign : "middle"
				}, {
					field : 'jffs_rl',
					title : '合同容量',
					align : "center",
					valign : "middle"
				}, {
					field : 'address',
					title : '地址',
					align : "center",
					valign : "middle"
				}, {
					field : 'Name',
					title : '操作',
					align : "center",
					valign : "middle",
					formatter : actionFormatter
				} ]
			});
		};

		//得到查询的参数
		oTableInit.queryParams = function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
				limit : params.limit, //页面大小
				offset : params.offset, //页码
				departmentname : $("#txt_search_departmentname").val(),
				statu : $("#txt_search_statu").val()
			};
			return temp;
		};

		return oTableInit;
	};

	var ButtonInit = function() {
		var oInit = new Object();
		var postdata = {};

		oInit.Init = function() {
			//初始化页面上面的按钮事件
		};
		return oInit;
	};

	//操作栏的格式化
	function actionFormatter(value, row, index) {
		var id = value;
		var result = "";
		result += "<a href='javascript:;' class='btn btn-xs blue' @click='isShow' title='档案管理'><span class='glyphicon glyphicon-pencil'></span>&nbsp;&nbsp;档案管理</a>";
		result += "<a href='' class='btn btn-xs green' onclick=\"EditViewById('"
				+ id
				+ "', view='view')\" title='设备维护'><span class='glyphicon glyphicon-search'></span>&nbsp;&nbsp;设备维护</a>";
		return result;
	}

	/* new Vue({
		el : '#app',
		data : {
			showPanel : false,
			showTip : false
		},
		methods : {
			isShow : function() {
				this.showPanel = !this.showPanel;
			},
			isTip : function() {
				this.showTip = !this.showTip;
			}
		}
	}) */
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		company: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.company = {};
		},
		update: function (event) {
			var companyid = getSelectedRow();
			if(companyid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(companyid)
		},
		saveOrUpdate: function (event) {
			alert(1111);
			var url = vm.company.companyid == null ? "qxgl/company/save" : "qxgl/company/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.company),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var companyids = getSelectedRows();
			if(companyids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "qxgl/company/delete",
                    contentType: "application/json",
				    data: JSON.stringify(companyids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(companyid){
			$.get(baseURL + "qxgl/company/info/"+companyid, function(r){
                vm.company = r.company;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});
 
function queryComByName() {
	var value = document.getElementById("txt_search_departmentname").value;
	var url = baseURL;
	if (value == null || value == "undefined" || value == "") {
		$.ajax({
			type : "POST",
			url : baseURL + "company/listAll",
			data : {},
			success : function(data) {
				console.log(data);
				$('#tb_departments')
						.bootstrapTable('load', data.jsonObject);
			}
		});
	} else {
		$.ajax({
			type : "POST",
			url : baseURL + "company/queryBynameOrAddress/" + value,
			data : {},
			success : function(data) {
				console.log(data);
				$('#tb_departments')
						.bootstrapTable('load', data.jsonObject);
			}
		});
	}
}
