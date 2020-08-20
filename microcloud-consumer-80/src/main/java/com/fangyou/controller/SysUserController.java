package com.fangyou.controller;

import com.fangyou.entity.SysUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SysUserController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders headers;


    /**
     * 查找所有用户信息
     * @return
     */
    @RequestMapping("/sysuser/list")
    @ResponseBody
    public Object findSysUsers(){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        return restTemplate.exchange("http://sysuser8020/sysuser/findUsersList/", HttpMethod.GET,request, List.class).getBody();
    }

    /**
     * 查找所有用户信息
     * @return
     */
    @RequestMapping("/sysuser/list2")
    @ResponseBody
    public Object findSysUsersT(){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        return restTemplate.exchange("http://sysuser8002/sysuser/findUsersList/", HttpMethod.GET,request, List.class).getBody();
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @RequestMapping("/sysuser/findusersbyid")
    @ResponseBody
    public Object findUsersById(long id){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        return restTemplate.exchange("http://sysuser8020/sysuser/findsysuserbyid/"+id,HttpMethod.GET,request, SysUser.class);
    }

}
