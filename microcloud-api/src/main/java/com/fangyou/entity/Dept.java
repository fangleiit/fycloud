package com.fangyou.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {
    private static final long serialVersionUID = 2865150533322921101L;
    private Long deptno;
    private String dname;
    private String loc;
}
