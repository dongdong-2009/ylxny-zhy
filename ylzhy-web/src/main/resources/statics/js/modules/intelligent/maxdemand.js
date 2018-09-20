
// 智能用电 最大需量分析

$(function(){
	var dayMax = echarts.init(document.getElementById('day-max'));
	var timeMax = echarts.init(document.getElementById('time-max'));
	option1 = {
	    title: {
	        text: '日最大需量',
	        padding: [4,0,10,15]
	    },
	    color: ['#89c3f8'],
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            
	            type : 'shadow'       
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    legend: {
            data:['上限值', '最大需量']
        },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['01', '02', '03', '04', '05', '06', '07'],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value',
	            name: ''
	        }
	    ],
	    toolbox: { 
	        feature: {
	            magicType: {
	                type: ['bar', 'line']
	            }
	        }
	    },
	    series : [
	        {
	        	name:'上限值',
	            type:'line',
	            data:[100, 100, 100, 100, 100, 100, 100],
	            itemStyle:{
                    normal:{
                        color:'#bd90ed'
                    }
                }
	        },
	        {
	        	name:'最大需量',
	            type:'line',
	            data:[36, 62, 28, 14, 35, 50,96]
	        }
	    ]
	};

	option2 = {
	    title: {
	        text: '发生时间分布',
	        padding: [4,0,10,15]
	    },
	    color: ['#89c3f8'],
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            
	            type : 'shadow'       
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    legend: {
            data:['最大需量发生时间']
        },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['01', '02', '03', '04', '05', '06', '07'],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value',
	            name: ''
	        }
	    ],
	    toolbox: { 
	        feature: {
	            magicType: {
	                type: ['bar', 'line']
	            }
	        }
	    },
	    series : [
	        {
	        	name:'最大需量发生时间',
	            type:'line',
	            data:[36, 62, 28, 14, 35, 50,96]
	        }
	    ]
	};
	dayMax.setOption(option1);
	timeMax.setOption(option2);
	setTimeout(function (){
	    window.onresize = function () {
	        dayMax.resize();
	        timeMax.resize();
	    }
	},200)
})