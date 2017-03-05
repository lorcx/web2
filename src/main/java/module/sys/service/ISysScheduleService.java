package module.sys.service;

import module.sys.entity.SysSedchule;
import util.PageUtils;
import java.util.List;

/**
 * Created by lx on 2017/3/5.
 */
public interface ISysScheduleService {
    List<SysSedchule> getSecheduleListBypage(PageUtils pageUtil);
}
