package com.czk.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.czk.sys.entity.Product;
import com.czk.sys.entity.Shopping;
import com.czk.sys.service.IProductService;
import com.czk.sys.service.IShoppingService;
import com.czk.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
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
public class ShoppingController {
    private final IShoppingService Service;
    @Autowired
    private IProductService productService;

    public ShoppingController(IShoppingService orderService) {
        this.Service = orderService;
    }
    @GetMapping("/shopping/deleteone")
    @CrossOrigin
    public Result<Shopping> deleteshop(@RequestParam("userid") String userid,
                                    @RequestParam("productname") String productname,
                                    @RequestParam("payment") String payment,
                                    @RequestParam("perprice") String perprice){
        LambdaQueryWrapper<Shopping> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Shopping::getUi,userid);
        wrapper.eq(Shopping::getPn,productname);
        wrapper.eq(Shopping::getPp,perprice);
        Service.remove(wrapper);
        return Result.success("删除购物车商品成功");
    }
    @GetMapping("/shopping")
    @CrossOrigin
    public Result<Shopping> addshop(@RequestParam("userid") String userid,
                                    @RequestParam("productname") String productname,
                                    @RequestParam("payment") String payment,
                                    @RequestParam("perprice") String perprice){
        Shopping shopping = new Shopping();
        shopping.setUi(Integer.valueOf(userid));
        shopping.setPn(productname);
        shopping.setPp(Double.valueOf(perprice));
        shopping.setPy(payment);
        Service.save(shopping);
        return Result.success("添加商品到购物车成功");
    }
    @GetMapping("/myorder/done")
    @CrossOrigin
    public Result<List<Shopping>> order(@RequestParam("userid") String userid){
        Integer integer = Integer.parseInt(userid);
        List<Shopping> data= Service.orderbyuserid(integer);
        for(Shopping s:data){
            s.setHttp(productService.selectonebyname(s.getPn()).getPicturehttp());
        }
        if(data!=null){
            return Result.success(data);
        }
        return Result.fail();
    }
    @GetMapping("/myorder/undone")
    @CrossOrigin
    public Result<List<Shopping>> unorder(@RequestParam("userid") String userid){
        Integer integer = Integer.parseInt(userid);
        List<Shopping> data= Service.unorderbyuserid(integer);
        for(Shopping s:data){
            s.setHttp(productService.selectonebyname(s.getPn()).getPicturehttp());
        }
        if(data!=null){
            return Result.success(data);
        }
        return Result.fail();
    }
    @GetMapping("/myorder/all")
    @CrossOrigin
    public Result<List<Shopping>> all(@RequestParam("userid") String userid){
        Integer integer = Integer.parseInt(userid);
        List<Shopping> data= Service.allbyuserid(integer);
        for(Shopping s:data){
            s.setHttp(productService.selectonebyname(s.getPn()).getPicturehttp());
        }
        if(data!=null){
            return Result.success(data);
        }
        return Result.fail();
    }
    @GetMapping("/myorder/undotodone")
    @CrossOrigin
    public Result<?> untodone(@RequestParam("userid") String userid,
                                           @RequestParam("productname") String productname,
                                           @RequestParam("payment") String payment,
                                           @RequestParam("perprice") String perprice){
        LambdaQueryWrapper<Shopping> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Shopping::getUi,userid);
        wrapper.eq(Shopping::getPn,productname);
        wrapper.eq(Shopping::getPp,perprice);
        Shopping one = Service.getOne(wrapper);
        one.setPy("done");
        Service.updateById(one);
        return Result.success(Service.getById(one.getOi()));
    }
}
