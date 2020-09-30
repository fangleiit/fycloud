package com.fangyou.dept.service;

import com.fangyou.entity.Dept;

import java.util.List;

public interface IDeptService {
    public Dept findById(long id);
    public Integer addDept(Dept dept);
    public List<Dept> findAll();
}
