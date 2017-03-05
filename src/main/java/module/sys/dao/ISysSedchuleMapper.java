package module.sys.dao;

import common.dao.BaseDao;
import module.sys.entity.SysSedchule;
import util.PageUtils;
import java.util.List;

public interface ISysSedchuleMapper extends BaseDao<SysSedchule> {
    List<SysSedchule> getSecheduleListBypage(PageUtils pageUtils);
}