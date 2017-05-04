package module.sys.service;

import module.sys.entity.SysSchedule;
import util.PageUtils;
import java.util.List;


/**
 * Created by lx on 2017/3/5.
 */
public interface ISysScheduleService {

    SysSchedule getScheduleById(String scheduleId);

    List<SysSchedule> getScheduleListByPage(PageUtils pageUtil);

    SysSchedule getSedchuleInfoById(String scheduleId);

    void saveOrUpateSchedule(SysSchedule schedule);

    void deleteBatch(String[] scheduleIds);

    void run(String[] scheduleIds);

    void pause(String[] scheduleIds);

    void resume(String[] scheduleIds);

    int updateBatch(String[] scheduleIds, int status);

    public void update(SysSchedule schedule);
}
