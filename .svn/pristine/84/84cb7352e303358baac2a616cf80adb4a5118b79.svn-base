
// 报警信息 报警排名
$(function(){
	var topBar = echarts.init(document.getElementById('topBar'));
	option = {
	    title: {
	        text: '报警排名top10',
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
	    xAxis : [
	        {
	            type : 'value',
	            axisTick: {
	                alignWithLabel: true
	            },
	            name: '次数'
	        }
	    ],
	    yAxis : [
	        {
	            type : 'category',
	            name: '',
	            data : ['电容柜1', '电容柜2', '电容柜3', '电容柜4', '电容柜5', '电容柜6', '电容柜7','电容柜8','电容柜9','电容柜10']
	        }
	    ],
	    series : [
	        {
	            type:'bar',
	            data:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
	            label: {
	                normal: {
	                    show: true,
	                    position: 'right'
	                }
	            }
	        }
	    ],
	     toolbox: { //可视化的工具箱
	        show: true,
	        feature: {
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
	    }
	};
	topBar.setOption(option);

	setTimeout(function (){
	    window.onresize = function () {
	        topBar.resize();
	    }
	},200)
})