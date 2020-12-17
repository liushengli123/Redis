package com.example.demo.service.Impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /*缓存的概念：将运行的结果存放在内存中，以后再要相同的数据，直接从缓存中取，不需要调用方法
                1、在主配置内加入@EnableCaching注解开启缓存
                2、在相应的方法添加@Cacheable注解，指定将结果缓存
                    其中有很多重要的属性：cacheNames/value  指定缓存的名字
                                      cacheManager/cacheManager 缓存管理器
                                      condition 指定符合条件下才进行缓存
                                      unless 除非满足条件，则不缓存
                                      sync 是否使用异步方式
            原理：cacheAutoConfiguration自动配置类
                在调用方法之前会检查有没有缓存，默认按照参数的值作为key去查缓存，如果没有就将值存入缓存，以后再调用就用这个值
                key生成策略：keyGenerator生成
      */
    @Cacheable(cacheNames = "user")
    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
