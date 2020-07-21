package com.fangyou.service;

import com.fangyou.dao.SysUserDao;
import com.fangyou.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface ISysUserService {
    List<SysUser> findUsers();
    SysUser findUserById(long id);
    boolean createUser(@Param("sysUser") SysUser sysUser);
    boolean deleteUserById(Long id);
    List<SysUser> findSysUserByUserNameAndPassword(SysUser sysUser);
}
