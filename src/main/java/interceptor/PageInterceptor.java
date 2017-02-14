package interceptor;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mabtis 分页拦截器
 * Created by Administrator on 2017/2/14 0014.
 */
@Intercepts({@Signature(type= StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PageInterceptor implements Interceptor{

    /**
     * 拦截器要执行的方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler,
                SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                new DefaultReflectorFactory());
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String id = mappedStatement.getId();
        // 需要分页的sql
        if (id.matches(".+ByPage$")) {
            BoundSql boundSql = statementHandler.getBoundSql();
            Map<String, Object> params = (Map<String, Object>) boundSql.getParameterObject();
            String sql = boundSql.getSql();
            String countSql = "select count(1) from (" + sql + ")";
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement countStatment = connection.prepareStatement(countSql);
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(countStatment);
            ResultSet rs = countStatment.executeQuery();
            if (rs.next()) {

            }
            String pageSql = parsePageSql(sql);
            metaObject.setValue("delegate.boundSql.sql", pageSql);
        }

        return invocation.proceed();
    }

    /**
     * 要拦截的对象
     * @param o
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 设置初始化的属性值
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * 解析sql
     * @return
     */
    private String parsePageSql (String pageSql) throws Exception {
        int endNum = 3;
        int startNum = 0;
        String resultSql = "select tab_x.*, rownum rn from (" + pageSql + ") tab_x where rownum <=" + endNum;
        resultSql = "select tab_y.* from (" + resultSql + ") tab_y where tab_y.rn >= " + startNum;
        if (StringUtils.isBlank(resultSql)) {
            throw new Exception("分页sql解析失败 [sql]: " + pageSql);
        }
        return resultSql;
    }

    public static void main(String[] args) {

        PageInterceptor pi = new PageInterceptor();
        try {
            System.out.println(pi.parsePageSql("select id from sys_user"));
            System.out.println(pi.parsePageSql("select s2.id\n" +
                    "                  from sys_menu sm, sys_role_menu s2\n" +
                    "                 where sm.id = s2.menu_id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
