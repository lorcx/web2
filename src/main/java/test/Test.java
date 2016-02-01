package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/1/28.
 */
public class Test{
    public static void main(String[] args) {
        List list = new ArrayList();
        Map map = new HashMap();
        for(int i = 0;i < 2;i++){
            TestEntity te = new TestEntity();
            te.haedMan = (String) map.get("");
            te.applyUser = (String) map.get("");
            te.techoglyUser = (String) map.get("");
            te.businessUser = (String) map.get("");
            list.set(i,te);
        }

    }
}

class TestEntity{
    public String haedMan;
    public String applyUser;
    public String techoglyUser;
    public String businessUser;
}