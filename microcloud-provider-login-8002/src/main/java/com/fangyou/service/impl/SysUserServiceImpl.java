package com.fangyou.service.impl;

import com.fangyou.dao.SysUserDao;
import com.fangyou.entity.SysUser;
import com.fangyou.service.ISysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl  implements ISysUserService {

    @Resource
    private SysUserDao sysUserDao;

    @Override
    public List<SysUser> findUsers() {
        return sysUserDao.findUsers();
    }

    @Override
    public SysUser findUserById(Long id) {
        return sysUserDao.findUserById(id);
    }

    @Override
    public boolean createUser(SysUser sysUser) {
        return sysUserDao.createUser(sysUser);
    }

    @Override
    public boolean deleteUserById(Long id) {
        return sysUserDao.deleteUserById(id);
    }

    @Override
    public List<SysUser> findSysUserByUserNameAndPassword(SysUser sysUser) {
        return sysUserDao.findSysUserByUserNameAndPassword(sysUser);
    }
}
