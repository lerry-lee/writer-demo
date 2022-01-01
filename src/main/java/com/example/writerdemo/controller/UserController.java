package com.example.writerdemo.controller;

import com.example.writerdemo.entity.User;
import com.example.writerdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //处理跨域请求
public class UserController {

    private final static String ContentType = "application/x-www-form-urlencoded";

    @Autowired
    private UserService userService;

    /**
     * 检查用户名是否已存在,不存在返回0、存在返回1
     */
    @GetMapping(value = "/register")
    public int checkUsername(@RequestParam("username") String username) {
        //若用户名已存在
        if (userService.queryByUsername(username)) {
            return 1;
        }
        return 0;
    }

    /**
     * 注册
     */
    @PutMapping(value = "/register")
    public int register(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        //若添加新用户成功
        if (userService.addUser(user)) {
            return 1;
        }
        return 0;
    }

    /**
     * todo: 获得登录状态
     */
    @GetMapping(value = "/login")
    public String getUsername() {
//        String username = (String) SecurityUtils.getSubject().getPrincipal();
//        return username;
        return "";
    }

    /**
     * 登录
     */
    @PostMapping(value = "/login", consumes = ContentType)
    public int login(@RequestParam("username") String username,
                     @RequestParam("password") String password) {
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//
//        try {
//            subject.login(token);
//            logger.info(username + "已登录 ");
//            Session session = subject.getSession();
//            session.setAttribute("subject", subject);
//            return 1;
//        } catch (AuthenticationException e) {
//            return 0;
//        }
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        //若当前用户名和密码正确
        if (userService.queryByUser(user)) {
            return 1;
        }
        return 0;
    }

    /**
     * 退出登录
     */
    @GetMapping(value = "/logout")
    public void logout() {
//        SecurityUtils.getSubject().logout();
    }

}
