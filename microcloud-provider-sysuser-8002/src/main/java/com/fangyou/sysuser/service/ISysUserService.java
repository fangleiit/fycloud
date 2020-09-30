package com.fangyou.sysuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangyou.sysuser.entity.SysUserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISysUserService extends IService<SysUserEntity> {
    /**
     * 查询所有用户
     * @return
     */
    List<SysUserEntity> findUsers();

    /**
     * 根据用户id查找用户
     * @param id
     * @return
     */
    SysUserEntity findUserById(long id);
    Integer createUser(@Param("sysUser") SysUserEntity sysUser);
    Integer deleteUserById(Long id);
    List<SysUserEntity> findSysUserByUserNameAndPassword(SysUserEntity SysUserEntity);
}
