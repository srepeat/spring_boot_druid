$(function () {
    $.ajax({
        "url" : js_ctx + "/contrRpt/listmap.json",
        "type" : "get",
        "dataType" : "json",
        "success":function(data){
            var colors = new Array();
            var heads = new Array();
            var datas = new Array();

            // oddPrice: 10000
            // odrCustomer: "E家人"
            // odrId: 2

            $.each(data.orders,function (idx,obj) {
                var red = parseInt(Math.random()*257).toString(16);
                var blue = parseInt(Math.random()*257).toString(16);
                var green= parseInt(Math.random()*257).toString(16);

                var col = '#'+red+blue+green;
                colors.push(col);
                heads.push(obj.odrCustomer)

                var object = {
                    value: obj.odrTotalPrice,
                    name: obj.odrCustomer
                }
                datas.push(object)
            })
            loadData(colors,heads,datas);
        }
    })
})
