package com.fangyou.vo.region;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class TCodeRegionVo implements Serializable {
    private static final long serialVersionUID = 4546275918571103899L;
    private Integer id;
    private Integer parentId;
    private String name;
    private List<TCodeRegionVo> child = new ArrayList<TCodeRegionVo>();
}
