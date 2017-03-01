package module.sys.controller;

import common.exception.RRException;
import module.sys.entity.SysConfig;
import module.sys.service.ISysConfigService;
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

/**
 * 参数管理
 * Created by Administrator on 2017/2/27 0027.
 */
@RestController
@RequestMapping("/sys/config")
public class SysConfigController {

    @Autowired
    private ISysConfigService configService;

    @RequestMapping("/list")
    @RequiresPermissions("sys:config:list")
    public R queryConfigList(Integer currPage, Integer pageSize) {
        PageUtils pageUtil = new PageUtils(pageSize, currPage);
        pageUtil.setParams(new HashMap<String, Object>());

        // 查询用户记录
        List<SysConfig> configList = configService.queryConfigList(pageUtil);
        pageUtil.setList(configList);
        return R.ok().put("page", pageUtil);
    }

    /**
     * 保存用户
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:config:save")
    public R saveConfig(@RequestBody SysConfig config) {
        verifyForm(config);
        configService.saveOrUpdate(config);
        return R.ok();
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    public R delete(@RequestBody String[] configIds) {
        configService.deleteBatch(configIds);
        return R.ok();
    }


    /**
     * 更新参数信息
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:config:update")
    public R updateConfig(@RequestBody SysConfig config) {
        verifyForm(config);

        if (StringUtils.isBlank(config.getId())) {
            throw new RRException("config id 不能为空");
        }

        configService.saveOrUpdate(config);
        return R.ok();
    }

    /**
     * 参数校验
     * @param config
     */
    private void verifyForm(SysConfig config) {
        if (StringUtils.isBlank(config.getKey())) {
            throw new RRException("参数名称不能为空");
        }

        if (StringUtils.isBlank(config.getValue())) {
            throw new RRException("参数值不能为空");
        }
    }


    /**
     * 参数信息
     *
     * @return
     */
    @RequestMapping("/info/{configId}")
    @RequiresPermissions("sys:config:info")
    public R info(@PathVariable("configId") String configId) {
        if (StringUtils.isBlank(configId)) {
            return R.error("参数id不能为空");
        }
        SysConfig config = configService.getConfigById(configId);
        return R.ok().put("config", config);
    }

}
