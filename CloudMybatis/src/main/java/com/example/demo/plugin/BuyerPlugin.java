package com.example.demo.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class BuyerPlugin implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuyerPlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler handler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(handler);
        BoundSql boundSql = handler.getBoundSql();
        if (boundSql.getSql().contains("age")) {
            // 重写sql
            String sql = buildSql(boundSql.getSql());
            LOGGER.info("sql------------->{}", sql);
            metaStatementHandler.setValue("delegate.boundSql.sql", sql);
        }
        return invocation.proceed();
    }


    /**
     * 将用户授权的供应商加入到sql查询台条件
     *
     * @param sql sql
     * @return String
     */
    private String buildSql(String sql) {
        int where = sql.toLowerCase().indexOf("where");
        StringBuilder sb = new StringBuilder(1000);
        String firstSql = sql.substring(0, where + 5);
        String lastSql = sql.substring(where + 5, sql.length());
        sb.append(firstSql).append(" age = 2 ").append(" and ");
        sb.append(lastSql);
        return sb.toString();
    }

    @Override
    public Object plugin(Object target) {
        return (target instanceof StatementHandler) ? Plugin.wrap(target, this) : target;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}