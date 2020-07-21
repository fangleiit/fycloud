package com.fangyou.controller;

import com.fangyou.entity.Dept;
import com.fangyou.entity.SysUser;
import com.fangyou.service.ISysUserService;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    public List<SysUser> findUsersList(HttpServletRequest request, ModelMap modelMap){
        List<SysUser> users = sysUserService.findUsers();
        return users;
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/sysuser/findsysuserbyid/{id}",method = RequestMethod.GET)
    public SysUser findSysUserById(@PathVariable("id") long id){
        SysUser sysUser = sysUserService.findUserById(id);
        return sysUser;
    }

    /**
     * 登录用户验证
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/sysuser/findloginuser",method = RequestMethod.POST)
    public SysUser findloginuser(@RequestBody SysUser sysUser){
        List<SysUser> sysUsers = sysUserService.findSysUserByUserNameAndPassword(sysUser);
        if(!StringUtils.isEmpty(sysUsers)){
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
