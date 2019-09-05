package com.sinosoft.lis.test.vo.request;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* <p>
* 用户登录日志
* </p>
*
* @author cxq
* @since 2019-08-23
*/
@Data
public class UserLoginLogRqVo {
    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    private String serialNo;

    /**
     * 用户名
     */
    private String userCode;

    /**
     * 用户登录日期
     */
    private Date loginDate;

    /**
     * 用户登录时间
     */
    private String loginTime;

    /**
     * 用户登录机构
     */
    private String loginComCode;

    public String getLoginDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(loginDate);
    }

    public void setLoginDate(String loginDate) {
        try {
            this.loginDate = new SimpleDateFormat("yyyy-MM-dd").parse(loginDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
