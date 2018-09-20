


$(function(){

    // 电流
    var current = Vue.extend({
        template:` 
            <div id="current" style="height: 400px;">
        `,
        data: function () {
            return{
                chart: ''
            }
        },
        watch: {
            option: {
                handler(newVal, oldVal) {
                    if (this.chart) {
                        if (newVal) {
                            this.chart.setOption(newVal);
                        } else {
                            this.chart.setOption(oldVal);
                        }
                    } else {
                        this.init();
                    }
                },
                deep: true 
            }
        },
        props:{
            width: {
                type: String,
                default: "100%"
            },
            height: {
                type: String,
                default: "400px"
            },
            option:{
                type: Object,
                default(){
                    return{
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
                            data: [1, 2, 4, 8, 16, 32, 64, 128, 256]
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
                                data: [1, 2, 4, 8, 16, 32, 64, 128, 256]
                            },
                            {
                                name: 'B相电流',
                                type: 'line',
                                data: [1, 2, 4, 8, 16, 32, 64, 5, 256]
                            },
                            {
                                name: 'C相电流',
                                type: 'line',
                                data: [1, 2, 4, 8, 2, 32, 64, 128, 256]
                            }
                        ] 
                    }
                }
            }
        },
        computed: {
            style() {
                return {
                    height: this.height,
                    width: this.width
                }
            }
         },
        methods:{
            init: function(){
                this.chart = echarts.init(document.getElementById('current'));
                this.chart.setOption(this.option);
                window.addEventListener("resize", this.chart.resize);
            }
        },
        mounted(){
            $.ajax({
                type: "POST",
                url: "../../summary/datarecord/initElectricCurrent/list",
                data: {
                    // startTime: this.startTime,
                    // endTime: this.endTime
                },
                dataType: "json",
                success: function(data){
                    console.log(data)
                }
            });
            this.init();  
        }
    });

    // 电压
    var voltage = Vue.extend({
        template:` 
            <div id="voltage" style="height: 400px;">
        `,
        data: function () {
            return{
                sData: []
            }
        },
        methods:{
            drawLine: function(){
                var voltage = echarts.init(document.getElementById('voltage'))
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
                });
            }
        },
        mounted(){
            this.drawLine();
        }
    });

    //功率因数
    var powerfactor = Vue.extend({
        template:` 
            <div id="powerfactor" style="height: 400px;">
        `,
        data: function () {
            return{
                sData: []
            }
        },
        methods:{
            drawLine: function(){
                var powerfactor = echarts.init(document.getElementById('powerfactor'))
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
                });
                powerfactor.resize();
            }
        },
        mounted(){
            this.drawLine();
        }
    });

    //负荷
    var charge = Vue.extend({
        template:` 
            <div id="charge" style="height: 400px;">
        `,
        data: function () {
            return{
                sData: []
            }
        },
        methods:{
            drawLine: function(){
                var charge = echarts.init(document.getElementById('charge'))
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
                });
                charge.resize();
            }
        },
        mounted(){
            this.drawLine();
        }
    });

    //温度
    var temperature = Vue.extend({
        template:` 
            <div id="temperature" style="height: 400px;">
        `,
        data: function () {
            return{
                sData: []
            }
        },
        methods:{
            drawLine: function(){
                var temperature = echarts.init(document.getElementById('temperature'))
                temperature.setOption({
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
                });
                temperature.resize();
            }
        },
        mounted(){
            this.drawLine();
        }
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
            chartData:{
                xData:[],
                sData:[]
            },
            startTime:'',
            endTime: '',
            isAct:0,
            tab1:true,
            tab2:false,
            tab3:false,
            tab4:false,
            tab5:false
        },
        mounted() {
            this.refreshData();
        },
        methods: {
            toggle:function(index){
                this.isAct = index;
                index != 0 ? this.tab1 = false : this.tab1 = true;
                index == 1 ? this.tab2 = true : this.tab2 = false;
                index == 2 ? this.tab3 = true : this.tab3 = false;
                index == 3 ? this.tab4 = true : this.tab4 = false;
                index == 4 ? this.tab5 = true : this.tab5 = false;
            },
            query:function(){
                console.log(this.startTime + ' ' + this.endTime)
                if(this.isAct == 1){
                    this.askfor('../../summary/datarecord/initVoltage/list');
                }
                if(this.isAct == 2){
                    this.askfor('../../summary/datarecord/initPowerFactor/list');
                }
            },
            askfor:function(url){
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {
                        startTime: this.startTime,
                        endTime: this.endTime
                    },
                    dataType: "json",
                    success: function(data){
                        console.log(data)
                    }
                }); 
            },
            refreshData:function(){
                let xData = this.chartData.xData,
                    sData = this.chartData.sData;
                for (let i = 0; i < xData.length; i++) {
                    setTimeout(() => {
                        this.option.xAxis.data.push(xData[i]);
                        this.option.series[0].data.push(sData[i]);
                    }, 1000*i)
                }
            }
        },
        components: {
            "tab1": current,
            "tab2": voltage,
            "tab3": powerfactor,
            "tab4": charge,
            "tab5": temperature
        }
    });
})



window.onresize = function () {
    
}


