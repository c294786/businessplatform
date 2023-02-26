package com.czk.sys.controller;

import com.czk.sys.entity.Bigpicture;
import com.czk.sys.service.IBigpictureService;
import com.czk.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
public class BigpictureController {
    @Autowired
    private IBigpictureService service;
    @GetMapping("/picture")
    @CrossOrigin
    public Result<List<Bigpicture>> big(){
        List<Bigpicture> data=service.list();
        return Result.success(data,"传输成功");
    }
}
