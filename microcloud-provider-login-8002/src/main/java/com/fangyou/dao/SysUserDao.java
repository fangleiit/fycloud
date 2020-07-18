package com.fangyou.dao;

import com.fangyou.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserDao {
    List<SysUser> findUsers();
    SysUser findUserById(Long id);
    boolean createUser(@Param("sysUser") SysUser sysUser);
    boolean deleteUserById(Long id);
    List<SysUser> findSysUserByUserNameAndPassword(@Param("sysUser") SysUser sysUser);
}
