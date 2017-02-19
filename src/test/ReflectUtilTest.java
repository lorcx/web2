import module.sys.entity.SysUser;
import org.junit.Test;
import util.ReflectUtil;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class ReflectUtilTest {

    @Test
    public void testGetFieldValue() {
        SysUser su = new SysUser();
        System.out.println(ReflectUtil.getFieldValue(su, "userName"));
    }

    @Test
    public void testSetFieldValue() {
        SysUser su = new SysUser();
        ReflectUtil.setFieldValue(su, "userName", "abc");
        System.out.println(ReflectUtil.getFieldValue(su, "userName"));
    }


}
