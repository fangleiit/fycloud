package com.fangyou.dept.service.impl;

import com.fangyou.dept.mapper.DeptMapper;
import com.fangyou.dept.service.IDeptService;
import com.fangyou.entity.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IDeptServiceImpl implements IDeptService {
    @Resource
    private DeptMapper deptDao;

    @Override
    public Dept findById(long id) {
        return deptDao.selectById(id);
    }
    @Override
    public Integer addDept(Dept dept) {
        return deptDao.insert(dept);
    }
    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
