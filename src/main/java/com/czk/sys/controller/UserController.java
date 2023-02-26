package com.czk.sys.controller;

import com.czk.sys.entity.User;
import com.czk.sys.service.IUserService;
import com.czk.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2023-02-25
 */
@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping("/register")
    @CrossOrigin
    public Result<?> register(@RequestBody User user){
        boolean add = userService.save(user);
        if(add){
            return Result.success("注册成功");
        }
        return Result.fail(201,"注册失败");
    }
    @PostMapping("/login")
    @CrossOrigin
    public Result<Map<String,Object>> login(@RequestBody User user){
        Map<String,Object> data = userService.login(user);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail(201,"用户名或密码错误");
    }
    @PostMapping("/info")
    @CrossOrigin
    public Result<Map<String,Object>> getUserInfo(HttpServletRequest request){
        // 根据token获取用户信息，redis
        String Authorization=request.getHeader("Authorization");
        // System.out.println(Authorization);
        Map<String,Object> data = userService.getUserInfo(Authorization);
        if(data != null){
            return Result.success(data,"验证成功");
        }
        return Result.fail(203,"登录信息无效，请重新登录");
    }
    @PostMapping("/update")
    @CrossOrigin
    public Result<?> update(@RequestBody User user) {
        System.out.println(user);
        userService.updateById(user);
        User user1=userService.getById(user.getUserid());
        return Result.success(user1,"修改用户成功");
    }

}

