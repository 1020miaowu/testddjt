package com.sudytech.ddjt.service;

import com.sudytech.ddjt.sdo.THdxtHdsq;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sudytech.ddjt.vo.MyQueryResult;
import com.sudytech.ddjt.vo.QRVO;

import java.util.List;

/**
* @author sudy701
* @description 针对表【T_HDXT_HDSQ(活动申请)】的数据库操作Service
* @createDate 2023-02-15 15:48:13
*/
public interface THdxtHdsqService extends IService<THdxtHdsq> {
    /**
     * 查询
     */
    List<THdxtHdsq> listBy();

    QRVO getQR(Integer id);


    List<MyQueryResult> queryDdjt(String xn, String hdzt, Integer userid);
}
