package com.fangyou.controller;

import com.fangyou.entity.Dept;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DeptController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders headers;

    /**
     * 根据id查找部门信息
     * @param id
     * @return
     */
    @RequestMapping("/dept/findById")
    @ResponseBody
    public Object findById(long id){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        Dept dept = restTemplate.exchange("http://dept8010/dept/findById/"+id, HttpMethod.GET,request,Dept.class).getBody();
        return dept;
    }

    /**
     * 查找所有部门信息
     * @return
     */
    @RequestMapping("/dept/list")
    @ResponseBody
    public Object list(){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        List<Dept> depts = restTemplate.exchange("http://dept8010/dept/list/",HttpMethod.GET,request,List.class).getBody();
        return depts;
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @RequestMapping("/dept/add")
    @ResponseBody
    public Object add(Dept dept){
        HttpEntity<Object> request = new HttpEntity<Object>(dept,headers);
        boolean flag = restTemplate.exchange("http://dept8010/dept/add/",HttpMethod.POST,request,Boolean.class).getBody();
        return flag;
    }

    /**
     * 部门添加页面
     * @param request
     * @return
     */
    @RequestMapping("/dept/toAdddept")
    public String toAddDept(HttpServletRequest request){
        return "html/dept/addDept";
    }

}
