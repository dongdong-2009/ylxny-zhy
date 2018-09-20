$(function () {
	
	
	//json转化 跟options 键值对应上
	function to_selectOption(data){
	   // var len=eval(data).length;
		
		var sblxAll =[];
		
		var len= data.length;
	 
	    for(var i=0;i<len;i++){
	    	var sblxone =new Object() ;
	    	sblxone.text=data[i].Zdmc;
	    	sblxone.value=data[i].ZdId;
	    	sblxone.lxId=data[i].lxId;
	    	sblxAll.push(sblxone);
	    }
	   // console.log("sblxAll===="+JSON.stringify(sblxAll) ) ;
	    return  sblxAll ;  
	}
	function getSelectList(URl,vmdata){
		var  code;
			$.ajax({
   				type: "POST",
   			    url: URl,
                contentType: "application/json",
                //async: false,//同步  
   			    data:{} ,
   			    success: function(r){    
   			    	if(r.code === 0){
   					var   temp=  to_selectOption(r.page);
   					  vmdata=temp;
   					code=r.code;
   					}else{
   						alert(r.msg);
   						return '';
   					}
   				}
   			});  
		  
			return code;	
	}
	
	
	
	var vm = new Vue({
        el: '#app',
        data: {
            showPanel: false,
            showTip: false,
    		title: null,
    		company: {},
    		gsgms:{},
    		types:{},
    		propertys:{},
    		provinces:{},
    		cities:{},
    		counties:{}
        }, 
        mounted: function() {
       	     //初始化各种下拉列表
        	 
        	this.init();
    	},
        methods: {
           isShow: function(){
        	  
        	   vm.showPanel = !vm.showPanel;
        	   vm.title="新增企业";
           },
           isTip: function(){
        	   vm.showTip = !vm.showTip;
           },
           init:function(){
        	   // 初始化公司类型
   		    //初始化下拉列表数据 
   			//var url = baseURL+ "dict/dmdict/loadlist/"+0+"/"+1+"/"+20;//公司类型
   			var types =this.getSonList(0,1,20);
   			this.types=types;
   		 
            //初始化公司大类
   			//var url =  "dict/dmdict/loadlist/"+0+"/"+5+"/"+20;//公司大类
   			var gsgms=this.getSonList(0,5,20);
   			this.gsgms = gsgms ;		
             
   		
 			//var url =  "dict/dmdict/loadlist/"+0+"/"+2+"/"+20;//公司性质
 			var propertys=this.getSonList(0,2,20);
 			this.propertys = propertys ;	
 			 
 			//省份
 			//var url =  "dict/dmdict/loadlist/"+0+"/"+3+"/"+40;//省份
 			var provinces=this.getSonList(0,3,40);
 			this.provinces = provinces ;	
 
         },
         getSonList: function (pid,lxId,showsl) {
        	 var  temp ;
        		var url =  "dict/dmdict/loadlist/"+pid+"/"+lxId+"/"+showsl;//省份
     			$.ajax({
       				type: "POST",
       			    url: baseURL + url,
                    contentType: "application/json",
                    async: false,//同步  
       			    data:{} ,
       			    success: function(r){    
       			    	if(r.code === 0){
       			    		temp=  to_selectOption(r.page);
       					 
       							// console.log(" vm.provinces===="+ JSON.stringify( vm.provinces )) ;
       					}else{
       						alert(r.msg);
       					}
       				}
       			}); 
     			 
        	 return temp;
         },
		 saveOrUpdate: function (event) {
			var url = vm.company.companyid == null ? "company/company/save" : "company/company/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.company),
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
			var companyids = getSelectedRows();
			if(companyids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "company/company/delete",
                    contentType: "application/json",
				    data: JSON.stringify(companyids),
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
		getInfo: function(companyid){
			$.get(baseURL + "company/company/info/"+companyid, function(r){
                vm.company = r.company;
            });
		},
		selectSonList: function(event){
			 var parentId= event.target.value;// $(event.target).find("option:selected").attr("value")  ) ;
			 var lxId=$(event.target).find("option:selected").attr("lxId")   ;//自定义属性获取
	         var selectId=event.target.id   ;
	       //  console.log("parentId===="+  parentId) ;
	       //  console.log("lxId===="+  lxId) ;
	        // console.log("selectId===="+  selectId) ;
             if(selectId=="province"){
            	var cities=vm.getSonList(parentId,lxId,40); 
              //  console.log("cities===="+  JSON.stringify(cities )) ;
                vm.cities=cities;
             }
             if(selectId=="city"){
             	var counties=vm.getSonList(parentId,lxId,40); 
               //  console.log("cities===="+  JSON.stringify(cities )) ;
                 vm.counties=counties;
              }
		 } 
        }
     });
});