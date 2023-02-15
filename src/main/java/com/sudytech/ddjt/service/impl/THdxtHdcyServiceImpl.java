package com.sudytech.ddjt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sudytech.base.mvc.TypedResult;
import com.sudytech.ddjt.sdo.THdxtHdcy;
import com.sudytech.ddjt.service.THdxtHdcyService;
import com.sudytech.ddjt.mapper.THdxtHdcyMapper;
import com.sudytech.ddjt.vo.THdxtHdcyResult;
import com.sudytech.zhxg.student.vo.StudentInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sudytech.ddjt.utils.StuUtils;

import java.util.Date;
import java.util.List;

/**
* @author sudy701
* @description 针对表【T_HDXT_HDCY(活动成员)】的数据库操作Service实现
* @createDate 2023-02-15 15:48:13
*/
@Service
public class THdxtHdcyServiceImpl extends ServiceImpl<THdxtHdcyMapper, THdxtHdcy>
    implements THdxtHdcyService{

    @Autowired
    private StuUtils stuUtils;

    @Autowired
    THdxtHdcyMapper hdxtHdcyMapper;
    @Override
    public TypedResult<THdxtHdcyResult> getCy(StudentInfoVO studentInfoVO, Integer hdsqId) {
        THdxtHdcyResult result = stuUtils.toThdxtHdcy(studentInfoVO);
        if (null == result) {
            return TypedResult.error("无学生信息！");
        }
        Integer userid = result.getUserId();
        QueryWrapper<THdxtHdcy> queryWrapper = new QueryWrapper<>();
        //判断要模糊查询的数据是否为空，在放进条件控制器queryWrapper
        if (null != userid) {
            queryWrapper.eq("userid", userid);
        }

        List<THdxtHdcy> list = baseMapper.selectList(queryWrapper);
        if (!list.isEmpty()) {
            return TypedResult.error("已签到过，请勿重复签到！");
        }
        THdxtHdcy tHdxtHdcy = new THdxtHdcy();
        tHdxtHdcy.setUserid(userid);
        tHdxtHdcy.setQdsj(result.getOutInTime());
        tHdxtHdcy.setHdsqid(hdsqId);
        super.saveOrUpdate(tHdxtHdcy);
        return TypedResult.success(result);
    }

    @Override
    public TypedResult<THdxtHdcyResult> signOut(StudentInfoVO studentInfoVO,Integer hdsqId){
        Integer userid = studentInfoVO.getStudentInfo().getId();
        QueryWrapper<THdxtHdcy> queryWrapper = new QueryWrapper<>();
        //判断要模糊查询的数据是否为空，在放进条件控制器queryWrapper
        if (null != userid) {
            queryWrapper.eq("userid", userid);
        }

        List<THdxtHdcy> list = baseMapper.selectList(queryWrapper);
        if (list.isEmpty()) {
            return TypedResult.error("未签到！");
        }
        THdxtHdcy tHdxtHdcy = list.get(0);
        if(null == tHdxtHdcy.getQdsj()){
            tHdxtHdcy.setQtsj(new Date());
            super.saveOrUpdate(tHdxtHdcy);
        }
        return TypedResult.error("请勿重复签退！");
    }

}




