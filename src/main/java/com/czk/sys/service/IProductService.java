package com.czk.sys.service;

import com.czk.sys.entity.Product;
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
public interface IProductService extends IService<Product> {
    List<Product> send();

    Product select(String product);

    List<Product> selectp();

    List<Product> selectf();

    List<Product> selectb();

    List<Product> selects();

    Product selectonebyname(String pn);
}
