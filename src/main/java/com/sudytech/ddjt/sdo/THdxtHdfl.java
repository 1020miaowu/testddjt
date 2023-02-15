package com.sudytech.ddjt.sdo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sudytech.appware.baseservice.submit.sdo.DefaultFormObject;
import com.sudytech.appware.customprocess.pojo.CustProcessFormObject;
import com.sudytech.appware.processService.extbootscan.StaticSrpingContext;
import com.sudytech.ddjt.service.THdxtHdflService;
import lombok.Data;

/**
 * 活动分类
 * @TableName T_HDXT_HDFL
 */
@TableName(value ="T_HDXT_HDFL")
@Data
public class THdxtHdfl extends DefaultFormObject implements Serializable {
    /**
     * 活动分类主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类代码
     */
    @TableField(value = "FLDM")
    private String fldm;

    /**
     * 分类名称
     */
    @TableField(value = "FLMC")
    private String flmc;

    /**
     * 管理人员id
     */
    @TableField(value = "USERID")
    private Integer userid;

    /**
     * 排序
     */
    @TableField(value = "PX")
    private Integer px;

    /**
     * 状态，数据字典（启用/禁用）
     */
    @TableField(value = "ZT")
    private String zt;

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
        THdxtHdfl other = (THdxtHdfl) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFldm() == null ? other.getFldm() == null : this.getFldm().equals(other.getFldm()))
            && (this.getFlmc() == null ? other.getFlmc() == null : this.getFlmc().equals(other.getFlmc()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getPx() == null ? other.getPx() == null : this.getPx().equals(other.getPx()))
            && (this.getZt() == null ? other.getZt() == null : this.getZt().equals(other.getZt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFldm() == null) ? 0 : getFldm().hashCode());
        result = prime * result + ((getFlmc() == null) ? 0 : getFlmc().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getPx() == null) ? 0 : getPx().hashCode());
        result = prime * result + ((getZt() == null) ? 0 : getZt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fldm=").append(fldm);
        sb.append(", flmc=").append(flmc);
        sb.append(", userid=").append(userid);
        sb.append(", px=").append(px);
        sb.append(", zt=").append(zt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    static THdxtHdflService tHdxtHdflService;
    public THdxtHdfl(){
        if(null == tHdxtHdflService){
            tHdxtHdflService = StaticSrpingContext.getContext().getBean(THdxtHdflService.class);
        }
    }
    @Override
    public BaseMapper getBusinessMapper() {
        return tHdxtHdflService.getBaseMapper();
    }


}