package com.myringle.blog.controller;


import com.myringle.blog.annotation.MyLog;
import com.myringle.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Api(value = "用户中心",tags = "用户中心")
public class UserController {

    @Autowired
    private UserService userService;


    //用户登录
    @PostMapping("login")
    @ApiOperation(value = "登录",notes = "根据用户名登录")
    @ApiImplicitParam(value = "用户名和密码", paramType = "query" )
    @MyLog(value = "登录记录")  //这里添加了AOP的自定义注解
    public  Boolean  login(@RequestParam("username") String username, @RequestParam("password") String password){
         return this.userService.login(username,password);
    }

    //注册中心
    @ApiOperation(value = "注册",notes = "根据用户名注册")
    @ApiImplicitParam(value = "用户名和密码", paramType = "query" )
    @PostMapping("regirstry")
    @MyLog(value = "注册记录")  //这里添加了AOP的自定义注解
    public  Boolean  regirstry(@RequestParam("username") String username, @RequestParam("password") String password){
           return userService.regirstry(username,password);
    }



}
