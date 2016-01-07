package module.dao.user;

import module.entity.base.BaseUser;

/**
 * Created by dell on 2016/1/6.
 */
@SuppressWarnings("all")
public interface IBaseUserDao {
    public BaseUser getBaseUserDaoById(String id);

    public void saveBaseUser(BaseUser user);
}
