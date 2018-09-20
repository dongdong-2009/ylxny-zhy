$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'dict/device/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '站点id', name: 'station_id', index: 'station_id', width: 80 }, 			
			{ label: '采集设备唯一id', name: 'device_id', index: 'device_id', width: 80 }, 			
			{ label: '是否启用 （0 启用 1 不启用）', name: 'inUse', index: 'inUse', width: 80 }, 			
			{ label: '采集设备在线状态（0 启用 1 停用）', name: 'online_status', index: 'online_status', width: 80 }, 			
			{ label: 'sim卡号', name: 'sim', index: 'sim', width: 80 }, 			
			{ label: '安装位置', name: 'place', index: 'place', width: 80 }, 			
			{ label: ' 上线时间', name: 'onlinetime', index: 'onlinetime', width: 80 }, 			
			{ label: '采集器最后在线时间', name: 'lasttime', index: 'lasttime', width: 80 }, 			
			{ label: '默认采集器下回路的协议都是一样的', name: 'protocol_type', index: 'protocol_type', width: 80 }			
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
		device: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.device = {};
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
			var url = vm.device.id == null ? "dict/device/save" : "dict/device/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.device),
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
				    url: baseURL + "dict/device/delete",
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
			$.get(baseURL + "dict/device/info/"+id, function(r){
                vm.device = r.device;
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