package com.sinosoft.lis.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sinosoft.lis.test.vo.request.UserLoginLogRqVo;
import com.sinosoft.lis.test.entity.UserLoginLog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户登录日志 Mapper 接口
 * </p>
 *
 * @author cxq
 * @since 2019-08-23
 */
public interface UserLoginLogMapper extends BaseMapper<UserLoginLog> {

    /**
     * 为了区别plus原来的查询select*的字段 ，自定义为dy
     * @return 多表关联查询
     */
    @Select("SELECT * FROM user_login_log where a.user_code=#{userCode}")
    List<UserLoginLogRqVo> selectListPage(Page<UserLoginLogRqVo> page, @Param("userCode") String userCode);

}
