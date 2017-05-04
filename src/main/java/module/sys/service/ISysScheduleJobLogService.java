package module.sys.service;

import module.sys.entity.SysScheduleLog;
import util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/5 0005.
 */
public interface ISysScheduleJobLogService {
    SysScheduleLog queryScheduleLog(String scheduleLogId);

    List<SysScheduleLog> queryList(PageUtils pageUtils);

    void save(SysScheduleLog scheduleLog);
}
