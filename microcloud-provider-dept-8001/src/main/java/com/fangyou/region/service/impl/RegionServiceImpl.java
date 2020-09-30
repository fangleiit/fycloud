package com.fangyou.region.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fangyou.dept.entity.TCodeRegionEntity;
import com.fangyou.entity.TCodeRegionVo;
import com.fangyou.region.mapper.RegionMapper;
import com.fangyou.region.service.IRegionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RegionServiceImpl extends ServiceImpl<RegionMapper, TCodeRegionEntity> implements IRegionService {

    @Resource
    private RegionMapper regionMapper;

    @Override
    public List<TCodeRegionEntity> treeTcodeRegionList(Integer id) {
        LambdaQueryWrapper<TCodeRegionEntity> wrapper = Wrappers.<TCodeRegionEntity>query().lambda();
        List<TCodeRegionEntity> tcodeRegionList = regionMapper.selectList(wrapper);
        List<TCodeRegionEntity> tcodeRegionTreeList = buildTree(tcodeRegionList,id);
        return tcodeRegionTreeList;

    }

    private List<TCodeRegionEntity> buildTree(List<TCodeRegionEntity> tcodeRegionList, Integer pId) {
        List<TCodeRegionEntity> treeList = new ArrayList<>();
        for(TCodeRegionEntity tcr : tcodeRegionList){
            if(tcr.getParentId().equals(pId)){
                tcr.setChild(buildTree(tcodeRegionList,tcr.getId()));
                treeList.add(tcr);
            }
        }
        return treeList;
    }
}
