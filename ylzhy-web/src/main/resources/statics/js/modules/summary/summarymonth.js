$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'summary/summarymonth/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '年份', name: 'year', index: 'year', width: 80 }, 			
			{ label: '月份', name: 'month', index: 'month', width: 80 }, 			
			{ label: '当月使用电量', name: 'month_power', index: 'month_power', width: 80 }, 			
			{ label: '当月总电量 即截止本月电表读数', name: 'month_total_power', index: 'month_total_power', width: 80 }, 			
			{ label: '当月电费', name: 'month_fee', index: 'month_fee', width: 80 }, 			
			{ label: '最大需量', name: 'month_max_power_demand', index: 'month_max_power_demand', width: 80 }, 			
			{ label: '最大需量时间', name: 'month_max_demand_time', index: 'month_max_demand_time', width: 80 }, 			
			{ label: '回路id', name: 'line_id', index: 'line_id', width: 80 }, 			
			{ label: '回路名称', name: 'line_name', index: 'line_name', width: 80 }, 			
			{ label: '', name: 'stationd_id', index: 'stationd_id', width: 80 }, 			
			{ label: '站点名称', name: 'station_name', index: 'station_name', width: 80 }, 			
			{ label: '公司id', name: 'company_id', index: 'company_id', width: 80 }, 			
			{ label: '日最大负荷', name: 'max_fuhe', index: 'max_fuhe', width: 80 }, 			
			{ label: '日最大负荷时间', name: 'max_fuhe_time', index: 'max_fuhe_time', width: 80 }, 			
			{ label: '日功率因数', name: 'power_factor', index: 'power_factor', width: 80 }, 			
			{ label: '最小负荷', name: 'min_fuhe', index: 'min_fuhe', width: 80 }, 			
			{ label: '最小负荷时间', name: 'min_fuhe_time', index: 'min_fuhe_time', width: 80 }, 			
			{ label: '平均负荷', name: 'avg_fuhe', index: 'avg_fuhe', width: 80 }, 			
			{ label: '峰谷差', name: 'p_r_aprt', index: 'p_r_aprt', width: 80 }, 			
			{ label: '峰谷率', name: 'p_r_rate', index: 'p_r_rate', width: 80 }, 			
			{ label: '负荷率', name: 'fuhe_rate', index: 'fuhe_rate', width: 80 }			
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
		summaryMonth: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.summaryMonth = {};
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
			var url = vm.summaryMonth.id == null ? "summary/summarymonth/save" : "summary/summarymonth/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.summaryMonth),
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
				    url: baseURL + "summary/summarymonth/delete",
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
			$.get(baseURL + "summary/summarymonth/info/"+id, function(r){
                vm.summaryMonth = r.summaryMonth;
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