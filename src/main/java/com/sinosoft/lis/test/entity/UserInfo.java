package com.sinosoft.lis.test.entity;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.sinosoft.lis.test.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 用户信息
* </p>
*
* @author cxq
* @since 2019-08-27
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userCode;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户所属机构
     */
    private String comCode;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户联系电话
     */
    private String phone;

    /**
     * 用户状态:0-无效,1-有效
     */
    private String userState;

    /**
     * 有效起期
     */
    private Date validStartDate;

    /**
     * 有效起始时间
     */
    private String validStartTime;

    /**
     * 有效止期
     */
    private Date validEndDate;

    /**
     * 有效终止时间
     */
    private String validEndTime;

    public String getValidStartDate() {
        return (validStartDate==null||"".equals(validStartDate))?null:new SimpleDateFormat("yyyy-MM-dd").format(validStartDate);
    }

    public void setValidStartDate(String validStartDate) {
        try {
            this.validStartDate = (validStartDate==null||"".equals(validStartDate))?null:new SimpleDateFormat("yyyy-MM-dd").parse(validStartDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getValidEndDate() {
        return (validEndDate==null||"".equals(validEndDate))?null:new SimpleDateFormat("yyyy-MM-dd").format(validEndDate);
    }

    public void setValidEndDate(String validEndDate) {
        try {
            this.validEndDate = (validEndDate==null||"".equals(validEndDate))?null:new SimpleDateFormat("yyyy-MM-dd").parse(validEndDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
