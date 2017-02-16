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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.PageUtils;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * mabtis 分页拦截器
 * https://my.oschina.net/u/726057/blog/336073
 * Created by Administrator on 2017/2/14 0014.
 */
@Intercepts({@Signature(type= StatementHandler.class, method = "prepare", args = {Connection.class, Object.class, PageUtils.class})})
public class PageInterceptor implements Interceptor{

    protected Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 拦截器要执行的方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException, SQLException {
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
            PageUtils pageUtils = (PageUtils) invocation.getArgs()[2];
            PreparedStatement countStatment = null;
            ResultSet rs = null;
            try {
                countStatment = connection.prepareStatement(countSql);
                ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
                parameterHandler.setParameters(countStatment);
                rs = countStatment.executeQuery();
                if (rs.next()) {
                    int totalCount = rs.getInt(0);// 总记录数
                    pageUtils.setTotalCount(totalCount);
                }
                String pageSql = parsePageSql(sql, pageUtils.getOffset(), pageUtils.getLimit());
                metaObject.setValue("delegate.boundSql.sql", pageSql);
            } catch (SQLException e) {
                logger.error("执行分页sql异常：" + e.getCause());
            } catch (Exception e) {
                logger.error("解析分页sql异常：" + e.getCause());
            } finally {
                if (null != rs) {
                   if (!rs.isClosed()) {
                        try {
                            rs.close();
                        } catch (SQLException e) {
                            logger.error("关闭resultSet失败：" + e.getCause());
                        }
                   }
                }
            }
        }
        return invocation.proceed();
    }


    /**
     * 解析sql
     * @return
     */
    private String parsePageSql (String pageSql, int offset, int limit) throws Exception {
        String resultSql = "select tab_y.* from (select tab_x.*, rownum rn from (" + pageSql + ") tab_x where rownum <=" + limit + ") tab_y where tab_y.rn >= " + offset;
        if (StringUtils.isBlank(resultSql)) {
            throw new Exception("分页sql解析失败 [sql]: " + pageSql);
        }
        return resultSql;
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

    public static void main(String[] args) {

//        PageInterceptor pi = new PageInterceptor();
//        try {
//            System.out.println(pi.parsePageSql("select id from sys_user"));
//            System.out.println(pi.parsePageSql("select s2.id\n" +
//                    "                  from sys_menu sm, sys_role_menu s2\n" +
//                    "                 where sm.id = s2.menu_id"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
