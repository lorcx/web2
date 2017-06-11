package module.sys.service;

import module.sys.dao.ISysScheduleLogMapper;
import module.sys.entity.SysScheduleLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.PageUtils;
import java.util.List;

/**
 * 定时任务日志
 * Created by Administrator on 2017/3/5 0005.
 */
@Service("scheduleJobLogService")
public class SysScheduleJobLogService implements ISysScheduleJobLogService {

    @Autowired
    private ISysScheduleLogMapper scheduleLogMapper;

    /**
     * 根据id 查询定时任务日志
     * @param scheduleLogId
     * @return
     */
    @Override
    public SysScheduleLog queryScheduleLog(String scheduleLogId) {
        return scheduleLogMapper.getOne(scheduleLogId);
    }

    /**
     * 查询定时任务日志列表
     * @param pageUtils
     * @return
     */
    @Override
    public List<SysScheduleLog> queryList(PageUtils pageUtils) {
        return scheduleLogMapper.getList(pageUtils);
    }

    /**
     * 保存定时任务
     * @param scheduleLog
     */
    @Override
    @Transactional
    public void save(SysScheduleLog scheduleLog) {
        scheduleLogMapper.save(scheduleLog);
    }
}
