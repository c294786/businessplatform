package com.czk.sys.service;

import com.czk.sys.entity.Shopping;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-02-25
 */
public interface IShoppingService extends IService<Shopping> {


    List<Shopping> orderbyuserid(Integer integer);

    List<Shopping> unorderbyuserid(Integer integer);

    List<Shopping> allbyuserid(Integer integer);
}
