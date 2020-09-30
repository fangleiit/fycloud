package com.fangyou.vo.sysuser;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class SysUserVo implements Serializable {
    private static final long serialVersionUID = -2128580645665341227L;
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
