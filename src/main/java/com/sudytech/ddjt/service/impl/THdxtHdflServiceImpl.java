package com.sudytech.ddjt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sudytech.ddjt.mapper.THdxtHdflMapper;
import com.sudytech.ddjt.sdo.THdxtHdfl;
import com.sudytech.ddjt.service.THdxtHdflService;
import com.sudytech.ddjt.vo.MyQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 尹文豪
 */
@Service
public class THdxtHdflServiceImpl extends ServiceImpl<THdxtHdflMapper, THdxtHdfl> implements THdxtHdflService {

    @Autowired
    THdxtHdflMapper tHdxtHdflMapper;


    @Override
    public List<MyQueryResult> queryDdjt() {
        return tHdxtHdflMapper.queryDdjt();
    }
}
