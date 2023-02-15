package com.sudytech.ddjt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sudytech.ddjt.sdo.THdxtHdfl;
import com.sudytech.ddjt.service.THdxtHdflService;
import com.sudytech.ddjt.mapper.THdxtHdflMapper;
import com.sudytech.ddjt.vo.MyQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author sudy701
* @description 针对表【T_HDXT_HDFL(活动分类)】的数据库操作Service实现
* @createDate 2023-02-15 15:48:13
*/
@Service
public class THdxtHdflServiceImpl extends ServiceImpl<THdxtHdflMapper, THdxtHdfl>
    implements THdxtHdflService{

    @Autowired
    THdxtHdflMapper tHdxtHdflMapper;
}
