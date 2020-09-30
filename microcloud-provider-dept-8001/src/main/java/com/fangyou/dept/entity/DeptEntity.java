package com.fangyou.dept.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("dept")
public class DeptEntity implements Serializable {
    private static final long serialVersionUID = 2865150533322921101L;
    @TableId(value = "deptno")
    private Long deptno;
    private String dname;
    private String loc;
}
