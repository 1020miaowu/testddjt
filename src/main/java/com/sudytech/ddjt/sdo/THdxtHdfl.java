package com.sudytech.ddjt.sdo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 尹文豪
 * 活动分类表
 */
@TableName(value ="t_ddxt_hdfl")
@Data
public class THdxtHdfl {
    /**
     *  活动分类主键id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     *  活动申请id（外键）
     */
    @TableField(value = "hdsq_id")
    private String hdsqId;
    /**
     *  管理人员id
     */
    @TableField(value = "userid")
    private String userid;
    /**
     *  排序
     */
    @TableField(value = "px")
    private String px;
    /**
     *  状态，数据字典（启用/禁用）
     */
    @TableField(value = "zt")
    private String zt;
}
