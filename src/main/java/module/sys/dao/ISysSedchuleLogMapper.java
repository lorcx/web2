package module.sys.dao;


import module.sys.entity.SysSedchuleLog;

public interface ISysSedchuleLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysSedchuleLog record);

    int insertSelective(SysSedchuleLog record);

    SysSedchuleLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysSedchuleLog record);

    int updateByPrimaryKey(SysSedchuleLog record);
}