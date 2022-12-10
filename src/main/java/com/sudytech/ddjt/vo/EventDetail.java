package com.sudytech.ddjt.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 尹文豪
 * 活动详情返回结果实体类
 */
@Data
public class EventDetail {

    /**
     *  活动分类
     */
    private String actClassification;
    /**
     *  活动专题
     */
    private String actSpecial;
    /**
     *  活动主题/标题
     */
    private String actTopic;
    /**
     *  活动地点
     */
    private String actPlace;
    /**
     *  负责人
     */
    private String head;
    /**
     *  负责人联系方式
     */
    private String headMobile;
    /**
     *  主讲人
     */
    private String speaker;
    /**
     *  主讲人联系方式
     */
    private String speakerMobile;
    /**
     *  活动开始时间
     */
    private String startTime;
    /**
     *  活动结束时间
     */
    private String endTime;
    /**
     *  活动宣传图
     */
    private String actImage;
    /**
     *  活动概述
     */
    private String actOverview;
    /**
     *  附件
     */
    private String annex;
    /**
     *  参与成员
     */
    private List<THdxtHdcyResult> partMembers;
}
