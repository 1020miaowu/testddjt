package com.sudytech.ddjt.utils;

import com.sudytech.ddjt.vo.THdxtHdcyResult;
import com.sudytech.zhxg.student.vo.StudentInfoVO;

import java.util.Date;

/**
 * 用于StudentInfo类的转换
 */
public class StuUtils {

    public THdxtHdcyResult toThdxtHdcy(StudentInfoVO studentInfoVO){
        String zymc = studentInfoVO.getMajor().getZymc();
        String org = studentInfoVO.getOrg().getName();
        String bjmc = studentInfoVO.getAdminClass().getBjmc();
        String name = studentInfoVO.getStudentInfo().getName();
        String code = studentInfoVO.getStudentInfo().getCode();
        Integer id = studentInfoVO.getStudentInfo().getId();
        if(null == zymc || null == org || null == bjmc
                || null == name || null == id || null == code){
            return null;
        }
        THdxtHdcyResult result = new THdxtHdcyResult();
        result.setClassroom(bjmc);
        result.setAcademy(org);
        result.setSpecialized(zymc);
        result.setStudentNumber(code);
        result.setStudentName(name);
        result.setOutInTime(new Date());
        result.setUserId(id);
        return result;
    }
}
