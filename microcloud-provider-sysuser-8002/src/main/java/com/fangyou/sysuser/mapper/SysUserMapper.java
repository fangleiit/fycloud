package com.fangyou.sysuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangyou.sysuser.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
    /**
     * 查询所有用户
     * @return
     */
    List<SysUserEntity> findUsers();

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    SysUserEntity findUserById(long id);
    List<SysUserEntity> findSysUserByUserNameAndPassword(@Param("sysUser") SysUserEntity sysUser);
}
