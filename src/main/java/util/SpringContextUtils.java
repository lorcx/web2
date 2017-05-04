package util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring context 工具类
 * Created by Administrator on 2017/3/5 0005.
 */
    //把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
    //泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注
@Component
public class SpringContextUtils implements ApplicationContextAware{
    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    /**
     * 根据name获取bean
     * @return
     */
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    /**
     * 获取bean
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }

    /**
     * 是否存在bean
     * @param name
     * @return
     */
    public static boolean containBean(String name) {
        return applicationContext.containsBean(name);
    }

    /**
     * 是否单例
     * @param name
     * @return
     */
    public static boolean isSingleton(String name) {
        return applicationContext.isSingleton(name);
    }

    public static Class<? extends Object> getType(String name) {
        return applicationContext.getType(name);
    }
}
