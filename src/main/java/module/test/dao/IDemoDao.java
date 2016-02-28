package module.test.dao;

import common.dao.IHbiGeneraldao;
import module.test.entity.Test1;

public interface IDemoDao extends IHbiGeneraldao<Test1,String> {

	public void test()throws Exception;

}
