package com.fangyou.region.controller;

import com.fangyou.dept.entity.TCodeRegionEntity;
import com.fangyou.entity.TCodeRegionVo;
import com.fangyou.region.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private IRegionService regionService;

    @RequestMapping("/region/treeList")
    public List<TCodeRegionEntity> treeTcodeRegionList(){
        return regionService.treeTcodeRegionList(0);
    }

}
