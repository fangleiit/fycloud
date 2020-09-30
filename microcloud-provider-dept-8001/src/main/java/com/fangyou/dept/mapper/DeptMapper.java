package com.fangyou.dept.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangyou.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
    List<Dept> findAll();
}
