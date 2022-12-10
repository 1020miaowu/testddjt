package com.sudytech.ddjt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sudytech.ddjt.sdo.THdxtHdfl;
import com.sudytech.ddjt.vo.MyQueryResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 尹文豪
 */
@Mapper
public interface THdxtHdflMapper extends BaseMapper<THdxtHdfl> {
    List<MyQueryResult> queryDdjt();
}
