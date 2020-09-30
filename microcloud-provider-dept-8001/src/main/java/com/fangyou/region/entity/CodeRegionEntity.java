package com.fangyou.region.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@TableName("t_code_region")
public class CodeRegionEntity implements Serializable {
    private static final long serialVersionUID = -5173604929330767088L;
    private Integer id;
    private Integer parentId;
    private String name;
    @TableField(exist = false)
    private List<CodeRegionEntity> child = new ArrayList<CodeRegionEntity>();
}
