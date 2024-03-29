//加载图表
var loadChart1 = function () {
    var request = new Object();
    request.url ="/ylzhy/summary/realtime_gonglv/list";
    var date = getFormatDate(new Date());
    request.data = {"date":date};
    get_by_ajax(1, myChart1, request);
}
var loadChart3 = function () {
    var request = new Object();
    request.url ="/ylzhy/summary/devide_fee";
    var date = getFormatDate(new Date());
    request.data = {"date":date};
    get_by_ajax(3, myChart3, request);
}
var loadChart4 = function () {
    var request = new Object();
    request.url ="/ylzhy/summary/dayPower/list";
    request.data = {};
    get_by_ajax(4, myChart4, request);
}
var loadChart5 = function () {
    var request = new Object();
    request.url = "/ylzhy/summary/monthPower/list";
    request.data = {startMonth:"1", endMonth:"9"};
    get_by_ajax(5, myChart5, request);
}
var loadChart6 = function () {
    var request = new Object();
    request.url ="/ylzhy/summary/month/feeCompare";
    request.data = {"startMonth": 8,"endMonth":9};
    get_by_ajax(6, myChart6, request);
}

var loadChart7 = function () {
	var request = new Object();
	request.url ="/ylzhy/summary/maximumDemand/list";
	request.data = {"nowDay": "2018-09","upMonth":"2018-08"};
	get_by_ajax(7, myChart7, request);
}

var loadChart8 = function () {
    var request = new Object();
    var date = getFormatDate(new Date());
    request.url ="/ylzhy/summary/maxFuhe";
    request.data = {"date":date};
    get_by_ajax(8, myChart8, request);
}

var loadCharts = function () {
    loadChart1();
    loadChart3();
    loadChart4();
    loadChart5();
    loadChart6();
    loadChart7();
    loadChart8();
};

function getFirstDayOfWeek (date) {
    var day = date.getDay() || 7;
    return new Date(date.getFullYear(), date.getMonth(), date.getDate() + 1 - day);
};

var loadOption = function (index, mychart, data) {
    mychart.hideLoading();
    if(index == 1){
        mychart.setOption({
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: data.quarters
            },
            series: [{
                data: data.datas,
                type: 'line',
                itemStyle: {
                    normal: {
                        color: "#4db4fa",
                        lineStyle: {
                            color: "#4db4fa"
                        }
                    }
                }
            }]
        });
    }
    if(index == 3){
        mychart.setOption({
            series : [
                {
                    type: 'pie',
                    radius : '65%',
                    center: ['30%', '55%'],
                    itemStyle : {
                        normal : {
                            label : {
                                show: true,
                                position : 'inner',
                                textStyle : {
                                    color: '#333'
                                },
                                formatter : function (params) {
                                    return (params.percent - 0).toFixed(0) + '%'
                                }
                            },
                            labelLine : {
                                show : false   //隐藏标示线
                            },
                            borderColor: '#fdfffe',
                            borderWidth: 1
                        }
                    },
                    data:[
                        {value:data.datas.tip, name:'尖峰：'},
                        {value:data.datas.peak, name:'峰段：'},
                        {value:data.datas.flat, name:'平段：'},
                        {value:data.datas.ravine, name:'谷段：'}
                    ]
                }
            ]
        });
    }
    if(index == 4){
        mychart.setOption({
                xAxis: {
                    type: 'category',
                    data: data.week
                },
                series: [{
                    data: data.datas,
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
            }
        )
    }
    if(index == 5){
        mychart.setOption({
                xAxis : [
                    {
                        type : 'category',
                        data : data.month,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                series : [
                    {
                        name:'月电量',
                        type:'bar',
                        barWidth: '60%',
                        data:data.datas,
                    }
                ]
            }
        )
    }
    if(index == 6){
        var preMonth = getPreMonth();
        var month = getMonth();
        mychart.setOption({
            xAxis: [
                {
                    type : 'category',
                    data : [preMonth, month]
                }
            ],
            series: [
                {
                    name:'上月电费：',
                    type: 'bar',
                    barWidth: 36,
                    label: {
                        normal: {
                            show: true,
                            position: 'top'
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: function (params){
                                var colorList = ['rgb(137,195,248)','rgb(189,144,237)'];
                                return colorList[params.dataIndex];
                            }
                        }
                    },
                    data: [data.datas[0]]
                },
                {
                    name:'本月电费：',
                    type: 'bar',
                    barWidth: 36,
                    label: {
                        normal: {
                            show: true,
                            position: 'top'
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: 'rgb(189,144,237)'
                        }
                    },
                    data:["-",data.datas[1]]
                }
            ]
        });
    }
    if(index == 7){
	   mychart.setOption({
		   xAxis: [
		            {
		                type : 'category',
		                data : data.day,
		                //axisLabel:{'interval':0,rotate:45}, 
		            }
		        ],
		        series : [
		                  {
		                      name: '上月',
		                      type: 'line',
		                      data: data.upPowers,
		                      itemStyle:{
		                          normal:{
		                              color:'#89c3f8'
		                          }
		                      }
		                  },
		                  {
		                      name: '本月',
		                      type: 'line',
		                      data: data.datas,
		                      itemStyle:{
		                          normal:{
		                              color:'#bd90ed'
		                          }
		                      }
		                  }
		              ]
       })
    }
    if(index == 8){
        mychart.setOption({
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: data.hour
            },
            yAxis: {
                type: 'value',
                name: 'kw'
            },
            series: [{
                data: data.datas,
                type: 'line',
                itemStyle: {
                    normal: {
                        color: "#4db4fa",
                        lineStyle: {
                            color: "#4db4fa"
                        }
                    }
                }
            }]
        })
    }
};

var get_by_ajax = function(index, mychart, request){
    $.ajax({
        type: "POST",
        url: request.url,
        data: request.data,
        dataType: "json",
        async: false,
        success: function(result){
            if(result.code == 0){
                //返回成功
                loadOption(index, mychart, result.data);
            }else{
                return -1;
            }
        }
    })
};


loadCharts();