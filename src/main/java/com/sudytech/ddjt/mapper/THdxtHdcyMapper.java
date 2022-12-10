package com.sudytech.ddjt.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sudytech.ddjt.sdo.THdxtHdcy;
import com.sudytech.ddjt.vo.THdxtHdcyResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface THdxtHdcyMapper  extends BaseMapper<THdxtHdcy> {
    List<THdxtHdcyResult> obtainBySqId();
}
