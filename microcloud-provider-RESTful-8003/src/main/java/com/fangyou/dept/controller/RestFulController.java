package com.fangyou.dept.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/restful")
public class RestFulController {

    /**
     * 聊天室
     * @return
     */
    @RequestMapping("/torestful")
    public String torestful(HttpServletRequest request, ModelMap modelMap){
        return "html/restful/restful";
    }
}
