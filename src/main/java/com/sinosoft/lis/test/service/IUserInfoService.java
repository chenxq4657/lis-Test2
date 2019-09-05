package com.sinosoft.lis.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinosoft.lis.test.vo.request.UserInfoRqVo;
import com.sinosoft.lis.test.entity.UserInfo;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author cxq
 * @since 2019-08-23
 */
public interface IUserInfoService extends IService<UserInfo> {
    /**
     * 新增用户
     * @param userInfoDto
     */
    void saveUser(UserInfoRqVo userInfoDto);
}
