package com.sinosoft.lis.test.controller;


import com.sinosoft.lis.test.common.BaseController;
import com.sinosoft.lis.test.common.Msg;
import com.sinosoft.lis.test.common.PubFun;
import com.sinosoft.lis.test.vo.request.UserInfoRqVo;
import com.sinosoft.lis.test.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author cxq
 * @since 2019-08-23
 */
@RestController
@RequestMapping("/test/user-info")
public class UserInfoController extends BaseController {

    @Autowired
    private IUserInfoService iUserInfoService;


    @RequestMapping("/add")
    public Msg add() {
        UserInfoRqVo t = new UserInfoRqVo();
        t.setUserCode("001");
        t.setPassword("001");
        t.setUserName("系统超级管理员");
        t.setValidStartDate(PubFun.getCurrentDate());
        t.setValidStartTime(PubFun.getCurrentTime());
        t.setComCode("86");
        t.setUserState("1");
        iUserInfoService.saveUser(t);
        Msg msg = Msg.success("操作成功");
        msg.setData(t);
        return msg;
    }
}
