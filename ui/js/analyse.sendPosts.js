layui.use(['layer', 'form'], function () {
    const layer = layui.layer;
    const form = layui.form;
    //点击右下角发帖
    $('#to-share').click(function () {
        const content = $('#content').val();
        const share_title = $('#share-title').val();
        const category = $('#category option:selected').val();
        if (content === '' || share_title === '') {
            layer.msg('内容或标题不能为空');
            return;
        }
        const data = {
            'author': window.localStorage["username"],
            'content': content,
            'title': share_title,
            'category': category
        };
        $.ajax({
            type: 'post'
            , url: host + '/posts/save'
            , contentType: "application/x-www-form-urlencoded"
            , xhrFields: {
                withCredentials: true
            }
            , data: data
            , success: function (rst) {
                if (rst.code === 1) {
                    layer.msg('分享成功');
                } else {
                    layer.msg(res.msg);
                }
            }
        });
    });

});
