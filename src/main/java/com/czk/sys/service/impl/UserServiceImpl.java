package com.czk.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.czk.sys.entity.User;
import com.czk.sys.mapper.UserMapper;
import com.czk.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-02-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Map<String, Object> login(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getPhone,user.getPhone());
        wrapper.eq(User::getPassword,user.getPassword());
        User loginUser=this.baseMapper.selectOne(wrapper);
        if(loginUser!=null){
            String key="user"+ UUID.randomUUID();
            redisTemplate.opsForValue().set(key,loginUser,60, TimeUnit.MINUTES);
            Map<String,Object> data=new HashMap<String, Object>();
            data.put("token",key);
            data.put("name",loginUser.getname());
            return data;
        }
        return null;
    }
    @Override
    public Map<String, Object> getUserInfo(String token) {
        // 根据token获取用户信息，redis
        Object obj = redisTemplate.opsForValue().get(token);
        if(obj != null){
            User login = JSON.parseObject(JSON.toJSONString(obj),User.class);
            User loginUser=this.baseMapper.selectById(login.getUserid());
            Map<String, Object> data = new HashMap<>();
            data.put("userid",loginUser.getUserid());
            data.put("name",loginUser.getname());
            data.put("phone",loginUser.getPhone());
            data.put("gender",loginUser.getGender());
            data.put("password",loginUser.getPassword());
            data.put("token",token);
            return data;
        }
        return null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }
}
