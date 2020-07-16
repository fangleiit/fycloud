package com.fangyou.service.impl;

import com.fangyou.dao.DeptDao;
import com.fangyou.service.IDeptService;
import com.fangyou.entity.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IDeptServiceImpl implements IDeptService {
    @Resource
    private DeptDao deptDao;

    @Override
    public Dept findById(long id) {
        return deptDao.findById(id);
    }
    @Override
    public boolean addDept(Dept dept) {
        return deptDao.doCreate(dept);
    }
    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
