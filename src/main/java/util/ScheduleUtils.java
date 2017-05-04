package util;

import common.Constant;
import common.exception.RRException;
import module.sys.entity.SysSchedule;
import org.quartz.*;

/**
 * 定时任务工具类
 * Created by Administrator on 2017/3/5 0005.
 */
public class ScheduleUtils {
    private final static String JOB_NAME = "TASK_";

    /**
     * 获取触发器key
     * @param scheduleId
     */
    public static TriggerKey getTriggerKey(String scheduleId) {
        return TriggerKey.triggerKey(JOB_NAME + scheduleId);
    }

    /**
     * 获取jobKey
     * @param scheduleId
     * @return
     */
    public static JobKey getJobKey(String scheduleId) {
        return JobKey.jobKey(JOB_NAME + scheduleId);
    }

    /**
     * 获取表达式触发器
     * @param scheduler
     * @param scheduleId
     * @return
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, String scheduleId) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(scheduleId));
        } catch (SchedulerException e) {
            throw new RRException("获取定时任务CronTrigger出现异常", e);
        }
    }

    /**
     * 创建定时任务
     * @param scheduler
     * @param schedule
     */
    public static void createScheduleJob(Scheduler scheduler, SysSchedule schedule){

        try {
            // 构建job信息
            JobDetail jobDetail = JobBuilder.newJob(ScheduleJob.class).withIdentity(getJobKey(schedule.getId())).build();

            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(schedule.getCronExpression());

            // 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(schedule.getId())).withSchedule(scheduleBuilder).build();

            scheduler.scheduleJob(jobDetail, trigger);

            // 放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(SysSchedule.JOB_PARAM_KEY, schedule);

            // 暂停任务
            if (schedule.getStatus().equals(Constant.ScheduleStatus.PAUSE.getValue())) {
                pauseJob(scheduler, schedule.getId());
            }
        } catch (SchedulerException e) {
            throw new RRException("创建定时任务失败", e);
        }
    }

    /**
     * 更新定时任务
     */
    public static void updateSchedule(Scheduler scheduler, SysSchedule schedule) {

        try {
            TriggerKey triggerKey = getTriggerKey(schedule.getId());

            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(schedule.getCronExpression());

            // 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(schedule.getId())).withSchedule(scheduleBuilder).build();

            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            // 参数
            trigger.getJobDataMap().put(SysSchedule.JOB_PARAM_KEY, schedule);

            scheduler.rescheduleJob(triggerKey, trigger);

            // 暂停任务
            if (schedule.getStatus().equals(Constant.ScheduleStatus.PAUSE.getValue())) {
                pauseJob(scheduler, schedule.getId());
            }
        } catch (SchedulerException e) {
            throw new RRException("更新定时任务失败", e);
        }

    }

    /**
     * 暂停任务
     * @param scheduler
     * @param id
     */
    public static void pauseJob(Scheduler scheduler, String id) {
        try {
            scheduler.pauseJob(getJobKey(id));
        } catch (SchedulerException e) {
            throw new RRException("暂停定时任务失败", e);
        }
    }

    /**
     * 立即执行任务
     * @param scheduler
     * @param schedule
     */
    public static void run(Scheduler scheduler, SysSchedule schedule) {
        try {
            JobDataMap dataMap = new JobDataMap();
            dataMap.put(SysSchedule.JOB_PARAM_KEY, schedule);
            scheduler.triggerJob(getJobKey(schedule.getId()), dataMap);
        } catch (SchedulerException e) {
            throw new RRException("暂停定时任务失败", e);
        }
    }

    /**
     * 恢复任务
     * @param scheduler
     * @param scheduleId
     */
    public static void resume(Scheduler scheduler, String scheduleId) {
        try {
            scheduler.resumeJob(getJobKey(scheduleId));
        } catch (SchedulerException e) {
            throw new RRException("恢复任务失败", e);
        }
    }

    /**
     * 恢复任务
     * @param scheduler
     * @param scheduleId
     */
    public static void deleteSchedule(Scheduler scheduler, String scheduleId) {
        try {
            scheduler.deleteJob(getJobKey(scheduleId));
        } catch (SchedulerException e) {
            throw new RRException("恢复任务失败", e);
        }
    }



}
