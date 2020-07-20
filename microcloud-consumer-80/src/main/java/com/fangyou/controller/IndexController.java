package com.fangyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    /**
     * 首页模板引用测试
     * @param request
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        return "html/index/index";
    }

    /**
     * 模板引用传值测试
     * @param request
     * @return
     */
    @RequestMapping("/fragment")
    public String fragment(HttpServletRequest request){
        return "html/layout/fragment";
    }

    /**
     * layout页面布局
     * @param request
     * @return
     */
    @RequestMapping("/layout")
    public String layout(HttpServletRequest request){
        return "html/layout/layout";
    }

    /**
     * 布局页面引用
     * @param request
     * @return
     */
    @RequestMapping("/home")
    public String home(HttpServletRequest request){
        return "html/index/home";
    }


    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, ModelMap modelMap){
        modelMap.addAttribute("errorMsg","用户名或者密码错误!");
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
}
