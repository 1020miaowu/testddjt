package com.sudytech.ddjt.controller;

import com.sudytech.base.mvc.TypedResult;
import com.sudytech.ddjt.sdo.THdxtHdsq;
import com.sudytech.ddjt.service.THdxtHdsqService;
import com.sudytech.log.ILog;
import com.sudytech.log.LogFactory;
import com.sudytech.security.ids.SSOUser;
import com.sudytech.system.CoreRequestContextUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

import static com.sudytech.audit.util.AuditLogUtil.getCurrentUser;

/**
 * @author 尹文豪
 * 活动申请
 * 搜索框：学年，活动主题，流程状态
 * 搜索，修改，删除，查看，新增，导出
 */
@RequestMapping(path = "/ddjt/api/sq")
@RestController
public class DdjtsqController {
    /**
     *  开启日志
     */
    private ILog _log = LogFactory.getInstance().getLog(DdjtController.class);

    THdxtHdsqService tHdxtHdsqService;

    /**
     *  新增
     *  提供申请人，申请学院，申请人联系方式，申请时间，活动分类，活动专题，活动主题，活动地点，负责人，负责人联系方式，主讲人，主讲人联系方式。活动开始时间，活动结束时间，活动宣传图，活动概述，附件，提交方式(放到流程里面)
     */
    @PostMapping("addSq")
    public TypedResult<Object> addSq(THdxtHdsq tHdxtHdsq) {
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
        // 记录到申请表里面,
        if (tHdxtHdsqService.save(tHdxtHdsq)){
        return TypedResult.success();}else {
            return TypedResult.error("提交失败，请再次确认信息");
        }
    }

    /**
     *  修改
     *  提供申请人，申请学院，申请人联系方式，申请时间，活动分类，活动专题，活动主题，活动地点，负责人，负责人联系方式，主讲人，主讲人联系方式。活动开始时间，活动结束时间，活动宣传图，活动概述，附件，提交方式
     */
    @PostMapping("updateSq")
    public TypedResult<Object> updateSq(THdxtHdsq tHdxtHdsq) {
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
        // 记录到申请表里面,
        if (tHdxtHdsqService.saveOrUpdate(tHdxtHdsq)){
            return TypedResult.success();}else {
            return TypedResult.error("修改失败，请再次确认信息");
        }
    }

    /**
     *  删除
     *  提供主键id
     */
    @PostMapping("removeSq")
    public TypedResult<Object> removeSq(Integer sqId) {
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
        // 判断流程状态是否为-1
        // 记录到申请表里面,
        if (tHdxtHdsqService.removeById(sqId)){
            return TypedResult.success();}else {
            return TypedResult.error("删除失败，请再次确认信息");
        }
    }

    // 导出

    /**
     *  查询
     *  提供活动主题，流程状态，学年
     */
    public TypedResult<List<THdxtHdsq>> queryDdjt(String xn, String hdzt,String dqhjbz, Integer pageNo, Integer pageSize) {
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
        // 不需要验证查询条件THdxtHdsq
        // 分页
        if (pageNo == null){
            pageNo = -1;
            pageSize = -1;
        }
        // 根据xn，hdzt查询我参与的活动
        List<THdxtHdsq> data =tHdxtHdsqService.listBy();
        // 获取总数
        int total = data.size();
        //分页
        List<THdxtHdsq> subList = data.stream().skip((long) (pageNo - 1) * pageSize).limit(pageSize).
                collect(Collectors.toList());
        return TypedResult.success(total, subList);
    }


}
