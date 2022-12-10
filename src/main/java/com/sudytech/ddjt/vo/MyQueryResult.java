package com.sudytech.ddjt.vo;

import lombok.Data;

/**
 * @author 尹文豪
 * 我参与的活动页面返回实体类
 */
@Data
public class MyQueryResult {
    /**
     *  参与人员id
     */
    private Integer userid;
    /**
     *  活动申请id
     */
    private Integer hdsqId;
    /**
     *  序号
     */
    private Integer sn;
    /**
     *  学年
     */
    private String xn;
    /**
     *  活动主题
     */
    private String bhzt;
    /**
     *  开始时间
     */
    private String kssj;
    /**
     *  结束时间
     */
    private String jssj;
    /**
     *  活动地点
     */
    private String hddd;
    /**
     *  签到时间
     */
    private String ddsj;

}
