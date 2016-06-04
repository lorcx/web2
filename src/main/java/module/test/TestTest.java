package module.test;

import org.apache.commons.lang.StringUtils;

/**
 * Created by dell on 2016/5/30.
 */
public class TestTest {
    public static void main(String[] args) {
        System.out.println(Math.ceil(2 / 5) );
//        TestTest t = new TestTest();
//        String hql = "select new map(u.id as id,u.nickName as nickName,u.userName as userName,u.creDate as creDate) from BaseUser u ";
//        System.out.println(t.prepareCountHql(hql));
    }
    protected String prepareCountHql(String hql) {

        String fromHql = hql;
        fromHql = "from" + StringUtils.substringAfter(fromHql, "from");
        fromHql = StringUtils.substringBefore(fromHql, "order by");
        int whereIndex = fromHql.indexOf("where");
        int leftIndex = fromHql.indexOf("left join");
        if (leftIndex >= 0) {
            if (whereIndex >= 0) {
                String temp = StringUtils.substringBefore(fromHql, "left");
                fromHql = temp + " where " + StringUtils.substringAfter(fromHql, "where");
            } else {
                fromHql = StringUtils.substringBefore(fromHql, "left");
            }
        }
        String countHql = "select count(*) " + fromHql;
        return countHql;
    }

}
