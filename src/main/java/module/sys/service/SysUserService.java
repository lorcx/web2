package module.sys.service;

import module.sys.dao.ISysUserMapper;
import module.sys.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by x on 2017/1/20.
 */
@Service("sysUserService")
public class SysUserService implements ISysUserService {
    @Autowired
    private ISysUserMapper userMapper;
    /**
     * 查询所有用户信息
     * @param params
     * @return
     */
    public List<SysUser> queryAllList(Map<String, Object> params) {
        return userMapper.getList(params);
    }
}
