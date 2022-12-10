package com.sudytech.ddjt.controller;

import camundajar.impl.scala.Int;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sudytech.base.mvc.TypedResult;
import com.sudytech.ddjt.sdo.THdxtHdcy;
import com.sudytech.ddjt.sdo.THdxtHdfl;
import com.sudytech.ddjt.sdo.THdxtHdsq;
import com.sudytech.ddjt.service.DictUtilsService;
import com.sudytech.ddjt.service.THdxtHdcyService;
import com.sudytech.ddjt.service.THdxtHdflService;
import com.sudytech.ddjt.service.THdxtHdsqService;
import com.sudytech.ddjt.vo.EventDetail;
import com.sudytech.ddjt.vo.MyQueryResult;
import com.sudytech.ddjt.vo.THdxtHdcyResult;
import com.sudytech.log.ILog;
import com.sudytech.log.LogFactory;
import com.sudytech.security.ids.SSOUser;
import com.sudytech.system.CoreRequestContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.sudytech.audit.util.AuditLogUtil.getCurrentUser;

/**
 * @author 尹文豪
 * 模块：道德讲堂管理系统
 * 我参与的活动
 * id相关的int
 */
@RequestMapping(path = "/ddjt/api/")
@RestController
public class DdjtController {
    // 页面分析
    // 导出按钮，按活动时间倒序排序，查看按钮，重置，查询按钮，搜索条件：学年（字典），活动主题
    /**
     *  开启日志
     */
    private ILog _log = LogFactory.getInstance().getLog(DdjtController.class);

    @Autowired
    private DictUtilsService dictUtilsService;


    /**
     *  活动分类
     */
    private THdxtHdflService tHdxtHdflService;

    /**
     *  活动申请
     */
    private THdxtHdsqService tHdxtHdsqService;

    /**
     *  活动成员
     */
    private THdxtHdcyService tHdxtHdcyService;

    // 列表展示
    @GetMapping("queryDdjt")
    /**
     *   传参：学年，活动主题，分页
     *   返回序号，id，学年，活动主题，开始时间，结束时间，活动地点，签到时间
     *   查活动成员表，然后通过活动申请id外键查询活动申请表数据。
     */
    public TypedResult<List<MyQueryResult>> queryDdjt(String xn, String hdzt, Integer pageNo, Integer pageSize) {
        // 验证是否登录
        SSOUser ssoUser = getCurrentUser();
        if(null == ssoUser || ssoUser.isAnonymous()){
            return TypedResult.error(-200,"人员未登录！");
        }
        // 验证是否有访问权限
        SSOUser ssoUser2 = CoreRequestContextUtil.getCoreRequestContext().getCurrentUser();
        if (ssoUser2.isAnonymous() || ssoUser2.getUser() == null) {
            return TypedResult.error("无权限访问");
        }
        // 不需要验证查询条件
        // 分页
        if (pageNo == null){
            pageNo = -1;
            pageSize = -1;
        }
        // 根据xn，hdzt查询我参与的活动
        List<MyQueryResult> data =tHdxtHdflService.queryDdjt();
        // 获取总数
        int total = data.size();
        //总页数
        int pageSum = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        //分页
        List<MyQueryResult> subList = data.stream().skip((pageNo - 1) * pageSize).limit(pageSize).
                collect(Collectors.toList());
        return TypedResult.success(total, subList);
    }

    // 导出接口
    // 暂时不做


    /**
     *  查看详情接口
     *  返回数据：申报学院，申请人，负责人，负责人联系方式，主讲人，主讲人联系方式，活动地点，时间，专题，主题，概述
     *  需要参数，活动申请id。通过活动申请id分别查询参与成员表和活动申请表
     */
    @GetMapping
    private TypedResult<EventDetail> eventDetails(Integer id){
        // 验证是否登录
        SSOUser ssoUser = getCurrentUser();
        if(null == ssoUser || ssoUser.isAnonymous()){
            return TypedResult.error(-200,"人员未登录！");
        }
        // 验证是否有访问权限
        SSOUser ssoUser2 = CoreRequestContextUtil.getCoreRequestContext().getCurrentUser();
        if (ssoUser2.isAnonymous() || ssoUser2.getUser() == null) {
            return TypedResult.error("无权限访问");
        }
        // 新建个对象作为结果
        EventDetail eventDetail = new EventDetail();
        // 通过活动申请id，获得活动申请表中全部信息
        THdxtHdsq applicationInfo = tHdxtHdsqService.getById(id);
        // 通过活动申请id，获得参与的所有成员
        List<THdxtHdcyResult> activeMembers = tHdxtHdcyService.obtainBySqId(id);
        // 存放参数
        // 活动分类id
        eventDetail.setActClassification(applicationInfo.getHdflId());
        // 活动专题
        eventDetail.setActSpecial(applicationInfo.getHdzt());
        // 活动主题/标题
        eventDetail.setActTopic(applicationInfo.getHdbt());
        // 活动地点
        eventDetail.setActPlace(applicationInfo.getHddd());
        // 负责人
        eventDetail.setHead(applicationInfo.getFzrmc());
        // 负责人联系电话
        eventDetail.setHeadMobile(applicationInfo.getFzrlxdh());
        // 主讲人
        eventDetail.setSpeaker(applicationInfo.getZjrmc());
        // 主讲人联系方式
        eventDetail.setSpeakerMobile(applicationInfo.getZjrlxdh());
        // 活动开始时间
        eventDetail.setStartTime(applicationInfo.getHdkssj());
        // 活动结束时间
        eventDetail.setEndTime(applicationInfo.getHdjssj());
        // 活动宣传图，附件
        eventDetail.setActImage(applicationInfo.getHdxct());
        // 活动概述
        eventDetail.setActOverview(applicationInfo.getHdgs());
        // 附件
        eventDetail.setAnnex(applicationInfo.getFj());
        // 参与成员
        eventDetail.setPartMembers(activeMembers);
        return TypedResult.success(eventDetail);
    }

}
