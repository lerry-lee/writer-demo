package com.example.writerdemo.controller;

import com.example.writerdemo.entity.User;
import com.example.writerdemo.response.WriterResponseType;
import com.example.writerdemo.service.UserService;
import com.example.writerdemo.service.model.UserModel;
import com.example.writerdemo.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //处理跨域请求
@Slf4j
public class UserController {

    private final static String ContentType = "application/x-www-form-urlencoded";

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 检查用户名是否已存在
     */
    @GetMapping(value = "/check_username")
    public WriterResponseType checkUsername(@RequestParam("username") String username) {
        Boolean result = userService.queryByUsername(username);
        //若查询失败，则返回异常
        if (result == null) {
            log.info(String.format("查询用户名%s时发生异常", username));
            return WriterResponseType.success("查询异常，请检查后台", null);
        }
        //若用户名已存在
        else if (result) {
            log.info(String.format("用户名%s已存在，不可以使用", username));
            return WriterResponseType.success(String.format("用户名%s已存在，不可以使用", username), null);
        }
        log.info(String.format("用户名%s不存在，可以使用", username));
        return WriterResponseType.failed(String.format("用户名%s不存在，可以使用", username), null);
    }

    /**
     * 注册
     */
    @PostMapping(value = "/register", consumes = ContentType)
    public WriterResponseType register(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        //若添加新用户成功
        if (userService.addUser(user)) {
            log.info(String.format("用户%s注册成功", username));
            return WriterResponseType.success(String.format("用户%s注册成功", username), null);
        }
        log.info(String.format("用户%s注册失败", username));
        return WriterResponseType.failed(String.format("用户%s注册失败", username), null);
    }

    /**
     * 验证用户登陆状态
     */
    @GetMapping(value = "validate_login")
    public WriterResponseType validateLogin(@RequestParam("user_token") String userToken) {
        //获取redis中用户模型
        UserModel userModel = (UserModel) redisUtil.get(userToken);
        if (userModel == null) {
            return WriterResponseType.failed("用户登陆已经过期", null);
        }
        return WriterResponseType.success();
    }

    /**
     * 登录
     */
    @PostMapping(value = "/login", consumes = ContentType)
    public WriterResponseType login(@RequestParam("username") String username,
                                    @RequestParam("password") String password) {
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        //若当前用户名和密码正确
        if (userService.queryByUser(user)) {
            String userToken = UUID.randomUUID().toString().replace("-", "");
            UserModel userModel = convertEntityToModel(user);
            //建立token和用户登录状态之间的联系
            redisUtil.set(userToken, userModel);
            redisUtil.expire(userToken, 30, TimeUnit.MINUTES);//设置超时时间
            log.info(String.format("用户%s登陆成功，为其创建token为%s", username, userToken));
            //返回token给前端
            return WriterResponseType.success("登陆成功", userToken);
        }
        log.info(String.format("用户名%s或密码不正确，登陆失败", username));
        return WriterResponseType.failed("用户名或密码不正确", null);
    }

    /**
     * 退出登录
     */
    @GetMapping(value = "/logout")
    public WriterResponseType logout(@RequestParam("user_token") String userToken) {
        //验证用户
        UserModel userModel = (UserModel) redisUtil.get(userToken);
        if (userModel == null) {
            log.info(String.format("token为%s的用户不存在", userToken));
            return WriterResponseType.failed("用户未登录，无需退出", null);
        }
        redisUtil.delete(userToken);
        log.info(String.format("用户%s已成功登出", userModel.getUsername()));
        return WriterResponseType.success("当前用户已登出", null);
    }

    public UserModel convertEntityToModel(User user) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        return userModel;
    }

}
