$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'dict/cmddict/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '协议类型（1.DLT645 2.MODBUS）', name: 'protocol_type', index: 'protocol_type', width: 80 }, 			
			{ label: '协议名称', name: 'protocol_name', index: 'protocol_name', width: 80 }, 			
			{ label: '统一命令码 与协议无关', name: 'cmd_code', index: 'cmd_code', width: 80 }, 			
			{ label: '命令标识 与采集数据记录的字段名对应', name: 'cmd_flag', index: 'cmd_flag', width: 80 }, 			
			{ label: '命令描述', name: 'cmd_desc', index: 'cmd_desc', width: 80 }, 			
			{ label: '命令类型 跟具体协议相关 如果为空则查看操作类型', name: 'cmd_type', index: 'cmd_type', width: 80 }, 			
			{ label: '命令字符串参考 跟具体协议相关', name: 'cmd', index: 'cmd', width: 80 }, 			
			{ label: '返回数据的单位', name: 'measurement', index: 'measurement', width: 80 }, 			
			{ label: '单位的名称', name: 'measurement_name', index: 'measurement_name', width: 80 }, 			
			{ label: '返回数据的格式 用#号表示 如###.###', name: 'format', index: 'format', width: 80 }, 			
			{ label: '返回数据的因子', name: 'factor', index: 'factor', width: 80 }, 			
			{ label: '返回数据操作类型(1.直读电表 2.计算)', name: 'data_oper_type', index: 'data_oper_type', width: 80 }, 			
			{ label: '操作函数', name: 'data_oper_func', index: 'data_oper_func', width: 80 }, 			
			{ label: '采集频率', name: 'frequency', index: 'frequency', width: 80 }, 			
			{ label: '读到的数据操作（1.直接写入数据库 2.计算）', name: 'data_write_oper', index: 'data_write_oper', width: 80 }, 			
			{ label: '数据写入需要计算的公式', name: 'data_write_formula', index: 'data_write_formula', width: 80 }, 			
			{ label: '所读数据作为公式参数的索引', name: 'data_write_param_index', index: 'data_write_param_index', width: 80 }, 			
			{ label: '计算结果对应的code', name: 'data_write_result_code', index: 'data_write_result_code', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		cmdDict: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.cmdDict = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.cmdDict.id == null ? "dict/cmddict/save" : "dict/cmddict/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.cmdDict),
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
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "dict/cmddict/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
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
		getInfo: function(id){
			$.get(baseURL + "dict/cmddict/info/"+id, function(r){
                vm.cmdDict = r.cmdDict;
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