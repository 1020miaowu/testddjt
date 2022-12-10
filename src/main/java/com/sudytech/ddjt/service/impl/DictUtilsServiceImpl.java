package com.sudytech.ddjt.service.impl;

import com.sudytech.ddjt.mapper.DictUtilsMapper;
import com.sudytech.ddjt.service.DictUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 尹文豪
 */
@Service
public class DictUtilsServiceImpl implements DictUtilsService {

    @Autowired
    DictUtilsMapper dictUtilsMapper;


    @Override
    public boolean dictXn(String xn) {
        return dictUtilsMapper.dictXn();
    }
}
