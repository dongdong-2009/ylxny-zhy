$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/dcdcmddict/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '协议类型（1.DLT645 2.MODBUS）', name: 'protocolType', index: 'protocol_type', width: 80 }, 			
			{ label: '协议名称', name: 'protocolName', index: 'protocol_name', width: 80 }, 			
			{ label: '统一命令码 与协议无关', name: 'cmdCode', index: 'cmd_code', width: 80 }, 			
			{ label: '命令描述', name: 'cmdDesc', index: 'cmd_desc', width: 80 }, 			
			{ label: '命令类型 跟具体协议相关', name: 'cmdType', index: 'cmd_type', width: 80 }, 			
			{ label: '命令字符串参考 跟具体协议相关', name: 'cmd', index: 'cmd', width: 80 }, 			
			{ label: '返回数据的单位', name: 'measurement', index: 'measurement', width: 80 }, 			
			{ label: '单位的名称', name: 'measurementName', index: 'measurement_name', width: 80 }, 			
			{ label: '返回数据的格式 用#号表示 如###.###', name: 'format', index: 'format', width: 80 }, 			
			{ label: '返回数据的因子', name: 'factor', index: 'factor', width: 80 }			
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
		dcdCmdDict: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.dcdCmdDict = {};
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
			var url = vm.dcdCmdDict.id == null ? "sys/dcdcmddict/save" : "sys/dcdcmddict/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.dcdCmdDict),
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
				    url: baseURL + "sys/dcdcmddict/delete",
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
			$.get(baseURL + "sys/dcdcmddict/info/"+id, function(r){
                vm.dcdCmdDict = r.dcdCmdDict;
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