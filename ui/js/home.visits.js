//获得访问量
$(function () {
    $.ajax({
        type: 'get'
        , url: host + '/visits/count'
        , contentType: "application/x-www-form-urlencoded"
        , xhrFields: {
            withCredentials: true
        }
        , success: function (rst) {
            $('#visits').append(rst.data);
        }
    });
});