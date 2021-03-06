package com.fangyou.sysuser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestFragmentController {

    /**
     * 首页模板引用测试
     * @param request
     * @return
     */
    @RequestMapping("/copyright")
    public String index(HttpServletRequest request){
        return "html/testfragment/copyright";
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
    @RequestMapping("/testcontent")
    public String home(HttpServletRequest request){
        return "html/testfragment/testcontent";
    }

}
