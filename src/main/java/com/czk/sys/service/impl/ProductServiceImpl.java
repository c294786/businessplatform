package com.czk.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.czk.sys.entity.Product;
import com.czk.sys.mapper.ProductMapper;
import com.czk.sys.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-02-25
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Override
    public List<Product> send() {
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.ne(Product::getCategory, "大图");
        List<Product> products = this.baseMapper.selectList(wrapper);
        return products;
    }

    @Override
    public Product select(String product) {
        LambdaQueryWrapper<Product> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Product::getProductid,product);
        Product data=this.baseMapper.selectOne(wrapper);
        return data;
    }

    @Override
    public List<Product> selectp() {
        LambdaQueryWrapper<Product> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Product::getCategory,"手机");
        List<Product> list = this.baseMapper.selectList(wrapper);
        if(list!=null){
            return list;
        }
        return null;
    }

    @Override
    public List<Product> selectf() {
        LambdaQueryWrapper<Product> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Product::getCategory,"食品");
        List<Product> list = this.baseMapper.selectList(wrapper);
        if(list!=null){
            return list;
        }
        return null;
    }

    @Override
    public List<Product> selectb() {
        LambdaQueryWrapper<Product> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Product::getCategory,"图书");
        List<Product> list = this.baseMapper.selectList(wrapper);
        if(list!=null){
            return list;
        }
        return null;
    }

    @Override
    public List<Product> selects() {
        LambdaQueryWrapper<Product> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Product::getCategory,"鞋靴");
        List<Product> list = this.baseMapper.selectList(wrapper);
        if(list!=null){
            return list;
        }
        return null;
    }

    @Override
    public Product selectonebyname(String pn) {
        LambdaQueryWrapper<Product> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Product::getName,pn);
        Product p=this.baseMapper.selectOne(wrapper);
        return p;
    }
}
