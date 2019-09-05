package com.sinosoft.lis.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.lis.test.common.PubFun;
import com.sinosoft.lis.test.vo.request.UserLoginLogRqVo;
import com.sinosoft.lis.test.entity.UserLoginLog;
import com.sinosoft.lis.test.mapper.UserLoginLogMapper;
import com.sinosoft.lis.test.service.IUserLoginLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户登录日志 服务实现类
 * </p>
 *
 * @author cxq
 * @since 2019-08-23
 */
@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog> implements IUserLoginLogService {


    @Override
    @Transactional
    public void saveLog(UserLoginLogRqVo userLoginLogDto) {
        UserLoginLog userLoginLog = new UserLoginLog();
        BeanUtils.copyProperties(userLoginLogDto,userLoginLog);
        userLoginLog.setMakeOperator("001");
        userLoginLog.setMakeDate(PubFun.getCurrentDate());
        userLoginLog.setMakeTime(PubFun.getCurrentTime());
        userLoginLog.setModifyOperator("001");
        userLoginLog.setModifyDate(PubFun.getCurrentDate());
        userLoginLog.setModifyTime(PubFun.getCurrentTime());

        this.save(userLoginLog);
    }

    @Override
    public IPage<UserLoginLog> selectListPage(int current, int size) {
        // 新建分页
        Page page = new Page<UserLoginLog>(current, size);
        UserLoginLog userLoginLog = new UserLoginLog();
        userLoginLog.setUserCode("001");
        QueryWrapper queryWrapper = new QueryWrapper<UserLoginLog>(userLoginLog);

//        Map<String,Object> param = new HashMap<>();
//        param.put("id","2");
        // 返回分页结果 1为id
        return this.page(page,queryWrapper);
    }
}
