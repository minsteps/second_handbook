package com.example.dao.impl;

import com.example.utils.JdbcUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    //通用查询
    //封装成任何类型的对象的列表需要使用范形<T>
    public static <T> List<T> fetchList(Class<T> type, String sql, Object... args) {
        List<T> result = new ArrayList<T>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.prepareStatement(sql);
            //封装参数
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }
            rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                T t = type.newInstance();
                for (int i = 1; i <= columnCount; i++) {//columnCount从1开始
                    String label = rsmd.getColumnLabel(i);//获取i列的列名
                    Object value = rs.getObject(i);//获取i列的列值
                    BeanUtils.setProperty(t, label, value);
                }
                result.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseResoure(rs, statement, connection);
        }
        return result;
    }


    //通用增删改
    //不能用于处理事务
    public static int update(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            result = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseResoure(statement, connection);
        }
        return result;
    }
    public static void close(Connection conn) {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}