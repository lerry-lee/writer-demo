//获得访问量
$(function () {
    $.ajax({
        type: 'get'
        , contentType: "application/x-www-form-urlencoded"
        , url: host + '/visits/count'
        , xhrFields: {
            withCredentials: true
        }
        , success: function (rst) {
            $('#visits').append(rst.data);
        }
    });
});