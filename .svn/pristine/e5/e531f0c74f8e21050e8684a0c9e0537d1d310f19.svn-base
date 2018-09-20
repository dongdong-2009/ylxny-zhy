var setOption = function (chart, result) {
    chart.setOption({
        yAxis : [
            {
                type : 'category',
                name: '',
                data : result.names,
            }
        ],
        series : [
            {
                data:result.datas,
            }
        ],
    });
}

var getByAjax = function (chart, request) {
    $.ajax({
        type: "POST",
        url: request.url,
        data: request.data,
        dataType: "json",
        async: false,
        success: function(result){
            if(result.code == 0){
                //返回成功
                setOption(chart, result.data);
            }else{
                return -1;
            }
        }
    })
}

var load = function () {
    var request = new Object();
    request.url = "/ylzhy/summary/powerRank/list";
    request.data = {"type":1,"companyId":1,"startDate":getFormatDateOffset(new Date(), -4),"endDate": getFormatDate(new Date())};
    getByAjax(topBar, request);
}

load();
