package module.sys.service;

import module.sys.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by x on 2017/1/20.
 */
public interface ISysUserService {
    public List<SysUser> queryAllList(Map<String,Object> params);
}
