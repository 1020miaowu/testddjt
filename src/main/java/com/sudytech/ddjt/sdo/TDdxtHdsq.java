package com.sudytech.ddjt.sdo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sudytech.appware.baseservice.submit.sdo.DefaultFormObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 尹文豪
 *
 */
@TableName(value ="t_ddxt_hdsq")
@Data
public class TDdxtHdsq extends DefaultFormObject implements Serializable {
    /**
     *  主键id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     *  流程定义名称
     */
    @TableField(value = "processde")
    private String processde;
    /**
     *  流程id
     */
    @TableField(value = "lcid")
    private String lcid;
    /**
     *  当前环节步骤
     */
    @TableField(value = "dqhjbz")
    private String dqhjbz;
    /**
     *  当前环节名称
     */
    @TableField(value = "dqhjmc")
    private String dqhjmc;
    /**
     *  部门/学院id
     */
    @TableField(value = "bm_id")
    private String bmId;
    /**
     *  部门名称
     */
    @TableField(value = "bm_mc")
    private String bmMc;
    /**
     *  部门代码
     */
    @TableField(value = "bm_dm")
    private String bmDm;
    /**
     *  班级代码
     */
    @TableField(value = "bjdm")
    private String bjdm;
    /**
     *  专业代码
     */
    @TableField(value = "zydm")
    private String zydm;
    /**
     *  申请人id
     */
    @TableField(value = "sqrid")
    private String sqrid;
    /**
     *  申请人名称
     */
    @TableField(value = "sqrmc")
    private String sqrmc;
    /**
     *  申请人工号
     */
    @TableField(value = "sqrgh")
    private String sqrgh;
    /**
     *  申请时间
     */
    @TableField(value = "sqsj")
    private String sqsj;
    /**
     *  联系电话（手机号）
     */
    @TableField(value = "lxdh")
    private String lxdh;
    /**
     *  流程状态： -1 草稿，0未处理，1办理中，2已办结（审核通过），3已终止（审核不通过）
     */
    @TableField(value = "lczt")
    private String lczt;
    /**
     *  学年
     */
    @TableField(value = "xn")
    private String xn;
    /**
     *  活动分类id
     */
    @TableField(value = "hdfl_id")
    private String hdflId;
    /**
     *  活动专题，数据字典
     */
    @TableField(value = "hdzt")
    private String hdzt;
    /**
     *  活动主题/标题
     */
    @TableField(value = "hdbt")
    private String hdbt;
    /**
     *  活动地点
     */
    @TableField(value = "hddd")
    private String hddd;
    /**
     *  负责人名称
     */
    @TableField(value = "fzrmc")
    private String fzrmc;
    /**
     *  负责人联系电话
     */
    @TableField(value = "fzrlxdh")
    private String fzrlxdh;
    /**
     *  主讲人名称
     */
    @TableField(value = "zjrmc")
    private String zjrmc;
    /**
     *  主讲人联系电话
     */
    @TableField(value = "zjrlxdh")
    private String zjrlxdh;
    /**
     *  活动开始时间
     */
    @TableField(value = "hdkssj")
    private String hdkssj;
    /**
     *  活动结束时间
     */
    @TableField(value = "hdjssj")
    private String hdjssj;
    /**
     *  活动宣传图，附件
     */
    @TableField(value = "hdxct")
    private String hdxct;
    /**
     *  活动概述
     */
    @TableField(value = "hdgs")
    private String hdgs;
    /**
     *  附件
     */
    @TableField(value = "fj")
    private String fj;







}
