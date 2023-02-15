package com.sudytech.ddjt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sudytech.appware.configservice.custommanage.entity.ConfigEntity;
import com.sudytech.appware.configservice.custommanage.service.impl.CustomManagerDefaultImpl;
import com.sudytech.appware.configservice.custommanage.vo.ExtendParamVO;
import com.sudytech.appware.configservice.custommanage.vo.SearchVO;
import com.sudytech.appware.processService.extbootscan.StaticSrpingContext;
import com.sudytech.ddjt.sdo.THdxtHdfl;
import com.sudytech.ddjt.service.THdxtHdflService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HdxtManageServiceImpl extends CustomManagerDefaultImpl {

    /**
     * 是否使用自定义的权限校验，true则使用下面的hasSearchPerm，不再使用公用权限校验
     * 只用在公用的查询、导出时鉴权
     * @return
     */
    @Override
    public boolean useCustomSearchPerm() {
        return false;
    }

    @Override
    public boolean hasSearchPerm(ExtendParamVO extendParam, ConfigEntity config) {
        return false;
    }

    @Override
    public void resetSearchVO(ExtendParamVO extendParam, SearchVO searchVO) {

    }

    @Override
    public boolean useCustomSearchImpl() {
        return false;
    }

    @Override
    public List<Map<String, Object>> fetchData(ExtendParamVO extendParam, SearchVO searchVO, Page page) {
        return null;
    }

    @Override
    public void parseData(ExtendParamVO extendParam, List<Map<String, Object>> datas) {

    }

    @Override
    public boolean useCustomExport() {
        return false;
    }

    @Override
    public String export(ExtendParamVO extendParam, SearchVO searchVO) {
        return null;
    }

    @Override
    public boolean useCustomImport() {
        return true;
    }

    @Override
    public String doImport(ExtendParamVO extendParam, SearchVO searchVO, String filePath) {
        return null;
    }

    @Override
    public List<Integer> getDefultBussinessId(JSONObject params) {
        THdxtHdflService tHdxtHdflService = StaticSrpingContext.getContext().getBean(THdxtHdflService.class);
        List<THdxtHdfl> list = tHdxtHdflService.list();
        List<Integer> listId = new ArrayList<>();
        for (THdxtHdfl tHdxtHdfl : list) {
            listId.add(tHdxtHdfl.getId());
        }
        return listId;
    }
}
