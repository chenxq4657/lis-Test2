package com.sinosoft.lis.test.entity;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.sinosoft.lis.test.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 用户登录日志
* </p>
*
* @author cxq
* @since 2019-08-27
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserLoginLog extends BaseEntity {
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
        return (loginDate==null||"".equals(loginDate))?null:new SimpleDateFormat("yyyy-MM-dd").format(loginDate);
    }

    public void setLoginDate(String loginDate) {
        try {
            this.loginDate = (loginDate==null||"".equals(loginDate))?null:new SimpleDateFormat("yyyy-MM-dd").parse(loginDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
