$(function () {
	var lxId=UrlParm.parm("lxId");
	var zdid = UrlParm.parm("zdid");
    console.log(zdid);
    $("#jqGrid").jqGrid({
        url: baseURL + 'dict/dmdict/list/'+lxId+'/'+zdid,
        datatype: "json",
        colModel: [			
//			{ label: '', name: 'lxid', index: 'lxId', width: 80 }, 			
			{ label: 'zdid', name: 'zdid', index: 'ZdId', hidden: true, key: true },
			{ label: '字段值', name: 'zdcode', index: 'Zdcode', width: 80 }, 			
			{ label: '父ID', name: 'parentid', index: 'parentId', width: 80 }, 			
			{ label: '字段名称', name: 'zdmc', index: 'Zdmc', width: 80 }, 			
			{ label: '属性 ', name: 'property', index: 'property', width: 80 }, 			
			{ label: '选用标志', name:'xybz', index:'xybz', width:80, fixed:true, sortable:false, resize:false,  
                formatter: function (value, grid, rows, state) {  
                     if(value=='Y') return "选用";   
                     if(value=='N') return "禁用";   
                }  
            },
//			{ label: '排序', name: 'zdorder', index: 'zdorder', width: 80 }, 			
			{ label: '英文名称', name: 'en', index: 'en', width: 80 },			
			{ label: '备注', name: 'bz', index: 'bz', width: 80 },
			{ 
				label: '操作', name: 'flag', index: 'flag', width: 45, align: 'center',
                formatter: function (cellvalue, options, rowObject) {
                	var lxId = rowObject['lxid'];    
                	var zdid = rowObject['zdid'];
                  return "<div style='float:left'><a href='"+baseURL+"modules/dict/dmdict.html?lxId="+lxId+"&zdid="+zdid+"'>维护下级</a></div>";
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
//获取url参数 
UrlParm = function() { 
	  var data, index;  
	  (function init() {  
	    data = [];  
	    index = {};  
	    var u = window.location.search.substr(1);  
	    if (u != '') {  
	      var parms = decodeURIComponent(u).split('&');  
	      for (var i = 0, len = parms.length; i < len; i++) {  
	        if (parms[i] != '') {  
	          var p = parms[i].split("=");  
	          if (p.length == 1 || (p.length == 2 && p[1] == '')) {
	            data.push(['']);  
	            index[p[0]] = data.length - 1;  
	          } else if (typeof(p[0]) == 'undefined' || p[0] == '') {
	            data[0] = [p[1]];  
	          } else if (typeof(index[p[0]]) == 'undefined') {
	            data.push([p[1]]);  
	            index[p[0]] = data.length - 1;  
	          } else {// c=aaa  
	            data[index[p[0]]].push(p[1]);  
	          }  
	        }  
	      }  
	    }  
	  })();  
	  return {  
	    parm : function(o) { 
	      try {  
	        return (typeof(o) == 'number' ? data[o][0] : data[index[o]][0]);  
	      } catch (e) {  
	      }  
	    },   
	    parmValues : function(o) { 
	      try {  
	        return (typeof(o) == 'number' ? data[o] : data[index[o]]);  
	      } catch (e) {}  
	    },  
	    hasParm : function(parmName) {  
	      return typeof(parmName) == 'string' ? typeof(index[parmName]) != 'undefined' : false;  
	    },  
	    parmMap : function() {  
	      var map = {};  
	      try {  
	        for (var p in index) {  map[p] = data[index[p]];  }  
	      } catch (e) {}  
	      return map;  
	    }  
	  }  
}();  

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		dmDict: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.dmDict = {};
		},
		update: function (event) {
			var zdid = getSelectedRow();
			if(zdid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(zdid)
		},
		saveOrUpdate: function (event) {
			var url = vm.dmDict.zdid == null ? "dict/dmdict/save" : "dict/dmdict/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.dmDict),
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
			var zdids = getSelectedRows();
			if(zdids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "dict/dmdict/delete",
                    contentType: "application/json",
				    data: JSON.stringify(zdids),
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
		getInfo: function(zdid){
			$.get(baseURL + "dict/dmdict/info/"+zdid, function(r){
                vm.dmDict = r.dmDict;
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