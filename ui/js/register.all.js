layui.use('layer', function () {
    const layer = layui.layer;
    let ulegal, plegal;

    //用户名合法检测
    $('#username').focus(function () {
        $('#error-umsg').empty();
    });
    $('#username').blur(function () {
        ulegal = true;
        var username = $('#username').val();
        var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;

        if (username === '') {
            ulegal = false;
            $('#error-umsg').html('用户名不能为空');
        } else if (!uPattern.test(username)) {
            ulegal = false;
            $('#error-umsg').html('用户名只能是4到16位且不包含特殊字符');
        }
        if (ulegal) {
            $.ajax({
                type: 'get'
                , url: 'register'
                , data: {'username': username}
                , success: function (rst) {
                    if (rst == 0)
                        $('#uValidation').css('opacity', '1');
                    else
                        $('#error-umsg').html('用户名已存在');
                }
            });
        }
    });
    //密码合法检测
    $('#password').focus(function () {
        $('#error-pmsg').empty();
    });
    $('#password').blur(function () {
        plegal = true;
        var password = $('#password').val();
        var pPattern = /^[a-zA-Z0-9!@#$%^&*?_-]{4,16}$/;

        if (password === '') {
            plegal = false;
            $('#error-pmsg').html('密码不能为空');
        } else if (!pPattern.test(password)) {
            plegal = false;
            $('#error-pmsg').html('密码不能少于4位');
        }
        if (plegal)
            $('#pValidation').css('opacity', '1');
    });
    //密码确认合法检测
    $('#password_verify').focus(function () {
        $('#error-pvmsg').empty();
    });
    $('#password_verify').blur(function () {
        var password_verify = $('#password_verify').val();
        var password = $('#password').val();
        if (password_verify !== password) {
            $('#error-pvmsg').html('两次密码不相同');
            plegal = false;
        }
        if (plegal)
            $('#pvValidation').css('opacity', '1');
    });

    //注册请求
    $('#register').click(function () {
        if (ulegal && plegal) {
            const username = $('#username').val();
            const password = $('#password').val();
            $.ajax({
                type: 'POST'
                , contentType: "application/x-www-form-urlencoded"
                , url: host + '/user/register'
                , data: {
                    'username': username,
                    'password': password
                }
                , xhrFields: {
                    withCredentials: true
                }
                , success: function (rst) {
                    if (rst.code === 1) {
                        layer.msg('注册成功！即将跳转登录页面');
                        setTimeout(function () {
                            window.location.href = 'login.html';
                        }, 2000);
                    } else {
                        layer.msg('注册失败！原因为' + rst.msg);
                    }
                }
            })
            ;
        }
    });

});
