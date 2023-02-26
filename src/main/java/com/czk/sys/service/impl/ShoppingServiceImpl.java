package com.czk.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.czk.sys.entity.Shopping;
import com.czk.sys.mapper.ShoppingMapper;
import com.czk.sys.service.IShoppingService;
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
public class ShoppingServiceImpl extends ServiceImpl<ShoppingMapper, Shopping> implements IShoppingService {



    @Override
    public List<Shopping> orderbyuserid(Integer integer) {
        LambdaQueryWrapper<Shopping> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Shopping::getUi,integer);
        wrapper.eq(Shopping::getPy,"done");
        List<Shopping> data=this.baseMapper.selectList(wrapper);
        return data;
    }

    @Override
    public List<Shopping> unorderbyuserid(Integer integer) {
        LambdaQueryWrapper<Shopping> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Shopping::getUi,integer);
        wrapper.eq(Shopping::getPy,"undo");
        List<Shopping> data=this.baseMapper.selectList(wrapper);
        return data;
    }

    @Override
    public List<Shopping> allbyuserid(Integer integer) {
        LambdaQueryWrapper<Shopping> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Shopping::getUi,integer);
        List<Shopping> data=this.baseMapper.selectList(wrapper);
        return data;
    }
}
