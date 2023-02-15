package com.sudytech.ddjt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sudytech.ddjt.sdo.THdxtHdsq;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sudytech.ddjt.vo.MyQueryResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author sudy701
* @description 针对表【T_HDXT_HDSQ(活动申请)】的数据库操作Mapper
* @createDate 2023-02-15 15:48:13
* @Entity com.sudytech.ddjt.sdo.THdxtHdsq
*/
public interface THdxtHdsqMapper extends BaseMapper<THdxtHdsq> {

    List<THdxtHdsq> selectListBy();

    List<MyQueryResult> queryDdjt(@Param("xn")String xn, @Param("hdbt")String hdzt, @Param("userid")Integer userid);
}


