package com.sudytech.ddjt.sdo;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sudytech.appware.baseservice.standard.service.SchoolYearService;
import com.sudytech.appware.customprocess.pojo.CustProcessDefaultFormObject;
import com.sudytech.appware.customprocess.pojo.CustProcessFormObject;
import com.sudytech.appware.processService.extbootscan.StaticSrpingContext;
import com.sudytech.ddjt.service.THdxtHdsqService;
import com.sudytech.kns.sdo.NeedyStudentsApply;
import com.sudytech.kns.service.NeedyStudentsApplyService;
import com.sudytech.security.ids.SSOUser;
import com.sudytech.system.CoreRequestContextUtil;
import com.sudytech.zhxg.student.service.StudentInfoService;
import com.sudytech.zhxg.student.vo.StudentInfoVO;
import lombok.Data;

/**
 * 活动申请
 * @TableName T_HDXT_HDSQ
 */
@TableName(value ="T_HDXT_HDSQ")
@Data
public class THdxtHdsq extends CustProcessDefaultFormObject implements Serializable {
    /**
     * 活动申请id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 流程定义ID
     */
    @TableField(value = "PROCESSDEFID")
    private String processDeFid;

    /**
     * 业务规则ID
     */
    @TableField(value = "BUSINESSID")
    private Integer businessId;

    /**
     * 环节ID
     */
    @TableField(value = "ACTIVITYID")
    private Integer activityId;

    /**
     * 环节定义ID
     */
    @TableField(value = "ACTIVITYDEFID")
    private String activitydefId;

    /**
     * 环节定义名称
     */
    @TableField(value = "ACTIVITYDEFNAME")
    private String activityDefName;

    /**
     * 申请人学院ID
     */
    @TableField(value = "ORGID")
    private Integer orgId;

    /**
     * 申请人学院名称
     */
    @TableField(value = "ORGNAME")
    private String orgName;

    /**
     * 申请人学院代码
     */
    @TableField(value = "ORGCODE")
    private String orgCode;

    /**
     * 申请人班级代码
     */
    @TableField(value = "CLASSCODE")
    private String classCode;

    /**
     * 申请人班级名称
     */
    @TableField(value = "CLASSFNAME")
    private String classFName;

    /**
     * 申请人专业代码
     */
    @TableField(value = "MAJORCODE")
    private String majorCode;

    /**
     * 申请人专业名称
     */
    @TableField(value = "MAJORNAME")
    private String majorName;

    /**
     * 申请人ID
     */
    @TableField(value = "APPLYUSERID")
    private Integer applyUserId;

    /**
     * 申请人姓名
     */
    @TableField(value = "APPLYUSERNAME")
    private String applyUserName;

    /**
     * 申请人学号
     */
    @TableField(value = "APPLYUSERCODE")
    private String applyUserCode;

    /**
     * 申请时间
     */
    @TableField(value = "APPLYTIME")
    private Date applyTime;

    /**
     * 申请人手机号
     */
    @TableField(value = "PHONE")
    private String phone;

    /**
     * 流程状态：-1草稿0未处理1办理中2已完成3已终止
     */
    @TableField(value = "STATUS")
    private Integer status;

    /**
     * 学年
     */
    @TableField(value = "XN")
    private String xn;

    /**
     * 活动分类id
     */
    @TableField(value = "HDFLID")
    private Integer hdflid;

    /**
     * 活动专题，数据字典
     */
    @TableField(value = "HDZT")
    private String hdzt;

    /**
     * 活动主题/标题
     */
    @TableField(value = "HDBT")
    private String hdbt;

    /**
     * 活动地点
     */
    @TableField(value = "HDDD")
    private String hddd;

    /**
     * 负责人名称
     */
    @TableField(value = "FZRMC")
    private String fzrmc;

    /**
     * 负责人联系电话
     */
    @TableField(value = "FZRLXDH")
    private String fzrlxdh;

    /**
     * 主讲人名称
     */
    @TableField(value = "ZJRMC")
    private String zjrmc;

    /**
     * 主讲人联系电话
     */
    @TableField(value = "ZJRLXDH")
    private String zjrlxdh;

    /**
     * 活动开始时间
     */
    @TableField(value = "HDKSSJ")
    private Date hdkssj;

    /**
     * 活动结束时间
     */
    @TableField(value = "DHJSSJ")
    private Date dhjssj;

    /**
     * 活动宣传图，附件
     */
    @TableField(value = "HDXCT")
    private String hdxct;

    /**
     * 活动概述
     */
    @TableField(value = "HDGS")
    private String hdgs;

    /**
     * 附件
     */
    @TableField(value = "FJ")
    private String fj;

    /**
     * 办理人
     */
    @TableField(value = "BLR")
    private String blr;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        THdxtHdsq other = (THdxtHdsq) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProcessDeFid() == null ? other.getProcessDeFid() == null : this.getProcessDeFid().equals(other.getProcessDeFid()))
            && (this.getBusinessId() == null ? other.getBusinessId() == null : this.getBusinessId().equals(other.getBusinessId()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getActivitydefId() == null ? other.getActivitydefId() == null : this.getActivitydefId().equals(other.getActivitydefId()))
            && (this.getActivityDefName() == null ? other.getActivityDefName() == null : this.getActivityDefName().equals(other.getActivityDefName()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getClassCode() == null ? other.getClassCode() == null : this.getClassCode().equals(other.getClassCode()))
            && (this.getClassFName() == null ? other.getClassFName() == null : this.getClassFName().equals(other.getClassFName()))
            && (this.getMajorCode() == null ? other.getMajorCode() == null : this.getMajorCode().equals(other.getMajorCode()))
            && (this.getMajorName() == null ? other.getMajorName() == null : this.getMajorName().equals(other.getMajorName()))
            && (this.getApplyUserId() == null ? other.getApplyUserId() == null : this.getApplyUserId().equals(other.getApplyUserId()))
            && (this.getApplyUserName() == null ? other.getApplyUserName() == null : this.getApplyUserName().equals(other.getApplyUserName()))
            && (this.getApplyUserCode() == null ? other.getApplyUserCode() == null : this.getApplyUserCode().equals(other.getApplyUserCode()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getXn() == null ? other.getXn() == null : this.getXn().equals(other.getXn()))
            && (this.getHdflid() == null ? other.getHdflid() == null : this.getHdflid().equals(other.getHdflid()))
            && (this.getHdzt() == null ? other.getHdzt() == null : this.getHdzt().equals(other.getHdzt()))
            && (this.getHdbt() == null ? other.getHdbt() == null : this.getHdbt().equals(other.getHdbt()))
            && (this.getHddd() == null ? other.getHddd() == null : this.getHddd().equals(other.getHddd()))
            && (this.getFzrmc() == null ? other.getFzrmc() == null : this.getFzrmc().equals(other.getFzrmc()))
            && (this.getFzrlxdh() == null ? other.getFzrlxdh() == null : this.getFzrlxdh().equals(other.getFzrlxdh()))
            && (this.getZjrmc() == null ? other.getZjrmc() == null : this.getZjrmc().equals(other.getZjrmc()))
            && (this.getZjrlxdh() == null ? other.getZjrlxdh() == null : this.getZjrlxdh().equals(other.getZjrlxdh()))
            && (this.getHdkssj() == null ? other.getHdkssj() == null : this.getHdkssj().equals(other.getHdkssj()))
            && (this.getDhjssj() == null ? other.getDhjssj() == null : this.getDhjssj().equals(other.getDhjssj()))
            && (this.getHdxct() == null ? other.getHdxct() == null : this.getHdxct().equals(other.getHdxct()))
            && (this.getHdgs() == null ? other.getHdgs() == null : this.getHdgs().equals(other.getHdgs()))
            && (this.getFj() == null ? other.getFj() == null : this.getFj().equals(other.getFj()))
            && (this.getBlr() == null ? other.getBlr() == null : this.getBlr().equals(other.getBlr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProcessDeFid() == null) ? 0 : getProcessDeFid().hashCode());
        result = prime * result + ((getBusinessId() == null) ? 0 : getBusinessId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getActivitydefId() == null) ? 0 : getActivitydefId().hashCode());
        result = prime * result + ((getActivityDefName() == null) ? 0 : getActivityDefName().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getClassCode() == null) ? 0 : getClassCode().hashCode());
        result = prime * result + ((getClassFName() == null) ? 0 : getClassFName().hashCode());
        result = prime * result + ((getMajorCode() == null) ? 0 : getMajorCode().hashCode());
        result = prime * result + ((getMajorName() == null) ? 0 : getMajorName().hashCode());
        result = prime * result + ((getApplyUserId() == null) ? 0 : getApplyUserId().hashCode());
        result = prime * result + ((getApplyUserName() == null) ? 0 : getApplyUserName().hashCode());
        result = prime * result + ((getApplyUserCode() == null) ? 0 : getApplyUserCode().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getXn() == null) ? 0 : getXn().hashCode());
        result = prime * result + ((getHdflid() == null) ? 0 : getHdflid().hashCode());
        result = prime * result + ((getHdzt() == null) ? 0 : getHdzt().hashCode());
        result = prime * result + ((getHdbt() == null) ? 0 : getHdbt().hashCode());
        result = prime * result + ((getHddd() == null) ? 0 : getHddd().hashCode());
        result = prime * result + ((getFzrmc() == null) ? 0 : getFzrmc().hashCode());
        result = prime * result + ((getFzrlxdh() == null) ? 0 : getFzrlxdh().hashCode());
        result = prime * result + ((getZjrmc() == null) ? 0 : getZjrmc().hashCode());
        result = prime * result + ((getZjrlxdh() == null) ? 0 : getZjrlxdh().hashCode());
        result = prime * result + ((getHdkssj() == null) ? 0 : getHdkssj().hashCode());
        result = prime * result + ((getDhjssj() == null) ? 0 : getDhjssj().hashCode());
        result = prime * result + ((getHdxct() == null) ? 0 : getHdxct().hashCode());
        result = prime * result + ((getHdgs() == null) ? 0 : getHdgs().hashCode());
        result = prime * result + ((getFj() == null) ? 0 : getFj().hashCode());
        result = prime * result + ((getBlr() == null) ? 0 : getBlr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", processDeFid=").append(processDeFid);
        sb.append(", businessId=").append(businessId);
        sb.append(", activityId=").append(activityId);
        sb.append(", activitydefId=").append(activitydefId);
        sb.append(", activityDefName=").append(activityDefName);
        sb.append(", orgId=").append(orgId);
        sb.append(", orgName=").append(orgName);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", classCode=").append(classCode);
        sb.append(", classFName=").append(classFName);
        sb.append(", majorCode=").append(majorCode);
        sb.append(", majorName=").append(majorName);
        sb.append(", applyUserId=").append(applyUserId);
        sb.append(", applyUserName=").append(applyUserName);
        sb.append(", applyUserCode=").append(applyUserCode);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", xn=").append(xn);
        sb.append(", hdflid=").append(hdflid);
        sb.append(", hdzt=").append(hdzt);
        sb.append(", hdbt=").append(hdbt);
        sb.append(", hddd=").append(hddd);
        sb.append(", fzrmc=").append(fzrmc);
        sb.append(", fzrlxdh=").append(fzrlxdh);
        sb.append(", zjrmc=").append(zjrmc);
        sb.append(", zjrlxdh=").append(zjrlxdh);
        sb.append(", hdkssj=").append(hdkssj);
        sb.append(", dhjssj=").append(dhjssj);
        sb.append(", hdxct=").append(hdxct);
        sb.append(", hdgs=").append(hdgs);
        sb.append(", fj=").append(fj);
        sb.append(", blr=").append(blr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    static THdxtHdsqService tHdxtHdsqService;
    public THdxtHdsq(){
        if(null == tHdxtHdsqService){
            tHdxtHdsqService = StaticSrpingContext.getContext().getBean(THdxtHdsqService.class);
        }
    }
    @Override
    public BaseMapper getBusinessMapper() {
        return tHdxtHdsqService.getBaseMapper();
    }

    @Override
    public Integer getBusinessId(CustProcessFormObject formObject) {
        return this.getBusinessId();
    }

    //放入基础数据
}