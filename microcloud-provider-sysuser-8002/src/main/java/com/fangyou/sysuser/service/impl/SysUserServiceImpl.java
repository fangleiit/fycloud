package com.fangyou.sysuser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fangyou.sysuser.entity.SysUserEntity;
import com.fangyou.sysuser.mapper.SysUserMapper;
import com.fangyou.sysuser.service.ISysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUserEntity> findUsers() {
        List<SysUserEntity> sysUserList = sysUserMapper.findUsers();
        return sysUserList;
//        LambdaQueryWrapper<SysUserEntity> wrapper = Wrappers.<SysUserEntity>query().lambda();
//        return sysUserMapper.selectList(wrapper);
    }

    @Override
    public SysUserEntity findUserById(long id) {
        SysUserEntity sysUser = sysUserMapper.selectById(id);
//        SysUserEntity sysUser = sysUserMapper.findUserById(id);
        return sysUser;
    }

    @Override
    public Integer createUser(SysUserEntity sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public Integer deleteUserById(Long id) {
        return sysUserMapper.deleteById(id);
    }

    @Override
    public List<SysUserEntity> findSysUserByUserNameAndPassword(SysUserEntity sysUser) {
        return sysUserMapper.findSysUserByUserNameAndPassword(sysUser);
    }
}
