package com.sudytech.ddjt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sudytech.ddjt.mapper.THdxtHdcyMapper;
import com.sudytech.ddjt.sdo.THdxtHdcy;
import com.sudytech.ddjt.service.THdxtHdcyService;
import com.sudytech.ddjt.vo.THdxtHdcyResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 尹文豪
 * 活动成员
 */
@Service
public class THdxtHdcyServiceImpl extends ServiceImpl<THdxtHdcyMapper, THdxtHdcy> implements THdxtHdcyService {

    THdxtHdcyMapper hdxtHdcyMapper;
    @Override
    public List<THdxtHdcyResult> obtainBySqId(Integer id) {
        // 通过活动id查询参与成员信息
        return hdxtHdcyMapper.obtainBySqId();
    }
}
