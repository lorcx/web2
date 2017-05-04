package util;

import module.sys.entity.SysSchedule;
import module.sys.entity.SysScheduleLog;
import module.sys.service.ISysScheduleJobLogService;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 定时任务
 * Created by Administrator on 2017/3/5 0005.
 */
public class ScheduleJob extends QuartzJobBean{
    private Logger logger = LoggerFactory.getLogger(getClass());
    private ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        SysSchedule schedule = (SysSchedule) context.getMergedJobDataMap().get(SysSchedule.JOB_PARAM_KEY);

        // 获取spring bean
        ISysScheduleJobLogService scheduleJobLogService = (ISysScheduleJobLogService) SpringContextUtils.getBean("sysScheduleJobLogService");

        // 数据库保存执行记录
        SysScheduleLog sysScheduleLog = new SysScheduleLog();
        sysScheduleLog.setId(UUID.randomUUID().toString());
        sysScheduleLog.setBeanName(schedule.getBeanName());
        sysScheduleLog.setMethodName(schedule.getMethodName());
        sysScheduleLog.setParams(schedule.getParams());
        sysScheduleLog.setCreTime(new Date());

        // 任务的开始时间
        long startTime = System.currentTimeMillis();

        logger.info("任务准备执行，任务ID：" + schedule.getId());
        try {
            ScheduleRunnable task = new ScheduleRunnable(schedule.getBeanName(), schedule.getMethodName(), schedule.getParams());
            Future<?> future = service.submit(task);
            future.get();

            long times = System.currentTimeMillis() - startTime;
            sysScheduleLog.setTimes((int)times);
            // 任务状态 0 成功 1失败
            sysScheduleLog.setStatus("0");
            logger.info("任务准备完毕，任务ID：" + schedule.getId() + "  总共耗时：" + times + "毫秒");
        } catch (Exception e) {
            logger.error("任务执行失败，任务ID：" + schedule.getId(), e);
            long times = System.currentTimeMillis() - startTime;
            sysScheduleLog.setTimes((int)times);
            // 任务状态 0 成功 1失败
            sysScheduleLog.setStatus("1");
            sysScheduleLog.setError(StringUtils.substring(e.toString(), 0 , 2000));
        } finally {
            scheduleJobLogService.save(sysScheduleLog);
        }

    }
}
