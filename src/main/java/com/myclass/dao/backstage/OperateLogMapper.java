package com.myclass.dao.backstage;

import com.myclass.entity.backstage.OperateLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author joe
 * @Date 2019/8/23
 */
public interface OperateLogMapper {

    /**
     * 功能描述:
     * 〈添加 OperateLog 数据〉
     *
     * @param operateLog
     * @return int
     * @author 蜀山剑仙
     * @date 2019/8/23 下午12:02
     */
    int insertOperateLog(@Param("operateLog") OperateLog operateLog);

    /**
     * 功能描述:
     * 〈对 OperateLog 进行数据查询〉
     *
     * @param operateLog
     * @return java.util.List<com.myclass.entity.backstage.OperateLog>
     * @author 蜀山剑仙
     * @date 2019/8/28 下午2:14
     */
    List<OperateLog> listOperateLog(@Param("operateLog") OperateLog operateLog);
}
