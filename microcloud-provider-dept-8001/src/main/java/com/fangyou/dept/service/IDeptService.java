package com.fangyou.dept.service;

import com.fangyou.dept.entity.DeptEntity;

import java.util.List;

public interface IDeptService {
    public DeptEntity findById(long id);
    public Integer addDept(DeptEntity dept);
    public List<DeptEntity> findAll();
}
