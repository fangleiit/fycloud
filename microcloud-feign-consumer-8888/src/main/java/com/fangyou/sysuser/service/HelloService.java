package com.fangyou.sysuser.service;

import com.fangyou.vo.dept.DeptVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("dept8010")
public interface HelloService {

    @RequestMapping("/helloFeign")
    String hello();

    @RequestMapping(value = "/helloFeign1",method = RequestMethod.GET)
    String hello1(@RequestParam("name") String name);

    @RequestMapping(value = "/helloFeign2",method = RequestMethod.GET)
    String hello2(@RequestHeader("name") String name,@RequestHeader("age") Integer age);

    @RequestMapping(value = "/helloFeign3",method = RequestMethod.POST)
    String hello3(@RequestBody DeptVo dept);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    Object deptList();

    @RequestMapping(value = "/region/treeList",method = RequestMethod.GET)
    Object regionTreeList();
}
