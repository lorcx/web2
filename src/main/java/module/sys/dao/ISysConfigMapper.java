package module.sys.dao;

import common.dao.BaseDao;
import module.sys.entity.SysConfig;
import util.PageUtils;

import java.util.List;

/**
 * Created by x on 2017/1/20.
 */
public interface ISysConfigMapper extends BaseDao<SysConfig>{
    List<SysConfig> queryConfigList(PageUtils page);
}
