$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/dcdatarecord/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '站点id', name: 'stationId', index: 'station_id', width: 80 }, 			
			{ label: '设备id', name: 'deviceId', index: 'device_id', width: 80 }, 			
			{ label: '环路id', name: 'lineId', index: 'line_id', width: 80 }, 			
			{ label: '存入时间', name: 'synTime', index: 'syn_time', width: 80 }, 			
			{ label: 'a相电流', name: 'iA', index: 'i_a', width: 80 }, 			
			{ label: 'b相电流', name: 'iB', index: 'i_b', width: 80 }, 			
			{ label: 'c相电流', name: 'iC', index: 'i_c', width: 80 }, 			
			{ label: 'a相电压', name: 'vA', index: 'v_a', width: 80 }, 			
			{ label: '', name: 'vB', index: 'v_b', width: 80 }, 			
			{ label: '', name: 'vC', index: 'v_c', width: 80 }, 			
			{ label: 'a相有功', name: 'wUsefulA', index: 'w_useful_a', width: 80 }, 			
			{ label: 'b相有功', name: 'wUsefulB', index: 'w_useful_b', width: 80 }, 			
			{ label: 'c相有功', name: 'wUsefulC', index: 'w_useful_c', width: 80 }, 			
			{ label: 'a相无功', name: 'wUselessA', index: 'w_useless_a', width: 80 }, 			
			{ label: 'b相无功', name: 'wUselessB', index: 'w_useless_b', width: 80 }, 			
			{ label: 'c相无功', name: 'wUselessC', index: 'w_useless_c', width: 80 }, 			
			{ label: 'a相视在总功', name: 'wTotalA', index: 'w_total_a', width: 80 }, 			
			{ label: 'b相视在总功', name: 'wTotalB', index: 'w_total_b', width: 80 }, 			
			{ label: 'c相视在总功', name: 'wTotalC', index: 'w_total_c', width: 80 }, 			
			{ label: '总有功功率', name: 'wUsefulTotal', index: 'w_useful_total', width: 80 }, 			
			{ label: '总无功功率', name: 'wUselessTotal', index: 'w_useless_total', width: 80 }, 			
			{ label: '总视在总功', name: 'wTotalTotal', index: 'w_total_total', width: 80 }, 			
			{ label: '当前有功需量', name: 'wCurrentUsefulRequire', index: 'w_current_useful_require', width: 80 }, 			
			{ label: '当前无功需量', name: 'wCurrentUselessRequire', index: 'w_current_useless_require', width: 80 }, 			
			{ label: '当前视在需量', name: 'wCurrentTotalRequire', index: 'w_current_total_require', width: 80 }, 			
			{ label: 'A相功率因数', name: 'powerFactorA', index: 'power_factor_a', width: 80 }, 			
			{ label: 'B相功率因数', name: 'powerFactorB', index: 'power_factor_b', width: 80 }, 			
			{ label: 'C相功率因数', name: 'powerFactorC', index: 'power_factor_c', width: 80 }, 			
			{ label: '总功率因数', name: 'totalPowerFactor', index: 'total_power_factor', width: 80 }, 			
			{ label: '零线电流', name: 'iZeroCurve', index: 'i_zero_curve', width: 80 }, 			
			{ label: '三相电流不平衡', name: 'iUnbalanceAbc', index: 'i_unbalance_abc', width: 80 }, 			
			{ label: '三相电压不平衡', name: 'vUnbalanceAbc', index: 'v_unbalance_abc', width: 80 }, 			
			{ label: '频率', name: 'frenqency', index: 'frenqency', width: 80 }, 			
			{ label: '环境温度', name: 'envTemp', index: 'env_temp', width: 80 }, 			
			{ label: '湿度', name: 'envHumidity', index: 'env_humidity', width: 80 }, 			
			{ label: '复费率1', name: 'feeRate1', index: 'fee_rate_1', width: 80 }, 			
			{ label: '复费率2', name: 'feeRate2', index: 'fee_rate_2', width: 80 }, 			
			{ label: '复费率3', name: 'feeRate3', index: 'fee_rate_3', width: 80 }, 			
			{ label: '复费率4', name: 'feeRate4', index: 'fee_rate_4', width: 80 }, 			
			{ label: '复费率5', name: 'feeRate5', index: 'fee_rate_5', width: 80 }, 			
			{ label: '复费率6', name: 'feeRate6', index: 'fee_rate_6', width: 80 }, 			
			{ label: '复费率7', name: 'feeRate7', index: 'fee_rate_7', width: 80 }, 			
			{ label: '复费率8', name: 'feeRate8', index: 'fee_rate_8', width: 80 }, 			
			{ label: 'A相正向有功电量', name: 'kwhUsefulA', index: 'kwh_useful_a', width: 80 }, 			
			{ label: 'B相正向有功电量', name: 'kwhUsefulB', index: 'kwh_useful_b', width: 80 }, 			
			{ label: 'Ｃ相正向有功电量', name: 'kwhUsefulC', index: 'kwh_useful_c', width: 80 }, 			
			{ label: '当前总正向有功电量', name: 'kwhUsefulAbc', index: 'kwh_useful_abc', width: 80 }, 			
			{ label: 'A相正向有功电量（计算电费）', name: 'kwhUsefulTotalA', index: 'kwh_useful_total_a', width: 80 }, 			
			{ label: 'B相正向有功电量（计算电费）', name: 'kwhUsefulTotalB', index: 'kwh_useful_total_b', width: 80 }, 			
			{ label: 'Ｃ相正向有功电量（计算电费）', name: 'kwhUsefulTotalC', index: 'kwh_useful_total_c', width: 80 }, 			
			{ label: '总正向有功电量（计算电费）', name: 'kwhUsefulTotalAbc', index: 'kwh_useful_total_abc', width: 80 }, 			
			{ label: 'A相电缆温度', name: 'tempA', index: 'temp_a', width: 80 }, 			
			{ label: 'B相电缆温度', name: 'tempB', index: 'temp_b', width: 80 }, 			
			{ label: 'C相电缆温度', name: 'tempC', index: 'temp_c', width: 80 }, 			
			{ label: '负荷率', name: 'loadRate', index: 'load_rate', width: 80 }, 			
			{ label: '频率偏差', name: 'frequencyOffset', index: 'frequency_offset', width: 80 }			
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
		dcDataRecord: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.dcDataRecord = {};
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
			var url = vm.dcDataRecord.id == null ? "sys/dcdatarecord/save" : "sys/dcdatarecord/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.dcDataRecord),
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
				    url: baseURL + "sys/dcdatarecord/delete",
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
			$.get(baseURL + "sys/dcdatarecord/info/"+id, function(r){
                vm.dcDataRecord = r.dcDataRecord;
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