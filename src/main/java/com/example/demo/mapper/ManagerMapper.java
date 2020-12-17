package com.example.demo.mapper;

import com.example.demo.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ManagerMapper {
    @Select("select * from manager where id=#{id}")
    Manager getById(Integer id);

    @Update("update manager set name=#{name},sex=#{sex},age=#{age} where id=#{id}")
    void Update(Manager manager);
}
