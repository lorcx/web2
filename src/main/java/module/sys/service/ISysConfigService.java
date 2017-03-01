package module.sys.service;

import module.sys.entity.SysConfig;
import util.PageUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/2/27 0027.
 */
public interface ISysConfigService {
    List<SysConfig> queryConfigList(PageUtils page);

    SysConfig getConfigById(String configId);

    void saveOrUpdate(SysConfig config);

    void deleteBatch(String[] configIds);
}
