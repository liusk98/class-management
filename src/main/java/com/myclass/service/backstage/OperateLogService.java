package com.myclass.service.backstage;

import com.myclass.entity.backstage.OperateLog;

import java.util.List;

/**
 * @author joe
 * @Date 2019/8/28
 */
public interface OperateLogService {

    /**
     * 功能描述:
     * 〈根据条件查询 operateLog〉
     *
     * @param operateLog
     * @return java.util.List<com.myclass.entity.backstage.OperateLog>
     * @author 蜀山剑仙
     * @date 2019/8/28 下午2:32
     */
    List<OperateLog> queryOperateLog(OperateLog operateLog);
}
