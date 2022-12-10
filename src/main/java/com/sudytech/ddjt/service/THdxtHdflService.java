package com.sudytech.ddjt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sudytech.ddjt.sdo.THdxtHdfl;
import com.sudytech.ddjt.vo.MyQueryResult;

import java.util.List;

/**
 * @author 尹文豪
 * 活动分类表
 */
public interface THdxtHdflService extends IService<THdxtHdfl> {
    List<MyQueryResult> queryDdjt();
}
