package interceptor;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.PageUtils;
import util.ReflectUtil;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * mabtis 分页拦截器
 * https://my.oschina.net/u/726057/blog/336073
 * Created by Administrator on 2017/2/14 0014.
 */
@Intercepts({@Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class, Integer.class})})
public class PageInterceptor implements Interceptor {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 拦截器要执行的方法
     * delegate 代表
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException, SQLException {
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        Object obj = boundSql.getParameterObject();
        if (obj instanceof PageUtils) {
            PageUtils pageUtils = (PageUtils) obj;
            MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
            Connection connection = (Connection) invocation.getArgs()[0];
            String sql = boundSql.getSql();
            String pageSql = null;
            try {
                setTotalRecord(pageUtils, mappedStatement, connection);
                pageSql = parsePageSql(sql, pageUtils.getOffset(), pageUtils.getLimit());
            } catch (Exception e) {
                logger.error("解析分页sql异常：" + e.getCause());
            }
            ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
        }
        return invocation.proceed();
    }

    /**
     * 设置总页数
     */
    private void setTotalRecord(PageUtils pageUtils, MappedStatement mappedStatement, Connection connection) {
        BoundSql boundSql = mappedStatement.getBoundSql(pageUtils);
        String sql = boundSql.getSql();
        String countSql = getCountSql(sql);
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, pageUtils);
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, pageUtils, countBoundSql);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(countSql);
            parameterHandler.setParameters(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int totalRecord = rs.getInt(1);
                pageUtils.setTotalCount(totalRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    if (!rs.isClosed()) {
                       rs.close();
                    }
                }
                if (pstmt != null) {
                    if (!pstmt.isClosed()) {
                        pstmt.isClosed();
                    }
                }
            } catch (SQLException e) {
                logger.error("关闭资源【ResultSet, PreparedStatement】失败：" + e.getCause());
            }
        }

    }

    /**
     * 解析sql
     *
     * @return
     */
    private String parsePageSql(String pageSql, int offset, int limit) throws Exception {
        String resultSql = "select tab_y.* from (select tab_x.*, rownum rn from (" + pageSql + ") tab_x where rownum <=" + limit + ") tab_y where tab_y.rn >= " + offset;
        if (StringUtils.isBlank(resultSql)) {
            throw new Exception("分页sql解析失败 [sql]: " + pageSql);
        }
        return resultSql;
    }

    /**
     * 获取总记录数sql
     *
     * @return
     */
    private String getCountSql(String sql) {
        return "select count(1) from (" + sql + ")";
    }

    /**
     * 要拦截的对象
     *
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 设置初始化的属性值
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }

}
