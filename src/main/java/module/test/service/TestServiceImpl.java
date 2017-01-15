package module.test.service;


import module.test.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lx on 2016/1/31.
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public List getAllRecord() {
       return testDao.getList(null);
    }

}
