package com.sudytech.ddjt.vo;

import lombok.Data;

/**
 *  新增
 *  提供申请人，申请学院，申请人联系方式，申请时间，活动分类，活动专题，活动主题，活动地点，负责人，负责人联系方式，主讲人，主讲人联系方式。活动开始时间，活动结束时间，活动宣传图，活动概述，附件，提交方式
 * @author 尹文豪
 */
@Data
public class SqRequest {
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
     *  申请人
     */
    private String appPerson;
    /**
     *  申请学院
     */
    private String appAcademy;
    /**
     *  申请人联系方式
     */
    private String appMobile;
    /**
     *  申请时间
     */
    private String appTime;
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
}
