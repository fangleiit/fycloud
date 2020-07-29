package com.fangyou.controller;


import com.fangyou.service.IDeptService;
import com.fangyou.entity.Dept;
import com.netflix.discovery.EurekaClientConfig;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptRestController {

    @Resource
    public IDeptService deptService;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/findById/{id}",method = RequestMethod.GET)
    public Object findById(@PathVariable("id") long id){
       return deptService.findById(id);
    }

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public Object add(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public Object list(){
        List<String> services = discoveryClient.getServices();
        if(!StringUtils.isEmpty(services)){
            for(String service : services){
                System.out.println(" -- " + service );
            }
        }
        return deptService.findAll();
    }


    @RequestMapping(value = "/helloFeign",method = RequestMethod.GET)
    public String helloFeign(){
        return "HelloFeign";
    }
    @RequestMapping(value = "/helloFeign1",method = RequestMethod.GET)
    public String helloFeign1(@RequestParam String name){
        return "HelloFeign: " + name;
    }
    @RequestMapping(value = "/helloFeign2",method = RequestMethod.GET)
    public String helloFeign2(@RequestHeader String name,@RequestHeader Integer age){
        return "HelloFeign "+ name + " " + age;
    }
    @RequestMapping(value = "/helloFeign3",method = RequestMethod.POST)
    public String helloFeign3(@RequestBody Dept dept){
        return "HelloFeign" + dept.getDname();
    }

    @RequestMapping(value = "/helloWord",method = RequestMethod.POST)
    public String HelloWord(@RequestParam String name){
        return "HelloWorld " + name;
    }
}
