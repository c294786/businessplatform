package com.czk.sys.controller;

import com.czk.sys.entity.Product;
import com.czk.sys.service.IProductService;
import com.czk.vo.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    @CrossOrigin
    public Result<List<Product>> sendProduct(){
        List<Product> data =productService.send();
        if (data!=null){
            return Result.success(data);
        }
        return Result.fail("图片获取失败");
    }
    @GetMapping("/home/search")
    @CrossOrigin
    public Result<Product> selectProduct(@RequestParam("productid") String id){
        System.out.println(id);
        Product data =productService.select(id);
        if (data!=null){
            return Result.success(data);
        }
        return Result.fail("商品信息获取失败");
    }
    @RequestMapping("/home/categoryShoe")
    @CrossOrigin
    public Result<List<Product>> selectshoe(){
        List<Product> data =productService.selects();
        if (data!=null){
            return Result.success(data);
        }
        return Result.fail("分类查询失败");
    }
    @RequestMapping("/home/categoryBook")
    @CrossOrigin
    public Result<List<Product>> selectbook(){
        List<Product> data =productService.selectb();
        if (data!=null){
            return Result.success(data);
        }
        return Result.fail("分类查询失败");
    }
    @RequestMapping("/home/categoryFood")
    @CrossOrigin
    public Result<List<Product>> selectfood(){
        List<Product> data =productService.selectf();
        if (data!=null){
            return Result.success(data);
        }
        return Result.fail("分类查询失败");
    }
    @RequestMapping("/home/categoryPhone")
    @CrossOrigin
    public Result<List<Product>> selectphone(){
        List<Product> data =productService.selectp();
        if (data!=null){
            return Result.success(data);
        }
        return Result.fail("分类查询失败");
    }

}
