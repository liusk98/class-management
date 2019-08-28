package com.myclass.service.backstage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myclass.dao.backstage.OperateLogMapper;
import com.myclass.entity.backstage.OperateLog;
import com.myclass.service.backstage.OperateLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author joe
 * @Date 2019/8/28
 */
@Service("operateLogService")
public class OperateLogServiceImpl implements OperateLogService {

    @Resource
    private OperateLogMapper operateLogMapper;

    /**
     * 功能描述:
     * 〈根据条件查询 operateLog〉
     *
     * @param operateLog
     * @return java.util.List<com.myclass.entity.backstage.OperateLog>
     * @author 蜀山剑仙
     * @date 2019/8/28 下午2:32
     */
    @Override
    public List<OperateLog> queryOperateLog(OperateLog operateLog) {
        Page<OperateLog> operateLogPage = PageHelper.startPage(1, 10);
        return operateLogMapper.listOperateLog(operateLog);
    }
}
