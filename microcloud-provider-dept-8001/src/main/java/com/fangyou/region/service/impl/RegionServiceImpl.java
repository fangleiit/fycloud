package com.fangyou.region.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fangyou.region.entity.CodeRegionEntity;
import com.fangyou.region.mapper.RegionMapper;
import com.fangyou.region.service.IRegionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RegionServiceImpl extends ServiceImpl<RegionMapper, CodeRegionEntity> implements IRegionService {

    @Resource
    private RegionMapper regionMapper;

    @Override
    public List<CodeRegionEntity> treeTcodeRegionList(Integer id) {
        LambdaQueryWrapper<CodeRegionEntity> wrapper = Wrappers.<CodeRegionEntity>query().lambda();
        List<CodeRegionEntity> tcodeRegionList = regionMapper.selectList(wrapper);
        List<CodeRegionEntity> tcodeRegionTreeList = buildTree(tcodeRegionList,id);
        return tcodeRegionTreeList;

    }

    private List<CodeRegionEntity> buildTree(List<CodeRegionEntity> tcodeRegionList, Integer pId) {
        List<CodeRegionEntity> treeList = new ArrayList<>();
        for(CodeRegionEntity tcr : tcodeRegionList){
            if(tcr.getParentId().equals(pId)){
                tcr.setChild(buildTree(tcodeRegionList,tcr.getId()));
                treeList.add(tcr);
            }
        }
        return treeList;
    }
}
