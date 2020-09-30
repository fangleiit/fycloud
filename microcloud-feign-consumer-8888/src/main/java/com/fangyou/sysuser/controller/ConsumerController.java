package com.fangyou.sysuser.controller;

import com.fangyou.sysuser.service.HelloService;
import com.fangyou.vo.dept.DeptVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private HelloService helloService;

    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuffer sb = new StringBuffer();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello1("张三")).append("\n");
        sb.append(helloService.hello2("张三",30)).append("\n");
        DeptVo dept = new DeptVo();
        dept.setDname("测试");
        sb.append(helloService.hello3(dept)).append("\n");
        return sb.toString();
    }

}
