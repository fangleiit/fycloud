package com.fangyou.sysuser.controller;

import com.fangyou.sysuser.entity.SysUserEntity;
import com.fangyou.sysuser.service.ISysUserService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@RestController
public class SysUserController {
    @Resource
    private ISysUserService sysUserService;

    /**
     * 查找所有用户
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/sysuser/findUsersList",method = RequestMethod.GET)
    public List<SysUserEntity> findUsersList(HttpServletRequest request, ModelMap modelMap){
        List<SysUserEntity> users = sysUserService.findUsers();
        return users;
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/sysuser/findsysuserbyid/{id}",method = RequestMethod.GET)
    public SysUserEntity findSysUserById(@PathVariable("id") long id){
        SysUserEntity sysUser = sysUserService.findUserById(id);
        return sysUser;
    }

    /**
     * 登录用户验证
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/sysuser/findloginuser",method = RequestMethod.POST)
    public SysUserEntity findUsersByNameAndPass(@RequestBody SysUserEntity sysUser){
        List<SysUserEntity> sysUsers = sysUserService.findSysUserByUserNameAndPassword(sysUser);
        if(sysUsers != null && sysUsers.size() > 0){
            return sysUsers.get(0);
        }
        return null;
    }

    @RequestMapping(value = "/sysuser/hellohystrix",method = RequestMethod.GET)
    public String hellohystrix() throws InterruptedException {
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);
        return "hellohystrix";
    }
}
