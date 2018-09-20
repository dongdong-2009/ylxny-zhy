$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'summary/datarecord/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '站点id', name: 'station_id', index: 'station_id', width: 80 }, 			
			{ label: '设备id', name: 'device_id', index: 'device_id', width: 80 }, 			
			{ label: '环路id', name: 'line_id', index: 'line_id', width: 80 }, 			
			{ label: '存入时间', name: 'syn_time', index: 'syn_time', width: 80 }, 			
			{ label: 'a相电流', name: 'i_a', index: 'i_a', width: 80 }, 			
			{ label: 'b相电流', name: 'i_b', index: 'i_b', width: 80 }, 			
			{ label: 'c相电流', name: 'i_c', index: 'i_c', width: 80 }, 			
			{ label: 'a相电压', name: 'v_a', index: 'v_a', width: 80 }, 			
			{ label: '', name: 'v_b', index: 'v_b', width: 80 }, 			
			{ label: '', name: 'v_c', index: 'v_c', width: 80 }, 			
			{ label: 'a相有功', name: 'w_useful_a', index: 'w_useful_a', width: 80 }, 			
			{ label: 'b相有功', name: 'w_useful_b', index: 'w_useful_b', width: 80 }, 			
			{ label: 'c相有功', name: 'w_useful_c', index: 'w_useful_c', width: 80 }, 			
			{ label: 'a相无功', name: 'w_useless_a', index: 'w_useless_a', width: 80 }, 			
			{ label: 'b相无功', name: 'w_useless_b', index: 'w_useless_b', width: 80 }, 			
			{ label: 'c相无功', name: 'w_useless_c', index: 'w_useless_c', width: 80 }, 			
			{ label: 'a相视在总功', name: 'w_total_a', index: 'w_total_a', width: 80 }, 			
			{ label: 'b相视在总功', name: 'w_total_b', index: 'w_total_b', width: 80 }, 			
			{ label: 'c相视在总功', name: 'w_total_c', index: 'w_total_c', width: 80 }, 			
			{ label: '总有功功率', name: 'w_useful_total', index: 'w_useful_total', width: 80 }, 			
			{ label: '总无功功率', name: 'w_useless_total', index: 'w_useless_total', width: 80 }, 			
			{ label: '总视在总功', name: 'w_total_total', index: 'w_total_total', width: 80 }, 			
			{ label: '当前有功需量', name: 'w_current_useful_require', index: 'w_current_useful_require', width: 80 }, 			
			{ label: '当前无功需量', name: 'w_current_useless_require', index: 'w_current_useless_require', width: 80 }, 			
			{ label: '当前视在需量', name: 'w_current_total_require', index: 'w_current_total_require', width: 80 }, 			
			{ label: 'A相功率因数', name: 'power_factor_a', index: 'power_factor_a', width: 80 }, 			
			{ label: 'B相功率因数', name: 'power_factor_b', index: 'power_factor_b', width: 80 }, 			
			{ label: 'C相功率因数', name: 'power_factor_c', index: 'power_factor_c', width: 80 }, 			
			{ label: '总功率因数', name: 'total_power_factor', index: 'total_power_factor', width: 80 }, 			
			{ label: '零线电流', name: 'i_zero_curve', index: 'i_zero_curve', width: 80 }, 			
			{ label: '三相电流不平衡', name: 'i_unbalance_abc', index: 'i_unbalance_abc', width: 80 }, 			
			{ label: '三相电压不平衡', name: 'v_unbalance_abc', index: 'v_unbalance_abc', width: 80 }, 			
			{ label: '频率', name: 'frenqency', index: 'frenqency', width: 80 }, 			
			{ label: '环境温度', name: 'env_temp', index: 'env_temp', width: 80 }, 			
			{ label: '湿度', name: 'env_humidity', index: 'env_humidity', width: 80 }, 			
			{ label: '复费率1', name: 'fee_rate_1', index: 'fee_rate_1', width: 80 }, 			
			{ label: '复费率2', name: 'fee_rate_2', index: 'fee_rate_2', width: 80 }, 			
			{ label: '复费率3', name: 'fee_rate_3', index: 'fee_rate_3', width: 80 }, 			
			{ label: '复费率4', name: 'fee_rate_4', index: 'fee_rate_4', width: 80 }, 			
			{ label: '复费率5', name: 'fee_rate_5', index: 'fee_rate_5', width: 80 }, 			
			{ label: '复费率6', name: 'fee_rate_6', index: 'fee_rate_6', width: 80 }, 			
			{ label: '复费率7', name: 'fee_rate_7', index: 'fee_rate_7', width: 80 }, 			
			{ label: '复费率8', name: 'fee_rate_8', index: 'fee_rate_8', width: 80 }, 			
			{ label: 'A相正向有功电量', name: 'kwh_useful_a', index: 'kwh_useful_a', width: 80 }, 			
			{ label: 'B相正向有功电量', name: 'kwh_useful_b', index: 'kwh_useful_b', width: 80 }, 			
			{ label: 'Ｃ相正向有功电量', name: 'kwh_useful_c', index: 'kwh_useful_c', width: 80 }, 			
			{ label: '当前总正向有功电量', name: 'kwh_useful_abc', index: 'kwh_useful_abc', width: 80 }, 			
			{ label: 'A相正向有功电量（计算电费）', name: 'kwh_useful_total_a', index: 'kwh_useful_total_a', width: 80 }, 			
			{ label: 'B相正向有功电量（计算电费）', name: 'kwh_useful_total_b', index: 'kwh_useful_total_b', width: 80 }, 			
			{ label: 'Ｃ相正向有功电量（计算电费）', name: 'kwh_useful_total_c', index: 'kwh_useful_total_c', width: 80 }, 			
			{ label: '总正向有功电量（计算电费）', name: 'kwh_useful_total_abc', index: 'kwh_useful_total_abc', width: 80 }, 			
			{ label: 'A相电缆温度', name: 'temp_a', index: 'temp_a', width: 80 }, 			
			{ label: 'B相电缆温度', name: 'temp_b', index: 'temp_b', width: 80 }, 			
			{ label: 'C相电缆温度', name: 'temp_c', index: 'temp_c', width: 80 }, 			
			{ label: '负荷率', name: 'load_rate', index: 'load_rate', width: 80 }, 			
			{ label: '频率偏差', name: 'frequency_offset', index: 'frequency_offset', width: 80 }			
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
		dataRecord: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.dataRecord = {};
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
			var url = vm.dataRecord.id == null ? "summary/datarecord/save" : "summary/datarecord/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.dataRecord),
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
				    url: baseURL + "summary/datarecord/delete",
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
			$.get(baseURL + "summary/datarecord/info/"+id, function(r){
                vm.dataRecord = r.dataRecord;
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