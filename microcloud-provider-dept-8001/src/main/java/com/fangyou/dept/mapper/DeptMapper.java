package com.fangyou.dept.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangyou.dept.entity.DeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper extends BaseMapper<DeptEntity> {
    List<DeptEntity> findAll();
}
