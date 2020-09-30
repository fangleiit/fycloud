package com.fangyou.sysuser.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fangyou.vo.dept.DeptVo;
import com.fangyou.vo.region.TCodeRegionVo;
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
        DeptVo dept = JSONObject.parseObject(JSON.toJSONString(restTemplate.exchange("http://dept8010/dept/findById/"+id, HttpMethod.GET,request, DeptVo.class).getBody()),DeptVo.class);
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
        List<DeptVo> depts = JSONObject.parseArray(JSON.toJSONString(restTemplate.exchange("http://dept8010/dept/list/",HttpMethod.GET,request,List.class).getBody()),DeptVo.class);
        return depts;
    }

    /**
     * 查找行政区划
     * @return
     */
    @RequestMapping("/region/treeList")
    @ResponseBody
    public Object treeList(){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        List<TCodeRegionVo> tcodeRegionList =
                JSONObject.parseArray(JSON.toJSONString(restTemplate.exchange("http://dept8010/region/treeList/",HttpMethod.GET,request,List.class).getBody()),TCodeRegionVo.class);
        return tcodeRegionList;
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @RequestMapping("/dept/add")
    @ResponseBody
    public Object add(DeptVo dept){
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