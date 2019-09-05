package com.sinosoft.lis.test.common;

import lombok.Getter;

/**
 * Created by cxq on 2019/8/23.
 */
public class CurrentInfo {

    @Getter
    private String currentDate = PubFun.getCurrentDate();

    @Getter
    private String currentTime = PubFun.getCurrentTime();

}
