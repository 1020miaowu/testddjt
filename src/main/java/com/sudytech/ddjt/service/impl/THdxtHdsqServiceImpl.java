package com.sudytech.ddjt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sudytech.ddjt.sdo.THdxtHdsq;
import com.sudytech.ddjt.service.THdxtHdsqService;
import com.sudytech.ddjt.mapper.THdxtHdsqMapper;
import com.sudytech.ddjt.vo.MyQueryResult;
import com.sudytech.ddjt.vo.QRVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author sudy701
* @description 针对表【T_HDXT_HDSQ(活动申请)】的数据库操作Service实现
* @createDate 2023-02-15 15:48:13
*/
@Service
public class THdxtHdsqServiceImpl extends ServiceImpl<THdxtHdsqMapper, THdxtHdsq>
    implements THdxtHdsqService{
    @Autowired
    THdxtHdsqMapper tHdxtHdsqMapper;


    @Override
    public List<THdxtHdsq> listBy() {
        return null;
    }

    @Override
    public QRVO getQR(Integer id) {
        QueryWrapper<THdxtHdsq> queryWrapper =  new QueryWrapper<>();
        //判断要模糊查询的数据是否为空，在放进条件控制器queryWrapper
        if(null != id){
            queryWrapper.eq("id",id);
        }

        THdxtHdsq tHdxtHdsq = baseMapper.selectOne(queryWrapper);
        QRVO qrvo = null;
        if(null != tHdxtHdsq && 2 == Integer.valueOf(tHdxtHdsq.getStatus())){
            BeanUtils.copyProperties(qrvo,tHdxtHdsq);
        }
        return qrvo;
    }

    @Override
    public List<MyQueryResult> queryDdjt(String xn, String hdzt, Integer userid) {
        return tHdxtHdsqMapper.queryDdjt(xn,hdzt,userid);
    }
}




