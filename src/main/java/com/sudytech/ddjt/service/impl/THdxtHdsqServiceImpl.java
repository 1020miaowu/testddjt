package com.sudytech.ddjt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sudytech.ddjt.mapper.THdxtHdsqMapper;
import com.sudytech.ddjt.sdo.THdxtHdsq;
import com.sudytech.ddjt.service.THdxtHdsqService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 尹文豪
 */
@Service
public class THdxtHdsqServiceImpl extends ServiceImpl<THdxtHdsqMapper, THdxtHdsq> implements THdxtHdsqService {

    THdxtHdsqMapper tHdxtHdsqMapper;
    @Override
    public List<THdxtHdsq> listBy() {
        return tHdxtHdsqMapper.selectListBy();
    }
}
