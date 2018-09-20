
//日期选择框
$(function () {
    $("#datetime-start").datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });

    $("#datetime-end").datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
});


var vm = new Vue({
	el:"#record",
	data:{
	    navLists:[
	        {"text":"电流"},
	        {"text":"电压"},
	        {"text":"功率因数"},
	        {"text":"负荷"},
	        {"text":"温度"}
	    ],
	    isAct:0,
	    a:true,
	    b:true,
	    c:true,
	    d:true,
	    e:true
	},
	methods:{
	    toggle:function(index){
	        this.isAct = index;
	        index != 0 ? this.a = false : this.a = true;
	        index == 1 ? this.b = true : this.b = false;
	        index == 2 ? this.c = true : this.c = false;
	        index == 3 ? this.d = true : this.d = false;
	        index == 4 ? this.e = true : this.e = false;
	    }
	}
});


$(function(){
	var datagram = echarts.init(document.getElementById('datagram'));
	var voltage = echarts.init(document.getElementById('voltage'));
	var power = echarts.init(document.getElementById('power'));
	var burden = echarts.init(document.getElementById('burden'));
	var temperature = echarts.init(document.getElementById('temperature'));

    option1 = {
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
	        data: ['一', '二', '三', '四', '五', '六', '七', '八', '九']
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
	            data: [1, 3, 9, 27, 81, 247, 741, 2223, 6669]
	        },
	        {
	            name: 'B相电流',
	            type: 'line',
	            data: [1, 2, 4, 8, 16, 32, 64, 128, 256]
	        },
	        {
	            name: 'C相电流',
	            type: 'line',
	            data: [1/2, 1/4, 1/8, 1/16, 1/32, 1/64, 1/128, 1/256, 1/512]
	        }
	    ]
	};

	option2 = {
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
	        data: ['一', '二', '三', '四', '五', '六', '七', '八', '九']
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
	            data: [1, 3, 9, 27, 81, 247, 741, 2223, 6669]
	        },
	        {
	            name: 'B相电压',
	            type: 'line',
	            data: [1, 2, 4, 8, 16, 32, 64, 128, 256]
	        },
	        {
	            name: 'C相电压',
	            type: 'line',
	            data: [1/2, 1/4, 1/8, 1/16, 1/32, 1/64, 1/128, 1/256, 1/512]
	        }
	    ]
	};

	option3 = {
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
	        data: ['一', '二', '三', '四', '五', '六', '七', '八', '九']
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
	            data: [1, 3, 9, 27, 81, 247, 741, 2223, 6669]
	        },
	        {
	            name: 'B功率因数',
	            type: 'line',
	            data: [1, 2, 4, 8, 16, 32, 64, 128, 256]
	        },
	        {
	            name: 'C功率因数',
	            type: 'line',
	            data: [1/2, 1/4, 1/8, 1/16, 1/32, 1/64, 1/128, 1/256, 1/512]
	        }
	    ]
	};

	option4 = {
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
	        data: ['一', '二', '三', '四', '五', '六', '七', '八', '九']
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
	            data: [1, 3, 9, 27, 81, 247, 741, 2223, 6669]
	        },
	        {
	            name: 'B负荷',
	            type: 'line',
	            data: [1, 2, 4, 8, 16, 32, 64, 128, 256]
	        },
	        {
	            name: 'C负荷',
	            type: 'line',
	            data: [1/2, 1/4, 1/8, 1/16, 1/32, 1/64, 1/128, 1/256, 1/512]
	        }
	    ]
	};

	option5 = {
		title: {
	        text: '温度',
	        padding: [0,0,50,20]
	    },
	    tooltip: {
	        trigger: 'item',
	        formatter: '{a} <br/>{b} : {c}'
	    },
	    xAxis: {
	        type: 'category',
	        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
	    },
	    yAxis: {
	        type: 'value',
	        name: '℃'
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
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
	    series: [{
	        data: [820, 932, 901, 934, 1290, 1330, 1320],
	        type: 'line'
	    }]
	};

	datagram.setOption(option1);
	voltage.setOption(option2);
	power.setOption(option3);
	burden.setOption(option4);
	temperature.setOption(option5);

    window.onresize = function () {
        datagram.resize();
        voltage.resize();
        power.resize();
        burden.resize();
        temperature.resize();
    }
})
