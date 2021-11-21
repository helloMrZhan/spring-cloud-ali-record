package com.zjq.authservice.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>用户登录</p>
 *
 * @author zjq
 * @date 2021/11/2
 */
@RestController
public class LoginController{

    @GetMapping("/login")
    public String login(@RequestParam(value = "username",required = false,defaultValue = "zjq") String username,
                        @RequestParam(value = "password",required = false,defaultValue = "helloWorld") String password) {

        return "登录成功，你好"+username;
    }


    @GetMapping("/logout")
    public String logout(@RequestParam(value = "username",required = false,defaultValue = "zjq") String username) {

        return "退出成功，再见"+username;
    }

}
