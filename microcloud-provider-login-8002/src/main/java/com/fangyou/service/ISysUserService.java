package com.fangyou.service;

import com.fangyou.dao.SysUserDao;
import com.fangyou.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISysUserService {
    List<SysUser> findUsers();
    SysUser findUserById(Long id);
    boolean createUser(@Param("sysUser") SysUser sysUser);
    boolean deleteUserById(Long id);
    List<SysUser> findSysUserByUserNameAndPassword(@Param("sysUser") SysUser sysUser);
}
