package module.sys.service;

import common.Constant;
import module.sys.dao.ISysScheduleMapper;
import module.sys.entity.SysSchedule;
import org.apache.commons.lang.StringUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.PageUtils;
import util.ScheduleUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lx on 2017/3/5.
 */
@Service("sysScheduleService")
public class SysScheduleService implements ISysScheduleService {
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private ISysScheduleMapper scheduleMapper;

    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init() {
        List<SysSchedule> scheduleList = scheduleMapper.getList(new HashMap<String, Object>());
        for (SysSchedule schedule : scheduleList) {
            CronTrigger trigger = ScheduleUtils.getCronTrigger(scheduler, schedule.getId());

            // 如果不存在，则创建
            if (null == trigger) {
                ScheduleUtils.createScheduleJob(scheduler, schedule);
            } else {
                ScheduleUtils.updateSchedule(scheduler, schedule);
            }
        }
    }

    /**
     * 查询任务信息
     * @param scheduleId
     * @return
     */
    @Override
    public SysSchedule getScheduleById(String scheduleId) {
        return scheduleMapper.getOne(scheduleId);
    }

    /**
     * 分页查询定时管理
     * @param pageUtils
     * @return
     */
    @Override
    public List<SysSchedule> getScheduleListByPage(PageUtils pageUtils) {
        return scheduleMapper.getScheduleListByPage(pageUtils);
    }

    /**
     * 根据id获取定时信息
     * @param scheduleId
     * @return
     */
    @Override
    public SysSchedule getSedchuleInfoById(String scheduleId) {
        return scheduleMapper.getOne(scheduleId);
    }

    /**
     * 保存或更新定时任务
     * @param schedule
     */
    @Override
    @Transactional
    public void saveOrUpateSchedule(SysSchedule schedule) {
        if (StringUtils.isNotBlank(schedule.getId())) {
           schedule.setId(UUID.randomUUID().toString());
           schedule.setStatus(Constant.ScheduleStatus.NORMAL.getValue() + "");
           scheduleMapper.save(schedule);

           ScheduleUtils.createScheduleJob(scheduler, schedule);
        } else {
            ScheduleUtils.updateSchedule(scheduler, schedule);

            scheduleMapper.update(schedule);
        }
    }

    /**
     * 删除
     * @param scheduleIds
     */
    @Override
    @Transactional
    public void deleteBatch(String[] scheduleIds) {
        for (String scheduleId : scheduleIds) {
            ScheduleUtils.deleteSchedule(scheduler, scheduleId);
        }

        scheduleMapper.deleteBatch(scheduleIds);
    }

    /**
     * 运行
     * @param scheduleIds
     */
    @Override
    @Transactional
    public void run(String[] scheduleIds) {
        for (String scheduleId : scheduleIds) {
            ScheduleUtils.run(scheduler, getSedchuleInfoById(scheduleId));
        }
    }

    /**
     * 暂停任务
     * @param scheduleIds
     */
    @Override
    @Transactional
    public void pause(String[] scheduleIds) {
        for (String scheduleId : scheduleIds) {
            ScheduleUtils.resume(scheduler, scheduleId);
        }
        updateBatch(scheduleIds, Constant.ScheduleStatus.PAUSE.getValue());
    }

    /**
     * 恢复任务
     * @param scheduleIds
     */
    @Override
    @Transactional
    public void resume(String[] scheduleIds) {
        for (String scheduleId : scheduleIds) {
            ScheduleUtils.resume(scheduler, scheduleId);
        }

        updateBatch(scheduleIds, Constant.ScheduleStatus.NORMAL.getValue());
    }

    /**
     * 批量更新
     * @param scheduleIds
     * @param status
     * @return
     */
    @Override
    @Transactional
    public int updateBatch(String[] scheduleIds, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", scheduleIds);
        map.put("status", status);
        return scheduleMapper.updateBatch(map);
    }

    /**
     * 更新
     * @param schedule
     * @return
     */
    @Override
    @Transactional
    public void update(SysSchedule schedule) {
        ScheduleUtils.updateSchedule(scheduler, schedule);
        scheduleMapper.update(schedule);
    }
}
