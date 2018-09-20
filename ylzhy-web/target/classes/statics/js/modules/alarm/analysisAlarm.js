
// 报警信息 报警分析
$(function(){
	var analysis = echarts.init(document.getElementById('analysis'));
	option = {
	    title: {
	        text: '报警统计',
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
            data:['2018-06-20', '2018-06-21']
        },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['电流', '电压', '功率因数', '负荷', '线缆温度', '三相不平衡', '需量', '谐波'],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value',
	            name: '次数'
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
	analysis.setOption(option);
	setTimeout(function (){
	    window.onresize = function () {
	        analysis.resize();
	    }
	},200)
})