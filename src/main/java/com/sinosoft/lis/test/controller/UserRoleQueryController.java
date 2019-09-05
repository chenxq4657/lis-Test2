package com.sinosoft.lis.test.controller;


import com.sinosoft.lis.test.common.BaseController;
import com.sinosoft.lis.test.common.CheckResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxq
 * @since 2019-07-22
 */
@RestController
@RequestMapping("/test/userRoleQuery")
public class UserRoleQueryController extends BaseController {

    @RequestMapping("/query")
    public String query() {
        logger.debug("debug开始查询");
        logger.info("info开始查询");
        logger.warn("warn开始查询");
        logger.error("error开始查询");
        logger.debug("debug结束查询");
        logger.info("info结束查询");
        logger.warn("warn结束查询");
        logger.error("error结束查询");
        return "111111111";
    }

    @RequestMapping("/check")
    public CheckResult check() {
        CheckResult checkResult = new CheckResult();
        /*UserRole t = new UserRole();
        t.setId(null);
        t.setUserId("2");
        t.setRoleDate(null);
        t.setMakeOperator("2");
        *//*t.setMakeDate(currentDate);
        t.setMakeTime(currentTime);
        t.setModifyOperator("2");
        t.setModifyDate(currentDate);
        t.setModifyTime(currentTime);*//*

        //指定规则文件
//        KieSession kieSession1 = fileKieSessionMap.getKieSessionMap().get("Rules.drl");


//        kieSession1.setGlobal("checkResult",checkResult);

        //执行某一规则
//        AgendaFilter agendaFilter = new RuleNameEqualsAgendaFilter("222",false);
//        kieSession1.fireAllRules(agendaFilter);

        KieSession kieSession1 = PubFun.getKieSession("Rules");
        kieSession1.insert(checkResult);
        kieSession1.insert(t);
        kieSession1.fireAllRules();*/

        return checkResult;
    }

}
