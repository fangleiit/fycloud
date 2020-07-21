package com.fangyou.controller;

import com.fangyou.entity.Dept;
import com.fangyou.entity.SysUser;
import com.fangyou.service.ConsumerService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.*;

@RestController
public class ConsumerController {

    public static final String DEPT_FINDBYID_URL = "http://dept8010/dept/findById/";
    public static final String DEPT_FINDALL_URL = "http://dept8010/dept/list/";
    public static final String DEPT_ADD_URL = "http://dept8010/dept/add/";


    public static final String SYSUSER_FINDALL_URL = "http://login8020/sysuser/findUsersList/";
    public static final String SYSUSER_FINDUSERBYID_URL = "http://login8020/sysuser/findsysuserbyid/";
    public static final String SYSUSER_FINDBYUNAMEANDPWORD_URL = "http://login8020/sysuser/findloginuser/";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders headers;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private ConsumerService consumerService;

    /**
     * 根据id查找部门信息
     * @param id
     * @return
     */
    @RequestMapping("/consuer/dept/findById")
    public Object findById(long id){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        Dept dept = restTemplate.exchange(DEPT_FINDBYID_URL+id,HttpMethod.GET,request,Dept.class).getBody();
        return dept;
    }

    /**
     * 查找所有部门信息
     * @return
     */
    @RequestMapping("/consuer/dept/list")
    public Object list(){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        List<Dept> depts = restTemplate.exchange(DEPT_FINDALL_URL,HttpMethod.GET,request,List.class).getBody();
        return depts;
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @RequestMapping("/consuer/dept/add")
    public Object add(Dept dept){
        HttpEntity<Object> request = new HttpEntity<Object>(dept,headers);
        boolean flag = restTemplate.exchange(DEPT_ADD_URL,HttpMethod.POST,request,Boolean.class).getBody();
        return flag;
    }

    /**
     * 查找所有用户信息
     * @return
     */
    @RequestMapping("/consuer/sysuser/list")
    public Object findSysUsers(){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        return restTemplate.exchange(SYSUSER_FINDALL_URL,HttpMethod.GET,request,List.class).getBody();
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @RequestMapping("/consuer/sysuser/findusersbyid")
    public Object findUsersById(long id){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        return restTemplate.exchange(SYSUSER_FINDUSERBYID_URL+id,HttpMethod.GET,request,SysUser.class);
    }

    /**
     * 登录
     * @param sysUser
     * @return
     */
    @RequestMapping("/consuer/findloginuser")
    public Object findUsersByNameAndPass(SysUser sysUser){
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
//        map.add("username", sysUser.getUsername());
//        map.add("password",sysUser.getPassword());
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        HttpEntity<Object> request = new HttpEntity<Object>(sysUser,headers);
        ResponseEntity<SysUser> responSysUser =  restTemplate.exchange("http://login8020/sysuser/findloginuser/",
              HttpMethod.POST,request,SysUser.class);
        SysUser sysUserresult =  responSysUser.getBody();
        return sysUserresult;
    }

    /**
     * 测试断路器
     * @return
     */
    @RequestMapping(value = "/consuer/helloConsumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return consumerService.helloService();
    }

}
