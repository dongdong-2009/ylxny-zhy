$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'alarm/useralarmrecord/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '公司id', name: 'company_id', index: 'company_id', width: 80 }, 			
			{ label: '站点id', name: 'station_id', index: 'station_id', width: 80 }, 			
			{ label: '站点名称', name: 'station_name', index: 'station_name', width: 80 }, 			
			{ label: '回路id', name: 'line_id', index: 'line_id', width: 80 }, 			
			{ label: '回路名称', name: 'line_name', index: 'line_name', width: 80 }, 			
			{ label: '报警类型', name: 'alarm_type', index: 'alarm_type', width: 80 }, 			
			{ label: '报警因素', name: 'alarm_factor', index: 'alarm_factor', width: 80 }, 			
			{ label: '报警时间', name: 'alarm_time', index: 'alarm_time', width: 80 }, 			
			{ label: '报警级别', name: 'alarm_level', index: 'alarm_level', width: 80 }, 			
			{ label: '当前值', name: 'current_value', index: 'current_value', width: 80 }, 			
			{ label: '越限值', name: 'water_value', index: 'water_value', width: 80 }, 			
			{ label: '事件状态', name: 'status', index: 'status', width: 80 }			
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
		userAlarmRecord: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.userAlarmRecord = {};
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
			var url = vm.userAlarmRecord.id == null ? "alarm/useralarmrecord/save" : "alarm/useralarmrecord/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.userAlarmRecord),
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
				    url: baseURL + "alarm/useralarmrecord/delete",
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
			$.get(baseURL + "alarm/useralarmrecord/info/"+id, function(r){
                vm.userAlarmRecord = r.userAlarmRecord;
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