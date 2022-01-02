layui.use(['rate', 'layer'], function () {
    const layer = layui.layer;
    const rate = layui.rate;
    var self, comparison, summary, automatic;
    //加载评分图标
    rate.render({
        elem: '#test0'
        , length: 10
        , value: 0
        , half: false
        , theme: '#FF8000' //自定义主题色
        , text: true
        , choose: function (value) {
            self = value;
        }
    });
    rate.render({
        elem: '#test1'
        , length: 10
        , value: 0
        , half: false
        , theme: '#009688'
        , text: true
        , choose: function (value) {
            comparison = value;
        }
    });

    rate.render({
        elem: '#test2'
        , length: 10
        , value: 0
        , half: false
        , theme: '#1E9FFF'
        , text: true
        , choose: function (value) {
            summary = value;
        }
    })
    rate.render({
        elem: '#test3'
        , length: 10
        , value: 0
        , half: false
        , theme: '#2F4056'
        , text: true
        , choose: function (value) {
            automatic = value;
        }
    });

    //评分提交
    $('#score-submit').click(function () {
        const content = parent.$('#temporary-storage').html();

        const title = $('#title').val();
        if ($.trim(title) === '') {
            layer.msg('请填写标题后再提交哦')
        } else if (self === undefined || comparison === undefined || summary === undefined || automatic === undefined) {
            layer.msg('请全部评分后再提交哦');
        } else {
            const data = {
                'username': window.localStorage["username"],
                'title': title,
                'content': content,
                'self': self,
                'comparison': comparison,
                'summary': summary,
                'automatic': automatic
            };
            $.ajax({
                type: 'post'
                , url: host + '/reflective/save'
                , contentType: "application/x-www-form-urlencoded"
                , xhrFields: {
                    withCredentials: true
                }
                , data: data
                , success: function (rst) {
                    if (rst.code === 1) {
                        layer.msg('保存成功');
                    } else {
                        layer.msg('保存失败，' + rst.msg);
                    }
                }
            });
        }
    });

});