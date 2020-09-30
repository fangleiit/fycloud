package com.fangyou.dept.service.impl;

import com.fangyou.dept.mapper.DeptMapper;
import com.fangyou.dept.entity.DeptEntity;
import com.fangyou.dept.service.IDeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class IDeptServiceImpl implements IDeptService {
    @Resource
    private DeptMapper deptDao;

    @Override
    public DeptEntity findById(long id) {
        return deptDao.selectById(id);
    }
    @Override
    public Integer addDept(DeptEntity dept) {
        return deptDao.insert(dept);
    }
    @Override
    public List<DeptEntity> findAll() {
        return deptDao.findAll();
    }
}
