$(function () {
    var tioxtu;
    $.ajax({
        "url" : js_ctx + "/consRpt/listmap.json",
        "type" : "get",

        "dataType" : "json",
        "success":function(data){
            $.each(data.basDicts.content,function (idx,obj) {
                tioxtu =" <div style=\"\">\n" +
                    "                  <span class=\"bar\">\n" +
                    "                     <span class=\"bar-percent\" style=\"height:"+obj.dictIsEditable+"0%\"><span class=\"num-percent\">"+obj.dictIsEditable+"</span></span>\n" +
                    "                  </span>\n" +
                    "                                                        <span class=\"\">"+obj.dictItem+"</span>\n" +
                    "                                                    </div>";
                $(".bar-div").append(tioxtu);
            })
        }
    })
})