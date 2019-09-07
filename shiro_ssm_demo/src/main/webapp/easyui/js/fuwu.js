function loadData(colors,heads,datas){
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);

    var app = {};

    app.title = '环形图';

    var option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        // color:['#93D8A9','#FFB99D','#AF7DCC'],
        color:colors,
        legend: {
            orient: 'horizontal',
            x: 'left',
            // data: ['E家人', '聪海信息科技有限公司', '百事可乐公司']
            data:heads
        },
        series: [{
            name: '访问来源',
            type: 'pie',
            radius: ['30%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data: datas
        }]
    };
    myChart.setOption(option, true);
    /*if(option && typeof option === "object") {

    }*/
}