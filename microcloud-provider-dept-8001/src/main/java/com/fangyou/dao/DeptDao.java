package com.fangyou.dao;

import com.fangyou.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeptDao {
    public boolean doCreate(@Param("dept") Dept dept);
    public Dept findById(Long id);
    public List<Dept> findAll();
}
