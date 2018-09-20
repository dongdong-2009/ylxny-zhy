$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'summary/summaryhour/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '公司id', name: 'company_id', index: 'company_id', width: 80 }, 			
			{ label: '站点id', name: 'station_id', index: 'station_id', width: 80 }, 			
			{ label: '', name: 'station_name', index: 'station_name', width: 80 }, 			
			{ label: '回路id', name: 'line_id', index: 'line_id', width: 80 }, 			
			{ label: '回路名称', name: 'line_name', index: 'line_name', width: 80 }, 			
			{ label: '采集日期', name: 'date', index: 'date', width: 80 }, 			
			{ label: '小时(按24小时算)', name: 'hour', index: 'hour', width: 80 }, 			
			{ label: '一小时的用电量(单位：KWH)', name: 'hour_power', index: 'hour_power', width: 80 }, 			
			{ label: '一小时读表电量 累计值', name: 'hour_total_power', index: 'hour_total_power', width: 80 }, 			
			{ label: '小时功率', name: 'hour_gonglv', index: 'hour_gonglv', width: 80 }, 			
			{ label: '每小时最大需量', name: 'hour_max_power_demand', index: 'hour_max_power_demand', width: 80 }, 			
			{ label: '最大需量时间', name: 'hour_max_demand_time', index: 'hour_max_demand_time', width: 80 }, 			
			{ label: '半小时最大负荷', name: 'max_fuhe_half', index: 'max_fuhe_half', width: 80 }, 			
			{ label: '一小时最大负荷', name: 'max_fuhe_full', index: 'max_fuhe_full', width: 80 }, 			
			{ label: '半小时最大负荷', name: 'max_fuhe_half_time', index: 'max_fuhe_half_time', width: 80 }, 			
			{ label: '一小时最大负荷', name: 'max_fuhe_full_time', index: 'max_fuhe_full_time', width: 80 }			
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
		summaryHour: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.summaryHour = {};
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
			var url = vm.summaryHour.id == null ? "summary/summaryhour/save" : "summary/summaryhour/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.summaryHour),
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
				    url: baseURL + "summary/summaryhour/delete",
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
			$.get(baseURL + "summary/summaryhour/info/"+id, function(r){
                vm.summaryHour = r.summaryHour;
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