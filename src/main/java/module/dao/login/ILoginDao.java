package module.dao.login;

import module.entity.base.BaseUser;

/**
 *
 * Created by lx on 2015/12/25.
 */
@SuppressWarnings("all")
public interface ILoginDao {

    BaseUser getUserInfoById(String id);

    Object getUserInfoByName(String UserName);

}
