package com.fangyou.sysuser.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = -2128580645665341227L;
    @TableId(value = "id")
    private Long id;
    private String username;
    private String password;
    private String email;
    private Date dateBirth;
    private Integer age;
    private String sex;
    private String realname;
    private String homeAddress;
    private String currentAddress;
    private String phoneNumber;
    private String corporateName;
    private BigInteger deptId;
    private String positionJob;
    private String positionalTitles;
    private String recordSchooling;
    private String documentType;
    private String idNumber;
    private String maritalStatus;
    private String userMode;
    private Timestamp createTime;
    private String createBy;
    private Timestamp updateTime;
    private String updateBy;
}
