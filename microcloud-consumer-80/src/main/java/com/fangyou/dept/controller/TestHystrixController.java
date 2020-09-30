package com.fangyou.dept.controller;

import com.fangyou.dept.service.ConsumerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestHystrixController {

    @Resource
    private ConsumerService consumerService;

    /**
     * 测试断路器
     * @return
     */
    @RequestMapping(value = "/consuer/helloConsumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return consumerService.helloService();
    }

}
