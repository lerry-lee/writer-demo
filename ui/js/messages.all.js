$(function () {
    //查询所有未读消息
    $.ajax({
        type: 'get'
        , url: host + '/messages/query_all_not_read'
        , data: {
            "username": window.localStorage["username"]
        }
        , contentType: "application/x-www-form-urlencoded"
        , xhrFields: {
            withCredentials: true
        }
        , success: function (rst) {
            if (rst.code === 1) {
                const json = rst.data;
                for (var i in json) {
                    $('#messages').append("<div class='layui-colla-item'>" +
                        "<h2 class='msg-colla-title' mid='" + json[i].id + "'><i class='zhankai'></i>" + json[i].message + "<span class='layui-badge-dot'></span></h2>" +
                        "<div class='msg-colla-content' mid='" + json[i].id + "'>" + json[i].comment + "</div></div>");
                }
            } else {
                layer.alert(rst.msg);
            }
        }
    });
    //为动态添加的h2元素添加点击事件，消除小红点标记为已读
    $('#messages').delegate("h2", 'click', function () {

        let mid = $(this).attr('mid');
        $("div.msg-colla-content[mid=" + mid + "]").toggle();

        // 去掉小红点,标记为已读
        mid = $(this).attr('mid');
        let flag = false;
        const data = {
            'id': mid
        };
        $.ajax({
            async: false
            , type: 'post'
            , url: host + '/messages/read'
            , contentType: "application/x-www-form-urlencoded"
            , xhrFields: {
                withCredentials: true
            }
            , data: data
            , success: function (rst) {
                if (rst.code === 1) {
                    flag = true;
                } else {
                    layer.alert(rst.msg);
                }
            }
        });
        if (flag) {
            $(this).children("span").css('display', 'none');
        }
    });
    //标记所有消息为已读
    $('#makeMessagesRead').click(function () {
        layer.confirm('确定所有消息标记为已读吗？', {
            offset: '200px',
            btn: ['确定', '我再想想'] //按钮
        }, function (index) {
            $.ajax({
                type: 'post'
                , url: host+'/messages/read_all'
                , data: {
                    "username": window.localStorage["username"]
                }
                , contentType: "application/x-www-form-urlencoded"
                , xhrFields: {
                    withCredentials: true
                }
                , success: function (rst) {
                    if (rst.code === 1) {
                        $('span').css('visibility', 'hidden');
                    } else {
                        layer.alert(rst.msg);
                    }
                }
            });
            layer.close(index);
        });
    });

});

