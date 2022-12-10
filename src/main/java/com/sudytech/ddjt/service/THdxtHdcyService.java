package com.sudytech.ddjt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sudytech.ddjt.sdo.THdxtHdcy;
import com.sudytech.ddjt.vo.THdxtHdcyResult;

import java.util.List;


/**
 * @author 尹文豪
 * 活动成员表
 */
public interface THdxtHdcyService extends IService<THdxtHdcy> {

    /**
     * 通过活动id查询参与成员信息
     */
    List<THdxtHdcyResult> obtainBySqId(Integer id);
}
