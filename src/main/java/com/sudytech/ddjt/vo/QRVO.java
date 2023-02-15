package com.sudytech.ddjt.vo;

import lombok.Data;

import java.util.Date;

/**
 * 二维码VO
 */
@Data
public class QRVO {
    private String hdbt;
    private Date kssj;
    private Date jssj;
    private String QRurl;
}
