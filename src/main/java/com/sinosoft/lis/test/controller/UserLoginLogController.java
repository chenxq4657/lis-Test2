package com.sinosoft.lis.test.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sinosoft.lis.test.common.BaseController;
import com.sinosoft.lis.test.common.Msg;
import com.sinosoft.lis.test.common.PageMsg;
import com.sinosoft.lis.test.common.PubFun;
import com.sinosoft.lis.test.entity.UserLoginLog;
import com.sinosoft.lis.test.enumdict.ResponseState;
import com.sinosoft.lis.test.service.IUserLoginLogService;
import com.sinosoft.lis.test.vo.request.UserLoginLogRqVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 用户登录日志 前端控制器
 * </p>
 *
 * @author cxq
 * @since 2019-08-23
 */
@RestController
@RequestMapping("/test/user-login-log")
public class UserLoginLogController extends BaseController {

    @Autowired
    private IUserLoginLogService iUserLoginLogService;

    @RequestMapping("/add")
    public Msg add() {
        UserLoginLogRqVo t = new UserLoginLogRqVo();
        t.setSerialNo(UUID.randomUUID().toString().substring(0,20));
        t.setUserCode("001");
        t.setLoginDate(PubFun.getCurrentDate());
        t.setLoginTime(PubFun.getCurrentTime());
        t.setLoginComCode("86");
        iUserLoginLogService.saveLog(t);
        Msg msg = Msg.success("操作成功");
        msg.setData(t);
        return msg;
    }

    @RequestMapping("/pageByUserCode")
    public PageMsg pageByUserCode() {

        IPage<UserLoginLog> page=iUserLoginLogService.selectListPage(1, 2);
        PageMsg pageMsg = new PageMsg<UserLoginLog,UserLoginLogRqVo>(ResponseState.SUCCESS.toString(),"查询成功！") {
            @Override
            protected List<UserLoginLogRqVo> entitiesToVoes(List<UserLoginLog> list) {
                List voList = new ArrayList<UserLoginLogRqVo>();
                for (UserLoginLog userLoginLog:list){
                    UserLoginLogRqVo userLoginLogRqVo = new UserLoginLogRqVo();
                    BeanUtils.copyProperties(userLoginLog,userLoginLogRqVo);
                    voList.add(userLoginLogRqVo);
                }
                return voList;
            }
        };
        pageMsg.setRecords(page);
        return pageMsg;

    }
}
