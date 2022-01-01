//按回车快速登陆
$(document).keypress(function (e) {
    if (e.which === 13) {
        $('#login').click();
    }
});

//加载弹出层组件
layui.use('layer', function () {
    const layer = layui.layer;
    //登录请求
    $("#login").click(function () {
        let username = $(" input[ name='username' ] ").val();
        let password = $(" input[ name='password' ] ").val();
        if (username === "" || password === "") {
            layer.msg("用户名或密码不能为空！");
            return;
        }
        $.ajax({
            type: 'POST'
            , url: host + '/user/login'
            , contentType: "application/x-www-form-urlencoded"
            , data: {
                'username': username,
                'password': password
            }
            , xhrFields: {
                withCredentials: true
            }
            , success: function (result) {
                //登录成功或访问量+1
                if (result.code === 1) {
                    layer.msg("登陆成功");
                    window.localStorage["token"] = result.data;
                    window.localStorage["username"] = username;
                    $.ajax({
                        type: 'GET'
                        , url: host + '/visits/add'
                        , data: {
                            'username': username,
                        }
                        , success:
                            function () {
                                window.location.href = 'home.html';
                            }
                    });
                } else {
                    layer.msg('登陆失败，原因为' + result.msg);
                }
            }
            , error: function (data) {
                alert("请求失败，原因为" + data.responseText);
            }
        });
    });

});
