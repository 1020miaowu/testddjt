package com.sudytech.ddjt.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author 尹文豪
 * 参与人员返回
 */
@Data
public class THdxtHdcyResult {
    /**
     *  姓名
     */
    private String studentName;

    /**
     * userId
     */
    private Integer userId;
    /**
     *  学工号
     */
    private String studentNumber;
    /**
     *  学院/部门
     */
    private String academy;
    /**
     *  专业
     */
    private String specialized;
    /**
     *  班级
     */
    private String classroom;
    /**
     *  年级
     */
    private String grade;
    /**
     *  签到时间
     */
    private Date checkInTime;
    /**
     *  签退时间
     */
    private Date outInTime;
}
