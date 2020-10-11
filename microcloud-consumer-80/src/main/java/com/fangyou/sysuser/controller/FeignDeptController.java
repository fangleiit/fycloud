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
import java.util.List;

@Controller
public class FeignDeptController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;

    public static final String GATWAYURL = "http://gateway5555:5555/api-feigndept";

    /**
     * 查找所有部门信息
     * @return
     */
    @RequestMapping("/hello/dept/list")
    @ResponseBody
    public Object feignGetDeptList(){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        List<DeptVo> depts = JSONObject.parseArray(JSON.toJSONString(restTemplate.exchange(GATWAYURL + "/feign-deptList/", HttpMethod.GET,request,List.class).getBody()),DeptVo.class);
        return depts;
    }


    /**
     * 查找所有部门信息
     * @return
     */
    @RequestMapping("/hello/region/treelist")
    @ResponseBody
    public Object helloGetRegion(){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        List<TCodeRegionVo> tcodeRegionList =
                JSONObject.parseArray(JSON.toJSONString(restTemplate.exchange(GATWAYURL + "/feign-regiontreeList/",HttpMethod.GET,request,List.class).getBody()),TCodeRegionVo.class);
        return tcodeRegionList;
    }

}
