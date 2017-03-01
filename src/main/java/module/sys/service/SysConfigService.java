package module.sys.service;

import module.sys.dao.ISysConfigMapper;
import module.sys.entity.SysConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageUtils;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/2/27 0027.
 */
@Service("sysConfigService")
public class SysConfigService implements ISysConfigService {

    @Autowired
    private ISysConfigMapper configMapper;

    /**
     * 分页查询参数管理
     * @param page
     * @return
     */
    @Override
    public List<SysConfig> queryConfigList(PageUtils page) {
        return configMapper.queryConfigList(page);
    }

    @Override
    public SysConfig getConfigById(String configId) {
        return configMapper.getOne(configId);
    }

    /**
     * 保存 跟新
     * @param config
     */
    @Override
    public void saveOrUpdate(SysConfig config) {
        if (StringUtils.isBlank(config.getId())) {
            config.setId(UUID.randomUUID().toString());
            config.setStatus("1");
            configMapper.save(config);
        }
        configMapper.update(config);
    }

    /**
     * 批量删除配置信息
     * @param configIds
     */
    @Override
    public void deleteBatch(String[] configIds) {
        configMapper.deleteBatch(configIds);
    }


}
