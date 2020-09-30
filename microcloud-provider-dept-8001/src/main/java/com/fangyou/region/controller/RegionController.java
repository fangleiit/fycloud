package com.fangyou.region.controller;

import com.fangyou.region.entity.CodeRegionEntity;
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
    public List<CodeRegionEntity> treeTcodeRegionList(){
        return regionService.treeTcodeRegionList(0);
    }

}
