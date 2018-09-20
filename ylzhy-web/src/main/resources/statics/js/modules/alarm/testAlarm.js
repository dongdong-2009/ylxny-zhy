var getByAjax = function (request) {
    $.ajax({
        type: "POST",
        url: request.url,
        data: request.data,
        dataType: "json",
        async: false,
        success: function(result){
            if(result.code == 0){
                //返回成功

            }else{
                return -1;
            }
        }
    })
}

var request = new Object();
request.url = "/ylzhy/alarm/waterCrossCompare";
request.data = {"type":1,"lineId":1,"startDate":getFormatDateOffset(new Date(), -1),"endDate": getFormatDate(new Date())};
getByAjax(request);
