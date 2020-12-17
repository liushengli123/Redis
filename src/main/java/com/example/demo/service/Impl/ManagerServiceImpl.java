package com.example.demo.service.Impl;

import com.example.demo.mapper.ManagerMapper;
import com.example.demo.pojo.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired(required = false)
    ManagerMapper managerMapper;
    /*cacheAble中的属性:
    *                                 cacheNames/value  指定缓存的名字
                                      cacheManager/cacheManager 缓存管理器
                                      condition 指定符合条件下才进行缓存
                                      unless 除非满足条件，则不缓存
                                      sync 是否使用异步方式(注意当使用异步的方式时unless会失效)
                                      * */
    @Cacheable(value = "manager",condition = "#a0 >= 2",unless = "#a0 ==2")
    @Override
    public Manager getById(Integer id) {
        return managerMapper.getById(id);
    }

//  cacheput缓存修改:当设置key与上面一致时，能够保证二次查询的结果为更新后的结果，如果不设置key,会导致查询结果为第一次缓存的结果
    @CachePut(value = "manager",key = "#result.id")
    @Override
    public Manager update(Manager manager) {
         managerMapper.Update(manager);
         return manager;
    }

//    默认删除指定key的缓存,不影响其他缓存
//    beforeInvocation=false,缓存的清除是否在方法之前执行，默认是在方法之后执行，如果出现异常缓存就不会清除缓存
    @CacheEvict(value = "manager",key = "#id",beforeInvocation = true)
    @Override
    public void delete(Integer id) {
        System.out.println(id);
//        int i=1/0;
    }
}
