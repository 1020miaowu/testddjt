package com.sudytech.ddjt.sdo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 尹文豪
 * 活动成员表
 */
@TableName(value ="t_ddxt_hdcy")
@Data
public class THdxtHdcy {
    /**
     *  活动成员主键id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     *  活动申请id（外键）
     */
    @TableField(value = "hdsq_id")
    private String hdsqId;
    /**
     *  参与人员id
     */
    @TableField(value = "userid")
    private String userid;
    /**
     *  签到时间
     */
    @TableField(value = "qdsj")
    private String qdsj;
    /**
     *  签退时间
     */
    @TableField(value = "qtsj")
    private String qtsj;
}
