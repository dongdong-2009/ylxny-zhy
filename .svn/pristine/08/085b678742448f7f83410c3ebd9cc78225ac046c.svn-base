$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'alarm/sysalarmsetting/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '公司id', name: 'company_id', index: 'company_id', width: 80 }, 			
			{ label: '采集器id', name: 'device_id', index: 'device_id', width: 80 }, 			
			{ label: '回路id', name: 'line_id', index: 'line_id', width: 80 }, 			
			{ label: '报警类型', name: 'alarm_type', index: 'alarm_type', width: 80 }, 			
			{ label: '报警父类别', name: 'alarm_parent_type', index: 'alarm_parent_type', width: 80 }, 			
			{ label: '指标名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '越限报警水位默认最高值', name: 'default_value_top', index: 'default_value_top', width: 80 }, 			
			{ label: '越限报警水位默认最低值', name: 'default_value_bottom', index: 'default_value_bottom', width: 80 }, 			
			{ label: '报警级别', name: 'alarm_level', index: 'alarm_level', width: 80 }, 			
			{ label: '报警级别名称', name: 'alarm_level_name', index: 'alarm_level_name', width: 80 }			
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
		sysAlarmSetting: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysAlarmSetting = {};
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
			var url = vm.sysAlarmSetting.id == null ? "alarm/sysalarmsetting/save" : "alarm/sysalarmsetting/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysAlarmSetting),
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
				    url: baseURL + "alarm/sysalarmsetting/delete",
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
			$.get(baseURL + "alarm/sysalarmsetting/info/"+id, function(r){
                vm.sysAlarmSetting = r.sysAlarmSetting;
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