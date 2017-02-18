package util;

import java.lang.reflect.Field;

/**
 * 反射工具类
 * http://elim.iteye.com/blog/1851081
 * Created by lx on 2017/2/18.
 */
public class ReflectUtil {
    /**
     * 利用反射获取指定对象的指定属性
     * @param target 目标对象
     * @param fieldName 目标属性
     * @return
     */
    public static Object getFieldValue (Object target, String fieldName) {
        Object result = null;
        return result;
    }

    /**
     * 利用反射获取对象中的指定属性
     * @param target 目标对象
     * @param fieldName 目标属性
     * @return 目标字段
     */
    public static Field getField(Object target, String fieldName) {
        Field field = null;
        for (Class<?> clazz = target.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                // 如果没有找到就找父类，父类就返回null
            }
        }
        return field;
    }
}
