package com.sinosoft.lis.test.common;

import lombok.Data;

/**
 * Created by cxq on 2019/7/29.
 */
@Data
public class CheckResult {

    /**
     * true:通过校验；false：未通过校验
     */
    private boolean checkFlag = true;

    private String msg = "校验通过";

}
