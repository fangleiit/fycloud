package com.fangyou.controller;

import com.fangyou.entity.Dept;
import com.fangyou.entity.SysUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, ModelMap modelMap){
        return "html/login/login";
    }

    /**
     * 注册页面
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(HttpServletRequest request, ModelMap modelMap){
        return "html/login/register";
    }

    /**
     * 登录跳转首页页面
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request,SysUser sysUser,ModelMap modelMap){
        HttpEntity<Object> httpEntity = new HttpEntity<Object>(sysUser,headers);
        ResponseEntity<SysUser> responSysUser =  restTemplate.exchange("http://sysuser8020/sysuser/findloginuser/",
                HttpMethod.POST,httpEntity,SysUser.class);
        SysUser sysUserresult =  responSysUser.getBody();
        if(StringUtils.isEmpty(sysUserresult)){
            modelMap.addAttribute("errorMsg","用户名或者密码错误!");
            return "html/login/login";
        }
        request.getSession().setAttribute("sysUser",sysUserresult);
        modelMap.addAttribute("sysUser",sysUserresult);
        return "html/index/index";
    }


    /** TODO
     * 注册
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("/register")
    public String register(HttpServletRequest request,ModelMap modelMap){
        return "html/login/login";
    }

}
