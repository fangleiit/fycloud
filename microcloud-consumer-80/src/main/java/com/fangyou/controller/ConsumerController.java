package com.fangyou.controller;

import com.fangyou.entity.Dept;
import com.fangyou.entity.SysUser;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RestController
public class ConsumerController {

    public static final String DEPT_FINDBYID_URL = "http://127.0.0.1:8001/dept/findById/";
    public static final String DEPT_FINDALL_URL = "http://localhost:8001/dept/list/";
    public static final String DEPT_ADD_URL = "http://127.0.0.1:8001/dept/add/";


    public static final String SYSUSER_FINDALL_URL = "http://127.0.0.1:8002/sysuser/findUsersList/";
    public static final String SYSUSER_FINDUSERBYID_URL = "http://127.0.0.1:8002/sysuser/findsysuserbyid/";
    public static final String SYSUSER_FINDBYUNAMEANDPWORD_URL = "http://127.0.0.1:8002/sysuser/login/";

    @Resource
    private RestTemplate restTemplate;

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
        List<Dept> depts = restTemplate.getForObject("http://dept8010/dept/list/", List.class);
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
//    @RequestMapping("/consuer/login")
//    public Object login(SysUser sysUser){
//        ResponseEntity<SysUser> user = restTemplate.(SYSUSER_FINDBYUNAMEANDPWORD_URL,SysUser.class,sysUser);
//        return user;
//    }
}
