package com.fangyou.service;

import com.fangyou.entity.Dept;

import java.util.List;

public interface IDeptService {
    public Dept findById(long id);
    public boolean addDept(Dept dept);
    public List<Dept> findAll();
}
