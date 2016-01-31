package module.service.test;

import test.ICommonDaoTest;

/**
 * Created by lx on 2016/1/31.
 */
public class Test1ServiceImpl implements ITest1Service {
    public ICommonDaoTest daoTest;

    public void setDaoTest(ICommonDaoTest daoTest) {
        this.daoTest = daoTest;
    }

    @Override
    public void test() {
        daoTest.test();

    }
}
