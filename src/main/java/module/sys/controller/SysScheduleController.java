package module.sys.controller;

import common.exception.RRException;
import module.sys.entity.SysSchedule;
import module.sys.service.ISysScheduleService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.PageUtils;
import util.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时管理
 * Created by lx on 2017/3/5.
 */
//@RestController
//@RequestMapping("/sys/schedule")
public class SysScheduleController {

//    @Autowired
//    private ISysScheduleService scheduleService;
//
//    /**
//     * 查询定时分页
//     *
//     * @param pageSize 每页记录数
//     * @param currPage 当前页
//     * @return
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("sys:schedule:list")
//    public R getSecheduleListBypage(Integer currPage, Integer pageSize) {
//        Map<String, Object> params = new HashMap<>();
//        PageUtils pageUtil = new PageUtils(pageSize, currPage);
//        pageUtil.setParams(params);
//
//        // 查询定时记录
//        List<SysSchedule> scheduleList = scheduleService.getScheduleListByPage(pageUtil);
//        pageUtil.setList(scheduleList);
//        return R.ok().put("page", pageUtil);
//    }
//
//    /**
//     * 定时任务信息
//     * @return
//     */
//    @RequestMapping("/info/{scheduleId}")
//    @RequiresPermissions("sys:schedule:info")
//    public R info(@PathVariable String scheduleId) {
//        SysSchedule schedule = scheduleService.getSedchuleInfoById(scheduleId);
//        return R.ok().put("schedule", schedule);
//    }
//
//    /**
//     * 保存定时任务
//     * @param schedule
//     * @return
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("sys:schedule:save")
//    public R saveSchedule(@RequestBody SysSchedule schedule) {
//        try {
//            verifyForm(schedule);
//            scheduleService.saveOrUpateSchedule(schedule);
//        } catch (Exception e) {
//            return R.error(e.getMessage());
//        }
//        return R.ok();
//    }
//
//
//    /**
//     * 保存定时任务
//     * @param schedule
//     * @return
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("sys:schedule:update")
//    public R updateSchedule(@RequestBody SysSchedule schedule) {
//        if (StringUtils.isBlank(schedule.getId())) {
//            return R.error("id不能为空");
//        }
//        try {
//            verifyForm(schedule);
//            scheduleService.saveOrUpateSchedule(schedule);
//        } catch (Exception e) {
//            return R.error(e.getMessage());
//        }
//        return R.ok();
//    }
//
//    /**
//     * 删除定时任务
//     * @param scheduleIds
//     * @return
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("sys:schedule:update")
//    public R deleteSchedule(@RequestBody String[] scheduleIds) {
//        scheduleService.deleteBatch(scheduleIds);
//        return R.ok();
//    }
//
//
//    /**
//     * 立即执行定时任务
//     * @param scheduleIds
//     * @return
//     */
//    @RequestMapping("/run")
//    @RequiresPermissions("sys:schedule:run")
//    public R runSchedule(@RequestBody String[] scheduleIds) {
//        scheduleService.run(scheduleIds);
//        return R.ok();
//    }
//
//    /**
//     * 暂停定时任务
//     * @param scheduleIds
//     * @return
//     */
//    @RequestMapping("/pause")
//    @RequiresPermissions("sys:schedule:pause")
//    public R pauseSchedule(@RequestBody String[] scheduleIds) {
//        scheduleService.pause(scheduleIds);
//        return R.ok();
//    }
//
//    /**
//     * 恢复定时任务
//     * @param scheduleIds
//     * @return
//     */
//    @RequestMapping("/resume")
//    @RequiresPermissions("sys:schedule:resume")
//    public R resumeSchedule(@RequestBody String[] scheduleIds) {
//        scheduleService.resume(scheduleIds);
//        return R.ok();
//    }
//
//
//    /**
//     * 验证参数是否正确
//     */
//    private void verifyForm(SysSchedule schedule) throws Exception{
//        if (StringUtils.isBlank(schedule.getBeanName())) {
//            throw new RRException("bean名称不能为空");
//        }
//        if (StringUtils.isBlank(schedule.getMethodName())) {
//            throw new RRException("方法名称不能为空");
//        }
//        if (StringUtils.isBlank(schedule.getCronExpression())) {
//            throw new RRException("cron表达式不能为空");
//        }
//    }
}
