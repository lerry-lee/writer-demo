layui.use(['table', 'laydate'], function () {
    const laydate = layui.laydate;
    //加载时间选择框插件
    laydate.render({
        elem: '#date-time'
        , type: 'date'
        , range: true
    });
    const table = layui.table;
    //加载表格
    table.render({
        elem: '#demo',
        height: 312,
        url: host + '/reflective/query_all_by_username_with_limit?username=' + window.localStorage["username"],
        page: true,
        cols: [[
            {field: 'id', title: 'ID', align: 'center', width: 100, unresize: true, sort: true, fixed: 'left'},
            {field: 'title', title: '标题', align: 'center'},
            {field: 'sdate', title: '时间', align: 'center'},
            {field: 'right', title: '操作', align: 'center', toolbar: '#barDemo'}
        ]]
    });
    //表格中的操作，查看和删除
    table.on('tool(test)', function (obj) {
        const layEvent = obj.event;
        const data = obj.data;
        const tr = obj.tr;
        if (layEvent === 'del') {
            layer.confirm('确定删除该行吗？', {offset: '200px'}, function (index) {
                obj.del();
                layer.close(index);
                $.ajax({
                    type: 'post'
                    , url: host + '/reflective/delete'
                    , data: {
                        'id': data.id
                    }
                    , contentType: "application/x-www-form-urlencoded"
                    , xhrFields: {
                        withCredentials: true
                    }
                    , success: function (rst) {
                        if (rst.code === 1) {
                            layer.msg('删除成功', {offset: '200px'});
                        } else {
                            layer.msg('失败', {offset: '200px'});
                        }
                    }
                });
            });
        } else if (layEvent === 'detail') {
            layer.alert(data.content, {title: data.title, offset: '200px'})
        }
    });
    //表格中的模糊查询
    $('#title-search').click(function () {
        const title = $("#title-input").val();
        const date_time = $("#date-time").val();
        const start_date = date_time.substring(0, 10);
        const end_date = date_time.substring(12, 23);
        //判空
        if (title.trim() === "" || date_time.trim() === "") {
            layer.msg("查询条件不能为空！");
            return;
        }
        table.reload('demo', {
            url: host + '/reflective/fuzzy_query',
            where: {
                "username": window.localStorage["username"],
                "title": title,
                "start_date": start_date,
                "end_date": end_date,
            }
        });
    });

    //评分数据请求
    $.ajax({
        type: 'get'
        , url: host + '/reflective/query_all_by_username'
        , data: {
            "username": window.localStorage["username"]
        }
        , contentType: "application/x-www-form-urlencoded"
        , xhrFields: {
            withCredentials: true
        }
        , success: function (rst) {
            if (rst.code === 0) {
                const data = rst.data;
                // console.log(data);
                const data_source = [["id"], ["self"], ["comparison"], ["summary"], ["automatic"]];
                for (const i in data) {
                    data_source[0].push(data[i]["id"].toString());
                    data_source[1].push(data[i]["self"]);
                    data_source[2].push(data[i]["comparison"]);
                    data_source[3].push(data[i]["summary"]);
                    data_source[4].push(data[i]["automatic"]);
                }
                // console.log(data_source);
                const id_row1 = data_source[0][1];
                if (id_row1 === undefined) {
                    layer.msg('还没有数据哦，快去写作和评分吧', {offset: '200px'});
                    return;
                }
                //加载饼状图和折线图
                setTimeout(function () {

                    const option = {
                        legend: {},
                        tooltip: {
                            trigger: 'axis',
                            showContent: false
                        },
                        dataset: {
                            source: data_source
                        },
                        xAxis: {type: 'category'},
                        yAxis: {gridIndex: 0},
                        grid: {top: '55%'},
                        series: [
                            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
                            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
                            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
                            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
                            {
                                type: 'pie',
                                roseType: 'angle',
                                emphasis: {
                                    focus: 'self'
                                },
                                itemStyle: {
                                    // 阴影的大小
                                    shadowBlur: 60,
                                    // 阴影水平方向上的偏移
                                    shadowOffsetX: 0,
                                    // 阴影垂直方向上的偏移
                                    shadowOffsetY: 0,
                                    // 阴影颜色
                                    shadowColor: 'rgba(0, 0, 0, 0.3)'
                                },
                                id: 'pie',
                                radius: '40%',
                                center: ['50%', '25%'],
                                label: {
                                    formatter: '{b}: {@[' + data_source[0][0] + ']} ({d}%)'
                                },
                                encode: {
                                    itemName: data_source[0][0],
                                    value: data_source[0][1],
                                    tooltip: data_source[0][1]
                                }
                            }
                        ]
                    };
                    const myChart = echarts.init(document.getElementById("echarts"));
                    myChart.on('updateAxisPointer', function (event) {
                        const xAxisInfo = event.axesInfo[0];
                        if (xAxisInfo) {
                            const dimension = xAxisInfo.value + 1;
                            myChart.setOption({
                                series: {
                                    id: 'pie',
                                    label: {
                                        formatter: '{b}: {@[' + dimension + ']} ({d}%)'
                                    },
                                    encode: {
                                        value: dimension,
                                        tooltip: dimension
                                    }
                                }
                            });
                        }
                    });

                    myChart.setOption(option);

                });
            } else {
                layer.alert("get score failed," + rst.msg);
            }
        }
    });

});


