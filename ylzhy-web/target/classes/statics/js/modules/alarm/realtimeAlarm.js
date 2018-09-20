$(function () {
	  $("#datetime-start").datetimepicker({
	        format: 'YYYY-MM-DD',
	        locale: moment.locale('zh-cn')
	    });

	    $("#datetime-end").datetimepicker({
	        format: 'YYYY-MM-DD',
	        locale: moment.locale('zh-cn')
	    });
	    
	initBigAlrmType();
	
        	 $("#query_btn").click(function(){ 
             	  //var bigType = $("#bigAlarmType").val(); 
             	  var smallType = $("#smallAlarmType").val(); 
                  var level = $("#level").val(); 
                  var startDate = $("#datetime-start").val();
                  var endDate = $("#datetime-end").val();
                  
                 //点击查询，可以将自定义的参数设置到postData
                 $("#jqGrid").jqGrid('setGridParam',{ 
             
                	 url:baseURL+ '/alarm/queryByForm',
                     postData:{
                    	// bigType:bigType,
                    	 type:smallType,
                    	 level:level,
                    	 startDate:startDate,
                    	 endDate:endDate
                    }, //发送数据 
                     page:1  
                   
                 }).trigger("reloadGrid"); //重新载入 
             }); 
 
 
    $("#jqGrid").jqGrid({
        url: '../../alarm/list',
        datatype: "json",
        postData:{},//如果有默认的自定义参数，可以写在这里， 
        colModel: [			
			{  label: 'id', name: 'id',  width: 50, key: true, hidden:false},
			{ label: '公司id', name: 'company_id',   width: 80 }, 		
			{ label: '站点id', name: 'station_id',   width: 80 }, 
			{ label: '站点名称', name: 'station_name',   width: 80 }, 			
			//{ label: '对应的系统报警设置的id', name: 'alarm_setting_id' index:"alarm_setting_id",   width: 80 }, 			
			{ label: '回路id', name: 'line_id', index: 'line_id', width: 80 }, 			
			{ label: '回路名称', name: 'line_name', index: 'line_name', width: 60 }, 			
			{ label: '报警类型', name: 'alarm_type', index: 'alarm_type', width: 80 }, 			
			{ label: '报警名称', name: 'alarm_name', index: 'alarm_name', width: 80 },
			{ label: '报警因素', name: 'alarm_factor', index: 'alarm_factor', width: 80 }, 			
			{ label: '报警时间', name: 'alarm_time', index: 'alarm_time', width: 120 }, 					 
			{ label: '报警级别', name: 'alarm_level', index: 'alarm_level', width: 80 },					 
			{ label: '当前值', name: 'current_value', index: 'current_value', width: 80 }, 					 
			{ label: '越限值', name: 'water_value', index: 'water_value', width: 80 },				 
			{ label: '事件状态', name: 'status', index: 'status', width: 80 }  						 
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

//初始警报大类下拉框
function initBigAlrmType(){
	$("#smallAlarmType").append("<option value=''>请选择警报小类</option>");
	$("#bigAlarmType").html("");
	$.ajax({
		type: "POST",
	    url: baseURL + "dict/dmdict/loadlist/"+0+"/"+7+"/"+10,
        contentType: "application/json",
	    data: {},
	    success: function(r){
			console.log("===select===");
			console.log(r);
			console.log("===select===");
			$('#bigAlarmType').val("");
			$("#bigAlarmType").append("<option value='0'>请选择警报大类</option>");
			for(var i=0;i<r.page.length;i++){
				$("#bigAlarmType").append("<option value='"+r.page[i].ZdId+"'>"+r.page[i].Zdmc+"</option>");
			}
		}
	});
}
//级联显示警报小类下拉框
function changeType(){
	$("#smallAlarmType").html("");
	var parentId =$("#bigAlarmType option:selected").val();
	if($("#bigAlarmType option:selected").val()=="0"){
		$("#smallAlarmType").html("<option value=''>请选择警报小类</option>");
	}
	$.ajax({
		type: "POST",
	    url: baseURL + "dict/dmdict/loadlist/"+parentId+"/"+7+"/"+10,
        contentType: "application/json",
	    data: {},
	    success: function(r){
			console.log("===select===");
			console.log(r);
			console.log("===select===");
			for(var i=0;i<r.page.length;i++){
				$("#smallAlarmType").append("<option value='"+r.page[i].Zdcode+"'>"+r.page[i].Zdmc+"</option>");
			}
		}
	});
}

function importDate(){
	alert("导出数据");
}























