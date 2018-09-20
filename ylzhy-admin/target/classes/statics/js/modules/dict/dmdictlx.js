$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'dict/dmdictlx/list',
        datatype: "json",
        colModel: [			
			{ label: '类型ID', name: 'lxId', index: 'LX_ID', width: 50, key: true },
			{ label: '类型名称', name: 'lxMc', index: 'LX_MC', width: 80 }, 			
			{ label: '选用标志', name:'xybz', index:'XYBZ', width:80, fixed:true, sortable:false, resize:false,  
                formatter: function (value, grid, rows, state) {  
                     if(value=='Y') return "选用";   
                     if(value=='N') return "禁用";   
                }  
            },
//			{ label: '排序', name: 'lxPri', index: 'LX_PRI', width: 80 }, 			
			{ label: '备注', name: 'lxBz', index: 'LX_BZ', width: 80 },
			{ 
				label: '操作', name: 'flag', index: 'flag', width: 45, align: 'center',
                formatter: function (cellvalue, options, rowObject) {
                	var id = rowObject['lxId'];    
                  return "<div style='float:left'><a href='"+baseURL+"modules/dict/dmdict.html?lxId="+id+"&zdid=-1'>字典维护</a></div>";
                }
			} 	
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
		dmDictlx: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.dmDictlx = {};
		},
		update: function (event) {
			var lxId = getSelectedRow();
			if(lxId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(lxId)
		},
		saveOrUpdate: function (event) {
			var url = vm.dmDictlx.lxId == null ? "dict/dmdictlx/save" : "dict/dmdictlx/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.dmDictlx),
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
			var lxIds = getSelectedRows();
			if(lxIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "dict/dmdictlx/delete",
                    contentType: "application/json",
				    data: JSON.stringify(lxIds),
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
		getInfo: function(lxId){
			$.get(baseURL + "dict/dmdictlx/info/"+lxId, function(r){
                vm.dmDictlx = r.dmDictlx;
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