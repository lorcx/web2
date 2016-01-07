package module.service.user;

import module.entity.base.BaseUser;

/**
 * Created by dell on 2016/1/6.
 */
public interface IBaseUserService {
    public BaseUser getBaseUserInfoById(String id);

    public BaseUser saveBaseUser(BaseUser user);
}
