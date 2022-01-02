layui.use(['form'], function () {

    const form = layui.form;
    let flag = false;

    //邮箱正则表达式验证
    $('#email').focus(function () {
        $('#email-msg').empty();
    });
    $('#email').blur(function () {
        flag = true;
        const reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        const email = $(this).val();
        if (!reg.test(email)) {
            $('#email-msg').html("邮箱格式有误");
            flag = false;
        }
    });
    //建议提交请求
    $('#contact').click(function () {
        const name = $('#name').val();
        const email = $('#email').val();
        const comments = $('#comments').val();
        if (name === '' || email === '' || comments === '') {
            layer.msg('Name或Email或Comments不能为空！', {offset: '200px'});
            return;
        }
        // console.log(flag);
        if (!flag) {
            layer.msg('请确认邮箱正误', {offset: '200px'});
            return;
        }
        const data = {
            'username': window.localStorage["username"],
            'name': name,
            'email': email,
            'comments': comments
        };
        $.ajax({
            type: 'post'
            , url: host + '/contact/save'
            , data: data
            , contentType: "application/x-www-form-urlencoded"
            , xhrFields: {
                withCredentials: true
            }
            , success: function (rst) {
                if (rst.code === 1) {
                    layer.msg('发送成功！感谢您的宝贵建议！', {offset: '200px'});
                } else {
                    layer.alert(rst.msg);
                }
            }
        });
    });
});