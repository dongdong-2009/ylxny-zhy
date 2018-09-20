$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'log/eventlog/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '操作类型 (1.读取数据 )', name: 'event_type', index: 'event_type', width: 80 }, 			
			{ label: '操作日期', name: 'oper_date', index: 'oper_date', width: 80 }, 			
			{ label: '开始时间', name: 'start_time', index: 'start_time', width: 80 }, 			
			{ label: '结束时间', name: 'end_time', index: 'end_time', width: 80 }, 			
			{ label: '当天的第n次操作 每天第一次从1自增长 隔天重置为1', name: 'seq_on_day', index: 'seq_on_day', width: 80 }, 			
			{ label: '查询一个回路的命令条数', name: 'cmd_times', index: 'cmd_times', width: 80 }, 			
			{ label: '每条命令执行的平均时间', name: 'avg_time_per_cmd', index: 'avg_time_per_cmd', width: 80 }, 			
			{ label: '成功数量', name: 'success_count', index: 'success_count', width: 80 }, 			
			{ label: '失败数量', name: 'fail_count', index: 'fail_count', width: 80 }, 			
			{ label: '采集器id', name: 'device_id', index: 'device_id', width: 80 }, 			
			{ label: '采集器的ip地址记录', name: 'device_ip', index: 'device_ip', width: 80 }, 			
			{ label: '回路地址 以16进制形式表示', name: 'line_address', index: 'line_address', width: 80 }, 			
			{ label: '协议类型', name: 'protocol_type', index: 'protocol_type', width: 80 }, 			
			{ label: '协议名称', name: 'protocol_name', index: 'protocol_name', width: 80 }, 			
			{ label: '站点id', name: 'station_id', index: 'station_id', width: 80 }, 			
			{ label: '站点名称', name: 'station_name', index: 'station_name', width: 80 }, 			
			{ label: '公司id', name: 'company_id', index: 'company_id', width: 80 }, 			
			{ label: '公司名称', name: 'company_name', index: 'company_name', width: 80 }			
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
		eventLog: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.eventLog = {};
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
			var url = vm.eventLog.id == null ? "log/eventlog/save" : "log/eventlog/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.eventLog),
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
				    url: baseURL + "log/eventlog/delete",
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
			$.get(baseURL + "log/eventlog/info/"+id, function(r){
                vm.eventLog = r.eventLog;
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