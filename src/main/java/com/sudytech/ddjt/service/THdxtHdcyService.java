package com.sudytech.ddjt.service;

import com.sudytech.base.mvc.TypedResult;
import com.sudytech.ddjt.sdo.THdxtHdcy;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sudytech.ddjt.vo.THdxtHdcyResult;
import com.sudytech.zhxg.student.vo.StudentInfoVO;

/**
* @author sudy701
* @description 针对表【T_HDXT_HDCY(活动成员)】的数据库操作Service
* @createDate 2023-02-15 15:48:13
*/
public interface THdxtHdcyService extends IService<THdxtHdcy> {


    TypedResult<THdxtHdcyResult> getCy(StudentInfoVO studentInfoVO,Integer hdsqId);

    TypedResult<THdxtHdcyResult> signOut(StudentInfoVO studentInfoVO, Integer hdsqId);
}
