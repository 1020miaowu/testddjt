package com.sudytech.ddjt.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sudytech.base.mvc.TypedResult;
import com.sudytech.ddjt.sdo.THdxtHdfl;
import com.sudytech.ddjt.service.THdxtHdcyService;
import com.sudytech.ddjt.service.THdxtHdflService;
import com.sudytech.ddjt.service.THdxtHdsqService;
import com.sudytech.ddjt.vo.QRVO;
import com.sudytech.ddjt.vo.THdxtHdcyResult;
import com.sudytech.log.ILog;
import com.sudytech.log.LogFactory;
import com.sudytech.security.ids.SSOUser;
import com.sudytech.system.base.mvc.BaseController;
import com.sudytech.zhxg.student.service.StudentInfoService;
import com.sudytech.zhxg.student.vo.StudentInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 尹文豪
 * 模块：道德讲堂管理系统
 * 我参与的活动
 * id相关的int
 */
@Api(tags = {"活动系统"})
@RequestMapping(path = "/ddjt/api/")
@RestController
public class DdjtController extends BaseController {
    // 页面分析
    // 导出按钮，按活动时间倒序排序，查看按钮，重置，查询按钮，搜索条件：学年（字典），活动主题
    /**
     *  开启日志
     */
    private ILog _log = LogFactory.getInstance().getLog(DdjtController.class);

    @Autowired
    private StudentInfoService studentInfoService;

    /**
     *  活动分类
     */
    @Autowired
    private THdxtHdflService tHdxtHdflService;

    /**
     *  活动申请
     */
    @Autowired
    private THdxtHdsqService tHdxtHdsqService;

    /**
     *  活动成员
     */
    @Autowired
    private THdxtHdcyService tHdxtHdcyService;


    // 获取启用状态的活动分类接口
    @ApiOperation(value = "获取启用状态的活动分类接口")
    @GetMapping(path = "hdfl")
    public TypedResult hdfl() {
        //登陆判断
        SSOUser ssoUser = getCurrentUser();
        if (ssoUser.isAnonymous()) {
            return TypedResult.error(-200, "人员未登录!");
        }
        LambdaQueryWrapper<THdxtHdfl> queryWrapper = new LambdaQueryWrapper<THdxtHdfl>();
        queryWrapper.eq(THdxtHdfl::getZt,"启用");
        List<THdxtHdfl> tKnbzBzzls = tHdxtHdflService.list(queryWrapper);
        return TypedResult.success(tKnbzBzzls);
    }


    @ApiOperation(value = "活动二维码生成")
    @ApiImplicitParams({})
    @RequestMapping(path = "qr",method = RequestMethod.POST)
    TypedResult qr(@RequestParam(required = true, value = "id")Integer id){
        SSOUser ssoUser = getCurrentUser();
        if(null == ssoUser || ssoUser.isAnonymous()){
            return TypedResult.error(-200,"人员未登录!");
        }
        if(null == id){
            return TypedResult.error("请正确选择！");
        }
        QRVO qr = tHdxtHdsqService.getQR(id);
        if (null == qr){
            return TypedResult.error("请正确选择！");
        }
        qr.setQRurl("signup");
        return TypedResult.success(qr);
    }
    @ApiOperation(value = "二维码签到")
    @ApiImplicitParams({})
    @RequestMapping(path = "qr",method = RequestMethod.GET)
    TypedResult signup(@RequestParam(required = true, value = "hdsqId")Integer hdsqId){
        SSOUser ssoUser = getCurrentUser();
        if(null == ssoUser || ssoUser.isAnonymous()){
            return TypedResult.error(-200,"人员未登录!");
        }
        String code = ssoUser.getUser().getLoginName();
        StudentInfoVO studentInfoVO = studentInfoService.queryStudentInfo(null, code);
        if(null == studentInfoVO){
            return TypedResult.error(-200,"签到错误，请核实身份！");
        }
        TypedResult<THdxtHdcyResult> cy = tHdxtHdcyService.getCy(studentInfoVO,hdsqId);
        return cy;
    }

    @ApiOperation(value = "二维码签退")
    @ApiImplicitParams({})
    @RequestMapping(path = "out",method = RequestMethod.GET)
    TypedResult signout(@RequestParam(required = true, value = "hdsqId")Integer hdsqId) {
        SSOUser ssoUser = getCurrentUser();
        if(null == ssoUser || ssoUser.isAnonymous()){
            return TypedResult.error(-200,"人员未登录!");
        }
        String code = ssoUser.getUser().getLoginName();
        StudentInfoVO studentInfoVO = studentInfoService.queryStudentInfo(null, code);
        if(null == studentInfoVO){
            return TypedResult.error(-200,"签退错误，请核实身份！");
        }
        TypedResult<THdxtHdcyResult> result = tHdxtHdcyService.signOut(studentInfoVO, hdsqId);
        return result;
    }

}
