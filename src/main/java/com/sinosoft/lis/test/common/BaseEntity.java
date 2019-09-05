package com.sinosoft.lis.test.common;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cxq on 2019/7/15.
 */
@Data
public class BaseEntity {

    /**
     * 入机操作人
     */
    private String makeOperator;

    /**
     * 入机日期
     */
    private Date makeDate;

    /**
     * 入机时间
     */
    private String makeTime;

    /**
     * 最后修改操作人
     */
    private String modifyOperator;

    /**
     * 最后修改日期
     */
    private Date modifyDate;

    /**
     * 最后修改时间
     */
    private String modifyTime;

    public String getMakeDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(makeDate);
    }

    public void setMakeDate(String makeDate) {
        try {
            this.makeDate = new SimpleDateFormat("yyyy-MM-dd").parse(makeDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getModifyDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(modifyDate);
    }

    public void setModifyDate(String modifyDate) {
        try {
            this.modifyDate = new SimpleDateFormat("yyyy-MM-dd").parse(modifyDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
