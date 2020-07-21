package com.fangyou.controller;

import com.fangyou.entity.Dept;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class TestThymeleafController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;


    /**
     *  thymeleaf基本使用
     * @param modelMap
     * @return
     */
    @RequestMapping("/consuer/thymeleaf/usebase")
    public String helloIndex(ModelMap modelMap){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        List<Dept> depts = restTemplate.exchange("http://dept8010/dept/list/", HttpMethod.GET,request,List.class).getBody();
        modelMap.addAttribute("message","你好thymeleaf");
        modelMap.addAttribute("username","策士");
        modelMap.addAttribute("flag","yes");
        modelMap.addAttribute("depts",depts);
        modelMap.addAttribute("type","link");
        modelMap.addAttribute("pageId","springcloud/2017/09/11/");
        modelMap.addAttribute("img","http://www.ityouknow.com/assets/images/neo.jpg");
        modelMap.addAttribute("name","fangyou");
        modelMap.addAttribute("age",30);
        modelMap.addAttribute("sex","woman");
        return "html/testthymeleaf/testbase";
    }

    /**
     *  thymeleaf 内联使用
     *  用于jsvascript取值
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("/consuer/thymeleaf/inline")
    public String inline(HttpServletRequest request, ModelMap modelMap){
        modelMap.addAttribute("username","方优");
        request.setAttribute("request","i am request");
        request.getSession().setAttribute("session","i am session");
        return "html/testthymeleaf/testinline";
    }

    /**
     * thymeleaf其他用法
     * @param modelMap
     * @return
     */
    @RequestMapping("/consuer/thymeleaf/useothers")
    public String date(ModelMap modelMap){
        modelMap.addAttribute("userName","Hello,方优");
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        modelMap.addAttribute("depts",restTemplate.exchange("http://dept8010/dept/list/",HttpMethod.GET,request,List.class));
        modelMap.addAttribute("count",12);
        modelMap.addAttribute("date",new Date());
        return "html/testthymeleaf/testothers";
    }
}
