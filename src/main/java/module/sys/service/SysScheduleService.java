package module.sys.service;

import module.sys.dao.ISysSedchuleMapper;
import module.sys.entity.SysSedchule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageUtils;
import java.util.List;

/**
 * Created by lx on 2017/3/5.
 */
@Service("sysScheduleService")
public class SysScheduleService implements ISysScheduleService {

    @Autowired
    private ISysSedchuleMapper sedchuleMapper;


    /**
     * 分页查询定时管理
     * @param pageUtils
     * @return
     */
    @Override
    public List<SysSedchule> getSecheduleListBypage(PageUtils pageUtils) {
        return sedchuleMapper.getSecheduleListBypage(pageUtils);
    }
}
