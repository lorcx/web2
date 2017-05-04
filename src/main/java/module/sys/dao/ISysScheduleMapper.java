package module.sys.dao;

import common.dao.BaseDao;
import module.sys.entity.SysSchedule;
import util.PageUtils;

import java.util.List;

public interface ISysScheduleMapper extends BaseDao<SysSchedule> {
    List<SysSchedule> getScheduleListByPage(PageUtils pageUtils);
}