
// 能效分析 电能质量

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


$(function(){

	var power = Vue.extend({
        template:` 
			<div id="power" style="height: 400px;">
        `,
        data: function () {
            return{
                sData: [520, 932, 601, 934, 1190, 1330, 1320]
            }
        },
        methods:{
        	drawLine: function(){
		        var power = echarts.init(document.getElementById('power'))
		        power.setOption({
		            title: {
				        text: '功率因数',
				        padding: [4,0,0,15]
				    },
				    tooltip: {
				        trigger: 'axis'
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    xAxis: {
				        type: 'category',
				        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
				    },
				    yAxis: {
				        type: 'value',
				        name: ''
				    },
				    series: [{
				        data: this.sData,
				        type: 'line',
				        smooth: true,
				        itemStyle: {
				            normal: {
				                color: "#158ae4",
				                lineStyle: {
				                    color: "#158ae4"
				                }
				            }
				        }
				    }]
		        });
		        power.resize();
        	}
        },
        mounted(){
		    this.drawLine();
		    // $.ajax({
	        //     type: "GET",
	        //     url: "",
	        //     data: {},
	        //     dataType: "json",
	        //     success: function(data){
	                        
	        //     }
	        // });	
		}
    });


 	var harmonic = Vue.extend({
        template:`
			<div id="harmonic" style="height: 400px;">
        `,
        data: function () {
            return{
                
            }
        },
        methods:{
        	drawLine: function(){		
		        var harmonic = echarts.init(document.getElementById('harmonic'))
		        harmonic.setOption({
		            title: {
				        text: '谐波',
				        padding: [4,0,0,15]
				    },
				    tooltip: {
				        trigger: 'axis'
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    xAxis: {
				        type: 'category',
				        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
				    },
				    yAxis: {
				        type: 'value',
				        name: ''
				    },
				    series: [{
				        data: [520, 932, 601, 934, 1190, 1330, 1320],
				        type: 'line',
				        smooth: true,
				        itemStyle: {
				            normal: {
				                color: "#158ae4",
				                lineStyle: {
				                    color: "#158ae4"
				                }
				            }
				        }
				    }]
		        });
		        window.onresize = function () {
			        harmonic.resize();
			    };    
        	}
        },
        mounted(){
		    this.drawLine();
		}
    });


 	var imbalance = Vue.extend({
        template:`
			<div id="imbalance" style="height: 400px;">
        `,
        data: function () {
            return{
                
            }
        },
        methods:{
        	drawLine: function(){		
		        var imbalance = echarts.init(document.getElementById('imbalance'))
		        imbalance.setOption({
		            title: {
				        text: '三相不平衡',
				        padding: [4,0,0,15]
				    },
				    tooltip: {
				        trigger: 'axis'
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    xAxis: {
				        type: 'category',
				        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
				    },
				    yAxis: {
				        type: 'value',
				        name: ''
				    },
				    series: [{
				        data: [520, 932, 601, 934, 1190, 1330, 1320],
				        type: 'line',
				        smooth: true,
				        itemStyle: {
				            normal: {
				                color: "#158ae4",
				                lineStyle: {
				                    color: "#158ae4"
				                }
				            }
				        }
				    }]
		        });
        	}
        },
        mounted(){
		    this.drawLine();
		}
    });


 	var lineloss = Vue.extend({
        template:`
			<div id="lineloss" style="height: 400px;"></div>
        `,
        data: function () {
            return{
                
            }
        },
        methods:{
        	drawLine: function(){		
		        var lineloss = echarts.init(document.getElementById('lineloss'))
		        lineloss.setOption({
		            title: {
				        text: '线损',
				        padding: [4,0,0,15]
				    },
				    tooltip: {
				        trigger: 'axis'
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    xAxis: {
				        type: 'category',
				        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
				    },
				    yAxis: {
				        type: 'value',
				        name: ''
				    },
				    series: [{
				        data: [520, 932, 601, 934, 1190, 1330, 1320],
				        type: 'line',
				        smooth: true,
				        itemStyle: {
				            normal: {
				                color: "#158ae4",
				                lineStyle: {
				                    color: "#158ae4"
				                }
				            }
				        }
				    }]
		        });
        	}
        },
        mounted(){
		    this.drawLine();
		}
    });


	var vm = new Vue({
		el:"#topic",
		data:{
		    navLists:[
		        {"text":"功率因数"},
		        {"text":"谐波"},
		        {"text":"三项不平衡"},
		        {"text":"线损"}
		    ],
		    isAct:0,
		    tab1:true,
		    tab2:false,
		    tab3:false,
		    tab4:false
		},
		methods:{
		    toggle:function(index){
		        this.isAct = index;
		        index != 0 ? this.tab1 = false : this.tab1 = true;
		        index == 1 ? this.tab2 = true : this.tab2 = false;
		        index == 2 ? this.tab3 = true : this.tab3 = false;
		        index == 3 ? this.tab4 = true : this.tab4 = false;
		    }
		},
		components: {
			"tab1": power,
            "tab2": harmonic,
            "tab3": imbalance,
            "tab4": lineloss
        }
	});

})