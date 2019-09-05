package com.sinosoft.lis.test.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sinosoft.lis.test.vo.request.UserLoginLogRqVo;
import com.sinosoft.lis.test.entity.UserLoginLog;

/**
 * <p>
 * 用户登录日志 服务类
 * </p>
 *
 * @author cxq
 * @since 2019-08-23
 */
public interface IUserLoginLogService extends IService<UserLoginLog> {

    /**
     * 保存登录日志
     * @param userLoginLogDto
     */
    void saveLog(UserLoginLogRqVo userLoginLogDto);

    IPage<UserLoginLog> selectListPage(int current, int size);
}
