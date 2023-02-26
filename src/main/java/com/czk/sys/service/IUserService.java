package com.czk.sys.service;

import com.czk.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-02-25
 */
public interface IUserService extends IService<User> {
    Map<String, Object> login(User user);
    Map<String, Object> getUserInfo(String token);

    void logout(String token);
}
