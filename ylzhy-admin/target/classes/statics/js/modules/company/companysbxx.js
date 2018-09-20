$(function () {
	
	//初始化设备类型下拉框
	
	
	
	
   //标准的写法，相关查询可以参考
        $("#query_btn").click(function(){ 
        	//escape($("#companyName").val())
        	  var companyName  = $("#companyName").val() ; 
              var sbnum = $("#sbnum").val() ; 
              var sblx =  $("#sblx").val() ; 
              var sbname =  $("#sbname").val() ; 
              var sbaddress =  $("#sbaddress").val() ; 
          
            //点击查询，可以将自定义的参数设置到postData
            $("#jqGrid").jqGrid('setGridParam',{ 
        
                url: baseURL + 'company/companysbxx/list',
                postData:{companyName:companyName,sbnum:sbnum,sblx:sblx,sbaddress:sbaddress,sbname:sbname}, //发送数据 
                page:1  
              
            }).trigger("reloadGrid"); //重新载入 
        }); 
 
 
    $("#jqGrid").jqGrid({
        url: baseURL + 'company/companysbxx/list',
        datatype: "json",
        postData:{},//如果有默认的自定义参数，可以写在这里， 
        colModel: [			
			{  name: 'sbId',  width: 50, key: true, hidden:false},
			{ label: '设备名称', name: 'sbname',   width: 80 }, 		
			{ label: '企业名称', name: 'companyName',   width: 80 }, 
			{ label: '设备类型', name: 'sblxMc',   width: 80 }, 			
			{ label: '设备小类', name: 'sbDetailName',   width: 80 }, 			
			{ label: '上级设备', name: 'parentsbname', index: 'parentsbname', width: 80 }, 			
			{ label: '设备编号', name: 'sbnum', index: 'sbnum', width: 80 }, 			
			{ label: '回路地址', name: 'sbaddress', index: 'sbaddress', width: 80 }, 			
			{ label: '支持的协议', name: 'protocol', index: 'protocol', width: 80 }		,
			{ label: '是否选用', name: 'xybz', index: 'xybz', width: 80 }, 			
			{ label: '创建时间', name: 'createtime', index: 'createtime', width: 80 }  					 
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,20,30,40,50],
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


//json转化 跟options 键值对应上
function to_selectOption(data){
   // var len=eval(data).length;
	
	var sblxAll =[];
	
	var len= data.length;
 
    for(var i=0;i<len;i++){
    	var sblxone =new Object() ;
    	sblxone.text=data[i].Zdmc;
    	sblxone.value=data[i].ZdId;
    	sblxAll.push(sblxone);
    }
   // console.log("sblxAll===="+JSON.stringify(sblxAll) ) ;
    return  sblxAll ;  
}

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: "设备信息维护",
		companySbxx: {},
		items:{},
		sblxselected:'',

	},
	mounted() {
	 
	    this.init();
	},
	methods: {
		init :function () {
		    //初始化下拉列表数据 
			var url =  "dict/dmdict/loadlist/"+0+"/"+4+"/"+10;
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data:{} ,
			    success: function(r){    
			    	if(r.code === 0){
							var  temp=  to_selectOption(r.page);
						     vm.items = temp ;			 
					}else{
						alert(r.msg);
					}
				}
			});
		},
			
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.companySbxx = {};
		},
		update: function (event) {
			var sbid = getSelectedRow();
			if(sbid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(sbid)
		},
		saveOrUpdate: function (event) {
			var url = vm.companySbxx.sbid == null ? "company/companysbxx/save" : "company/companysbxx/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.companySbxx),
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
			var sbids = getSelectedRows();
			if(sbids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "company/companysbxx/delete",
                    contentType: "application/json",
				    data: JSON.stringify(sbids),
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
		getInfo: function(sbid){
			$.get(baseURL + "company/companysbxx/info/"+sbid, function(r){
                vm.companySbxx = r.companySbxx;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
	    sblxSelect:function (event) {
	    	 alert(1111); //可以实现关联查询 
	    }
	}
});