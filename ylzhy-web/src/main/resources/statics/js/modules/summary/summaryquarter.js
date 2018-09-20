$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'summary/summaryquarter/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '公司id', name: 'company_id', index: 'company_id', width: 80 }, 			
			{ label: '站点id', name: 'station_id', index: 'station_id', width: 80 }, 			
			{ label: '回路id', name: 'line_id', index: 'line_id', width: 80 }, 			
			{ label: '站点名称', name: 'station_name', index: 'station_name', width: 80 }, 			
			{ label: '回路名称', name: 'line_name', index: 'line_name', width: 80 }, 			
			{ label: '日期', name: 'date', index: 'date', width: 80 }, 			
			{ label: '小时数', name: 'hour', index: 'hour', width: 80 }, 			
			{ label: '分钟数', name: 'minite', index: 'minite', width: 80 }, 			
			{ label: 'A相电流', name: 'current_a', index: 'current_a', width: 80 }, 			
			{ label: 'B相电流', name: 'current_b', index: 'current_b', width: 80 }, 			
			{ label: 'C相电流', name: 'current_c', index: 'current_c', width: 80 }, 			
			{ label: 'A相电压', name: 'voltage_a', index: 'voltage_a', width: 80 }, 			
			{ label: 'B相电压', name: 'voltage_b', index: 'voltage_b', width: 80 }, 			
			{ label: 'C相电压', name: 'voltage_c', index: 'voltage_c', width: 80 }, 			
			{ label: 'A相功率因数', name: 'factor_a', index: 'factor_a', width: 80 }, 			
			{ label: 'B相功率因数', name: 'factor_b', index: 'factor_b', width: 80 }, 			
			{ label: 'C相功率因数', name: 'factor_c', index: 'factor_c', width: 80 }, 			
			{ label: 'A相负荷', name: 'fuhe_a', index: 'fuhe_a', width: 80 }, 			
			{ label: 'B相负荷', name: 'fuhe_b', index: 'fuhe_b', width: 80 }, 			
			{ label: 'C相负荷', name: 'fuhe_c', index: 'fuhe_c', width: 80 }, 			
			{ label: 'A相功率', name: 'gonglv_a', index: 'gonglv_a', width: 80 }, 			
			{ label: 'B相功率', name: 'gonglv_b', index: 'gonglv_b', width: 80 }, 			
			{ label: 'C相功率', name: 'gonglv_c', index: 'gonglv_c', width: 80 }, 			
			{ label: '实时电流', name: 'realtime_current', index: 'realtime_current', width: 80 }, 			
			{ label: '实时电压', name: 'realtime_voltage', index: 'realtime_voltage', width: 80 }, 			
			{ label: '实时功率', name: 'realtime_gonglv', index: 'realtime_gonglv', width: 80 }			
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
		summaryQuarter: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.summaryQuarter = {};
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
			var url = vm.summaryQuarter.id == null ? "summary/summaryquarter/save" : "summary/summaryquarter/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.summaryQuarter),
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
				    url: baseURL + "summary/summaryquarter/delete",
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
			$.get(baseURL + "summary/summaryquarter/info/"+id, function(r){
                vm.summaryQuarter = r.summaryQuarter;
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