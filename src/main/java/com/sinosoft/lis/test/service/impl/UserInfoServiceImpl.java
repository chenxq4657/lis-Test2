package com.sinosoft.lis.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.lis.test.common.PubFun;
import com.sinosoft.lis.test.vo.request.UserInfoRqVo;
import com.sinosoft.lis.test.entity.UserInfo;
import com.sinosoft.lis.test.mapper.UserInfoMapper;
import com.sinosoft.lis.test.service.IUserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author cxq
 * @since 2019-08-23
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Override
    public void saveUser(UserInfoRqVo userInfoDto) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDto,userInfo);
        userInfo.setMakeOperator("001");
        userInfo.setMakeDate(PubFun.getCurrentDate());
        userInfo.setMakeTime(PubFun.getCurrentTime());
        userInfo.setModifyOperator("001");
        userInfo.setModifyDate(PubFun.getCurrentDate());
        userInfo.setModifyTime(PubFun.getCurrentTime());

        this.save(userInfo);
    }
}
