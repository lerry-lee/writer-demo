layui.use(['layer', 'util', 'laypage', 'element'], function () {
    const layer = layui.layer;
    const util = layui.util;
    const laypage = layui.laypage;
    const element = layui.element;
    //固定快
    util.fixbar({
        bar1: '&#xe611;'
        , css: {right: 30, bottom: 50}
        , bgcolor: '#393D49;width:36px;height:36px;font-size:32px;line-height:36px'
        , click: function (type) {
            if (type === 'bar1') {
                layer.open({
                    type: 2,
                    offset: '200px',
                    title: '发布帖子到社区',
                    area: ['600px', '550px'],
                    content: 'editPosts.html'
                });
            }
        }
    });
    //获得未读消息数量
    $.ajax({
        type: 'get'
        , url: host + '/messages/count_not_read'
        , data: {
            "username":window.localStorage["username"]
        }
        , contentType: "application/x-www-form-urlencoded"
        , xhrFields: {
            withCredentials: true
        }
        , success: function (rst) {
            if (rst.code === 1) {
                $('#totalMessages').html(rst.data);
            } else {
                layer.alert(rst.msg);
            }
        }
    });
    //查询所有帖子
    $('#allPosts').click(function () {
        // $('#search_posts').attr('author', 'All');
        // $('#search_posts').attr('category', 'All');
        const data = [];
        $.ajax({
                async: false,
                type: 'get',
                url: host + '/posts/query_all',
                contentType: "application/x-www-form-urlencoded",
                xhrFields: {
                    withCredentials: true
                },
                success: function (rst) {
                    if (rst.code === 1) {
                        const json = rst.data;
                        for (var i in json) {
                            data.push("<article class='format-standard type-post hentry clearfix'>" +
                                "<header class='clearfix'><h3 class='post-title'>" +
                                json[i].title + "</h3>" +
                                "<hr class='layui-bg-gray'><div class='post-meta clearfix'>" +
                                "<span class='date'>" +
                                json[i].sdate + "</span><span class='category'>" +
                                json[i].category + "</span>" +
                                "<span class='comments'><a name='to-comments' title='" + json[i].title + "' author='" + json[i].author +
                                "' sid='" + json[i].id + "'>" + json[i].totalComments +
                                " Comments</a></span>" + "<span class='by-author'>" +
                                json[i].author + "</span></div>" +
                                "<hr class='layui-bg-gray'></header>" +
                                "<p>" + json[i].content + "</p></article>");
                        }
                    } else {
                        layer.alert(rst.msg);
                    }
                }
            }
        );
        //分页模块
        laypage.render({
            elem: 'posts_demo'
            , count: data.length
            , layout: ['prev', 'page', 'next', 'count', 'limit', 'skip']
            , jump: function (obj) {
                //模拟渲染
                document.getElementById('posts_list').innerHTML = function () {
                    var arr = []
                        , thisData = data.concat().splice(obj.curr * obj.limit - obj.limit, obj.limit);
                    layui.each(thisData, function (index, item) {
                        arr.push(item);
                    });
                    // console.log( thisData+''+arr);
                    return arr.join('');
                }();
            }
        });
    });
    //查询我的帖子
    $('#myPosts').click(function () {
        // $('#search_posts').attr('author', 'My');
        // $('#search_posts').attr('category', 'All');
        const data = [];
        $.ajax({
                async: false,
                type: 'get',
                url: host + '/posts/query_all_by_author',
                contentType: "application/x-www-form-urlencoded",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    "author": window.localStorage["username"]
                },
                success: function (rst) {
                    if (rst.code === 1) {
                        const json = rst.data;
                        for (var i in json) {
                            data.push("<article class='format-standard type-post hentry clearfix'>" +
                                "<header class='clearfix'><h3 class='post-title'>" +
                                json[i].title + "</h3>" +
                                "<hr class='layui-bg-gray'><div class='post-meta clearfix'>" +
                                "<span class='date'>" +
                                json[i].sdate + "</span><span class='category'>" +
                                json[i].category + "</span>" +
                                "<span class='comments'><a name='to-comments' title='" + json[i].title + "' author='" + json[i].author +
                                "' sid='" + json[i].id + "'>" + json[i].totalComments +
                                " Comments</a></span>" + "<span class='by-author'>" +
                                json[i].author + "</span></div>" +
                                "<hr class='layui-bg-gray'></header>" +
                                "<p>" + json[i].content + "</p></article>");
                        }
                    } else {
                        layer.alert(rst.msg);
                    }
                }
            }
        );
        //分页模块
        laypage.render({
            elem: 'posts_demo'
            , count: data.length
            , layout: ['prev', 'page', 'next', 'count', 'limit', 'skip']
            , jump: function (obj) {
                //模拟渲染
                document.getElementById('posts_list').innerHTML = function () {
                    var arr = []
                        , thisData = data.concat().splice(obj.curr * obj.limit - obj.limit, obj.limit);
                    layui.each(thisData, function (index, item) {
                        arr.push(item);
                    });
                    // console.log( thisData+''+arr);
                    return arr.join('');
                }();
            }
        });
    });
    //模糊查询帖子
    $('#search_posts').click(function () {
        const author = $(this).attr('author');
        const key_words = $('#key_words').val();
        const category = $(this).attr('category');
        const data = [];
        $.ajax({
                async: false,
                type: 'get',
                url: host + '/posts/fuzzy_query',
                data: {
                    'key_words': key_words,
                    'category': category,
                    'author': author
                },
                contentType: "application/x-www-form-urlencoded",
                xhrFields: {
                    withCredentials: true
                },
                success: function (rst) {
                    if (rst.code === 1) {
                        const json = rst.data;
                        for (var i in json) {
                            data.push("<article class='format-standard type-post hentry clearfix'>" +
                                "<header class='clearfix'><h3 class='post-title'>" +
                                json[i].title + "</h3>" +
                                "<hr class='layui-bg-gray'><div class='post-meta clearfix'>" +
                                "<span class='date'>" +
                                json[i].sdate + "</span><span class='category'>" +
                                json[i].category + "</span>" +
                                "<span class='comments'><a name='to-comments' title='" + json[i].title + "' author='" + json[i].author +
                                "' sid='" + json[i].id + "'>" + json[i].totalComments +
                                " Comments</a></span>" + "<span class='by-author'>" +
                                json[i].author + "</span></div>" +
                                "<hr class='layui-bg-gray'></header>" +
                                "<p>" + json[i].content + "</p></article>");
                        }
                    } else {
                        layer.alert(rst.msg);
                    }
                }
            }
        );
        //分页模块
        laypage.render({
            elem: 'posts_demo'
            , count: data.length
            , layout: ['prev', 'page', 'next', 'count', 'limit', 'skip']
            , jump: function (obj) {
                //模拟渲染
                document.getElementById('posts_list').innerHTML = function () {
                    var arr = []
                        , thisData = data.concat().splice(obj.curr * obj.limit - obj.limit, obj.limit);
                    layui.each(thisData, function (index, item) {
                        arr.push(item);
                    });
                    return arr.join('');
                }();
            }
        });

    });
    //按类型快速查找
    $("a[name='choose_category']").click(function () {
        $("a[name='choose_category']").css('color', "whitesmoke");
        $(this).css('color', '#5fb878');
        const author = $(this).attr('author');
        const key_words = $('#key_words').val();
        const category = $(this).attr('category');
        $('#search_posts').attr('category', category);
        const data = [];
        $.ajax({
                async: false,
                type: 'get',
                url: host + '/posts/fuzzy_query',
                data: {
                    'category': category,
                    'author': author,
                    'key_words': key_words
                },
                contentType: "application/x-www-form-urlencoded",
                xhrFields: {
                    withCredentials: true
                },
                success: function (rst) {
                    if (rst.code === 1) {
                        const json = rst.data;

                        for (var i in json) {
                            data.push("<article class='format-standard type-post hentry clearfix'>" +
                                "<header class='clearfix'><h3 class='post-title'>" +
                                json[i].title + "</h3>" +
                                "<hr class='layui-bg-gray'><div class='post-meta clearfix'>" +
                                "<span class='date'>" +
                                json[i].sdate + "</span><span class='category'>" +
                                json[i].category + "</span>" +
                                "<span class='comments'><a name='to-comments' title='" + json[i].title + "' author='" + json[i].author +
                                "' sid='" + json[i].id + "'>" + json[i].totalComments +
                                " Comments</a></span>" + "<span class='by-author'>" +
                                json[i].author + "</span></div>" +
                                "<hr class='layui-bg-gray'></header>" +
                                "<p>" + json[i].content + "</p></article>");
                        }
                    } else {
                        layer.alert(rst.msg);
                    }
                }
            }
        );
        //分页模块
        laypage.render({
            elem: 'posts_demo'
            , count: data.length
            , layout: ['prev', 'page', 'next', 'count', 'limit', 'skip']
            , jump: function (obj) {
                //模拟渲染
                document.getElementById('posts_list').innerHTML = function () {
                    var arr = []
                        , thisData = data.concat().splice(obj.curr * obj.limit - obj.limit, obj.limit);
                    layui.each(thisData, function (index, item) {
                        arr.push(item);
                    });
                    // console.log( thisData+''+arr);
                    return arr.join('');
                }();
            }
        });
    });
    //为动态添加的a[name='to-comments']元素添加click事件
    $('#main-listing').delegate("a[name='to-comments']", "click", function () {
        var sid = $(this).attr("sid");
        var title = $(this).attr("title");
        var etitle = encodeURI(encodeURI(title));
        var author = $(this).attr("author");
        layer.open({
            type: 2,
            offset: '200px',
            shade: 0.5,
            title: '这篇文章的评论都在下面了哦',
            area: ['600px', '600px'],
            content: 'editComments.html?sid=' + sid + '&title=' + etitle + '&author=' + author
        });
    });
    //系统消息的click事件
    $('#systemMessages').click(function () {
        layer.open({
            type: 1
            ,
            title: false //不显示标题栏
            ,
            closeBtn: false
            ,
            area: '300px;'
            ,
            offset: '200px'
            ,
            shade: 0.8
            ,
            id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,
            resize: false
            ,
            btn: ['火速围观', '残忍拒绝']
            ,
            btnAlign: 'c'
            ,
            moveType: 1 //拖拽模式，0或者1
            ,
            content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">该项目在Gitee上维护<br>如需查看源码请前往</div>'
            ,
            success: function (layero) {
                var btn = layero.find('.layui-layer-btn');
                btn.find('.layui-layer-btn0').attr({
                    href: 'https://gitee.com/lerry-lee/writer-demo'
                    , target: '_blank'
                });
            }
        });
    });
    //绑定readmore事件
    $('#main-listing').on("click", 'p', function () {
        $('p').readmore(
            {
                maxHeight: 44
            }
        );
    });
    //默认展示所有帖子
    $(function () {
        $('#allPosts').trigger('click');
    });

});
