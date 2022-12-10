package com.sudytech.ddjt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sudytech.base.mvc.TypedResult;
import com.sudytech.ddjt.sdo.THdxtHdfl;
import com.sudytech.ddjt.service.DictUtilsService;
import com.sudytech.ddjt.service.THdxtHdflService;
import com.sudytech.ddjt.vo.MyQueryResult;
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

    private THdxtHdflService tHdxtHdflService;

    // 列表展示
    @GetMapping("queryDdjt")
    // 传参：学年，活动主题，分页
    // 返回序号，id，学年，活动主题，开始时间，结束时间，活动地点，签到时间
    // 查活动成员表，然后通过活动申请id外键查询活动申请表数据。
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
//        if (xn == null || "".equals(xn)){
//            // 查询所有学年。这里怎么校验是否有这个学年呢
//            String i="所有";
//        } else {
//            // 查询拥有的学年，如果他输入的在范围外就不展示。
//            String i=xn;
//        }
        // 分页
        if (pageNo == null){
            pageNo = -1;
            pageSize = -1;
        }

        List<MyQueryResult> data =tHdxtHdflService.queryDdjt();
        // 获取总数
        int total = data.size();
        //总页数
        int pageSum = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        //分页
        List<MyQueryResult> subList = data.stream().skip((pageNo - 1) * pageSize).limit(pageSize).
                collect(Collectors.toList());

        // 分页
//        List<MyQueryResult> data = new ArrayList<>();
//        Page<THdxtHdfl> page = Page.of(pageNo, pageSize);
//        Page<THdxtHdfl> pageData = tHdxtHdflService.page(page, null);
//        for (THdxtHdfl i : pageData.getRecords()){
//            int n = 0;
//            // 这里加进去了id，学年，学期，学院名称，管理员，班级号,班级名称，班会地点
//            MyQueryResult myQueryResult = new TBanhuiBhddResult();
//            myQueryResult.setId(i.getId());
//            myQueryResult.setSn(n);
//            myQueryResult.setXn(i.getXn());
//            myQueryResult.setXq(i.getXq());
//            // 暂时先放学院id，看看前端能不能自己去字典表查看(不知道这个字典表有没有缓存在前端，估计没有，以后再改)
//            myQueryResult.setXymc(i.getOrgId());
//
//            // 管理员这个字段不知道
//            // 经过确认，去除管理员字段
//            // tBanhuiBhddResults.setGly("管理员暂时未知");
//            myQueryResult.setBjh(i.getBjh());
//            myQueryResult.setBjmc(i.getBjmc());
//            myQueryResult.setBhdd(i.getBhdd());
//            data.add(myQueryResult);
//        }
        return TypedResult.success(total, subList);
    }
    // 导出接口
}
