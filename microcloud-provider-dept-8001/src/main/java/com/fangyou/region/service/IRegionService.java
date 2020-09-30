package com.fangyou.region.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangyou.region.entity.CodeRegionEntity;

import java.util.List;

public interface IRegionService extends IService<CodeRegionEntity> {

    List<CodeRegionEntity> treeTcodeRegionList(Integer id);
}
