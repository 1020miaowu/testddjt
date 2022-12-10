package com.sudytech.ddjt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sudytech.ddjt.sdo.THdxtHdsq;

import java.util.List;

/**
 * @author 尹文豪
 */
public interface THdxtHdsqMapper  extends BaseMapper<THdxtHdsq> {
    List<THdxtHdsq> selectListBy();
}
