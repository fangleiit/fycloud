package com.fangyou.region.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangyou.dept.entity.TCodeRegionEntity;

import java.util.List;

public interface IRegionService extends IService<TCodeRegionEntity> {

    List<TCodeRegionEntity> treeTcodeRegionList(Integer id);
}
