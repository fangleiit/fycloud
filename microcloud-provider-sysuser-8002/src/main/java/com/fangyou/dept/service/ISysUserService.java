package com.fangyou.dept.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangyou.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISysUserService extends IService<SysUser> {
    /**
     * 查询所有用户
     * @return
     */
    List<SysUser> findUsers();

    /**
     * 根据用户id查找用户
     * @param id
     * @return
     */
    SysUser findUserById(long id);
    Integer createUser(@Param("sysUser") SysUser sysUser);
    Integer deleteUserById(Long id);
    List<SysUser> findSysUserByUserNameAndPassword(SysUser sysUser);
}
