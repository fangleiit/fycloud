package com.fangyou.dept.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fangyou.mapper.SysUserMapper;
import com.fangyou.entity.SysUser;
import com.fangyou.dept.service.ISysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findUsers() {
        List<SysUser> sysUserList = sysUserMapper.findUsers();
        return sysUserList;
//        LambdaQueryWrapper<SysUser> wrapper = Wrappers.<SysUser>query().lambda();
//        return sysUserMapper.selectList(wrapper);
    }

    @Override
    public SysUser findUserById(long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
//        SysUser sysUser = sysUserMapper.findUserById(id);
        return sysUser;
    }

    @Override
    public Integer createUser(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public Integer deleteUserById(Long id) {
        return sysUserMapper.deleteById(id);
    }

    @Override
    public List<SysUser> findSysUserByUserNameAndPassword(SysUser sysUser) {
        return sysUserMapper.findSysUserByUserNameAndPassword(sysUser);
    }
}
