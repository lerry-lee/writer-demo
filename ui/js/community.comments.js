layui.use(['layer', 'form'], function () {
    const form = layui.form;
    const layer = layui.layer;
    const sid = $.getUrlParam('sid');
    const title = $.getUrlParam('title');
    const author = $.getUrlParam('author');

    //查询所有评论
    $.ajax({
        type: 'get'
        , url: host + '/comments/query_all'
        , data: {
            'sid': sid
        }
        , contentType: "application/x-www-form-urlencoded"
        , xhrFields: {
            withCredentials: true
        }
        , success: function (rst) {
            if (rst.code === 1) {
                const json = rst.data;
                if (json.length === 0) {
                    return;
                }
                for (var i in json) {
                    $('#commments-list').append("<article><p style='color: grey'>" +
                        json[i].cdate + "\xa0\xa0       " + json[i].commentator +
                        "</p><p>" +
                        json[i].comment +
                        "</p></article><hr class=\"layui-bg-gray\">");
                }
            } else {
                layer.alert(rst.msg);
            }
        }
    })
    ;
    //匿名选择
    let niming = 0;
    form.on('switch(niming)', function (data) {
        niming = (data.elem.checked == true ? 1 : 0); //开关是否开启，true或者false
    });
    //提交评论
    $('#save-comment').click(function () {
        const comment = $('#comment').val();

        if ($.trim(comment) === '') {
            layer.msg('评论内容不能为空');
            return;
        }
        const data = {
            'commentator': window.localStorage["username"],
            'sid': sid,
            'comment': comment,
            'niming': niming
        };
        $.ajax({
            type: 'post'
            , url: host + '/comments/save'
            , data: data
            , contentType: "application/x-www-form-urlencoded"
            , xhrFields: {
                withCredentials: true
            }
            , success: function (rst) {
                if (rst.code === 1) {
                    //向作者发送一条消息
                    const name = niming === 1 ? '匿名用户' : window.localStorage["username"];
                    $.ajax({
                        type: 'post'
                        , url: host + '/messages/save'
                        , contentType: "application/x-www-form-urlencoded"
                        , xhrFields: {
                            withCredentials: true
                        }
                        , data: {
                            'username': name,
                            'sid': sid,
                            'title': title,
                            'author': author,
                            'comment': comment
                        }
                        , success: function (rst) {
                            if (rst.code === 1) {
                                layer.msg('评论成功,并发送一条消息提醒了作者');
                            } else {
                                layer.alert('评论成功，但发送消息提醒失败，原因为：' + rst.msg);
                            }
                        }
                    });
                } else {
                    layer.alert(rst.msg);
                }
            }
        });
    });
});
//封装一个方法用于获取url中参数
(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
})(jQuery);