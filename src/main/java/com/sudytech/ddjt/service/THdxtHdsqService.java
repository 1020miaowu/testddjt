package com.sudytech.ddjt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sudytech.ddjt.sdo.THdxtHdsq;

import java.util.List;


/**
 * @author sudy701
 */
public interface THdxtHdsqService extends IService<THdxtHdsq> {



    /**
     * 查询
     */
    List<THdxtHdsq> listBy();
}
