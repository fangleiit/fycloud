package com.fangyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangyou.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 查询所有用户
     * @return
     */
    List<SysUser> findUsers();

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    SysUser findUserById(long id);
    List<SysUser> findSysUserByUserNameAndPassword(@Param("sysUser") SysUser sysUser);
}
