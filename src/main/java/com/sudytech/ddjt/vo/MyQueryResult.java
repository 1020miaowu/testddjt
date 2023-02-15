package com.sudytech.ddjt.vo;

import lombok.Data;

/**
 * @author 尹文豪
 * 我参与的活动页面返回实体类
 */
@Data
public class MyQueryResult {
    /**
     *  id
     */
    private Integer id;
    /**
     *  参与人员id
     */
    private Integer userid;
    /**
     *  活动申请id
     */
    private Integer hdsqId;
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
    private String hdkssj;
    /**
     *  结束时间
     */
    private String dhjssj;
    /**
     *  活动地点
     */
    private String hddd;
    /**
     *  签到时间
     */
    private String ddsj;

}
