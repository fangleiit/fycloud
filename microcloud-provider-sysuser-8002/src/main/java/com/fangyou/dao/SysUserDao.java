package com.fangyou.dao;

import com.fangyou.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Mapper
public interface SysUserDao {
    List<SysUser> findUsers();
    SysUser findUserById(long id);
    boolean createUser(@Param("sysUser") SysUser sysUser);
    boolean deleteUserById(Long id);
    List<SysUser> findSysUserByUserNameAndPassword(@Param("sysUser") SysUser sysUser);
}
