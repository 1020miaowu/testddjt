package com.sudytech.ddjt.sdo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sudytech.appware.baseservice.submit.sdo.DefaultFormObject;
import com.sudytech.appware.customprocess.pojo.CustProcessFormObject;
import com.sudytech.appware.processService.extbootscan.StaticSrpingContext;
import com.sudytech.ddjt.service.THdxtHdcyService;
import lombok.Data;

/**
 * 活动成员
 * @TableName T_HDXT_HDCY
 */
@TableName(value ="T_HDXT_HDCY")
@Data
public class THdxtHdcy extends DefaultFormObject implements Serializable {
    /**
     * 活动成员主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动申请id（外键）
     */
    @TableField(value = "HDSQID")
    private Integer hdsqid;

    /**
     * 参与人员id
     */
    @TableField(value = "USERID")
    private Integer userid;

    /**
     * 签到时间
     */
    @TableField(value = "QDSJ")
    private Date qdsj;

    /**
     * 签退时间
     */
    @TableField(value = "QTSJ")
    private Date qtsj;

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
        THdxtHdcy other = (THdxtHdcy) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHdsqid() == null ? other.getHdsqid() == null : this.getHdsqid().equals(other.getHdsqid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getQdsj() == null ? other.getQdsj() == null : this.getQdsj().equals(other.getQdsj()))
            && (this.getQtsj() == null ? other.getQtsj() == null : this.getQtsj().equals(other.getQtsj()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHdsqid() == null) ? 0 : getHdsqid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getQdsj() == null) ? 0 : getQdsj().hashCode());
        result = prime * result + ((getQtsj() == null) ? 0 : getQtsj().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hdsqid=").append(hdsqid);
        sb.append(", userid=").append(userid);
        sb.append(", qdsj=").append(qdsj);
        sb.append(", qtsj=").append(qtsj);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    static THdxtHdcyService tHdxtHdcyService;
    public THdxtHdcy(){
        if(null == tHdxtHdcyService){
            tHdxtHdcyService = StaticSrpingContext.getContext().getBean(THdxtHdcyService.class);
        }
    }
    @Override
    public BaseMapper getBusinessMapper() {
        return tHdxtHdcyService.getBaseMapper();
    }
}