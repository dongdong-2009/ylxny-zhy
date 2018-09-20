
// 能效分析 能耗同比
$(function(){
	var encons = echarts.init(document.getElementById('encons'));
	var elcons = echarts.init(document.getElementById('elcons'));
	option1 = {
	    title: {
	        text: '能耗时比',
	        padding: [4,0,0,15]
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
            data:['2018-06-20', '2018-06-21']
        },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['00:00', '03:00', '06:00', '09:00', '12:00', '15:00', '18:00', '21:00', '24:00'],
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
	    series : [
	        {
	        	name:'2018-06-20',
	            type:'line',
	            data:[10, 52, 20, 34, 90, 30, 20,5,62]
	        },
	        {
	        	name:'2018-06-21',
	            type:'line',
	            data:[36, 62, 28, 14, 98, 35, 50,96,50],
	            itemStyle:{
                    normal:{
                        color:'#bd90ed'
                    }
                }
	        }
	    ]
	};
	option2 = {
	    title: {
	        text: '用电量对比',
	        padding: [4,0,0,15]
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
            data:['2018-06-20', '2018-06-21']
        },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['00:00', '03:00', '06:00', '09:00', '12:00', '15:00', '18:00', '21:00', '24:00'],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value',
	            name: 'kwh'
	        }
	    ],
	    series : [
	        {
	        	name:'2018-06-20',
	            type:'line',
	            data:[10, 52, 20, 34, 90, 30, 20,5,62]
	        },
	        {
	        	name:'2018-06-21',
	            type:'line',
	            data:[36, 62, 28, 14, 98, 35, 50,96,50],
	            itemStyle:{
                    normal:{
                        color:'#bd90ed'
                    }
                }
	        }
	    ]
	};
	encons.setOption(option1);
	elcons.setOption(option2);

	setTimeout(function (){
	    window.onresize = function () {
	        encons.resize();
	        elcons.resize();
	    }
	},200)
})



$(function(){
	var elogy = echarts.init(document.getElementById('elogy'));
	var alogy = echarts.init(document.getElementById('alogy'));
	option1 = {
	    title: {
	        text: '能耗类比',
	        padding: [4,0,0,15]
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
            data:['2018-06-20', '2018-06-21']
        },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['00:00', '03:00', '06:00', '09:00', '12:00', '15:00', '18:00', '21:00', '24:00'],
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
	    series : [
	        {
	        	name:'2018-06-20',
	            type:'line',
	            data:[10, 52, 20, 34, 90, 30, 20,5,62]
	        },
	        {
	        	name:'2018-06-21',
	            type:'line',
	            data:[36, 62, 28, 14, 98, 35, 50,96,50],
	            itemStyle:{
                    normal:{
                        color:'#bd90ed'
                    }
                }
	        }
	    ]
	};
	option2 = {
	    title: {
	        text: '用电量类比',
	        padding: [4,0,0,15]
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
            data:['2018-06-20', '2018-06-21']
        },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['00:00', '03:00', '06:00', '09:00', '12:00', '15:00', '18:00', '21:00', '24:00'],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value',
	            name: 'kwh'
	        }
	    ],
	    series : [
	        {
	        	name:'2018-06-20',
	            type:'line',
	            data:[10, 52, 20, 34, 90, 30, 20,5,62]
	        },
	        {
	        	name:'2018-06-21',
	            type:'line',
	            data:[36, 62, 28, 14, 98, 35, 50,96,50],
	            itemStyle:{
                    normal:{
                        color:'#bd90ed'
                    }
                }
	        }
	    ]
	};
	elogy.setOption(option1);
	alogy.setOption(option2);

	setTimeout(function (){
	    window.onresize = function () {
	        elogy.resize();
	        alogy.resize();
	    }
	},200)
})