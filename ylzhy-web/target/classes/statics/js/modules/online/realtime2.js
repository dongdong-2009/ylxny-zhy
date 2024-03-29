
var listIndex = 0;

$(function(){
	var current = echarts.init(document.getElementById('current'));
	current.setOption({
	 	title: {
            text: '电流曲线',
            padding: [0,0,50,20]
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c}'
        },
        toolbox: { //可视化的工具箱
            show: true,
            feature: {
                dataView: { //数据视图
                    show: true
                },
                restore: { //重置
                    show: true
                },
                saveAsImage: {//保存图片
                    show: true
                },
                magicType: {//动态类型切换
                    type: ['bar', 'line']
                }
            }
        },
        legend: {
            left: 'center',
            data: ['A相电流', 'B相电流','C相电流']
        },
        xAxis: {
            type: 'category',
            splitLine: {show: false},
            data: []
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        yAxis: {
            type: 'log',
            name: 'A'
        },
        series: [
            {
                name: 'A相电流',
                type: 'line',
                data: []
            },
            {
                name: 'B相电流',
                type: 'line',
                data: []
            },
            {
                name: 'C相电流',
                type: 'line',
                data: []
            }
        ] 
	})
	$.ajax({
        type: "POST",
        url: "../../summary/datarecord/initElectricCurrent/list",
        data: {
            //lineId: $('#loop').attr('value')
        },
        dataType: "json",
        success: function(data){
            console.log(data)
            current.setOption({
		        xAxis: {
		            data: data.data.time
		        },
		        series: [
		        	{
			            name: 'A相电流',
			            data: data.data.aElectricCurrent
		        	},
		        	{
			            name: 'B相电流',
			            data: data.data.bElectricCurrent
		        	},
		        	{
			            name: 'C相电流',
			            data: data.data.cElectricCurrent
		        	}
		        ]
		    });
        }
    });
	window.addEventListener("resize", current.resize);


	$('#topic').on('click','li',function(){
		var index = $(this).index();
		$(this).addClass('active').siblings().removeClass('active');
		if(index == 0){
			listIndex = 0;
			$('#current').removeClass('isNone').siblings().addClass('isNone');
		}
		if(index == 1){
			listIndex = 1;
			$('#voltage').removeClass('isNone').siblings().addClass('isNone');
			var voltage = echarts.init(document.getElementById('voltage'));
			voltage.setOption({
		        title: {
		            text: '电压曲线',
		            padding: [0,0,50,20]
		        },
		        tooltip: {
		            trigger: 'item',
		            formatter: '{a} <br/>{b} : {c}'
		        },
		        toolbox: { //可视化的工具箱
		            show: true,
		            feature: {
		                dataView: { //数据视图
		                    show: true
		                },
		                restore: { //重置
		                    show: true
		                },
		                saveAsImage: {//保存图片
		                    show: true
		                },
		                magicType: {//动态类型切换
		                    type: ['bar', 'line']
		                }
		            }
		        },
		        legend: {
		            left: 'center',
		            data: ['A相电压', 'B相电压','C相电压']
		        },
		        xAxis: {
		            type: 'category',
		            splitLine: {show: false},
		            data: []
		        },
		        grid: {
		            left: '3%',
		            right: '4%',
		            bottom: '3%',
		            containLabel: true
		        },
		        yAxis: {
		            type: 'log',
		            name: 'V'
		        },
		        series: [
		            {
		                name: 'A相电压',
		                type: 'line',
		                data: []
		            },
		            {
		                name: 'B相电压',
		                type: 'line',
		                data: []
		            },
		            {
		                name: 'C相电压',
		                type: 'line',
		                data: []
		            }
		        ]
		    });
			$.ajax({
		        type: "POST",
		        url: "../../summary/datarecord/initVoltage/list",
		        data: {
		            //lineId: $('#loop').attr('value')
		        },
		        dataType: "json",
		        success: function(data){
		            console.log(data)
		            voltage.setOption({
				        xAxis: {
				            data: data.data.time
				        },
				        series: [
				        	{
					            name: 'A相电压',
					            data: data.data.aVoltage
				        	},
				        	{
					            name: 'B相电压',
					            data: data.data.bVoltage
				        	},
				        	{
					            name: 'C相电压',
					            data: data.data.cVoltage
				        	}
				        ]
				    });
		        }
		    });
		}
		if(index == 2){
			listIndex = 2;
			$('#powerfactor').removeClass('isNone').siblings().addClass('isNone');
			var powerfactor = echarts.init(document.getElementById('powerfactor'));
			powerfactor.setOption({
                title: {
                    text: '功率因数',
                    padding: [0,0,50,20]
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c}'
                },
                toolbox: { //可视化的工具箱
                    show: true,
                    feature: {
                        dataView: { //数据视图
                            show: true
                        },
                        restore: { //重置
                            show: true
                        },
                        saveAsImage: {//保存图片
                            show: true
                        },
                        magicType: {//动态类型切换
                            type: ['bar', 'line']
                        }
                    }
                },
                legend: {
                    left: 'center',
                    data: ['A功率因数', 'B功率因数','C功率因数']
                },
                xAxis: {
                    type: 'category',
                    splitLine: {show: false},
                    data: []
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                yAxis: {
                    type: 'log',
                    name: ''
                },
                series: [
                    {
                        name: 'A功率因数',
                        type: 'line',
                        data: []
                    },
                    {
                        name: 'B功率因数',
                        type: 'line',
                        data: []
                    },
                    {
                        name: 'C功率因数',
                        type: 'line',
                        data: []
                    }
                ]
            });
            $.ajax({
		        type: "POST",
		        url: "../../summary/datarecord/initPowerFactor/list",
		        data: {
		            //lineId: $('#loop').attr('value')
		        },
		        dataType: "json",
		        success: function(data){
		            console.log(data)
		            powerfactor.setOption({
				        xAxis: {
				            data: data.data.time
				        },
				        series: [
				        	{
					            name: 'A功率因数',
					            data: data.data.aPowerFactor
				        	},
				        	{
					            name: 'B功率因数',
					            data: data.data.bPowerFactor
				        	},
				        	{
					            name: 'C功率因数',
					            data: data.data.cPowerFactor
				        	}
				        ]
				    });
		        }
		    });
		}
		if(index == 3){
			listIndex = 3;
			$('#charge').removeClass('isNone').siblings().addClass('isNone');
			var charge = echarts.init(document.getElementById('charge'));
			charge.setOption({
                title: {
                    text: '负荷',
                    padding: [0,0,50,20]
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c}'
                },
                toolbox: { //可视化的工具箱
                    show: true,
                    feature: {
                        dataView: { //数据视图
                            show: true
                        },
                        restore: { //重置
                            show: true
                        },
                        saveAsImage: {//保存图片
                            show: true
                        },
                        magicType: {//动态类型切换
                            type: ['bar', 'line']
                        }
                    }
                },
                legend: {
                    left: 'center',
                    data: ['A负荷', 'B负荷','C负荷']
                },
                xAxis: {
                    type: 'category',
                    splitLine: {show: false},
                    data: []
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                yAxis: {
                    type: 'log',
                    name: 'kVar'
                },
                series: [
                    {
                        name: 'A负荷',
                        type: 'line',
                        data: []
                    },
                    {
                        name: 'B负荷',
                        type: 'line',
                        data: []
                    },
                    {
                        name: 'C负荷',
                        type: 'line',
                        data: []
                    }
                ]
            });
            $.ajax({
		        type: "POST",
		        url: "/ylzhy/realtime/fuhe/list",
		        data: {
		            //lineId: $('#loop').attr('value')
		        },
		        dataType: "json",
		        success: function(data){
		            console.log(data)
		            charge.setOption({
				        xAxis: {
				            data: []
				        },
				        series: [
				        	{
					            name: 'A负荷',
					            data: data.a
				        	},
				        	{
					            name: 'B负荷',
					            data: data.b
				        	},
				        	{
					            name: 'C负荷',
					            data: data.c
				        	}
				        ]
				    });
		        }
		    });
		}
	})
	 
})

//查询
$('#query').click(function(){
	var loopId = $('#loop').attr('value');
	var startTime = $('#datetime-start').val();
	var endTime = $('#datetime-end').val();
	// 电流
	if(listIndex == 0){
		if(startTime && endTime){
			console.log("电流")
			$.ajax({
		        type: "POST",
		        url: "../../summary/datarecord/electricCurrent/list",
		        data: {
		        	lineId: loopId,
		            startTime: startTime,
		            endTime: endTime
		        },
		        dataType: "json",
		        success: function(data){
		        	console.log(data)
		        	var current = echarts.init(document.getElementById('current'));
		            current.setOption({
				        xAxis: {
				            data: data.data.time
				        },
				        series: [
				        	{
					            name: 'A相电流',
					            data: data.data.aElectricCurrent
				        	},
				        	{
					            name: 'B相电流',
					            data: data.data.bElectricCurrent
				        	},
				        	{
					            name: 'C相电流',
					            data: data.data.cElectricCurrent
				        	}
				        ]
				    });
		        }    
		    });
			//askfor(loopId,"../../summary/datarecord/electricCurrent/list",startTime,endTime);
		}
	}
	// 电压
	if(listIndex == 1){
		if(startTime && endTime){
			console.log("电压")
			$.ajax({
		        type: "POST",
		        url: "../../summary/datarecord/voltage/list",
		        data: {
		        	lineId: loopId,
		            startTime: startTime,
		            endTime: endTime
		        },
		        dataType: "json",
		        success: function(data){
		        	console.log(data)
		        	var voltage = echarts.init(document.getElementById('voltage'));
		            voltage.setOption({
				        xAxis: {
				            data: data.data.time
				        },
				        series: [
				        	{
					            name: 'A相电压',
					            data: data.data.aVoltage
				        	},
				        	{
					            name: 'B相电压',
					            data: data.data.bVoltage
				        	},
				        	{
					            name: 'C相电压',
					            data: data.data.cVoltage
				        	}
				        ]
				    });
		        }    
		    });
		}
	}
	// 功率因数
	if(listIndex == 2){
		if(startTime && endTime){
			console.log("功率因数")
			$.ajax({
		        type: "POST",
		        url: "../../summary/datarecord/powerFactor/list",
		        data: {
		        	lineId: loopId,
		            startTime: startTime,
		            endTime: endTime
		        },
		        dataType: "json",
		        success: function(data){
		        	console.log(data)
		        	var powerfactor = echarts.init(document.getElementById('powerfactor'));
		            powerfactor.setOption({
				        xAxis: {
				            data: data.data.time
				        },
				        series: [
				        	{
					            name: 'A功率因数',
					            data: data.data.aPowerFactor
				        	},
				        	{
					            name: 'B功率因数',
					            data: data.data.bPowerFactor
				        	},
				        	{
					            name: 'C功率因数',
					            data: data.data.cPowerFactor
				        	}
				        ]
				    });
		        }    
		    });
		}
	}
	// 负荷
	if(listIndex == 3){
		if(startTime && endTime){
			askfor(loopId,"",startTime,endTime);
		}
	}
})



//查询
function askfor(id,url,startTime,endTime){
	$.ajax({
        type: "POST",
        url: url,
        data: {
        	lineId: id,
            startTime: startTime,
            endTime: endTime
        },
        dataType: "json",
        success: function(data){
            console.log(data)
        }    
    });
}

//初始化
function init(){
	
}