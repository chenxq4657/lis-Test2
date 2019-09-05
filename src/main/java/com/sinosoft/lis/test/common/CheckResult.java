package com.sinosoft.lis.test.common;

import lombok.Data;

/**
 * Created by cxq on 2019/7/29.
 */
@Data
public class CheckResult {

    private boolean checkFlag = true;// true:通过校验；false：未通过校验

    private String succMsg = "校验通过";

    private String errorMsg = "";

}
