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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ConsumerController {

    public static final String DEPT_FINDBYID_URL = "http://dept8010/dept/findById/";
    public static final String DEPT_FINDALL_URL = "http://dept8010/dept/list/";
    public static final String DEPT_ADD_URL = "http://dept8010/dept/add/";


    public static final String SYSUSER_FINDALL_URL = "http://login8002/sysuser/findUsersList/";
    public static final String SYSUSER_FINDUSERBYID_URL = "http://login8002/sysuser/findsysuserbyid/";
    public static final String SYSUSER_FINDBYUNAMEANDPWORD_URL = "http://login8002/sysuser/findloginuser/";

    @Resource
    private RestTemplate restTemplate;

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
        Dept dept = restTemplate.getForObject(DEPT_FINDBYID_URL+id,Dept.class);
        return dept;
    }

    /**
     * 查找所有部门信息
     * @return
     */
    @RequestMapping("/consuer/dept/list")
    public Object list(){
        List<Dept> depts = restTemplate.getForObject(DEPT_FINDALL_URL, List.class);
        return depts;
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @RequestMapping("/consuer/dept/add")
    public Object add(Dept dept){
        boolean flag = restTemplate.postForObject(DEPT_ADD_URL,dept,Boolean.class);
        return flag;
    }

    /**
     * 查找所有用户信息
     * @return
     */
    @RequestMapping("/consuer/sysuser/list")
    public Object findSysUsers(){
        return restTemplate.getForObject(SYSUSER_FINDALL_URL, List.class);
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @RequestMapping("/consuer/sysuser/findusersbyid")
    public Object findUsersById(long id){
        return restTemplate.getForObject(SYSUSER_FINDUSERBYID_URL+id, SysUser.class);
    }

    /**
     * 登录
     * @param sysUser
     * @return
     */
    @RequestMapping("/consuer/findloginuser")
    public Object findloginuser(SysUser sysUser){
//        List<Map<String, Object>> list = new ArrayList<>();
//        Map<String, Object> map = new HashMap<>(16);
//        List<String> stringList = discoveryClient.getServices();
//        stringList.forEach(str -> {
//            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(str);
//            serviceInstances.forEach(ins -> {
//                map.put("host", ins.getHost());
//                map.put("port", ins.getPort());
//                map.put("serviceId", ins.getServiceId());
//                map.put("uri", ins.getUri());
//                list.add(map);
//            });
//        });


        HttpHeaders headers =new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap params = new LinkedMultiValueMap();
        params.add("username","fangyou");
        params.add("password","123456");
        HttpEntity requestEntity =new HttpEntity<>(params, headers);
        ResponseEntity<SysUser> responseUser = restTemplate.exchange(SYSUSER_FINDBYUNAMEANDPWORD_URL,HttpMethod.POST,requestEntity,SysUser.class);
        SysUser loginUser = responseUser.getBody();
        return loginUser;
    }

    @RequestMapping(value = "/consuer/helloConsumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return consumerService.helloService();
    }

}
