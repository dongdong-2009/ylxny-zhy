//动态图表
var data1 = new Object();
data1.a = [];
data1.b = [];
data1.c = [];
var data2 = new Object();
data2.a = [];
data2.b = [];
data2.c = [];
var data3 = new Object();
data3.a = [];
data3.b = [];
data3.c = [];
var data4 = new Object();
data4.a = [];
data4.b = [];
data4.c = [];

var chart1 = datagram;
var chart2 = voltage;
var chart3 = power;
var chart4 = burden;

//通过ajax请求
var getByAjax = function(index, chart, request){
    $.ajax({
        type: "POST",
        url: request.url,
        data: request.data,
        dataType: "json",
        async: false,
        success: function(result){
            if(result.code == 0){
                pushData(index, chart, result.data);
            }else{
                return -1;
            }
        }
    })
};

var clearData = function (index) {
    if(index == 1){
        data1.a = [];
        data1.b = [];
        data1.c = [];
    }else if(index == 2){
        data2.a = [];
        data2.b = [];
        data2.c = [];
    }else if(index == 3){
        data3.a = [];
        data3.b = [];
        data3.c = [];
    }else if(index == 4){
        data4.a = [];
        data4.b = [];
        data4.c = [];
    }
}

var load = function (index,chart,request) {
    clearData(index);
    getByAjax(index,chart,request);
}

var refresh = function (index,chart, request) {
    getByAjax(index,chart, request);
}

var setOption = function (index, chart) {
    if(index == 1){

    } else if(index == 2){

    } else if(index == 3){

    } else if(index == 4){
        chart.setOption({
            series: [
                {
                    name: 'A负荷',
                    type: 'line',
                    data: data4.a
                },
                {
                    name: 'B负荷',
                    type: 'line',
                    data: data4.b
                },
                {
                    name: 'C负荷',
                    type: 'line',
                    data: data4.c
                }
            ]
        });
    }
}

var getAByIndex = function (index) {
    if(index == 1){
        return data1.a;
    }else if(index == 2){
        return data2.a;
    }else if(index == 3){
        return data3.a;
    }else if(index == 4){
        return data4.a;
    }
}

var getBByIndex = function (index) {
    if(index == 1){
        return data1.b;
    }else if(index == 2){
        return data2.b;
    }else if(index == 3){
        return data3.b;
    }else if(index == 4){
        return data4.b;
    }
}

var getCByIndex = function (index) {
    if(index == 1){
        return data1.c;
    }else if(index == 2){
        return data2.c;
    }else if(index == 3){
        return data3.c;
    }else if(index == 4){
        return data4.c;
    }
}

var pushData = function (index, chart, data) {
    var datas = data.datas;
    var a = datas.a;
    var b = datas.b;
    var c = datas.c;
    var aArr = getAByIndex(index);
    var bArr = getBByIndex(index);
    var cArr = getCByIndex(index);
    for(var i = 0 ; i < a.length; i++){
        if(typeof(a[i]) != undefined && aArr.indexOf(a[i]) != -1){
            continue;
        }
        aArr.push(a[i]);
    }
    for(var i = 0 ; i < b.length; i++){
        if(typeof(b[i]) != undefined && bArr.indexOf(b[i]) != -1){
            continue;
        }
        bArr.push(b[i]);
    }
    for(var i = 0 ; i < c.length; i++){
        if(typeof(c[i]) != undefined && cArr.indexOf(c[i]) != -1){
            continue;
        }
        cArr.push(c[i]);
    }
    setOption(index, chart);
}

var request = new Object();
request.url = "/ylzhy/realtime/fuhe/list";
request.data = {date:getFormatDate(new Date())};
load(4,chart4,request);

var refresh_req = new Object();
refresh_req.url = "/ylzhy/realtime/fuhe/refresh";
refresh_req.data = {date:getMiniteFormatDate(new Date())};
//var minite = 1000*60;
//setInterval(getByAjax(4,chart4,request), minite);