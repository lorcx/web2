package module.login.service;

import common.exception.ServiceException;

import java.util.Map;

/**
 * 登陆
 * Created by lx on 2015/12/25.
 */
public interface ILoginService {
    Map<String,Object> login(String userName,String passWord) throws ServiceException;
}
