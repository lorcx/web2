package module.sys.controller;

import module.sys.entity.SysSedchule;
import module.sys.service.ISysScheduleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/sys/schedule")
public class SysScheduleController {

    @Autowired
    private ISysScheduleService scheduleService;

    /**
     * 查询定时分页
     * @param pageSize 每页记录数
     * @param currPage 当前页
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedule:list")
    public R getSecheduleListBypage(Integer currPage, Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        PageUtils pageUtil = new PageUtils(pageSize, currPage);
        pageUtil.setParams(params);

        // 查询定时记录
        List<SysSedchule> scheduleList = scheduleService.getSecheduleListBypage(pageUtil);
        pageUtil.setList(scheduleList);
        return R.ok().put("page", pageUtil);
    }
}
